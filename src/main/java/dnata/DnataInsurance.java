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
public class DnataInsurance {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("dnataInsurance", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void dnataInsurance(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String SearchCorporateTraveller,
			String TravelType, String TravellerType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String StartDate, String EndDate, String PolicyFor,
			String SelectPax, String PaxDOB, String FOPType, String ModifySearch, String ChangeTrip,
			String OriginCityCodeM, String OriginLocationM, String DestinationCityCodeM, String DestinationLocationM,
			String ChangeTripDate, String StartDateM, String EndDateM, String ChangePolicyFor, String PolicyForM,
			String SelectPaxM, String PaxDOBM, String ChangeFOPType, String FOPTypeM, String BenefitsNo,
			String Benefits, String Resultpagestep, String QuoteTitle, String QuoteRemark, String Checkoutpagestep)
			throws Exception {
		TestBase.Companycode(Source, URL);
		QaRobot.impliwait(30);

		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

//		QaRobot.ClickOnElement("AdvanceButton");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Advance Button</i></b>");

//		QaRobot.ClickOnElement("ProceedLink");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Proceed Link</i></b>");

		QaRobot.PassValue("CompanyCode", CompanyCode);
//		QaExtentReport.test.log(Status.INFO,"<b><i>Write Company Code</i></b>");

		QaRobot.PassValue("UserName", UserName);
//		QaExtentReport.test.log(Status.INFO,"<b><i>Write User Name</i></b>");

		QaRobot.PassValue("PasswordFD", Password);
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

		QaRobot.PassValue("SearchCorporateTraveller", SearchCorporateTraveller);
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Search Corporate or Traveller Name </i></b>" + SearchCorporateTraveller);
		Thread.sleep(3000);

		Actions action = new Actions(QaBrowser.driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		QaRobot.ClickOnElement("STraveller");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("Insurance");
//		QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Insurance</i></b>");

		if (TravelType.equalsIgnoreCase("BusinessTravel")) {
			QaRobot.ClickOnElement("BusinessTravel");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on BusinessTravel</i></b>");
			Thread.sleep(5000);
			QaRobot.ClickOnElement("BusinessTravel");

			if (TravellerType.equalsIgnoreCase("Individual")) {
				QaRobot.ClickOnElement("Individual");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Individual</i></b>");
				Thread.sleep(5000);

				WebElement element = QaBrowser.driver
						.findElement(By.xpath("//div[@id='divTravelCategory']/div/div/div/div/div/div/select"));
				Select s = new Select(element);
				s.selectByIndex(1);
//				QaExtentReport.test.log(Status.INFO,"<b><i>Select Policy</i></b>");

				DnataTripType.InsuranceTriptype(TravellerType, OriginCityCode, OriginLocation, DestinationCityCode,
						DestinationLocation, StartDate, EndDate, PolicyFor, SelectPax, PaxDOB, FOPType);

				DnataResultPage.ResultPageForInsurance(TravellerType, SelectPax, PaxDOB, ModifySearch, ChangeTrip,
						OriginCityCodeM, OriginLocationM, DestinationCityCodeM, DestinationLocationM, ChangeTripDate,
						StartDateM, EndDateM, ChangePolicyFor, PolicyForM, SelectPaxM, PaxDOBM, ChangeFOPType, FOPTypeM,
						BenefitsNo, Benefits, Resultpagestep, QuoteTitle, QuoteRemark, Checkoutpagestep);
			}

			else if (TravellerType.equalsIgnoreCase("Dependent")) {
				QaRobot.ClickOnElement("Dependent");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Dependent</i></b>");
				Thread.sleep(15000);

				WebElement element = QaBrowser.driver
						.findElement(By.xpath("//div[@id='divTravelCategory']/div/div/div/div/div/div/select"));
				Select s = new Select(element);
				s.selectByIndex(1);
//				QaExtentReport.test.log(Status.INFO,"<b><i>Select Policy</i></b>");

				DnataTripType.InsuranceTriptype(TravellerType, OriginCityCode, OriginLocation, DestinationCityCode,
						DestinationLocation, StartDate, EndDate, PolicyFor, SelectPax, PaxDOB, FOPType);

				DnataResultPage.ResultPageForInsurance(TravellerType, SelectPax, PaxDOB, ModifySearch, ChangeTrip,
						OriginCityCodeM, OriginLocationM, DestinationCityCodeM, DestinationLocationM, ChangeTripDate,
						StartDateM, EndDateM, ChangePolicyFor, PolicyForM, SelectPaxM, PaxDOBM, ChangeFOPType, FOPTypeM,
						BenefitsNo, Benefits, Resultpagestep, QuoteTitle, QuoteRemark, Checkoutpagestep);
			}

			else if (TravellerType.equalsIgnoreCase("MultiplePassengers")) {
				QaRobot.ClickOnElement("MultiplePassengers");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on MultiplePassengers</i></b>");

				DnataTripType.InsuranceTriptype(TravellerType, OriginCityCode, OriginLocation, DestinationCityCode,
						DestinationLocation, StartDate, EndDate, PolicyFor, SelectPax, PaxDOB, FOPType);

//				DnataResultPage.ResultPageForInsurance(TravellerType, SelectPax, PaxDOB, ModifySearch, ChangeTrip,
//						OriginCityCodeM, OriginLocationM, DestinationCityCodeM, DestinationLocationM, ChangeTripDate,
//						StartDateM, EndDateM, ChangePolicyFor, PolicyForM, SelectPaxM, PaxDOBM, ChangeFOPType, FOPTypeM,
//						BenefitsNo, Benefits, Resultpagestep, QuoteTitle, QuoteRemark, Checkoutpagestep);
			}

			else if (TravellerType.equalsIgnoreCase("GuestUser")) {
				QaRobot.ClickOnElement("GuestUser");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on GuestUser</i></b>");
			}
		}

		else if (TravelType.equalsIgnoreCase("Personal")) {
			QaRobot.ClickOnElement("Personal");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Personal</i></b>");
		}
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
