package com.toolsqa.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class IframeTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/frames");
         Thread.sleep(3000);

        // Frame #1
        driver.switchTo().frame("frame1");
        String fromFrame1 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Working Frame #1: " + fromFrame1);
        Thread.sleep(1000);

        driver.switchTo().defaultContent();

        // Frame #2
        driver.switchTo().frame("frame2");
        String fromFrame2 = driver.findElement(By.tagName("h1")).getAttribute("id");
        //String fromFrame2 = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Working Frame #2: " + fromFrame2);
        Thread.sleep(1000);

        driver.switchTo().defaultContent();

        driver.close();
        driver.quit();
    }
}
