import com.experitest.appium.SeeTestClient;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGTestListener extends TestListenerAdapter {
        @Override
        public void onTestFailure(ITestResult result){

            SeeTestClient client = SeeTestClientHolder.getInstance().getClient();
            client.setReportStatus("failed","failed blah blah blah "+ System.currentTimeMillis());
            System.out.println("AHhhhhhhhhhhhhhhhhhhhhh failed!!!!!!!!!");
        }
    }

