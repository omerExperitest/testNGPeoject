import com.experitest.appium.SeeTestClient;

public class SeeTestClientHolder {
    private static SeeTestClientHolder ourInstance = new SeeTestClientHolder();
    private SeeTestClient mClient;

    public static SeeTestClientHolder getInstance() {
        return ourInstance;
    }

    private SeeTestClientHolder() {

    }
    public void setClient(SeeTestClient client){
        mClient = client;
    }
    public SeeTestClient getClient(){
        return  this.mClient;
    }
}
