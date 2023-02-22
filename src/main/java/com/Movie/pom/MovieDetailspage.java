package com.Movie.pom;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenricUtility.ExcelUtility;

public class MovieDetailspage {
	@FindBy(xpath="//input[@type='text']")
	private WebElement googleSearchTxtField;
	
	
	
	@FindBy(xpath="//h3[text()='Wikipedia']")
	private WebElement wikiLink;
	
	@FindBy(id="searchInput")
	private WebElement wikiSearchTextField;
	
	@FindBy(xpath = "//i[text()='Search']")
	private WebElement wikiSearchBtn;
	
	@FindBy(xpath = "//table[@class='infobox vevent']")
	private List<WebElement> boxSection;
	
	@FindBy(xpath = "//div[text()='Release date']/following::td[@class='infobox-data']//div[@class='plainlist']")
	private WebElement releaseDate;
	
	@FindBy(xpath = "//th[text()='Country']/following-sibling::td")
	private WebElement country;
	public MovieDetailspage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getGoogleSearchTxtField() {
		return googleSearchTxtField;
		
	}
	

	public WebElement getWikiLink() {
		return wikiLink;
	}

	public WebElement getWikiSearchTextField() {
		return wikiSearchTextField;
	}
	public WebElement getWikiSearchBtn() {
		return wikiSearchBtn;
	}
	public List<WebElement> getBoxSection() {
		return boxSection;
	}
	
	public void searchTxtFieldData(String text)
	{
		googleSearchTxtField.sendKeys(text+Keys.ENTER);
		
	}
	public void wikiLinkClick()
	{
		wikiLink.click();	
	}
	public void wikiTextFieldDetails(String detail)
	{
		wikiSearchTextField.sendKeys(detail);
		wikiSearchBtn.click();
	}
	
	public WebElement getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(WebElement releaseDate) {
		this.releaseDate = releaseDate;
	}

	public WebElement getCountry() {
		return country;
	}

	public void setCountry(WebElement country) {
		this.country = country;
	}

	public void boxDetails(WebDriver driver) throws Throwable
	{
		
		//String boxData[]=new String[2];
		String date = releaseDate.getText();
		String origin = country.getText();
		System.out.println(date);
		System.out.println(origin);
		ExcelUtility eLib=new ExcelUtility();
		eLib.readDataForWikiExcelFile(date, origin);
		//return date;
	
	}


}
