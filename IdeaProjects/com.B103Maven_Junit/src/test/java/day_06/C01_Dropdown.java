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

public class C01_Dropdown {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest(){
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken

        //  Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10
        //1.LOCATE dropdown element
        WebElement year =driver.findElement(By.xpath("//select[@id='year']"));
        //2.Select object olustur
        Select yearDropdown = new Select(year);
        //3. Selecet object kullşanarak 3 farklı secimde secim yapabilirim
        yearDropdown.selectByIndex(22);//SECENEK SIRASI 0 DAN BASLAR YAZARSAK İLK SECENEGİ SECER (2022)
         WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
         Select ayDropdown = new Select(ay);
         ayDropdown.selectByValue("0");//option in value degeri ile secim yapılabilir.January degerinin valuasi 0 oldugu için 0 yazdık

        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE

    }
    @Test
    public void printAllTest(){

     WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
     Select stateDropdown = new Select(state);
     List<WebElement> stateList = stateDropdown.getOptions();
     for (WebElement w :stateList){
         System.out.println(w.getText());
     }

    }

    @Test
    public void getSelectedOptionsTest(){

    //state dropdown undaki varsayılan secili secenegin Select a State oldugunu verify edelim
    WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
    Select stateDropdown = new Select(state);
    String varsayilanText =stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);
    }
   @After
    public void tearDown(){
        driver.close();
   }










   /*
      1.What is dropdown ?
      -->Liste olusturmak icin kullanılır
      2.How to handle dropdown elements?Dropdown nasıl automate edilir.
      -->1.dropdown ı locate ederim
         2.select object olustururum
         3.select object i ile istediğim secenegi secerim
         Not: selecet objecti olusturma nedenim dropdownların select class ile olusturulması
       3.Tum dropdown seceneklerini print ederiz ?
       -->tum drpodown elementlerini getOption() methodu ile listeye koyarız sonra secenekleri loop ile yazdırabiliriz
       4.Bir secenegin secilip secilmediğini otomate etmek icin ne yapılır

       getFirtsSelectedOption() methodu  secili olan secenegi return eder
     */







}
