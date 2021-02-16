
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class MyTest1 {


        @RepeatedTest(5)
        @Timeout(value = 90000)
        public void mytest123(){
            Demo.VoteNikki();
        }
}
