package com.pawel.automation.withdrawal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawel.automation.bank.account.AccountDto;
import com.pawel.automation.bank.disposition.DispositionDto;
import lombok.RequiredArgsConstructor;
import org.junit.Assert;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@Service
@RequiredArgsConstructor
public class WithdrawalService {

    private static final String BANK_URL = "http://localhost:8080/api/v1";
    private final ObjectMapper mapper;
    private final MockMvc mockMvc;
    private AccountDto account;
    private MvcResult mvcResult;

    public void createAccount() {
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders
                    .post(BANK_URL + "/accounts")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            account = mapper.readValue(mvcResult.getResponse().getContentAsString(), AccountDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAccount() {
        try {
            mvcResult = mockMvc.perform(MockMvcRequestBuilders
                    .get(BANK_URL + "/accounts/{id}", account.getNumber())
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();

            account = mapper.readValue(mvcResult.getResponse().getContentAsString(), AccountDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeDeposit(int amount) {
        makeOperation("deposit", amount);
    }

    public void makeWithdraw(int amount) {
        makeOperation("withdraw", amount);
    }

    public void assertAvailableFounds(int amount) {
        Assert.assertEquals(amount, account.getBalance());
    }

    public void assertInsufficientFundsException() {
        Assert.assertEquals("Insufficient Funds", mvcResult.getResponse().getErrorMessage());
    }

    public void assertNoErrors() {
        Assert.assertNull(mvcResult.getResponse().getErrorMessage());
    }

    private void makeOperation(String operation, int amount) {
        try {
            String body = mapper.writeValueAsString(DispositionDto.builder()
                    .accountNumber(account.getNumber())
                    .funds(amount)
                    .operationName(operation)
                    .build());

            mvcResult = mockMvc.perform(MockMvcRequestBuilders
                    .post(BANK_URL + "/dispositions")
                    .content(body)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
