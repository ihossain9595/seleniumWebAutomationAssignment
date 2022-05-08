package com.toolsqa.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        /*
        ________________________________________________________________________________________
        _______________________________ Mouse Right Click Action _______________________________
        */

        driver.get("https://demoqa.com/buttons");
        Thread.sleep(5000);

        Actions a = new Actions(driver);
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        a.contextClick(rightClick).perform();
        Thread.sleep(3000);


        /*
        _________________________________________________________________________________________
        _______________________________ Mouse Double Click Action _______________________________

        driver.get("https://demoqa.com/buttons");
        Thread.sleep(5000);

        Actions a = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        a.doubleClick(doubleClick).perform();
        Thread.sleep(3000);
        */

        /*
        ________________________________________________________________________________________
        _______________________________ Mouse Drag & Drop Action _______________________________

        driver.get("https://demoqa.com/droppable");
        Thread.sleep(5000);

        Actions a = new Actions(driver);
        WebElement dragElement = driver.findElement(By.id("draggable"));
        WebElement dropElement = driver.findElement(By.id("droppable"));
        a.dragAndDrop(dragElement, dropElement).perform();
        Thread.sleep(3000);
        */

        /*
        ________________________________________________________________________________________
        __________________________________ Mouse Hover Action __________________________________

        driver.get("https://demoqa.com/menu");
        Thread.sleep(5000);

        #1
        WebElement clickOn = driver.findElement(By.linkText("Main Item 1"));
        clickOn.click();
        System.out.println("Click On --> " + clickOn.getText());
        Thread.sleep(5000);
        driver.navigate().back();
        WebElement clickOn2 = driver.findElement(By.linkText("Main Item 3"));
        clickOn.click();
        System.out.println("Click On --> " + clickOn2.getText());
        Thread.sleep(5000);

        #2
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
        */

        driver.close();
    }
}
