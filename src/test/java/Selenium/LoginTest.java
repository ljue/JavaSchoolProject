//package Selenium;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import java.util.concurrent.TimeUnit;
//
//public class LoginTest {
//
//    private String hostUrl;
//    WebDriver driver;
//
//    @Before
//    public void init() throws Exception {
//        System.setProperty("webdriver.chrome.driver",
//                "D:\\JavaSchoolProject\\mywebapp\\chromedriver.exe");
//        driver = new ChromeDriver();
//        hostUrl = "http://localhost:8080/my-webapp/";
//        driver.navigate().to(hostUrl + "login");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void login() throws Exception {
//
//        driver.findElement(By.cssSelector("#login-login")).clear();
//        driver.findElement(By.cssSelector("#login-login")).sendKeys("client");
//
//        driver.findElement(By.cssSelector("#login-password")).clear();
//        driver.findElement(By.cssSelector("#login-password")).sendKeys("client");
//
//        driver.findElement(By.cssSelector(".btn")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        String nextUrl = driver.getCurrentUrl();
//
//        System.out.println(hostUrl+"   "+ nextUrl);
//        Assert.assertTrue(nextUrl.equals(hostUrl+"home"));
//    }
//
//    @After
//    public void quit() throws Exception {
//        driver.quit();
//    }
//}
