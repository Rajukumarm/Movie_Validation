package movieDetailsValidation;


import org.testng.annotations.Test;

import com.GenricUtility.ExcelUtility;
public class ValidateTest {
	@Test
	public void validateTest() throws Throwable
	{
		ExcelUtility eLib=new ExcelUtility();
		eLib.writeDataToExcel();


	}
}
