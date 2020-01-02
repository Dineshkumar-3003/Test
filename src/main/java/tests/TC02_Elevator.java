package tests;

import java.util.ArrayList;

import org.testng.annotations.Test;

import extent_reports.ExtentTestManager;

public class TC02_Elevator extends BaseTest {

	String Class_Name = this.getClass().getCanonicalName();

	@Test(priority = 0, description = "Invalid Login Scenario")
	public void Invalid_Login_Test() throws Exception {

		ArrayList<String> Elevators = new ArrayList<String>();
		Elevators.add("Pisgah");
		Elevators.add("Salina");
		Elevators.add("Sidney");

		String Test_Name = new Throwable().getStackTrace()[0].getMethodName();

		ExtentTestManager.startTest(Class_Name, Test_Name, "Invalid Login Scenario.");

		Login.App_Launch().Login_Valid().Select_Some_Ele("Pisgah");

	}

}
