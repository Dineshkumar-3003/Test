package tests;

import org.testng.annotations.Test;

import pages.Select_Browser;

public class TC03_Trucker_Create_Update {

	Select_Browser Obj_Select_Browser = new Select_Browser();

//	@Test(priority = 1)
	public void Create_Trucker() throws Exception {

		Obj_Select_Browser.BrowserLaunnch("chrome").App_Launch().Login_Valid().Select_All_Ele().Click_Truckers_Menu()
				.Create_Trucker().verify_Created_Trucker().driver.close();

	}

	@Test(priority = 2)
	public void Update_Farmer() throws Exception {

		Obj_Select_Browser.BrowserLaunnch("chrome").App_Launch().Login_Valid().Select_All_Ele().Click_Truckers_Menu()
				.Update_Trucker().verify_Updated_Trucker().driver.close();
	}

}
