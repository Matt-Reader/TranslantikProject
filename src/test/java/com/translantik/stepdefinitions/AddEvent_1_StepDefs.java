package com.translantik.stepdefinitions;

import com.translantik.pages.AddEventPage;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddEvent_1_StepDefs {



    @Then("the Driver should NOT see {string} button")
    public void the_Driver_should_NOT_see_button(String string) {
        Assert.assertFalse(Driver.get().findElement(By.cssSelector("a[title='Add an event to this record']")).isDisplayed());
        //If driver user sees the "Add Event" button test will fail.

    }

    @Then("User Should see Title, Owner, Organizer display name, Organizer email, Start Date, End Date as a compulsory field")
    public void user_Should_see_Title_Owner_Organizer_display_name_Organizer_email_Start_Date_End_Date_as_a_compulsory_field() {
        BrowserUtils.waitFor(5);
        Assert.assertEquals("Title*",Driver.get().findElement(By.xpath("(//label[@aria-required='true'])[1]")).getText());
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Owner*",Driver.get().findElement(By.xpath("(//label[@aria-required='true'])[2]")).getText());
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Organizer display name*",Driver.get().findElement(By.xpath("(//label[@aria-required='true'])[3]")).getText());
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Organizer email*",Driver.get().findElement(By.xpath("(//label[@aria-required='true'])[4]")).getText());
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Start*",Driver.get().findElement(By.xpath("(//label[@aria-required='true'])[5]")).getText());
        BrowserUtils.waitFor(1);
        Assert.assertEquals("End*",Driver.get().findElement(By.xpath("(//label[@aria-required='true'])[6]")).getText());
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.cssSelector("button[title='close']")).click();
        BrowserUtils.waitFor(2);
    }
    @Given("the user should fill the {string} ,{string} ,{string}  as follow")
    public void the_user_should_fill_the_as_follow(String titleInputBox, String organizerDispInputBox, String organizerEmailInputBox) {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_title-uid-')]")).sendKeys(titleInputBox);
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_organizerDisplayName')]")).sendKeys(organizerDispInputBox);
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//input[contains(@id,'oro_calendar_event_form_organizerEmail')]")).sendKeys(organizerEmailInputBox);
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("the user should be able to see -This value should not be blank.- message under compulsory field that is not filled.")
    public void the_user_should_be_able_to_see_This_value_should_not_be_blank_message_under_compulsory_field_that_is_not_filled() {
       // BrowserUtils.waitFor(1);
        try {Assert.assertEquals("This value should not be blank.",Driver.get().findElement(By.xpath("//span[contains(text(),'This value should not be blank.')]")).getText());
            Driver.get().findElement(By.cssSelector("button[title='close']")).click();

        }catch (Exception e){
           // BrowserUtils.waitForVisibility(By.cssSelector(".alert.alert-success.fade.in.top-messages >div"),1);
          // WebElement savedMessage =Driver.get().findElement(By.xpath("(//div[@class='message'])[1]"));
          // Assert.assertTrue(savedMessage.isDisplayed());
           String savedMessage = Driver.get().findElement(By.xpath("(//div[@class='message'])[1]")).getAttribute("class");
          //  System.out.println("savedMessage = " + savedMessage);
           Assert.assertFalse(savedMessage.equals("message"));
        }


    }


}
