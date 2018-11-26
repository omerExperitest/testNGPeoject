import org.openqa.selenium.*;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class testNGBasicBrowserTest {

    private static final String ACCESS_KEY = "eyJ4cC51IjoyMTczLCJ4cC5wIjoyLCJ4cC5tIjoiTVRVek9EZzBOak16TnpNd05RIiwiYWxnIjoiSFMyNTYifQ.eyJleHAiOjQ2OTI0NDYzMzcsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.Bw6n43YjA-z4gjTUVOtI_nzIZlIoQVO2WxfhnhdVH4U";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities dc = new DesiredCapabilities();

    @Parameters("browser")
    @BeforeTest
    public void setUp(String browser) throws Exception {
        System.out.println(new Date() + "\t" + "Starting test for - " + browser);
        url = new URL("https://qacloud.experitest.com/wd/hub");
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
        WebElement experitestLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"));
        experitestLink.click();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement freeTrial = driver.findElement(By.xpath("//*[@id=\"page_6858\"]/div[2]/div[1]/div[1]/a[1]/div"));
    }


    @AfterTest
    public void tearDown() {
        System.out.println("Link to reporter is " + dc.getCapability("reporterURL").toString());
        driver.quit();
    }
}