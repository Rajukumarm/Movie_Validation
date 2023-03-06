package movieDetailsValidation;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenricUtility.BaseClass;
import com.GenricUtility.ExcelUtility;
import com.Movie.pom.FetchMovie;
import com.Movie.pom.GooglePage;
import com.Movie.pom.IMBDHomePage;
import com.Movie.pom.MovieDetailspage;
public class ValidateTest extends BaseClass
{
	
	@Test
	public void mainIMDBExecution() throws Throwable {
		GooglePage gp=new GooglePage(driver);
		String googleImdb=fLib.readDataFromPropertyFile("googleimdpdata");
		String imdbData=fLib.readDataFromPropertyFile("movieName");
		gp.searchBox(googleImdb);
		
		IMBDHomePage im=new IMBDHomePage(driver);
		im.enterPusphaPage(imdbData);
		FetchMovie fm=new FetchMovie(driver);
		
		fm.validate(driver);
	}
	
	@Test
	public void wikiTest() throws Throwable
	{
		
		MovieDetailspage md=new MovieDetailspage(driver);
		String googleDetails= fLib.readDataFromPropertyFile("googledata");
		String wikiDetails=fLib.readDataFromPropertyFile("wikidata");
		md.searchTxtFieldData(googleDetails);
		
		md.wikiLinkClick();
		md.wikiTextFieldDetails(wikiDetails);
		wbLib.scrollBarAction(driver);
		md.boxDetails(driver);
		
	}

	@Test
	public void validateTest() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		String wikiReleaseDate = eLib.readDataFromExcel("valid", 1, 2);
		String wikiCountry = eLib.readDataFromExcel("valid", 1, 3);
		String imdbReleaseDate = eLib.readDataFromExcel("valid", 1, 0);
		String imdbCountry = eLib.readDataFromExcel("valid", 1, 1);
		
//		Assert.assertEquals(wikiReleaseDate, imdbReleaseDate);
//		Assert.assertEquals(wikiCountry, imdbCountry);
		
    SoftAssert sf=new SoftAssert();
    sf.assertEquals(wikiReleaseDate, imdbReleaseDate);
    sf.assertEquals(wikiCountry, imdbCountry);
		sf.assertAll();

	}
}
