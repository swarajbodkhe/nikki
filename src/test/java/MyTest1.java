import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class MyTest1 {



        @Test(invocationCount = 30000)
        public void mytest123(){
            Demo.VoteNikki();
        }

        @Test(invocationCount = 30000)
        public void mytest1234(){
        Demo.VoteNikki();
    }

    @AfterMethod
    public  void cleanup(){

    }


}
