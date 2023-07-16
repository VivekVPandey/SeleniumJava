package basicAuto;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Demo {

	public static void main(String[] args) throws Exception  {
		
		String userName= "VivekP";
		String password= "TestPass";
		
		System.setProperty("WebDriver.chrome.driver", "src/test/java/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//form/h2")).getText());
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("vivek pandey");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("vivek@test.cm");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("9090909090");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		String p= driver.findElement(By.xpath("//p[contains(@class,'infoMsg')]")).getText();//xpath contains text
		System.out.println(p);
		
		String s[]=p.split("'");
		//System.out.println(s[1]);
		password=s[1];
		
		driver.findElement(By.cssSelector("button[class*='login']")).click();//css selector contains text
		Thread.sleep(1000);
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText());
		String actual=driver.findElement(By.xpath("//div[contains(@class,'login')]/h2")).getText();
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'login')]/h1")).getText());
		assertEquals(true,actual.contains(userName));	
		driver.findElement(By.xpath("//button[contains(text(),'Out')]")).click();//xpath button text	
		
		driver.close();
		
		}
}
