package org.OpenWebPages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenWebPage {
	public static void main(String[] args) {
	OpenWebPage owp=new OpenWebPage();
	owp.openChrome();
	owp.openFireFox();
	}
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\chromedriver.exe");
		ChromeDriver cobj=new ChromeDriver();
		cobj.get("https://www.google.com");
	}
	public void openFireFox() {
		System.setProperty("webdriver.gecko.driver",
				"F:\\Testing\\EclipseProgram\\SeleniumBasic\\Executables\\geckodriver.exe");
		FirefoxDriver fobj=new FirefoxDriver();
		fobj.get("https://www.google.com");
	}
}
