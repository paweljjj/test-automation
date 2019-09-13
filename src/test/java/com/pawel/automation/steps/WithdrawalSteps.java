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
//        withdrawalService.makeDeposit();
    }

    @When("I want to withdraw {int} PLN")
    public void makeWithdraw(int amount) {
//        withdrawalService.makeWithdraw(amount);
    }

    @Then("Error Not enough founds should occur")
    public void assertErrorNotEnoughFounds() {
//        withdrawalService.assertErrorNotEnoughFounds();
    }

    @Then("I have {int} PLN on my Account")
    public void assertAvailableFounds(int amount) {
//        withdrawalService.assertAvailableFounds(amount);
    }

    @Then("I successfully withdraw {int} PLN")
    public void assertWithdrawalAmount(int amount) {
//        withdrawalService.assertWithdrawalAmount(amount);
    }

}
