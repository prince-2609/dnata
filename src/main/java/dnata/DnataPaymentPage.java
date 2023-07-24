package dnata;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class DnataPaymentPage {
	public static void individualForFlight() throws Exception {
		QaBrowser.driver.switchTo().alert().accept();
		Thread.sleep(5000);
		QaRobot.ClickOnElement("OKF");
		QaRobot.PassValue("ReceiptNoF", "9863647");
		QaRobot.ClickOnElement("ProceedF");
	}

	public static void individualForHotel() throws Exception {
		QaRobot.ClickOnElement("OKF");
		QaRobot.PassValue("ReceiptNoF", "9863647");
		QaRobot.ClickOnElement("ProceedF");
	}

	public static void individualForInsurance() throws Exception {
		QaRobot.ClickOnElement("OKF");
		QaRobot.PassValue("ReceiptNoF", "9863647");
		QaRobot.ClickOnElement("ProceedF");
	}

	public static void cardPayment(String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate, String CVV, String BillingAddress, String BillingState, String CardCity)
			throws Exception {
		if (CardType.equalsIgnoreCase("MasterCard")) {
			QaRobot.ClickOnElement("MasterCard");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MasterCard</i></b>");
			cardDetailsForFlight(CreditCardNumber, CardHolderName, CardExpiryDate, CVV, BillingAddress, BillingState,
					CardCity);
		} else if (CardType.equalsIgnoreCase("VisaCard")) {
			QaRobot.ClickOnElement("VisaCard");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on VisaCard</i></b>");
			cardDetailsForFlight(CreditCardNumber, CardHolderName, CardExpiryDate, CVV, BillingAddress, BillingState,
					CardCity);
		}
	}

	public static void cardDetailsForFlight(String CreditCardNumber, String CardHolderName, String CardExpiryDate,
			String CVV, String BillingAddress, String BillingState, String CardCity) throws Exception {
		QaRobot.PassValue("CreditCardNumber", CreditCardNumber);
		QaRobot.PassValue("CreditHolderName", CardHolderName);
		String cardDate[] = CardExpiryDate.split(",");
		String month = cardDate[0];
		String year = cardDate[1];
		String cardMonth = "//div[@id='CCTab']/div/div[2]/div[3]/div/div[1]/div/div[1]/select";
		QaRobot.selectTextByLocator1(cardMonth, month, "<b><i>Selected Expiry Month</i></b>");
		String cardYear = "//div[@id='CCTab']/div/div[2]/div[3]/div/div[1]/div/div[2]/select";
		QaRobot.selectTextByLocator1(cardYear, year, "<b><i>Selected Expiry Year</i></b>");
		QaRobot.PassValue("CardCVVNumber", CVV);
		QaRobot.PassValue("BillingAddressF", BillingAddress);
		String billingState = "(//select[@id='ddlBillingState'])[1]";
		QaRobot.selectTextByLocator1(billingState, BillingState, "<b><i>Selected Billing State</i></b>");
		String cardCity[] = CardCity.split(",");
		String cityCode = cardCity[0];
		String cityLocation = cardCity[1];
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divCityCC']/p"), cityCode, cityLocation,
				By.xpath("(//input[@id='txtBillingCity'])[1]"));
		QaRobot.ScreenshotMethod("cardPayment", "<b><i>Screenshot for Card Payment</i></b>");
		QaExtentReport.extentScreenshot("Card Payment");
		QaRobot.ClickOnElement("CreditPayNow");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Credit Pay Now</i></b>");
	}
}
