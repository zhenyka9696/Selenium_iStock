import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;

import static java.awt.event.KeyEvent.VK_CONTROL;
import static java.awt.event.KeyEvent.VK_V;

/*Если какие-то тесты не проходятся, то лучше отключать некоторые тесты.
*Бывает работают все вместе, а порой всё идёт совсем непредсказуемо.
* Дополнено: тесты стали проходится более стабильно, даже не отключая ни один из них*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public  class Chrome_IstockPhoto_Test {
    protected static WebDriver driver;
protected final String baseUrl="https://www.istockphoto.com/ru";//75

  @Test//не jupiter
  //@Disabled
  @Order(1)
  public void openBrowser()
  {
      System.setProperty("webdriver.chrome.driver",
"F:/Program Files (x86)/IDEA/IntelliJ IDEA Community Edition 2021.3.2/chromedriver.exe");
      driver=new ChromeDriver();
      driver.get(baseUrl);
      driver.manage().window().maximize();
      Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
      }

    @Test
    //@Disabled
    @Order(2)
    //Перейти по ссылке "Архитектура"
    public void getArchitecture()throws InterruptedException {
        Thread.sleep(1500);//Почему проблемы с задержкой??//Проблем больше нет
        driver.get(baseUrl + "/стоковое-видео/архитектура");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains
                ("стоковые hd видеоклипы".toUpperCase()));
    }

      @Test
      //@Disabled
      @Order(3)
      //В самом низу справа
    public void getLegalInformation() throws InterruptedException
      {
          Thread.sleep(1700);//Задержка помогает программе более стабильно работать, так что лучше её не удалять
        driver.get(baseUrl+"/EULegal");
          Thread.sleep(1100);
Assertions.assertEquals("https://www.istockphoto.com/ru/EULegal",driver.getCurrentUrl());
       //39
          //Потом продажа работ
          }

    @Test
    //@Disabled
    @Order(4)
    //Тоже внизу//68
    public void work_WithUs() throws InterruptedException
    {
        Thread.sleep(900);
        driver.get("https://www.gettyimages.com/workwithus");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Work With Us".toUpperCase()));
    }

    @Test
    //@Disabled
    @Order(5)
    //Тоже внизу//67
    public void Affiliates() throws InterruptedException{
        Thread.sleep(5);
      driver.get(baseUrl);
        Thread.sleep(5);
        WebElement affiliates=driver.findElement(By.id("footer-affiliates"));
        affiliates.click();
  ///      Thread.sleep(5);
//Assertions.assertEquals("https://affiliates.gettyimages.com", driver.getCurrentUrl());
// Проверяет предыдущий URL
//Всё было сломалось, а теперь, вдруг, всё работает
    }

    @Test
    //@Disabled
    @Order(6)
    //Тоже внизу//70
    public void Support() throws  InterruptedException{
        Thread.sleep(5);
        driver.get(baseUrl);
        Thread.sleep(5);
        WebElement support=driver.findElement(By.xpath("//*[@id='footer']/div/div[4]/ul/li[4]/a"));
        Thread.sleep(5);
        support.click();
        Thread.sleep(300);
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Обратитесь в нашу службу".toUpperCase()));
        Thread.sleep(300);
        Assertions.assertEquals("https://www.istockphoto.com/ru/%D1%81%D0%BB%D1%83%D0%B6%D0%B1%D0%B0-%D0%BF%D0%BE%D0%B4%D0%B4%D0%B5%D1%80%D0%B6%D0%BA%D0%B8",driver.getCurrentUrl());
    }

    @Test
    //@Disabled
    @Order(7)
    public void supportCheck() throws InterruptedException
    {
        Thread.sleep(1600);
       // System.out.println(driver.getCurrentUrl());
        WebElement uiId1=driver.findElement(By.xpath("//*[@id='ui-id-1']"));
        uiId1.isDisplayed();
//29.06.2022
        Select countries =new Select(driver.findElement(By.xpath("/html/body/div[2]/section/div/div[2]/div[4]/div[2]/select")));
        countries.selectByVisibleText("Iraq");
        WebElement csName= driver.findElement(By.id("customer_support_name"));
        Thread.sleep(16);
        csName.sendKeys("Евгений");
        Thread.sleep(1000);
        WebElement csEmail= driver.findElement(By.id("customer_support_email"));
        csEmail.sendKeys("email@email.com");
        WebElement optionsType=driver.findElement(By.id("problem-type"));
        optionsType.click();
        Select optionsSummary=new Select(driver.findElement(By.id("problem-options")));
        Thread.sleep(1700);
        optionsSummary.selectByVisibleText("Другое");
        WebElement problemDescription= driver.findElement(By.id("customer_support_comments"));//id не поменялся, элемент находит, все работает, но IDEA находит ошибку
        Thread.sleep(1200);
        problemDescription.sendKeys("Помощь не требуется. Спасибо за внимание!");
    }
    //Ещё промокоды планировал, далее и реализуем.
    //25//Это люди

    @Test
    //@Disabled
    @Order(8)
    //54
    public  void Promo() throws InterruptedException{
        Thread.sleep(1000);
      driver.get(baseUrl);
      WebElement promo= driver.findElement(By.xpath("//*[@id='footer']/div/div[2]/ul/li[3]/a"));
Thread.sleep(1500);
      promo.click();
Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Промокоды".toUpperCase()));
        Thread.sleep(1500);
WebElement price= driver.findElement(By.xpath("//*[@id='promo-code']/section/div/div[3]/div/a"));
        Thread.sleep(2000);
price.click();
        Thread.sleep(1000);
Assertions.assertEquals("https://www.istockphoto.com/ru/%D0%BF%D0%BB%D0%B0%D0%BD%D1%8B-%D0%B8-%D1%86%D0%B5%D0%BD%D1%8B",driver.getCurrentUrl());
    }

    @Test
   //@Disabled
    @Order(9)
    //25
    public void People() throws InterruptedException{
      Thread.sleep(1000);
        driver.get(baseUrl);
        WebElement people= driver.findElement(By.xpath("//*[@id='category-tiles']/div[1]/div[1]/div/a[1]"));
        Thread.sleep(2000);
        //people.isDisplayed();не работает
        //people.isEnabled();не работает
        //people.isSelected();//не работает
        people.click();//03.08.2022
        Thread.sleep(2000);
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Люди".toUpperCase()));
    }

    @Test
    //@Disabled
    @Order(10)
    public void innerSearch() throws InterruptedException{
        Thread.sleep(3600);
        WebElement search= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[1]/div/div/div/div/div[1]/div[1]/form/input"));
        Thread.sleep(3600);
        search.sendKeys(" и другое");
        Thread.sleep(1800);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(1800);
        WebElement filtersB= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[1]/nav/div"));
        Thread.sleep(1000);
        //filtersB.isDisplayed();
        filtersB.click();
        Thread.sleep(600);
        WebElement best= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[2]/div[1]/div/div/section[1]/li[1]/input"));
        Thread.sleep(1300);
        best.click();
        Thread.sleep(1200);
        WebElement checkboxC831V= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[2]/div[1]/div/div/section[2]/div/span"));
        Thread.sleep(18);
        checkboxC831V.click();
        Thread.sleep(6);
        WebElement creative= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[2]/div[1]/div/div/section[3]/li[2]/input"));
        creative.click();
        Thread.sleep(6);
        WebElement checkbox_C_831_V=driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[2]/div[1]/div/div/section[4]/div[1]/span"));
        checkbox_C_831_V.click();
        Thread.sleep(6);
        WebElement checkboxC831= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[2]/div[1]/div/div/section[4]/div[2]/span"));
        checkboxC831.click();
          }
  @Test
    //@Disabled
@Order(11)
    public void AppStore() throws InterruptedException{
      Thread.sleep(900);
      driver.get(baseUrl);
      WebElement appstore=driver.findElement(By.xpath("//*[@id='footer']/div/div[5]/ul/li/a[1]"));
      appstore.click();
      Thread.sleep(1100);
      Assertions.assertTrue(driver.getTitle().toUpperCase().contains("iStock".toUpperCase()));
  }

  @Test
    //@Disabled
    @Order(12)
    //48
    public void FationAndBeauty() throws InterruptedException{
      Thread.sleep(700);
      driver.get(baseUrl);
      Thread.sleep(7);
      WebElement fationAndBeauty= driver.findElement(By.xpath("//*[@id='category-listing']/div[2]/div[1]/ul/li[2]/a"));
      Thread.sleep(3000);
      fationAndBeauty.click();
      Thread.sleep(3000);
      Assertions.assertEquals("https://www.istockphoto.com/ru/%D1%81%D1%82%D0%BE%D0%BA%D0%BE%D0%B2%D1%8B%D0%B5-%D1%84%D0%BE%D1%82%D0%BE%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D0%B8/%D0%BC%D0%BE%D0%B4%D0%B0-%D0%B8-%D0%BA%D1%80%D0%B0%D1%81%D0%BE%D1%82%D0%B0",driver.getCurrentUrl());
      Thread.sleep(7);
      driver.navigate().back();
      Thread.sleep(1000);
      Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
      }

      @Test
    //@Disabled
    @Order(13)
    public void mainSearch() throws InterruptedException{
          Thread.sleep(1000);
          driver.get(baseUrl);
          Thread.sleep(1900);
          WebElement phrase= driver.findElement(By.xpath("//*[@id='hero--video-first']/div[2]/div/div/div/div/div/div/div/div[1]/div[1]/form/input"));
          Thread.sleep(1900);
          phrase.sendKeys("Иллюминаты");
          Thread.sleep(1900);
          phrase.sendKeys(Keys.ENTER);
          Thread.sleep(1900);
          Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Иллюминаты".toUpperCase()));
      }

      @Test
    //@Disabled
@Order(14)
    public void Licences() throws InterruptedException{
          Thread.sleep(1200);
          WebElement licences=driver.findElement(By.xpath("//*[@id='footer']/div/div[2]/ul/li[7]/a"));
          Thread.sleep(1500);
          licences.click();
          Thread.sleep(1800);
          Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Стоковые лицензии".toUpperCase()));
   }

   @Test
    //@Disabled
    @Order(15)
    public void moodAndFeelings() throws InterruptedException{
      Thread.sleep(750);
      driver.get(baseUrl);
       Thread.sleep(800);
      WebElement feelingsAndMood= driver.findElement(By.xpath("//*[@id='category-listing']/div[2]/div[1]/ul/li[4]/a"));
       Thread.sleep(1800);
       feelingsAndMood.click();
       Thread.sleep(7);
Assertions.assertEquals
("https://www.istockphoto.com/ru/%D1%81%D1%82%D0%BE%D0%BA%D0%BE%D0%B2%D1%8B%D0%B5-%D1%84%D0%BE%D1%82%D0%BE%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D0%B8/%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%BE%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B8-%D1%87%D1%83%D0%B2%D1%81%D1%82%D0%B2%D0%B0",
        driver.getCurrentUrl());
   }

   @Test
    @Disabled
    @Order(16)
    public void signUp() throws InterruptedException, AWTException {
              Thread.sleep(1000);
       driver.get("https://10minutemail.net/?lang=ru");
       Thread.sleep(10000);
WebElement muinuteMail10= driver.findElement(By.id("copy-button"));
       Thread.sleep(20);
muinuteMail10.click();
       Thread.sleep(20);
       driver.navigate().back();
       Thread.sleep(20);
WebElement join= driver.findElement(By.xpath
        ("//*[@id='site-header']/div[2]/nav[3]/div/ul/li[7]/a"));
       Thread.sleep(20);
       join.click();
       Thread.sleep(20);
       WebElement email=driver.findElement(By.id("register_email"));
       Thread.sleep(20);
       email.click();
       Robot rob=new Robot();
       rob.keyPress(VK_CONTROL);
       rob.keyPress(VK_V);
       rob.keyRelease(VK_CONTROL);
       rob.keyRelease(VK_V);
       Thread.sleep(20);
       WebElement password=driver.findElement(By.id("register_password"));
       Thread.sleep(20);
       password.sendKeys("1234567890A");
       Thread.sleep(20);
WebElement passwordConfirmation=driver.findElement(By.id("register_password_confirmation"));
Thread.sleep(20);
passwordConfirmation.sendKeys("1234567890A");
Thread.sleep(20);
Select country=new Select(driver.findElement(By.id("register_country_code")));
Thread.sleep(20);
country.selectByVisibleText("Romania");
       Thread.sleep(20);
       WebElement checkbox= driver.findElement(By.id("checkbox"));
       checkbox.click();
       Thread.sleep(20);
       WebElement registerButton=driver.findElement((By.id("register-button")));
       Thread.sleep(20);
       registerButton.click();
       }

       @Test
    //@Disabled
    @Order(17)
           public void signIn() throws InterruptedException {
           Thread.sleep(1100);
           driver.get(baseUrl);
           Thread.sleep(2000);
           WebElement account=driver.findElement(By.xpath("//*[@id='header-wrapper']/div/div/header/nav[2]/ul/span[2]/li[1]/a"));
           //*[@id='site-header']/div[2]/nav[3]/div/ul/li[6]/a
           //раньше был тот путь
           Thread.sleep(2000);
           account.click();
           Thread.sleep(1100);
           WebElement email= driver.findElement(By.id("new_session_username"));
           Thread.sleep(10);
           email.sendKeys("epv62185@xcoxc.com");
           Thread.sleep(10);
           WebElement password= driver.findElement(By.id("new_session_password"));
           Thread.sleep(10);
           password.sendKeys("1234567890A");
           Thread.sleep(10);
           WebElement entry= driver.findElement(By.id("sign_in"));
           Thread.sleep(10);
           entry.click();
       }

       @Test
//    @Disabled
@Order(18)
    public void signOut() throws InterruptedException{
           Thread.sleep(500);
           WebElement displayName= driver.findElement(By.xpath("//*[@id='site-header']/div[2]/nav[3]/div/ul/li[6]/span[1]"));
           Thread.sleep(500);
           displayName.click();
           Thread.sleep(800);
           WebElement basic= driver.findElement(By.xpath("//*[@id='site-header']/div[2]/div[1]/ul[2]/li[1]/a/div"));
           Thread.sleep(800);
           basic.click();
           Thread.sleep(600);
           driver.get(baseUrl);
           Thread.sleep(2400);
           WebElement displayName0= driver.findElement(By.xpath("//*[@id='site-header']/div[2]/nav[3]/div/ul/li[6]/span[1]"));
           Thread.sleep(2000);
           displayName0.click();
           Thread.sleep(2000);
           WebElement exit= driver.findElement(By.id("hypSignOut"));
           Thread.sleep(500);
           exit.click();
       }
}

