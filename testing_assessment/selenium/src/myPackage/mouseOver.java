package myPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.TakesScreenshot;

class Screenshot{
	public static void takepicture(WebDriver driver, String filename) throws Exception{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\screenshots\\"+filename+".png"));
	}
}

public class mouseOver {
	public static void main(String[] args) throws Exception{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\testing\\chromedriver.exe");
		WebDriver d=new ChromeDriver(options);
		d.get("http://www.myntra.com");
		Screenshot.takepicture(d, "img1");
		Thread.sleep(1000);
		Actions action=new Actions(d);
		WebElement women=d.findElement(By.linkText("Women"));
		action.moveToElement(women).build().perform();
		Screenshot.takepicture(d, "img2");
		Thread.sleep(1000);
		WebElement ethnicDresses=d.findElement(By.linkText("Kurtas & Suits"));
		action.moveToElement(ethnicDresses).build().perform();
		Screenshot.takepicture(d, "img3");
		Thread.sleep(1000);
		ethnicDresses.click();
		Screenshot.takepicture(d, "img4");
		
	}
}
