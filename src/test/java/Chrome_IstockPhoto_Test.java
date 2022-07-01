import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
//Зависает частенько после второго и третьего теста
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
        WebElement problemDescription= driver.findElement(By.id("customer_support_comments"));
        Thread.sleep(1200);
        problemDescription.sendKeys("Помощь не требуется. Спасибо за внимание!");
//do {}
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
        //*[@id="footer"]/div/div[2]/ul/li[3]/a
        Thread.sleep(700);
      promo.click();
Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Промокоды".toUpperCase()));
        Thread.sleep(7);
WebElement price= driver.findElement(By.xpath("//*[@id='promo-code']/section/div/div[3]/div/a"));
        Thread.sleep(7);
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
        Thread.sleep(1400);
        people.click();
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Люди".toUpperCase()));
    }

    @Test
    //@Disabled
    @Order(10)
    public void innerSearch() throws InterruptedException{
        Thread.sleep(1800);
        WebElement search= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[1]/div/div/div/div/div[1]/div[1]/form/input"));
        Thread.sleep(18);
        search.sendKeys(" и другое");
        Thread.sleep(18);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(18);
        WebElement filtersB= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[1]/nav/div"));
        Thread.sleep(1000);
        //filtersB.isDisplayed();
        filtersB.click();
        Thread.sleep(600);
        WebElement best= driver.findElement(By.xpath("/html/body/div[2]/section/div/main/div/div/div[2]/div[1]/div/div/section[1]/li[1]/input"));
        Thread.sleep(18);
        best.click();
        Thread.sleep(18);
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
      Thread.sleep(65);
      fationAndBeauty.click();
      Thread.sleep(7);
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
          Thread.sleep(19);
          phrase.sendKeys("Иллюминаты");
          Thread.sleep(19);
          phrase.sendKeys(Keys.ENTER);
          Thread.sleep(19);
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
       Thread.sleep(7);
       feelingsAndMood.click();
       Thread.sleep(7);
Assertions.assertEquals
("https://www.istockphoto.com/ru/%D1%81%D1%82%D0%BE%D0%BA%D0%BE%D0%B2%D1%8B%D0%B5-%D1%84%D0%BE%D1%82%D0%BE%D0%B3%D1%80%D0%B0%D1%84%D0%B8%D0%B8/%D0%BD%D0%B0%D1%81%D1%82%D1%80%D0%BE%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B8-%D1%87%D1%83%D0%B2%D1%81%D1%82%D0%B2%D0%B0",
        driver.getCurrentUrl());
   }

    /*
    @Test
    @Disabled
    @Order(100)
    public void signUp() {
        //*[@id="register_email"]
        //*[@id="register_password"]
        //*[@id="register_password_confirmation"]
        WebElement email = driver.findElement(By.id("register_email"));
        email.sendKeys(generate());
        WebElement password = driver.findElement(By.id("register_password"));
        password.sendKeys("abc1234567890");
        WebElement passwordConfirm = driver.findElement(By.id("register_password_confirmation"));
        passwordConfirm.sendKeys("abc1234567890");
        Select countries = new Select(driver.findElement(By.id
                ("register_country_code")));
        countries.selectByVisibleText("Российская Федерация");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        checkbox.click();
        WebElement button = driver.findElement(By.xpath("//*[@id='register-button']"));
        button.click();
    }
*/

   /* @Test
    @Disabled
    public void search(){
        String text="text";
        //*[@id="hero--video-first"]/div[2]/div/div/div/div/div/div/div/div[1]/div[1]/form/input
        WebElement input= driver.findElement(By.xpath("//SearchBox-istock-module__input___MBrbS[@name='phrase']"));
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        input.sendKeys(text);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        input.sendKeys(Keys.ENTER);
        //проверка, что поиск состоялся
        Assertions.assertTrue(driver.getCurrentUrl().contains("google.com/search"));
    }*/
}

