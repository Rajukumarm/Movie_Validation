package movieDetailsValidation;

import org.testng.annotations.Test;
import com.GenricUtility.BaseClass;
import com.Movie.pom.MovieDetailspage;

public class WikipediaTest extends BaseClass
{
	
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
}
