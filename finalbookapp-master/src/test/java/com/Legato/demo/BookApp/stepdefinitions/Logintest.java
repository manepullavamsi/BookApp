package com.Legato.demo.BookApp.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Logintest {
	
	WebDriver driver;
	WebElement target;
	
	@Given("Open the Chrome and start application")
	public void Open_the_Chrome_and_start_application()
	{

		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(chromeOptions);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		
	}
	
	
	
	
	@Given("user is on registration page")
	public void user_is_on_registration_page() throws InterruptedException 
	{

		driver.navigate().to("http://localhost:8080/");
		

		driver.findElement(By.xpath("//img[@id='icon']")).click();
		
		
		driver.findElement(By.xpath("//a[contains(text(),'SignUp')]")).click();
		Thread.sleep(1000);
	}

	@When("User enter all valid details")
	public void user_enter_all_valid_details() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pranavi123");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pranavi@gmail.com");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pranavi@12345");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='confpassword']")).sendKeys("pranavi@12345");
		Thread.sleep(1000);
		
		target = driver.findElement(By.xpath("//input[@id='profile']"));
		Thread.sleep(1000);
		
		target.sendKeys("C:\\Users\\sujith\\Documents\\image1.jpg");
		Thread.sleep(1000);
		
	   
	}
	

	@When("user clicks on signup button")
	public void user_clicks_on_signup_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='btn-color']")).click();
		Thread.sleep(3000);
	}

	@Then("user is navigated to login")
	public void user_is_navigated_to_login() throws InterruptedException {
	    driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
	    Thread.sleep(2000);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("pranavi123");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("pranavi@12345");
		Thread.sleep(2000);
	}
	@And("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		driver.findElement(By.id("btn-color")).click();
		Thread.sleep(1000);
	}
	
	@Then("user is navigated to homepage")

	public void user_is_navigated_to_homepage() throws InterruptedException{
		driver.findElement(By.xpath("//h1[@id='colorNav']")).isDisplayed();
		Thread.sleep(1000);
//		driver.close();
	}
	/*@Then("user click on profile image")
	public void user_click_on_profile_image() throws InterruptedException {
	    driver.findElement(By.xpath("//img[@id='icon']")).click();
	    Thread.sleep(2000);
	}

	@Then("user click on books")
	public void user_click_on_books() throws InterruptedException {
	    driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
	    Thread.sleep(2000);
	}*/

	@Then("user clicks on search button")
	public void user_clicks_on_search_button() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='search-btn']")).click();
	    Thread.sleep(2000);
	}
	
	@Then("user clicks search bar and  search the books")
	public void user_clicks_search_bar_and_search_the_books() throws InterruptedException
	{
		target = driver.findElement(By.xpath("//input[@id='search-box']"));
		
		target.click();
		Thread.sleep(2000);
		target.sendKeys("java");
		Thread.sleep(2000);
	}

 
	@Then("user clicks search button")
	public void user_clicks_search_button() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@id='search']")).click();
		Thread.sleep(2000);
	}
	@Then("user clicks on add to favorite button")
	public void user_clicks_on_add_to_favorite_button() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='intro']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]")).click();
		Thread.sleep(2000);
	}
	@Then("user clicks favirote textlink")
	public void user_clicks_favirote_textlink() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//a[contains(text(),'Favourites')]")).click();
		Thread.sleep(2000);
		
	}
	@And("user navigated to HomePage")
	public void user_navigated_to_HomePage() throws InterruptedException
	{
		driver.findElement(By.xpath("//body/nav[1]/a[1]")).click();
		 Thread.sleep(2000);
	}
	
	/*@Then("user click on profile")
	public void user_click_on_profile() throws InterruptedException {
	    driver.findElement(By.xpath("//img[@id='icon']")).click();
	    Thread.sleep(2000);
	}
	@Then("user selects on books")
	public void user_selects_on_books() throws InterruptedException {
	    driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();
	    Thread.sleep(2000);
	}*/
	
	/*@Then("user clicks on search btn")
	public void user_clicks_on_search_btn() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='search-btn']")).click();
	    Thread.sleep(2000);
	}*/
	/*
	@And("user will navigated to HomePage")
	public void user_will_navigated_to_HomePage() throws InterruptedException
	{
		driver.findElement(By.xpath("//body/nav[1]/a[1]")).click();
		 Thread.sleep(2000);
	}*/
	@Then("user clicks on search btn")
	public void user_clicks_on_search_btn() throws InterruptedException {
	    driver.findElement(By.xpath("//button[@id='search-btn']")).click();
	    Thread.sleep(2000);
	}
	@Then("user clicks search bar for recommendation")
	public void user_clicks_search_bar_for_recommendation() throws InterruptedException
	{
		target = driver.findElement(By.xpath("//input[@id='search-box']"));
		
		target.click();
		Thread.sleep(2000);
		target.sendKeys("java");
		Thread.sleep(2000);
	}
	
	@Then("user click search button")
	public void user_click_search_button() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[@id='search']")).click();
		Thread.sleep(2000);
	}
	
	@Then("user clicks on add to recommendation button")
	public void user_clicks_on_add_to_recommendation_button() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@id='intro']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[2]")).click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	/*@Then("user clicks on profile image for recommendation")
	public void user_clicks_on_profile_image_for_recommendation() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//img[@id='icon']")).click();
	    Thread.sleep(2000);
		
	}*/
	
	@Then("user selects recommendation")
	public void user_selects_recommendation() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Recommendations')]")).click();
		
		Thread.sleep(2000);
		
	}
	
	
	
	

	
	
}
