package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Tester {
    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();
        onnistunutKirjautuminen(driver);
        vaaraKayttajatunnus(driver);
        vaaraSalasana(driver);
        uusiKayttajatunnus(driver);
    }

    private static void onnistunutKirjautuminen(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }

    private static void vaaraKayttajatunnus(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("kalle");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }

    private static void vaaraSalasana(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println(driver.getPageSource());
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara salasana");
        element = driver.findElement(By.name("login"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
    }

    private static void uusiKayttajatunnus(WebDriver driver) {
        driver.get("http://localhost:8090");
        System.out.println( driver.getPageSource() );
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click(); 
        
        System.out.println("==");
        
        System.out.println( driver.getPageSource() );
        element = driver.findElement(By.name("username"));
        element.sendKeys("joonas2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("password1");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("password1");
        element = driver.findElement(By.name("add"));
        element.submit();
        
        System.out.println("==");
        System.out.println( driver.getPageSource() );
        System.out.println("==");

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        System.out.println("==");
        System.out.println( driver.getPageSource() );
        System.out.println("==");

        element = driver.findElement(By.linkText("logout"));
        element.click();

        System.out.println("==");
        System.out.println( driver.getPageSource() );
        System.out.println("==");
    }

    
}
