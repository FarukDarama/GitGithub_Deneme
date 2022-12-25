package day_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropdownTekrar {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://www.edding.com/tr-tr/fikirler/colouring-pages-and-templates/boyama-sayfalari/#filter=*;layout=muddled");
    }

    @Test

    public void selectByIndexTest(){
      WebElement options = driver.findElement(By.xpath("//*[@class='custom-select filter']"));
        Select dropdown = new Select(options);
       //dropdown.selectByIndex(2);
       //dropdown.selectByVisibleText("Araba boyama sayfaları");
       dropdown.selectByValue("134");

    }

    @Test
    public  void printAllOptionsTest(){
        WebElement options = driver.findElement(By.xpath("//*[@class='custom-select filter']"));
        Select dropdown = new Select(options);
        List<WebElement> catagories =  dropdown.getOptions();
        for (WebElement w:catagories){

            System.out.println(w.getText());
        }

    }

    @Test
    public void getSelectedOptionsTest() {
        WebElement options = driver.findElement(By.xpath("//*[@class='custom-select filter']"));
        Select dropdown = new Select(options);
        String defaultText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("*Choose category*",defaultText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }






}
