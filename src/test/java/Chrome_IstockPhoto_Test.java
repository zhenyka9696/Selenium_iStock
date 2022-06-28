import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public  class Chrome_IstockPhoto_Test {
    protected static WebDriver driver;
protected final String baseUrl="https://www.istockphoto.com/ru";//75

  @Test//не jupiter
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
    @Order(2)

    //Перейти по ссылке "Архитектура"
    public void getArchitecture()throws InterruptedException {
        Thread.sleep(5);//Почему проблемы с задержкой??
        driver.get(baseUrl + "/стоковое-видео/архитектура");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains
                ("стоковые hd видеоклипы".toUpperCase()));
    }

      @Test
      @Order(3)
      //В самом низу справа
    public void getLegalInformation() throws InterruptedException
      {
         Thread.sleep(5);
driver.get(baseUrl+"/EULegal");
Assertions.assertEquals("https://www.istockphoto.com/ru/EULegal",driver.getCurrentUrl());
       //39
          //Потом продажа работ
          }

    @Test
    @Order(4)
    //Тоже внизу//68
    public void work_WithUs() throws InterruptedException
    {
        Thread.sleep(5);
        driver.get("https://www.gettyimages.com/workwithus");
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Work With Us".toUpperCase()));
    }

    @Test
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
    }

    @Test
    @Order(6)
    //Тоже внизу//70
    public void Support() throws  InterruptedException{
        Thread.sleep(5);
        driver.get(baseUrl);
        Thread.sleep(5);
        WebElement support=driver.findElement(By.xpath("//*[@id='footer']/div/div[4]/ul/li[4]/a"));
        support.click();
        Thread.sleep(5);
        Assertions.assertTrue(driver.getTitle().toUpperCase().contains("Обратитесь в нашу службу".toUpperCase()));
    }

    @Test
    @Order(7)
    public void supportCheck() throws InterruptedException
    {
        Thread.sleep(5);
       // System.out.println(driver.getCurrentUrl());
        WebElement uiId1=driver.findElement(By.xpath("//*[@id='ui-id-1']"));
        uiId1.isDisplayed();

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

