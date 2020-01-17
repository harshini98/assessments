package myPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class Assessment {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\testing\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watches");
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Actions action=new Actions(driver);
		WebElement watch4=driver.findElement(By.cssSelector("img[data-image-index=\"3\"]"));
		action.moveToElement(watch4).click().build().perform();
		Screenshots.takepicture(driver, "watch1");
		Thread.sleep(3000);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(newTab.get(1));
		Screenshots.takepicture(driver, "watch2");
		driver.close();
		
		}				
	}

class Screenshots{
	public static void takepicture(WebDriver driver, String filename) throws Exception{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshots\\"+filename+".png"));
	}
}



