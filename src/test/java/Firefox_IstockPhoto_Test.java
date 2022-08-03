import org.junit.jupiter.api.*;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Firefox_IstockPhoto_Test extends Chrome_IstockPhoto_Test {
@Test
    @Order(1)
public void openBrowser()
{
    System.setProperty("webdriver.gecko.driver",//3
            "F:/Program Files (x86)/IDEA/IntelliJ IDEA Community Edition 2021.3.2/geckodriver.exe");
    driver=new FirefoxDriver();
    driver.get(baseUrl);
    driver.manage().window().maximize();
    Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
}
}
