package myPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

class LoginData
{
    private String _username;
    private String _password;

    public LoginData(String username, String password)
    {
        this.set_username(username);
        this.set_password(password);    
    }

    public String get_username()
    {
        return _username;
    }

    private void set_username(String _username)
    {
        this._username = _username;
    }

    public String get_password()
    {
        return _password;
    }

    private void set_password(String _password)
    {
        this._password = _password;
    }

}
public class MyDemo {
	public static void main(String[] args) throws Exception {
        LoginData data = new LoginData("username","password");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\testing\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com");
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("username"));
		Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys(data.get_username());
        Thread.sleep(3000);
        driver.findElement(By.name("password"));
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys(data.get_password());
        Thread.sleep(3000);
        driver.findElement(By.className("sqdOP.L3NKy.y3zKF")).click();
        Thread.sleep(3000);
        driver.close();
	}
//	public static void main (String[] args) throws Exception{
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\testing\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.amazon.in/");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("anjeer");
//		for(int i=1;i<=5;i++) {
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ARROW_DOWN);
//		Thread.sleep(3000);
//		}
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		driver.close();
//	}
}
