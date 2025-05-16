package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hook {
    public static WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
//        driver.get("https://ecommerce-playground.lambdatest.io/");

    }
    @After
    public void teardown() throws InterruptedException, IOException {
        takeScreenShot();
        Thread.sleep(2000);
        driver.close();
        driver.quit();

    }
    private void takeScreenShot() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile= scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(SrcFile,new File("target/screenshot"+System.currentTimeMillis()+".png"));
    }
}
