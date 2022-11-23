package dnata;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class DnataFlight 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("dnataFlight", "Sheet1");
	}	
	
	@Test(dataProvider = "getexceldata")
	public static void dnataforflight (String TestCaseId,String TestCaseType,String TestScenario,String Source,String URL,String CompanyCode,
			String UserName,String Password,String SearchCorporateTraveller,String TravelType,String TravellerType,String TripType,String OriginCityCode,
			String OriginLocation,String DestinationCityCode,String DestinationLocation,String DepartureDate,String ReturnDate,String adult,String child,
			String infant,String Class,String PreAirline,String PANumber,String PreferredAirlineSelect,String FOPType,String ShowDirectFlight,
			String Supplier,String ModifySearch,String ChangeTrip,String TripTypeM,String OriginCityCodeM,String OriginLocationM,String DestinationCityCodeM,
			String DestinationLocationM,String ChangeTripDate,String DepartureDateM,String ReturnDateM,String ChangeTravellers,String adultM,String childM,
			String infantM,String ChangeClass,String ClassM,String ChangeAirline,String PANumberM,String PreferredAirlineSelectM,String ShowDirectFlightM,String SupplierChange,
			String SupplierM,String Applyfilter,String FareType,String AirLine,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId+"-"+TestScenario);
		
		QaRobot.ClickOnElement("AdvanceButton");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Advance Button</i></b>");
		
		QaRobot.ClickOnElement("ProceedLink");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Proceed Link</i></b>");
		
		QaRobot.PassValue("CompanyCode",CompanyCode);
//		QaExtentReport.test.log(Status.INFO,"<b><i>Write Company Code</i></b>");
			
		QaRobot.PassValue("UserName",UserName);
//		QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
		QaRobot.PassValue("PasswordFD",Password);
//		QaExtentReport.test.log(Status.INFO,"<b><i>Write Password</i></b>");
		QaExtentReport.extentScreenshot("Sigh In Page");
			
		QaRobot.ClickOnElement("LogIn");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on LogIn</i></b>");
		
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		
		QaRobot.ClickOnElement("CallCenter");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on CallCenter</i></b>");
		
		QaRobot.ClickOnElement("ProductSearchFareBranding");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Product Search Fare Branding</i></b>");
		
		QaBrowser.driver.switchTo().parentFrame();
		
		QaRobot.switchframe("//frame[@name='main']");
		
		QaRobot.switchframe("//frame[@id='frm2']");
		
		QaRobot.ClickOnElement("Flight");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Flight</i></b>");
		
		QaRobot.PassValue("SearchCorporateTraveller",SearchCorporateTraveller);
		QaExtentReport.test.log(Status.INFO,"<b><i>Search Corporate or Traveller Name </i></b>"+SearchCorporateTraveller);
		Thread.sleep(3000);
		
		Actions action = new Actions(QaBrowser.driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		QaRobot.ClickOnElement("STraveller");
		Thread.sleep(5000);
		
		if(TravelType.equalsIgnoreCase("BusinessTravel"))
		{
			QaRobot.ClickOnElement("BusinessTravel");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on BusinessTravel</i></b>");
			Thread.sleep(5000);
			QaRobot.ClickOnElement("BusinessTravel");
			
			if(TravellerType.equalsIgnoreCase("Individual"))
			{
				QaRobot.ClickOnElement("Individual");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Individual</i></b>");
				Thread.sleep(5000);
				
				WebElement element = QaBrowser.driver.findElement(By.xpath("//div[@id='divTravelCategory']/div/div/div/div/div/div/select"));
				Select s = new Select(element);
				s.selectByIndex(1);
//				QaExtentReport.test.log(Status.INFO,"<b><i>Select Policy</i></b>");
				
				DnataTripType.flightTriptype( TravellerType, TripType,OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation,
						 DepartureDate, ReturnDate, adult, child, infant, Class,PreAirline, PANumber, PreferredAirlineSelect, FOPType,
						 ShowDirectFlight,Supplier);
				
				DnataResultPage.ResultPageForFlight(TravellerType,TripType,adult,child,infant,Supplier,ModifySearch, ChangeTrip, TripTypeM, OriginCityCodeM, OriginLocationM, DestinationCityCodeM,
						DestinationLocationM, ChangeTripDate, DepartureDateM, ReturnDateM, ChangeTravellers, adultM, childM, infantM, 
						ChangeClass, ClassM,ChangeAirline,PANumberM, PreferredAirlineSelectM, ShowDirectFlightM, SupplierChange, SupplierM, Applyfilter,
						FareType, AirLine, Resultpagestep, QuoteTitle, QuoteRemark,Checkoutpagestep);
			}
			else if(TravellerType.equalsIgnoreCase("Dependent"))
			{
				QaRobot.ClickOnElement("Dependent");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Dependent</i></b>");
				Thread.sleep(15000);
				
				WebElement element = QaBrowser.driver.findElement(By.xpath("//div[@id='divTravelCategory']/div/div/div/div/div/div/select"));
				Select s = new Select(element);
				s.selectByIndex(1);
//				QaExtentReport.test.log(Status.INFO,"<b><i>Select Policy</i></b>");
				
				DnataTripType.flightTriptype( TravellerType, TripType,OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation,
						 DepartureDate, ReturnDate, adult, child, infant, Class,PreAirline, PANumber, PreferredAirlineSelect, FOPType,
						 ShowDirectFlight,Supplier);
				
				DnataResultPage.ResultPageForFlight(TravellerType,TripType,adult,child,infant,Supplier,ModifySearch, ChangeTrip, TripTypeM, OriginCityCodeM, OriginLocationM, DestinationCityCodeM,
						DestinationLocationM, ChangeTripDate, DepartureDateM, ReturnDateM, ChangeTravellers, adultM, childM, infantM, 
						ChangeClass, ClassM,ChangeAirline,PANumberM, PreferredAirlineSelectM, ShowDirectFlightM, SupplierChange, SupplierM, Applyfilter,
						FareType, AirLine, Resultpagestep, QuoteTitle, QuoteRemark,Checkoutpagestep);
			}
			else if(TravellerType.equalsIgnoreCase("MultiplePassengers"))
			{
				QaRobot.ClickOnElement("MultiplePassengers");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on MultiplePassengers</i></b>");
				
				DnataTripType.flightTriptype( TravellerType, TripType,OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation,
						 DepartureDate, ReturnDate, adult, child, infant, Class,PreAirline, PANumber, PreferredAirlineSelect, FOPType,
						 ShowDirectFlight,Supplier);
			}
			else if(TravellerType.equalsIgnoreCase("GuestUser"))
			{
				QaRobot.ClickOnElement("GuestUser");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on GuestUser</i></b>");
				
				DnataTripType.flightTriptype( TravellerType, TripType,OriginCityCode, OriginLocation, DestinationCityCode, DestinationLocation,
						 DepartureDate, ReturnDate, adult, child, infant, Class,PreAirline,PANumber, PreferredAirlineSelect, FOPType,
						 ShowDirectFlight,Supplier);
			}
		}
		else if(TravelType.equalsIgnoreCase("Personal"))
		{
			QaRobot.ClickOnElement("Personal");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Personal</i></b>");
		}
	}
	
	@AfterMethod
	public static void afterMethod()
	{
		QaExtentReport.test.getExtent().flush();
	}
}
