package movieDetailsValidation;


import org.testng.annotations.Test;

import com.GenricUtility.BaseClass;
import com.Movie.pom.FetchMovie;
import com.Movie.pom.GooglePage;
import com.Movie.pom.IMBDHomePage;

class ImdbTest  extends BaseClass {
	
	
	@Test
	public void mainExecution() throws Throwable {
		GooglePage gp=new GooglePage(driver);
		String googleImdb=fLib.readDataFromPropertyFile("googleimdpdata");
		String imdbData=fLib.readDataFromPropertyFile("movieName");
		gp.searchBox(googleImdb);
		
		IMBDHomePage im=new IMBDHomePage(driver);
		im.enterPusphaPage(imdbData);
		FetchMovie fm=new FetchMovie(driver);
		
		fm.validate(driver);
	}
	
	
}
