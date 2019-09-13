package com.pawel.automation.steps;

import com.pawel.automation.withdrawal.WithdrawalService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WithdrawalSteps {

    private final WithdrawalService withdrawalService;

    @Given("I make {int} PLN deposit")
    public void makeDeposit(int amount) {
        withdrawalService.createAccount();
        withdrawalService.makeDeposit(amount);
    }

    @When("I want to withdraw {int} PLN")
    public void makeWithdraw(int amount) {
        withdrawalService.makeWithdraw(amount);
    }

    @Then("Error insufficient founds should occur")
    public void assertErrorNotEnoughFounds() {
        withdrawalService.assertInsufficientFundsException();
    }

    @Then("I have {int} PLN on my Account")
    public void assertAvailableFounds(int amount) {
        withdrawalService.checkAccount();
        withdrawalService.assertAvailableFounds(amount);
    }

    @Then("Error insufficient founds did not occur")
    public void assertWithdrawalAmount() {
        withdrawalService.assertNoErrors();
    }

}
