import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyTest1 {

    ThreadLocal<RemoteWebDriver> rc;
    @BeforeMethod
    public void a() throws MalformedURLException {
        rc=new ThreadLocal<>();
        DesiredCapabilities capabilities= DesiredCapabilities.chrome();
        capabilities.setPlatform(Platform.ANY);
        capabilities.setBrowserName("chrome");
        rc.set(new RemoteWebDriver(new URL("http://192.168.43.73:4444/wd/hub"),capabilities));
    }

        @Test(invocationCount = 5)
        public void mytest123(){
            Demo.VoteNikki(rc.get());
        }

        @Test(invocationCount = 5)
        public void mytest1234(){
        Demo.VoteNikki(rc.get());
    }
}
