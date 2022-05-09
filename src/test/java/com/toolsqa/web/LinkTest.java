package com.toolsqa.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinkTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/links");
        //Thread.sleep(3000);

        List<WebElement> allLinkElements = driver.findElements(By.cssSelector("[href]"));

        for (WebElement all : allLinkElements) {
            System.out.println("This is a link: " + all.getAttribute("href"));
        }
        //Thread.sleep(3000);
        driver.close();
    }
}
