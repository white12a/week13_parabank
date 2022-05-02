package com.parasoft.parabank.testsuite;

import com.parasoft.parabank.pages.AccountOverviewPage;
import com.parasoft.parabank.pages.HomPage;
import com.parasoft.parabank.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {
    HomPage homPage=new HomPage();
    AccountOverviewPage accountOverviewPage=new AccountOverviewPage();
 @Test
 public void userShouldLoginSuccessFullyWithValidCredentials() {
     homPage.sendEmailToEmailIdFieldOnHomePage("b12@gmail.com");
     homPage.sendPasswordOnHomePage("123456");
     homPage.clickOnLoginLink();
     String actualTitle=homPage.validateAccountOverView();
     String expectedTitle="Accounts Overview";
     Assert.assertEquals(actualTitle,expectedTitle,"Account overview Title Validation");
 }
 @Test
 public void verifyTheErrorMessage() {
     homPage.sendEmailToEmailIdFieldOnHomePage("12@gmail.com");
     homPage.clickOnLoginLink();
     String actualMessage=homPage.validateErrorMessage();
     String expectedMessage="Please enter a username and password.";
     Assert.assertEquals(actualMessage,expectedMessage,"Login Error message Validation");
 }
 @Test
 public void userShouldLogOutSuccessfully() {
     homPage.sendEmailToEmailIdFieldOnHomePage("b12@gmail.com");
     homPage.sendPasswordOnHomePage("123456");
     homPage.clickOnLoginLink();
     accountOverviewPage.clickOnLogOutBtn();
     homPage.validateCustomerLoginText();
 }


}
