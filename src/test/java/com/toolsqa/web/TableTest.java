package com.toolsqa.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TableTest {
    public static void main(String[] args) throws InterruptedException {
        String localDriverLocation = System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", localDriverLocation);
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/webtables");
        Thread.sleep(3000);

        // Delete
        driver.findElement(By.id("delete-record-1")).click();
        Thread.sleep(2000);

        // Edit
        driver.findElement(By.id("edit-record-2")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Ismail");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Hossain");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("ismail.9595@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("26");
        Thread.sleep(1000);
        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys("55000");
        Thread.sleep(1000);
        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys("Developer");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);

        // Add
        driver.findElement(By.id("addNewRecordButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys("Sumaiya");
        Thread.sleep(1000);
        driver.findElement(By.id("lastName")).sendKeys("Akter");
        Thread.sleep(1000);
        driver.findElement(By.id("userEmail")).sendKeys("sumaiya.akter@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("age")).sendKeys("26");
        Thread.sleep(1000);
        driver.findElement(By.id("salary")).sendKeys("65000");
        Thread.sleep(1000);
        driver.findElement(By.id("department")).sendKeys("Designer");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);

        // Search
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.click();
        Thread.sleep(2000);
        searchBox.sendKeys("legal");
        Thread.sleep(3000);

        // Change Rows
        Select selectRows = new Select(driver.findElement(By.cssSelector(".select-wrap select")));
        selectRows.selectByIndex(0);
        Thread.sleep(5000);

        driver.close();
        driver.quit();
    }
}
