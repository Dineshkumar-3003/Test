package tests;

import pages.Select_Browser;

import org.testng.annotations.Test;

public class TC02_Farmer_Create_Update {

	Select_Browser Obj_Select_Browser = new Select_Browser();

	@Test(priority = 1)
	public void Create_Farmer() throws Exception {

		Obj_Select_Browser.BrowserLaunnch("chrome").App_Launch().Login_Valid().Select_All_Ele().Click_Farmers_Menu()
				.Create_Farmer().verify_Created_Farmer().driver.close();

	}

	 @Test(priority = 2)
	public void Update_Farmer() throws Exception {

		Obj_Select_Browser.BrowserLaunnch("chrome").App_Launch().Login_Valid().Select_All_Ele().Click_Farmers_Menu()
				.Update_Farmer().verify_Updated_Farmer().driver.close();

	}

}
