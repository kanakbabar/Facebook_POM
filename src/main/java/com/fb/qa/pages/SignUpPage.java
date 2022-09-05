package com.fb.qa.pages;

import com.fb.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;

public class SignUpPage extends TestBase
{
    @FindBy(linkText = "Create New Account")
    WebElement CreateNewAccount;

    @FindBy(xpath = "//input[@placeholder='First name']")
    WebElement firstname;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "reg_email__")
    WebElement reg_email__;

    @FindBy(name = "reg_email_confirmation__")
    WebElement reg_email_confirmation__;

    @FindBy(id = "password_step_input")
    WebElement reg_passwd__;

    @FindBy(name = "birthday_day")
    WebElement birthday_day;

    @FindBy(name = "birthday_month")
    WebElement birthday_month;

    @FindBy(name = "birthday_year")
    WebElement birthday_year;

    @FindBy(name = "sex")
    WebElement gender;

    @FindBy(name = "websubmit")
    WebElement signUpBtn;
    public SignUpPage() throws FileNotFoundException {
        super();
        PageFactory.initElements(driver, this);
    }
    public String ValidateSignUpPageTittle()
    {
        return driver.getTitle();
    }

    public HomePage signUp(String fn, String ln, String em, String vem, String pwd, String bd, String bm, String by,
                           String g) throws FileNotFoundException {
        CreateNewAccount.click();
        firstname.sendKeys(fn);
        lastname.sendKeys(ln);
        reg_email__.sendKeys(em);
        reg_email_confirmation__.sendKeys(vem);
        reg_passwd__.sendKeys(pwd);
        birthday_day.sendKeys(bd);
        birthday_month.sendKeys(bm);
        birthday_year.sendKeys(by);
        gender.sendKeys(g);
        signUpBtn.click();
        return new HomePage();
    }
}