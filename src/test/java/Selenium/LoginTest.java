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
//        hostUrl = "http://localhost:8080/favcopters/";
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
//
//        driver.findElement(By.cssSelector(".btn")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        String nextUrl = driver.getCurrentUrl();
//
//        Assert.assertFalse(nextUrl.equals(hostUrl+"home"));
//    }
//
//    @Test
//    public void loginNullPassword() throws Exception {
//
//        driver.findElement(By.cssSelector("#login-login")).clear();
//        driver.findElement(By.cssSelector("#login-login")).sendKeys("client");
//
//        driver.findElement(By.cssSelector("#login-password")).clear();
//        driver.findElement(By.cssSelector("#login-password")).sendKeys("password");
//
//        driver.findElement(By.cssSelector(".btn")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        String nextUrl = driver.getCurrentUrl();
//
//        Assert.assertFalse(nextUrl.equals(hostUrl+"home"));
//    }
//
//    @Test
//    public void loginFalsePassword() throws Exception {
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
//        Assert.assertFalse(nextUrl.equals(hostUrl+"home"));
//    }
//
//    @Test
//    public void testRegistrationFailConfirmPassword() throws Exception {
//
//        driver.navigate().to(hostUrl + "registration");
//        driver.findElement(By.name("firstName")).sendKeys("client2");
//        driver.findElement(By.name("secondName")).sendKeys("client2");
//        driver.findElement(By.name("birthday")).sendKeys("12121992");
//        driver.findElement(By.name("email")).sendKeys("client2@mail.ru");
//        driver.findElement(By.name("login")).sendKeys("client2");
//        driver.findElement(By.name("pass")).sendKeys("client2");
//        driver.findElement(By.name("confirmPassword")).sendKeys("client222");
//
//        driver.findElement(By.cssSelector(".btn")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        String nextUrl = driver.getCurrentUrl();
//
//        Assert.assertFalse(nextUrl.equals(hostUrl+"home"));
//    }
//
//    @Test
//    public void testRegistration() throws Exception {
//
//        driver.navigate().to(hostUrl + "registration");
//        driver.findElement(By.name("firstName")).sendKeys("client1");
//        driver.findElement(By.name("secondName")).sendKeys("client1");
//        driver.findElement(By.name("birthday")).sendKeys("12121992");
//        driver.findElement(By.name("email")).sendKeys("client1@mail.ru");
//        driver.findElement(By.name("login")).sendKeys("client1");
//        driver.findElement(By.name("pass")).sendKeys("client1");
//        driver.findElement(By.name("confirmPassword")).sendKeys("client1");
//
//        driver.findElement(By.cssSelector(".btn")).click();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        String nextUrl = driver.getCurrentUrl();
//
//        Assert.assertTrue(nextUrl.equals(hostUrl+"home"));
//    }
//
//    @After
//    public void quit() throws Exception {
//        driver.quit();
//    }
//}
