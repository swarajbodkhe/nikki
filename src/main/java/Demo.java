import net.andreinc.mockneat.MockNeat;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Demo {

    public static String randomEmail(){
        MockNeat m= MockNeat.old();
        return m.emails().domain("gmail.com").val();
    }

    public static String randomName(){
        MockNeat m= MockNeat.old();
        return m.names().val().split(" ")[0];
    }


    public static void VoteNikki() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver=null;

            try{
                 driver= new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                driver.get("http://www.voot.com");
                WebDriverWait wt = new WebDriverWait(driver, 10);

                wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'Avatar')]"))));
                WebElement AccountIcon = driver.findElement(By.xpath("//img[contains(@src,'Avatar')]"));
                AccountIcon.click();
                wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[contains(@class,'MuiList')])[1]//span"))));
                WebElement LogIn = driver.findElement(By.xpath("(//div[contains(@class,'MuiList')])[1]//span"));
                LogIn.click();


                wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@role='dialog']//button)[3]"))));
                WebElement ContinueWithEmail = driver.findElement(By.xpath("(//div[@role='dialog']//button)[3]"));
                ContinueWithEmail.click();

                //from here
                WebElement email=driver.findElement(By.id("email"));
                email.sendKeys(randomEmail());
                email.sendKeys(Keys.ENTER);

                WebElement pwd=driver.findElement(By.id("password"));
                pwd.sendKeys("password");
                pwd.sendKeys(Keys.ENTER);


                wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name"))));
                WebElement Name=driver.findElement(By.id("name"));
                WebElement dob=driver.findElement(By.id("dob"));
                WebElement gender=driver.findElement(By.xpath("//span[text()='Male']"));
                WebElement pref=driver.findElement(By.xpath("//button//label[text()='Select your preference']"));


                Name.sendKeys(randomName());
                dob.sendKeys("05/12/1992");
                gender.click();
                pref.click();
                WebElement save=driver.findElement(By.xpath("//button[text()='Save']"));
                save.click();
                wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'purple')]/.."))));
                WebElement agreeTerms=driver.findElement(By.xpath("//img[contains(@src,'purple')]/.."));
                agreeTerms.click();
                WebElement submit=driver.findElement(By.xpath("//button[text()='Submit']"));
                submit.click();
                wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[contains(@src,'closeButton')]/.."))));
                WebElement closeup1=driver.findElement(By.xpath("//img[contains(@src,'closeButton')]"));
                //Actions atc=new Actions(driver);
                //atc.moveToElement(closeup1,5,5).click().build().perform();
                // closeup1.click();
                //closeup1.sendKeys(Keys.F5);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                driver.get(driver.getCurrentUrl());
                // Till here

                try {
                    driver.manage().window().maximize();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 3; i++) {
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
                }

                WebElement voteNow=driver.findElement(By.xpath("(//button[contains(@class,'interactivityPlayButton')])[1]"));
                String mainWindowHandle = driver.getWindowHandle();
                voteNow.click();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Set<String> allWindowHandles = driver.getWindowHandles();
                Iterator<String> iterator = allWindowHandles.iterator();

                // Here we will check if child window has other child windows and will fetch the heading of the child window
                while (iterator.hasNext()) {
                    String ChildWindow = iterator.next();
                    if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                        driver.switchTo().window(ChildWindow);
                        WebElement nikki = driver.findElement(By.xpath("//img[@alt='Nikki Tamboli']"));
                        nikki.click();
                        WebElement submitBtn=driver.findElement(By.xpath("//button[text()='Submit']"));
                        submitBtn.click();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(text(),'Thank You for Voting')]"))));

                    }
                }

            }finally {
                driver.quit();
            }

    }


}
