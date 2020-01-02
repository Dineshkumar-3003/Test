package Page_Objects;

import org.openqa.selenium.By;

public class PO_Dashboard {

	public final static By Menu_bar = By.id("navbar");

	public final static By Farmers_Menu = By
			.xpath("//*[@class = 'navbar-collapse collapse navbar-left']//child::li");

	public final static By Elevator_DD = By.xpath("//*[@class = 'elevator_drop_down']");

	public final static By Elevator_DD_Values = By.xpath("//*[@class = 'elevator_drop_down']//child::li");

	public final static By Map_Loader = By.xpath("//*[@id= 'Loading-Img-Map']//child::p");

	public final static By Header = By.xpath("//*[@class = 'navbar navbar-inverse navbar-fixed-top side_menu']");

}
