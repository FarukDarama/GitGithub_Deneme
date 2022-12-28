package tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Homework_01 {
    WebDriver driver;

    @Before
    public void setup(){
        //1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String anaSayfa = driver.findElement(By.xpath("//*[@style='color: orange;']")).getText();
        String beklenen = "Home";
        Assert.assertEquals(anaSayfa,beklenen);
        //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
        //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
        String actual = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        String beklenen1 ="New User Signup!";
        Assert.assertEquals(actual,beklenen1);
        //6. Adı ve e-posta adresini girin
        //7. 'Kaydol' düğmesini tıklayın (Keys.TAB,Keys.ENTER);)
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Hava", Keys.TAB,
                "haahhahjjjhhvvaAA.ozCbayy@hotmail.com",Keys.TAB,Keys.ENTER);
        //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
        String actual1 = driver.findElement(By.xpath("//*[@class='title text-center']")).getText();
        String expected1 = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(expected1,actual1);
        //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345");
        WebElement day = driver.findElement(By.xpath("//*[@id='days']"));
        Select dayDropdown = new Select(day);
        dayDropdown.selectByValue("27");
        //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).sendKeys("April",Keys.TAB).sendKeys("1990").sendKeys(Keys.TAB,Keys.SPACE).sendKeys(Keys.TAB,Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys("Hava",Keys.TAB).sendKeys("Ozbay",Keys.TAB).sendKeys(Keys.TAB,Keys.SPACE).sendKeys("Madrid",Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("India",Keys.SPACE).sendKeys(Keys.TAB).sendKeys("Orense",Keys.TAB).sendKeys("Barce",Keys.TAB)
                .sendKeys("32002",Keys.TAB).sendKeys("610196545",Keys.TAB).perform();
        //13. 'Hesap Oluştur düğmesini' tıklayın
        driver.findElement(By.xpath("(//*[@class='btn btn-default'])[1]")).click();
        actions.sendKeys(Keys.TAB,Keys.SPACE).perform();
        //14. 'HESAP OLUŞTURULDU!' görünür
        WebElement devam = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(devam.isDisplayed());
        //15. 'Devam Et' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
        WebElement hava = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(hava.isDisplayed());
        //17. 'Hesabı Sil' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın
        WebElement delete = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(delete.isDisplayed());
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
    }
    @After
    public void hhh(){
        driver.close();
    }







}

