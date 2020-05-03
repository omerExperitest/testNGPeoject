import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class testNGBasicBrowserTest {

    private static final String ACCESS_KEY = "eyJ4cC51Ijo0NTExMTYsInhwLnAiOjIsInhwLm0iOiJNVFU0T0RVeE5UVXhOREk1TlEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE5MDM4NzU1MTQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.WtGN8_mBE_GgVw1SYjTbG7OSePmTsFVUiPRzOgt_J2g";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();
    private final String BROWSER = "chrome";


    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional (BROWSER) String browser) throws Exception {
        System.out.println(new Date() + "\t" + "Starting test for - " + browser);
        url = new URL("https://demo.experitest.com/wd/hub");
        if (browser.equalsIgnoreCase("firefox")) {
            dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        } else if (browser.equalsIgnoreCase("chrome")) {
            dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        } else {
            dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.SAFARI);
            dc.setCapability(CapabilityType.PLATFORM, Platform.ANY);
        }
        dc.setCapability("accessKey", ACCESS_KEY);
        dc.setCapability("testName", "Demo Browsers Test");
        dc.setCapability("CustomerDemoName", "ATB");
        dc.setCapability("reporterURL", "https://qacloud.experitest.com/reporter/#/test-view-view/852");
        driver = new RemoteWebDriver(url, dc);
    }

    @Test
    public void SuccessfulTest() {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("lst-ib")));
//        WebElement searchBar = driver.findElement(By.id("No Such element"));
        WebElement searchBar = driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
        searchBar.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchBar.sendKeys("Experitest");
        searchBar.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}