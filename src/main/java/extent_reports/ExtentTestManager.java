package extent_reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OB: extentTestMap holds the information of thread ids and ExtentTest
 * instances. ExtentReports instance created by calling getReporter() method
 * from ExtentManager. At startTest() method, an instance of ExtentTest created
 * and put into extentTestMap with current thread id. At endTest() method, test
 * ends and ExtentTest instance got from extentTestMap via current thread id. At
 * getTest() method, return ExtentTest instance in extentTestMap by using
 * current thread id.
 */

public class ExtentTestManager {

	static String current_Test_Name = null;
	static List<String> Class_Test = new ArrayList<String>();

	static Map extentTestMap = new HashMap();
	static ExtentReports extent = ExtentManager.getReporter();

	public static synchronized ExtentTest getTest() {

		System.out.println("getTest - " + Thread.currentThread().getId());

		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {

		System.out.println("endTest - " + Thread.currentThread().getId());

		extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
	}

	public static synchronized ExtentTest startTest(String Class_Name, String testName, String desc) {

		ExtentTest test = null;
		String Retry = null;
		current_Test_Name = Class_Name + "." + testName;

		System.out.println("startTest - " + Thread.currentThread().getId());
		System.out.println("current_Test_Name is - " + current_Test_Name);

		for (String Name : Class_Test) {
			if (current_Test_Name.equalsIgnoreCase(Name)) {
				Retry = "Yes";
			}
		}

		if (Retry == "Yes") {
			test = getTest();
		} else {
			test = extent.startTest(testName, desc);
		}

		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);

		// Previous_Test_Name = current_Test_Name;
		Class_Test.add(current_Test_Name);
		return test;
	}

}
