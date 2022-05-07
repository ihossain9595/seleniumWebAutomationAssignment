package com.mercurytours.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MercuryToursTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/newtours/reservation.php");
        Thread.sleep(2000);

        // #1
        WebElement oneWay = driver.findElement(By.cssSelector("input[value=oneway]"));
        oneWay.click();
        // Thread.sleep(2000);

        // #2
        Select selectPassengerCount = new Select(driver.findElement(By.cssSelector("select[name='passCount']")));
        selectPassengerCount.selectByIndex(1);
        // Thread.sleep(2000);

        // #3
        Select selectFromPort = new Select(driver.findElement(By.cssSelector("select[name='fromPort']")));
        selectFromPort.selectByValue("Sydney");
        // Thread.sleep(2000);

        // #4
        Select selectFromMonth = new Select(driver.findElement(By.cssSelector("select[name='fromMonth']")));
        selectFromMonth.selectByIndex(4);
        // Thread.sleep(2000);

        // #5
        Select selectFromDay = new Select(driver.findElement(By.cssSelector("select[name='fromDay']")));
        selectFromDay.selectByValue("9");
        // Thread.sleep(2000);

        // #6
        Select selectToPort = new Select(driver.findElement(By.cssSelector("select[name='toPort']")));
        selectToPort.selectByValue("London");
        // Thread.sleep(2000);

        // #7
        Select selectToMonth = new Select(driver.findElement(By.cssSelector("select[name='toMonth']")));
        selectToMonth.selectByIndex(7);
        // Thread.sleep(2000);

        // #8
        Select selectToDay = new Select(driver.findElement(By.cssSelector("select[name='toDay']")));
        selectToDay.selectByValue("9");
        // Thread.sleep(2000);

        // #9
        WebElement firstClass = driver.findElement(By.cssSelector("input[name=servClass][value=First]"));
        firstClass.click();
        // Thread.sleep(2000);

        // #10
        Select selectAirline = new Select(driver.findElement(By.cssSelector("select[name='airline']")));
        selectAirline.selectByVisibleText("Blue Skies Airlines");
        Thread.sleep(2000);

        // #11
        WebElement btnContinue = driver.findElement(By.cssSelector("input[name=findFlights]"));
        btnContinue.click();
        Thread.sleep(3000);

        driver.close();
        driver.quit();

    }
}
