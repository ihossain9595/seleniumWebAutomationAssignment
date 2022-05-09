package com.toolsqa.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FormTest {
    public static void main(String[] args) throws InterruptedException {
        String driverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverLocation);
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.id("firstName")).sendKeys("Ismail");

        driver.findElement(By.id("lastName")).sendKeys("Hossain");

        driver.findElement(By.id("userEmail")).sendKeys("ismail.9595@gmail.com");

        driver.findElement(By.cssSelector("[for=gender-radio-1]")).click();

        driver.findElement(By.id("userNumber")).sendKeys("1675965112");

        WebElement inputDateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        inputDateOfBirth.click();

        Select selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        selectMonth.selectByIndex(4);

        Select selectYear = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        selectYear.selectByValue("1995");

        driver.findElement(By.className("react-datepicker__day--010")).click();

        WebElement selectSubject = driver.findElement(By.id("subjectsInput"));
        selectSubject.click();
        selectSubject.sendKeys("Computer Science");
        selectSubject.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("[for=hobbies-checkbox-2]")).click();

        WebElement selectImage = driver.findElement(By.id("uploadPicture"));
        selectImage.sendKeys("C:\\Users\\ihossain9595\\Downloads\\depositphotos_59038425-stock-photo-demo.jpg");

        driver.findElement(By.id("currentAddress")).sendKeys("Bashundhara R/A");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys("Uttar Pradesh").perform();
        action.sendKeys(Keys.ENTER).perform();

        action.sendKeys(Keys.TAB).perform();
        action.sendKeys("Lucknow").perform();
        action.sendKeys(Keys.ENTER).perform();

        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ENTER).perform();


        Thread.sleep(10000);
        driver.close();
    }
}
