import org.junit.jupiter.api.*;
import org.openqa.selenium.edge.EdgeDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class Edge_IstockPhoto_Test extends Chrome_IstockPhoto_Test{

    @Test
    @Order(1)
    public void openBrowser()
    {
        System.setProperty("webdriver.edge.driver",//3
                "F:/Program Files (x86)/IDEA/IntelliJ IDEA Community Edition 2021.3.2/msedgedriver.exe");
        driver=new EdgeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Assertions.assertEquals(baseUrl,driver.getCurrentUrl());
    }
}