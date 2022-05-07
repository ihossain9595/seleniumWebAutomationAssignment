package com.toolsqa.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/alerts");
        Thread.sleep(3000);

        // Click -> Alert
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(2000);


        /*
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Click -> Timer Alert
        driver.findElement(By.id("timerAlertButton")).click();
        Alert alertTimer = wait.until(ExpectedConditions.alertIsPresent());
        alertTimer.accept();
        Thread.sleep(2000);
        */

        // Click -> Confirm Alert
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.dismiss();
        Thread.sleep(2000);

        // Click -> Prompt Alert
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep(1000);
        Alert alertPrompt = driver.switchTo().alert();
        String alertText = alertPrompt.getText();
        System.out.println("Text on the prompt window: " + alertText);
        alertPrompt.sendKeys("Ismail Hossain");
        Thread.sleep(2000);
        alertPrompt.accept();
        Thread.sleep(2000);

        driver.close();
        driver.quit();
    }
}
