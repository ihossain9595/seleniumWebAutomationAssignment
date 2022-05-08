package com.toolsqa.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowTabTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://demoqa.com/browser-windows");
        String parentWindow = driver.getWindowHandle();
        Thread.sleep(3000);

        driver.findElement(By.id("windowButton")).click();
        driver.findElement(By.id("messageWindowButton")).click();

        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> iterator = childWindows.iterator();

        while (iterator.hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindow.equalsIgnoreCase(childWindow)) {
            driver.switchTo().window(childWindow);
                System.out.println("CLOSED");
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        driver.close();


        /*
        driver.findElement(By.id("tabButton")).click();

        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> iterator = childWindows.iterator();
        Thread.sleep(3000);

        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement getText = driver.findElement(By.tagName("h1"));
                System.out.println(getText.getText());
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.findElement(By.className("main-header")).getText());
        Thread.sleep(3000);
        */


        /*
        // Current
        String currentTabLocaiton = driver.getWindowHandle();

        // Tab
        driver.switchTo().newWindow(WindowType.TAB);
        String currentTabLocaiton2 = driver.getWindowHandle();
        Thread.sleep(3000);

        // Window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);

        driver.close(); // Window closed
        driver.switchTo().window(currentTabLocaiton2);
        driver.close(); // New tab closed
        driver.switchTo().window(currentTabLocaiton);
        driver.close(); // Current tab closed
        Thread.sleep(3000);
        */

        //driver.quit();
    }
}
