import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogTest {

	Logger logger = Logger.getLogger(this.getClass());
	private static WebDriver driver;
	 
	@Test
	public void testlog(){
		
		logger.info("Starting..");
		logger.debug("Very detailed log");
		logger.fatal("Terribly failing!");
} 
	
	@BeforeClass
	 public static void beforeClass() throws Exception {
	  
	  driver = new FirefoxDriver();
	  driver.get("http://timvroom.com/selenium/playground/");
	 }

	 @Test
	 public void task01() {

	  driver.findElement(By.id("answer1")).sendKeys(driver.getTitle());
	  
	 }
	 
	 @Test
	 public void task02(){
		 
		 driver.findElement(By.id("name")).sendKeys("Kilgore Trout");
	 }
	 
	 @Test
	 public void task03(){
		 
		 WebElement dropDownList = driver.findElement(By.id("occupation"));
		 new Select(dropDownList).selectByValue("scifiauthor");
	 }
	 
	 @Test
	 public void task04(){
		 
		 int box = driver.findElements(By.className("bluebox")).size();
		 String count= String.valueOf(box);
		 driver.findElement(By.id("answer4")).sendKeys(count);
	}
	 
	 @Test
	 public void task05(){
		 
		 driver.findElement(By.linkText("click me")).click();
		 
		 try {
			   TimeUnit.SECONDS.sleep(2L);
			  } catch (InterruptedException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
		 }
	 
	 @Test
	 public void task06(){
		 
		 	String redBoxClassName = driver.findElement(By.id("redbox")).getAttribute("class");
			driver.findElement(By.id("answer6")).sendKeys(redBoxClassName);
	 }
	 @Test
	 public void task07(){
		
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("ran_this_js_function()");
		 }
	 

	 @Test
	 public void task08(){
	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		Long returnValue = (Long)executor.executeScript("return got_return_from_js_function()");
		String value = String.valueOf(returnValue);
		driver.findElement(By.id("answer8")).sendKeys(value);
	 }
	 
	 @Test
	 public void task09(){
	
		 driver.findElement(By.xpath("//*[@value='wrotebook']")).click();
		}
	 
	@Test
	 public void task10(){
		 
		 WebElement element = driver.findElement(By.id("redbox"));
		 driver.findElement(By.id("answer10")).sendKeys(element.getText());
		 }
	
	@Test
	 public void task11(){
	
	      Point orange = driver.findElement(By.id("orangebox")).getLocation();
		  Point green = driver.findElement(By.id("greenbox")).getLocation();

		  if (orange.y > green.y){
		   //green
		   driver.findElement(By.id("answer11")).sendKeys("green");
		  } else {
		   driver.findElement(By.id("answer11")).sendKeys("orange");
		  }
	}
	
	@Test
	 public void task12(){
	
		  Dimension dimension = new Dimension (850, 650);
		  driver.manage().window().setSize(dimension);

		  }
	
	@Test
	 public void task13(){
	
		  List<WebElement> elementhere = driver.findElements(By.id("ishere"));
		  if (elementhere.size()== 0){
		   driver.findElement(By.id("answer13")) .sendKeys("no");
		  } else {
		   driver.findElement(By.id("answer13")) .sendKeys("yes");
		  }
}
	 
	@Test
	 public void task14(){
	
		Boolean isElement = driver.findElement(By.id("purplebox")).isDisplayed();
		  if (isElement ){
		   //yes
		   driver.findElement(By.id("answer14")) .sendKeys("yes");

		  } else {
		   driver.findElement(By.id("answer14")) .sendKeys("no");
		  }

}
	 
	@Test
	 public void task15(){
	
		driver.findElement(By.xpath("//a[.='click then wait']")).click();
		  WebDriverWait wait = new WebDriverWait (driver, 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='click after wait']")));
		  wait.pollingEvery(10,  TimeUnit.MILLISECONDS);
		  
		}
	 
	@Test
	 public void task16(){
	
		  driver.findElement(By.xpath("//a[.='click after wait']")).click();
		  driver.switchTo().alert().accept();
	}
	
	@Test
	 public void task17(){
	
		driver.findElement(By.id("submitbutton")).click();
	}
	
	@Test
	public void task18() {
		  driver.findElement(By.id("checkresults")).click();
	}

		
	 @AfterClass
	 public static void afterClass() {
	  
	  try {
	   TimeUnit.SECONDS.sleep(20L);
	  } catch (InterruptedException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  driver.close();
	 }

	
	
	
	
	
	
	
	
	
	
}	

