package com.Movie.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	
	@FindBy(name="q")
	private WebElement searchTab;
	
	@FindBy(xpath="//h3[contains(text(),'IMDb: Ratings, Reviews')]")
	private WebElement imbd;
	
	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBox() {
		return searchTab;
	}

	public WebElement getImbd() {
		return imbd;
	}
	
public void searchBox(String text) {
	searchTab.sendKeys(text+Keys.ENTER);
	imbd.click();
	
}
}
