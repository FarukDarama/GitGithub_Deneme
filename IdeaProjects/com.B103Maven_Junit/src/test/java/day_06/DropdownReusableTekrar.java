package day_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DropdownReusableTekrar {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://www.edding.com/tr-tr/fikirler/colouring-pages-and-templates/boyama-sayfalari/#filter=*;layout=muddled");
    }

    public void  selectFromDropdown(WebElement dropdown,String secenek){
      List<WebElement> options=  dropdown.findElements(By.tagName("option"));
      for (WebElement w :options){
          if(w.getText().equals(secenek)){
              w.click();
              break;
          }
      }

    }

    @Test
    public void selectFromDropdown(){
        selectFromDropdown(driver.findElement(By.xpath("//*[@class='custom-select filter']")),"124");



    }






}
