package com.TestMUAI;


import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class FirstParallelTest {
    String username = "amankumarjnvk";
    String accesskey = "LT_TBTiFHwz5ABJ2cTn7grpxFuKj5vnyRdjcEStbpRCkfeGHFT";
    static RemoteWebDriver driver = null;
    String gridURL = "@hub.lambdatest.com/wd/hub";
    String buidName = "LambdaTestSampleBuild1";
    String testName = "LambdaTestSampleName1";
    boolean status = false;
    @BeforeClass
    public void beforeClass() {
        
    }
    @Test
    public void firstDemoTest() {
        new FirstTest().test();
    }
    
    public static void main(String[] args) {
        new FirstTest().test();
    }
    public void test() {
        setUp();
        try {
            driver.get("https://www.testmuai.com/selenium-playground/todo-app/");

            driver.findElement(By.name("li1")).click();
            driver.findElement(By.name("li2")).click();

            driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
            driver.findElement(By.id("addbutton")).click();

            String enteredText = driver.findElement(By.xpath("/html/body/div/div/main/div/section/div/div/div/ul/li[6]/span")).getText();
            if (enteredText.equals("Yey, Let's add it to list")) {
                status = true;
            }
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //tearDown();
             Assert.assertTrue(status, "Test passed succesfully");
        }
    }
    private void setUp() {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("build", buidName);
        ltOptions.put("name", testName);
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), browserOptions);
            if(driver!=null) {
                System.out.println("Driver is initialized");
            }
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @AfterMethod 
    private void tearDown() {
        if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}
