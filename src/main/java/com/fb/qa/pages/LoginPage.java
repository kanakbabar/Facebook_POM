package com.fb.qa.pages;

import com.fb.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginPage extends TestBase
{
    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement login_button;

    @FindBy(xpath = "//img[@alt='Facebook']")
    WebElement Fb_logo;

    //initialize page factory or page object
    public LoginPage() throws FileNotFoundException {
        super();
        PageFactory.initElements(driver, this);
    }

    // Actions (features)
    public String ValidateLoginPageTittle()
    {
        return driver.getTitle();
    }


    public boolean ValidateFB_Image()
    {
        return Fb_logo.isDisplayed();
    }

    public HomePage login(String eml , String pswd) throws FileNotFoundException {
        email.sendKeys(eml);

        password.sendKeys(pswd);
        login_button.click();

        return new HomePage();
    }
    public HomePage loginMultipleAccounts(String un, String pass) throws FileNotFoundException {
        // TODO Auto-generated method stub
        email.sendKeys(un);
        password.sendKeys(pass);
        login_button.submit();
        return new HomePage();

    }
}
