package com.toolsqa.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MenuTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/menu");
        Thread.sleep(5000);

        /*
        WebElement clickOn = driver.findElement(By.linkText("Main Item 1"));
        clickOn.click();
        System.out.println("Click On --> " + clickOn.getText());
        Thread.sleep(5000);

        driver.navigate().back();

        WebElement clickOn2 = driver.findElement(By.linkText("Main Item 3"));
        clickOn.click();
        System.out.println("Click On --> " + clickOn2.getText());
        Thread.sleep(5000);
        */

        Actions a = new Actions(driver);

        WebElement x = driver.findElement(By.linkText("Main Item 2"));
        a.moveToElement(x).perform();
        Thread.sleep(2000);
        WebElement y = driver.findElement(By.partialLinkText("SUB SUB"));
        a.moveToElement(y).perform();
        Thread.sleep(2000);
        WebElement z = driver.findElement(By.linkText("Sub Sub Item 1"));
        a.moveToElement(z).click().perform();
        Thread.sleep(3000);

        driver.close();
    }
}
