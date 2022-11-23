package dnata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class DnataResultPage 
{
	public static void ResultPageForFlight(String TravellerType,String TripType,String adult,String child,String infant,String Supplier,String ModifySearch,String ChangeTrip,String TripTypeM,String OriginCityCodeM,String OriginLocationM,
			String DestinationCityCodeM,String DestinationLocationM,String ChangeTripDate,
			String DepartureDateM,String ReturnDateM,String ChangeTravellers,String adultM,String childM,String infantM,String ChangeClass,
			String ClassM,String ChangeAirline,String PANumberM,String PreferredAirlineSelectM,String ShowDirectFlightM,String SupplierChange,String SupplierM,
			String Applyfilter,String FareType,String AirLine,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		Thread.sleep(30000);
		QaRobot.ScreenshotMethod("ResultPage","<b><i>Screenshot for Result Page</i></b>");
		
//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		String DateSelection[]= DepartureDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= ReturnDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1= DateSelection1[0];
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.ClickOnElement("ModifySearchF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");
			Thread.sleep(3000);
			
			if(ChangeTrip.equalsIgnoreCase("Yes"))
			{
				if(TripTypeM.equalsIgnoreCase("OneWay"))
				{
					QaRobot.ClickOnElement("OneWayMF");
					
					Assert.assertFalse(OriginCityCodeM==DestinationCityCodeM, "Modified Origin And Destination City Code Can't Be Same");
					Assert.assertFalse(OriginLocationM==DestinationLocationM, "Modified Origin And Destination City Location Can't Be Same");
					
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM, OriginLocationM,By.xpath("//input[@id='MtxtDepartureCity0']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Departure city : </i></b>"+OriginCityCodeM+" - " + OriginLocationM);
					Thread.sleep(2000);
						
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM, DestinationLocationM,By.xpath("//input[@id='MtxtDestinationCity0']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>"+DestinationCityCodeM+" - " + DestinationLocationM);
					Thread.sleep(2000);
				}
				else if (TripTypeM.equalsIgnoreCase("RoundTrip"))
				{
					QaRobot.ClickOnElement("RoundTripMF");
					
					Assert.assertFalse(OriginCityCodeM==DestinationCityCodeM, "Modified Origin And Destination City Code Can't Be Same");
					Assert.assertFalse(OriginLocationM==DestinationLocationM, "Modified Origin And Destination City Location Can't Be Same");
					
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM, OriginLocationM,By.xpath("//input[@id='MtxtDepartureCity0']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Departure city : </i></b>"+OriginCityCodeM+" - " + OriginLocationM);
					Thread.sleep(2000);
						
					TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM, DestinationLocationM,By.xpath("//input[@id='MtxtDestinationCity0']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>"+DestinationCityCodeM+" - " + DestinationLocationM);
					Thread.sleep(2000);
				}
			}
			
			if(ChangeTripDate.equalsIgnoreCase("Yes"))
			{
				if(TripTypeM.equalsIgnoreCase("OneWay"))
				{
					QaRobot.ClickOnElement("OneWayMF");
//					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified OneWay</i></b>");
					Thread.sleep(3000);
					
					QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[1]")).click();
					Thread.sleep(2000);
					
					selectDateInCalendarOneWay(expDate,month,year);
				}
				else if (TripTypeM.equalsIgnoreCase("RoundTrip"))
				{
					QaRobot.ClickOnElement("RoundTripMF");
//					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified RoundTrip</i></b>");
					Thread.sleep(3000);
					
					QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[1]")).click();
					Thread.sleep(2000);
					
					selectDateInCalendarRoundTrip(expDate,month,year,expDate1,month1,year1);
				}
			}
			if(TravellerType.equalsIgnoreCase("Individual"))
			{
			}
			else
			{
				if(ChangeTravellers.equalsIgnoreCase("Yes"))
				{
					QaRobot.ClickOnElement("ChangeTravellersF");
//					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Travellers</i></b>");
					
					QaRobot.selectValueFromDropdown("dnataAdultMF", adultM, "<b><i>Select Modified adult for booking</i></b>"+" - "+adultM);
					Thread.sleep(2000);

					QaRobot.selectValueFromDropdown("dnataChildMF", childM, "<b><i>Select Modified child for booking</i></b>"+" - "+childM);
					Thread.sleep(2000);

					QaRobot.selectValueFromDropdown("dnataInfantMF", infantM, "<b><i>Select Modified infant for booking</i></b>"+" - "+infantM);
					Thread.sleep(2000);
					
					QaRobot.ClickOnElement("ChangeTravellersF");
				}
			}
			if(ChangeAirline.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("PreferredAirlineMF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified PreferredAirline</i></b>");
				Thread.sleep(2000);
				
				int pAS = Integer.parseInt(PANumberM);
				for (int i = 1; i <= pAS; i++) 
				{
					String[] tN = PreferredAirlineSelectM.split(",");
					String b = tN[i-1];
					TestBase.listofautosuggestion1(By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"),b,By.xpath("//div[@id='Return']/div/div/div[1]/div[1]/div[2]/div/div[4]/div[3]/div/div/div/div[1]/input"));
				}
				QaRobot.ClickOnElement("PreferredAirlineMF");
			}
			
			if(ChangeClass.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("ChangeTravellersF");
				
				QaRobot.selectTextByLocator("//select[@id='ddlClass']", ClassM, "<b><i>Select Modified Class for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("ChangeTravellersF");
			}
			
			if(ShowDirectFlightM.equalsIgnoreCase("Yes")) 
			{
				QaRobot.ClickOnElement("ShowDirectFlightMF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Show Direct Flight</i></b>");
			}
			
			if(SupplierChange.equalsIgnoreCase("Yes")) 
			{
				List<WebElement> listOfAirline1 = QaBrowser.driver.findElements(By.xpath("//div[@id='Return']/div/div/div[1]/div[5]/div/div[2]/div/div/div/label/span"));
				for (WebElement autoAirline1 : listOfAirline1) 
				  {
					if (autoAirline1.getText().equalsIgnoreCase(Supplier)) 
					{
						autoAirline1.click();
						break;
					} 
					else 
					{
						
					}
				  }
				
				List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("//div[@id='Return']/div/div/div[1]/div[5]/div/div[2]/div/div/div/label/span"));
				for (WebElement autoAirline : listOfAirline) 
				  {
					if (autoAirline.getText().equalsIgnoreCase(SupplierM)) 
					{
						autoAirline.click();
						break;
					} 
					else 
					{
						
					}
				  }
				QaExtentReport.test.log(Status.INFO, "<b><i>Select Supplier </i></b>"+SupplierM);
			}
			
			QaRobot.ClickOnElement("ModifySearchMF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
			QaExtentReport.extentScreenshot("Modified Search");
		}
		Thread.sleep(10000);
		
		if(Applyfilter.equalsIgnoreCase("Yes"))
		{
			if(FareType.equalsIgnoreCase("All"))
			{
				JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
				mo.executeScript("window.scrollBy(0,500)", "");
				
				QaRobot.ClickOnElement("Refundable");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("NonRefundable");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(3000);
			}
			else if(FareType.equalsIgnoreCase("Refundable"))
			{
				QaRobot.ClickOnElement("Refundable");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(3000);
			}
			else if(FareType.equalsIgnoreCase("Non-Refundable"))
			{
				QaRobot.ClickOnElement("NonRefundable");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(3000);
			}
			
			List<WebElement> listOfAirLine = QaBrowser.driver.findElements(By.xpath("(//div[@id='tdContainerTblAirlines'])[2]//li//span"));
			
			for (WebElement autoAirline : listOfAirLine) 
			  {
				if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
				{
					autoAirline.click();
					break;
				} 
				else 
				{
					
				}
			  }
			QaRobot.ScreenshotMethod("Applyfilter","<b><i>Screenshot for Apply filter</i></b>");
			QaExtentReport.extentScreenshot("Apply filter");
		}
		QaExtentReport.extentScreenshot("Result Page");
		
		if(ModifySearch.equalsIgnoreCase("No"))
		{
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
		}
		
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,400)", "");
		
		QaRobot.ClickOnElement("FlightItinery");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight Itinerary</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("FlightItinerary");
		Thread.sleep(10000);
		
		QaRobot.ClickOnElement("SelectFlight");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select Flight</i></b>");
		
		QaRobot.ClickOnElement("ShowDetails");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Show Details</i></b>");
		Thread.sleep(7000);
		QaExtentReport.extentScreenshot("Show Details");
		
		QaRobot.ClickOnElement("FareDetails");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Details</i></b>");
		Thread.sleep(4000);
		
		String ParentWindow3 = QaBrowser.driver.getWindowHandle();
		Set<String> handles3 = QaBrowser.driver.getWindowHandles();
		for (String childWindow3 : handles3) 
		{
			if (!childWindow3.equals(ParentWindow3))
				QaBrowser.driver.switchTo().window(childWindow3);
		}
		
		QaRobot.ClickOnElement("FareRulesF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Fare Rules");
		
		QaRobot.ClickOnElement("FareBreakupF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup</i></b>");
		Thread.sleep(5000);
		
		QaRobot.ClickOnElement("CustomerCostF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Customer Cost</i></b>");
		Thread.sleep(1000);
		QaExtentReport.extentScreenshot("Customer Cost");
		
		QaRobot.ClickOnElement("CompanyCostF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Company Cost</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Company Cost");
		
		QaRobot.ClickOnElement("BaggegeInformationF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Baggege Information");
		
		QaRobot.ClickOnElement("FareCloseF");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Close</i></b>");
		
		if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
		{
			QaRobot.ClickOnElement("AddToCartF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add To Cart</i></b>");
			Thread.sleep(5000);
			
			String ParentWindow = QaBrowser.driver.getWindowHandle();	
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) 
			{
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			
			QaRobot.ClickOnElement("NotificationCloseF");
			
			QaRobot.ClickOnElement("YourItinerary");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Your Itinerary</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Your Itinerary");
			
			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
			for (String childWindow5 : handles5) 
			{
				if (!childWindow5.equals(ParentWindow5))
					QaBrowser.driver.switchTo().window(childWindow5);
			}
			
			QaRobot.ClickOnElement("SendForApprovalF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send For Approval</i></b>");
			
			String ParentWindow1 = QaBrowser.driver.getWindowHandle();
			Set<String> handles1 = QaBrowser.driver.getWindowHandles();
			for (String childWindow1 : handles1) 
			{
				if (!childWindow1.equals(ParentWindow1))
					QaBrowser.driver.switchTo().window(childWindow1);
			}
			
			QaRobot.PassValue("QuotationTitle",QuoteTitle);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
			QaExtentReport.extentScreenshot("Quotation");
			
			QaRobot.PassValue("RemarkTitle",QuoteRemark);
//			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
			
			QaRobot.ClickOnElement("SendQuote");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
			Thread.sleep(5000);
			
			String ParentWindow2 = QaBrowser.driver.getWindowHandle();
			Set<String> handles2 = QaBrowser.driver.getWindowHandles();
			for (String childWindow2 : handles2) 
			{
				if (!childWindow2.equals(ParentWindow2))
					QaBrowser.driver.switchTo().window(childWindow2);
			}
			String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='FlightQuotationModal']/div/div/div[2]/p")).getText();
			System.out.println(getT);
			String getTxt1[]= getT.split(" ");
			String number = getTxt1[11];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
			
			QaRobot.ClickOnElement("NotificationCloseF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Quote Close</i></b>");
			QaBrowser.driver.switchTo().window(ParentWindow2);
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			
			QaRobot.ClickOnElement("Bookings");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
			
			QaRobot.ClickOnElement("BookingQueues");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.switchframe("//frame[@id='toolHeader']");
			
			QaRobot.ClickOnElement("CorporateQueue");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);
			
			QaRobot.PassValue("EnterEnquiryId",number);
//			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
			
			QaRobot.ClickOnElement("SearchEnquiryId");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");
			
			QaRobot.ClickOnElement("EnquiryView");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
			Thread.sleep(5000);
			
			String ParentWindow7 = QaBrowser.driver.getWindowHandle();
			Set<String> handles7 = QaBrowser.driver.getWindowHandles();
			for (String childWindow7 : handles7) 
			{
				if (!childWindow7.equals(ParentWindow7))
					QaBrowser.driver.switchTo().window(childWindow7);
			}
			
			QaExtentReport.extentScreenshot("Quotation View");
			
			QaBrowser.driver.close();
			Thread.sleep(7000);
			
			QaBrowser.driver.switchTo().window(ParentWindow7);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("ApproveButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(13000);
			
			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) 
			{
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(3000);
			QaRobot.ClickOnElement("SelectItinerary");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
			
			QaExtentReport.extentScreenshot("Itinerary View");
			
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");
			
			QaRobot.ClickOnElement("FinalApproveButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
			
			QaRobot.PassValue("TextArea","Ok");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
			
			QaRobot.ClickOnElement("OKButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("FinalBookButton");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(5000);
			
			String ParentWindow9 = QaBrowser.driver.getWindowHandle();
			Set<String> handles9 = QaBrowser.driver.getWindowHandles();
			for (String childWindow9 : handles9) 
			{
				if (!childWindow9.equals(ParentWindow9))
					QaBrowser.driver.switchTo().window(childWindow9);
			}
			
			QaRobot.ClickOnElement("EnquiryProcced");
			Thread.sleep(30000);
			QaBrowser.driver.switchTo().window(ParentWindow9);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			if(ModifySearch.equalsIgnoreCase("No"))
			{
				if(TripType.equalsIgnoreCase("OneWay"))
					{
					if(QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'The fare that you have selected is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
					{
						List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
						
						for (WebElement autoAirline : listOfAirline) 
						  {
							if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
							{
								autoAirline.click();
								break;
							} 
							else 
							{
								
							}
						  }
						
						JavascriptExecutor mo2 = (JavascriptExecutor) QaBrowser.driver;
						mo2.executeScript("window.scrollBy(0,-300)", "");
						
						QaRobot.ClickOnElement("BookNowF");
//						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
						Thread.sleep(8000);
					}
					}
			}
//			else if(ModifySearch.equalsIgnoreCase("Yes"))
//			{
//				if(TripTypeM.equalsIgnoreCase("OneWay"))
//				{
//					if(QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
//							+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
//					{
//						List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
//						
//						for (WebElement autoAirline : listOfAirline) 
//						  {
//							if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
//							{
//								autoAirline.click();
//								break;
//							} 
//							else 
//							{
//								
//							}
//						  }
//						
//						JavascriptExecutor mo2 = (JavascriptExecutor) QaBrowser.driver;
//						mo2.executeScript("window.scrollBy(0,-300)", "");
//						
//						QaRobot.ClickOnElement("BookNowF");
//						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
//						Thread.sleep(8000);
//					}
//				}
//			}
			
				if(TravellerType.equalsIgnoreCase("Individual"))
				{
					DnataCheckoutPage.individualforFlight(TravellerType,TripType,adult,child,infant, ModifySearch, ChangeTravellers,adultM, childM,infantM,Resultpagestep,QuoteTitle, QuoteRemark, Checkoutpagestep);
				}
				else if (TravellerType.equalsIgnoreCase("Dependent"))
				{
					DnataCheckoutPage.CheckoutForFlightDependent(TravellerType,TripType,adult,child,infant, ModifySearch,ChangeTravellers,adultM, childM,infantM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
				}
		}
		
		else if(Resultpagestep.equalsIgnoreCase("Book"))
		{
			QaRobot.ClickOnElement("BookNowF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
			Thread.sleep(8000);
			
			DnataCheckoutPage.individualforFlight(TravellerType,TripType,adult,child,infant, ModifySearch,ChangeTravellers, adultM, childM,infantM,Resultpagestep,QuoteTitle, QuoteRemark, Checkoutpagestep);
		}
	}
	
	public static void ResultPageForHotel(String TravellerType,String Rooms,String Adult,String Child,String Supplier,String ModifySearch,String ChangeTripLocation,String CityCodeM,String CityTitleM,String ChangeTripDate,
			String CheckInDateM,String CheckOutDateM,String ChangeRooms,String RoomsM,String AdultM,String ChildM,String ChildAgeM,String ChangeStarRating,
			String StarRatingM,String SupplierChange,String MSupplier,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		Thread.sleep(30000);
		
//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		String DateSelection[]= CheckInDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= CheckOutDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1= DateSelection1[0];
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.ClickOnElement("ModifySearchMH");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");
			Thread.sleep(5000);
			
			if(ChangeTripLocation.equalsIgnoreCase("Yes"))
			{
				TestBase.listofautosuggestion5(By.xpath("//div[@id='ModifydivHTCity']/p"), CityCodeM, CityTitleM,By.xpath("//input[@id='txtHotelSearch']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Modified City Name : </i></b>"+CityCodeM+"-"+ CityTitleM);
				Thread.sleep(2000);
			}
			
			if(ChangeTripDate.equalsIgnoreCase("Yes"))
			{
					QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
					Thread.sleep(2000);
					
					selectDateInCalendarHotel(expDate,month,year,expDate1,month1,year1);
			}
			
			if(ChangeRooms.equalsIgnoreCase("Yes"))
			{
				int room=Integer.parseInt(RoomsM);
				String[] adultcount=AdultM.split(",");
				String[] childcount=ChildM.split(",");
				
				if(room>5)
				{
					throw new Exception("Invalid Number of Rooms provided "+" : "+room);
				}
				else
				{
					WebElement roomelement=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
					Select selectroom=new Select(roomelement);
					selectroom.selectByValue(RoomsM);
					Thread.sleep(2000);
					if(TravellerType.equalsIgnoreCase("Individual"))
					{
						
					}
					else
					{
						for(int i=1;i<=room;i++)
						{
							WebElement adultelement=QaBrowser.driver.findElement(By.xpath("//select[@id='htlsltadult"+i+"']"));
							Select selectadult=new Select(adultelement);
							selectadult.selectByValue(adultcount[i-1]);
							Thread.sleep(2000);
							
							WebElement childelement=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlChildSlt"+i+"']"));
							Select selectchild=new Select(childelement);
							selectchild.selectByValue(childcount[i-1]);
							Thread.sleep(2000);
						}
						
						String[] ageofchild=ChildAgeM.split(",");
						for(String chd:childcount)
						{
							int chdcount=Integer.parseInt(chd);
							for(int i=1;i<=chdcount;i++)
							{
								String ac = ageofchild[i-1];
								int ac1 = Integer.parseInt(ac);
								
								if(ac1>17)
								{
									QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>"+" : "+ac1);
									throw new Exception("Invalid Child Age Selection"+" : "+ac1);
								}
								else
								{
									WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='htl"+chdcount+"child"+i+"age']"));
									Select selectage=new Select(childrenage);
									selectage.selectByValue(ageofchild[i-1]);
									Thread.sleep(2000);
								}
							}
						} 
					}
				}
			}
			
			if(ChangeStarRating.equalsIgnoreCase("Yes"))
			{
				WebElement StarRating=QaBrowser.driver.findElement(By.xpath("//select[@id='ddlstarRating']"));
				Select selectage=new Select(StarRating);
				selectage.selectByVisibleText(StarRatingM);
				Thread.sleep(2000);
			}
			
			if(SupplierChange.equalsIgnoreCase("Yes"))
			{
				List<WebElement> listOfAirline1 = QaBrowser.driver.findElements(By.xpath("//span[@id='chkselall']"));
				for (WebElement autoAirline1 : listOfAirline1) 
				  {
					if (autoAirline1.getText().equalsIgnoreCase("SabreHotel"))
					{
						autoAirline1.click();
						break;
					} 
					else 
					{
						
					}
				  }
				Thread.sleep(4000);
				List<WebElement> listOfSupplier = QaBrowser.driver.findElements(By.xpath("//span[@id='chkselall']"));
				
				for (WebElement autoSupplier : listOfSupplier) 
				  {
					if (autoSupplier.getText().equalsIgnoreCase(MSupplier)) 
					{
						autoSupplier.click();
						break;
					} 
					else 
					{
						
					}
				  }
			}
			QaRobot.ClickOnElement("ModifiedSearchMH");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
			QaExtentReport.extentScreenshot("Modified Search");
		}
		Thread.sleep(25000);
		
		if(ModifySearch.equalsIgnoreCase("No"))
		{
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
		}
		
		if(QaBrowser.driver.findElement(By.xpath("//div[@id='trErrHeading']/h1[contains(text(),'                                    No Results Found')]")).isDisplayed())
		{
			String a = QaBrowser.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[2]/section[1]/div/div[3]/div[2]/div[5]/div/div/h1/text()')]")).getText();
			System.out.println(a);
			Assert.assertEquals(Resultpagestep, a,"No Results Found");
//				QaExtentReport.test.log(Status.FAIL, "<b><i>No Results Found</i></b>");
//				throw new Exception("No Results Found");
		}
		else
		{
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,700)", "");
			
			QaRobot.ClickOnElement("SelectRoom");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SelectRoom</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("CancellationPolicy");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CancellationPolicy");
//			QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
			
			String ParentWindow4 = QaBrowser.driver.getWindowHandle();
			Set<String> handles4 = QaBrowser.driver.getWindowHandles();
			for (String childWindow4 : handles4) 
			{
				if (!childWindow4.equals(ParentWindow4))
					QaBrowser.driver.switchTo().window(childWindow4);
			}
			
			QaRobot.ClickOnElement("CPClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow4);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.ClickOnElement("FareBreakup");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("CustomerCostH");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CustomerCost");
			
			QaRobot.ClickOnElement("CompanyCostH");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CompanyCost");
			
			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
			for (String childWindow5 : handles5) 
			{
				if (!childWindow5.equals(ParentWindow5))
					QaBrowser.driver.switchTo().window(childWindow5);
			}
			
			QaRobot.ClickOnElement("FareBreakupClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow5);
			
			if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
			{
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				
				QaRobot.ClickOnElement("AddToCartH");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add To Cart</i></b>");
				Thread.sleep(5000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();	
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("NotificationCloseF");
				QaBrowser.driver.switchTo().window(ParentWindow);
				Thread.sleep(3000);
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ViewCart");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on View Cart</i></b>");
				Thread.sleep(5000);
				QaExtentReport.extentScreenshot("View Cart");
				
				String ParentWindow6 = QaBrowser.driver.getWindowHandle();
				Set<String> handles6 = QaBrowser.driver.getWindowHandles();
				for (String childWindow6 : handles6) 
				{
					if (!childWindow6.equals(ParentWindow6))
						QaBrowser.driver.switchTo().window(childWindow6);
				}
				
				QaRobot.PassValue("QuotationTitle",QuoteTitle);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
				QaExtentReport.extentScreenshot("Quotation");
				
				QaRobot.PassValue("RemarkTitle",QuoteRemark);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
				
				QaRobot.ClickOnElement("SendQuoteH");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
				Thread.sleep(10000);
				
				String ParentWindow2 = QaBrowser.driver.getWindowHandle();
				Set<String> handles2 = QaBrowser.driver.getWindowHandles();
				for (String childWindow2 : handles2) 
				{
					if (!childWindow2.equals(ParentWindow2))
						QaBrowser.driver.switchTo().window(childWindow2);
				}
				String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='FlightQuotationModal']/div/div/div[2]/p")).getText();
				System.out.println(getT);
				String getTxt1[]= getT.split(" ");
				String number = getTxt1[11];
				System.out.println(number);
				QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
				
				QaRobot.ClickOnElement("NotificationCloseF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Quote Close</i></b>");
				QaBrowser.driver.switchTo().window(ParentWindow2);
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='leftbar']");
				
				QaRobot.ClickOnElement("Bookings");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
				
				QaRobot.ClickOnElement("BookingQueues");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
				
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='toolHeader']");
				
				QaRobot.ClickOnElement("CorporateQueue");
				
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='frm2']");
				
				QaRobot.ClickOnElement("EnquiryQueue");
				Thread.sleep(3000);
				
				QaRobot.PassValue("EnterEnquiryId",number);
//				QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
				
				QaRobot.ClickOnElement("SearchEnquiryId");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Search Enquiry Id");
				
				QaRobot.ClickOnElement("EnquiryView");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
				Thread.sleep(13000);
				
				String ParentWindow7 = QaBrowser.driver.getWindowHandle();
				Set<String> handles7 = QaBrowser.driver.getWindowHandles();
				for (String childWindow7 : handles7) 
				{
					if (!childWindow7.equals(ParentWindow7))
						QaBrowser.driver.switchTo().window(childWindow7);
				}
				
				QaExtentReport.extentScreenshot("Quotation View");
				
				QaBrowser.driver.close();
				Thread.sleep(10000);
				
				QaBrowser.driver.switchTo().window(ParentWindow7);
				
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				
				QaRobot.ClickOnElement("ApproveButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
				Thread.sleep(13000);
				
				String ParentWindow8 = QaBrowser.driver.getWindowHandle();
				Set<String> handles8 = QaBrowser.driver.getWindowHandles();
				for (String childWindow8 : handles8) 
				{
					if (!childWindow8.equals(ParentWindow8))
						QaBrowser.driver.switchTo().window(childWindow8);
				}
				Thread.sleep(3000);
				
				if(TravellerType.equalsIgnoreCase("Individual"))
				{
					QaRobot.ClickOnElement("SelectItineraryH");
//					QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
				}
				else if(TravellerType.equalsIgnoreCase("Dependent"))
				{
					QaRobot.ClickOnElement("SelectItineraryDH1");
//					QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
					
					QaRobot.ClickOnElement("SelectItineraryDH2");
//					QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
				}
				
				QaExtentReport.extentScreenshot("Itinerary View");
				
				JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
				mo1.executeScript("window.scrollBy(0,500)", "");
				
				QaRobot.ClickOnElement("FinalApproveButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
				
				QaRobot.PassValue("TextArea","Ok");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
				
				QaRobot.ClickOnElement("OKButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
				Thread.sleep(13000);
				QaBrowser.driver.switchTo().window(ParentWindow8);
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				
				QaRobot.ClickOnElement("FinalBookButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
				Thread.sleep(30000);
				
				DnataCheckoutPage.individualforHotel(TravellerType,Adult,Child,ModifySearch,ChangeRooms,AdultM,ChildM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
			}
			
			else if(Resultpagestep.equalsIgnoreCase("Book"))
			{
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				
				QaRobot.ClickOnElement("BookH");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(10000);
				
				DnataCheckoutPage.individualforHotel(TravellerType,Adult,Child,ModifySearch,ChangeRooms,AdultM,ChildM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
			}
		}
	}
	
	public static void ResultPageForInsurance(String TravellerType,String SelectPax,String PaxDOB,String ModifySearch,String ChangeTrip,String OriginCityCodeM,String OriginLocationM,
			String DestinationCityCodeM,String DestinationLocationM,String ChangeTripDate,String StartDateM,String EndDateM,String ChangePolicyFor,
			String PolicyForM,String SelectPaxM,String PaxDOBM,String ChangeFOPType,String FOPTypeM,String BenefitsNo,String Benefits,String Resultpagestep,
			String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		Thread.sleep(20000);
//		QaRobot.ScreenshotMethod("ResultPage","<b><i>Screenshot for Result Page</i></b>");
		
//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		String DateSelection[]= StartDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= EndDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1= DateSelection1[0];
		
		String DateSelection2[]= PaxDOBM.split("-");
		String Year = DateSelection2[2];
		String Month = DateSelection2[1];
		String Day = DateSelection2[0];
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.ClickOnElement("ModifyI");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");
			Thread.sleep(3000);
			
			if(ChangeTrip.equalsIgnoreCase("Yes"))
			{
				Assert.assertFalse(OriginCityCodeM==DestinationCityCodeM, "Modified Origin And Destination City Code Can't Be Same");
				Assert.assertFalse(OriginLocationM==DestinationLocationM, "Modified Origin And Destination City Location Can't Be Same");
				
				TestBase.listofautosuggestion4(By.xpath("//div[@id='divIDepartureCity']/p"), OriginCityCodeM, OriginLocationM,By.xpath("//input[@id='txtINSDepartureCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Modified Origin city : </i></b>"+OriginCityCodeM+" - " + OriginLocationM);
				Thread.sleep(2000);
					
				TestBase.listofautosuggestion4(By.xpath("//div[@id='divIDestinationCity']/p"), DestinationCityCodeM, DestinationLocationM,By.xpath("//input[@id='txtINSDestinationCity']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Modified Destination city : </i></b>"+DestinationCityCodeM+" - " + DestinationLocationM);
				Thread.sleep(2000);
			}
			
			if(ChangeTripDate.equalsIgnoreCase("Yes"))
			{
				QaBrowser.driver.findElement(By.xpath("//div[@id='Arrival']/div/div/div[1]/div[1]/div[2]/div/div[1]/div/div/span[1]/img")).click();
				Thread.sleep(2000);
				
				selectDateInCalendarInsurance(expDate,month,year,expDate1,month1,year1);
			}
			
			if(ChangePolicyFor.equalsIgnoreCase("Yes"))
			{
				if(TravellerType.equalsIgnoreCase("Individual"))
				{
				}
				else
				{
					if(PolicyForM.equalsIgnoreCase("Individual")||PolicyForM.equalsIgnoreCase("Family"))
					{
						Assert.assertFalse(Integer.parseInt(SelectPaxM)>9, "Invalid Pax Selected "+"-"+SelectPaxM);
						
						WebElement PaxNoM = QaBrowser.driver.findElement(By.xpath("//select[@id='pax']"));
						Select s = new Select(PaxNoM);                                  
						s.selectByVisibleText(SelectPaxM);
						
						for(int i=2;i<=Integer.parseInt(SelectPaxM);i++)
						{
							QaBrowser.driver.findElement(By.xpath("//div[@id='clsDOB_"+i+"']/div/div/span/img")).click();
							Thread.sleep(2000);
							
							selectDateInCalendarPassenger(Day,Month,Year);
						}
					}
					else if(PolicyForM.equalsIgnoreCase("Couple"))
					{
						Assert.assertFalse(Integer.parseInt(SelectPaxM)>2, "Invalid Pax Selected "+"-"+SelectPaxM);
						
						QaBrowser.driver.findElement(By.xpath("//img[@id='imgDOB2']")).click();
						Thread.sleep(2000);
						
						selectDateInCalendarPassenger(Day,Month,Year);
					}
				}
				Thread.sleep(3000);
			}
			
			if(ChangeFOPType.equalsIgnoreCase("Yes"))
			{
				WebElement FOPM = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlSearchFopINS']"));
				Select s1 = new Select(FOPM);                                  
				s1.selectByVisibleText(FOPTypeM);
			}

			QaExtentReport.extentScreenshot("Modified Search");
			QaRobot.ClickOnElement("ModifySearchFI");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
		}
		Thread.sleep(10000);
		QaExtentReport.extentScreenshot("Result Page");
		
		if(ModifySearch.equalsIgnoreCase("No"))
		{
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
		}
		
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,400)", "");
		
		int bN = Integer.parseInt(BenefitsNo);
		for (int i = 1; i <= bN; i++) 
		{
			String[] tN = Benefits.split(",");
			String b = tN[i-1];
			List<WebElement> listOfCover = QaBrowser.driver.findElements(By.xpath("//div[@id='div_020100_WRLDWD_21_0']/div/label"));
			
			for (WebElement autoCover : listOfCover) 
			  {
				if (autoCover.getText().equalsIgnoreCase(b)) 
				{
					autoCover.click();
					break;
				} 
				else 
				{
				}
			  }
		}
		Thread.sleep(3000);
		
		QaRobot.ClickOnElement("GetQuote");
		Thread.sleep(5000);
		
		QaRobot.ClickOnElement("FareBreakupI");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup</i></b>");
		Thread.sleep(5000);
		
		String ParentWindow3 = QaBrowser.driver.getWindowHandle();
		Set<String> handles3 = QaBrowser.driver.getWindowHandles();
		for (String childWindow3 : handles3) 
		{
			if (!childWindow3.equals(ParentWindow3))
				QaBrowser.driver.switchTo().window(childWindow3);
		}
		
		QaRobot.ClickOnElement("CustomerCostI");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Customer Cost</i></b>");
		Thread.sleep(1000);
		QaExtentReport.extentScreenshot("Customer Cost");
		
		QaRobot.ClickOnElement("CompanyCostI");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Company Cost</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Company Cost");
		
		QaRobot.ClickOnElement("FareCloseI");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Close</i></b>");
		Thread.sleep(2000);
		if(Resultpagestep.equalsIgnoreCase("Add to Cart")||Resultpagestep.equalsIgnoreCase("Send Quote"))
		{
			if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
			{
				QaRobot.ClickOnElement("AddToCartI");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add To Cart</i></b>");
				Thread.sleep(5000);
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();	
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				
				QaRobot.ClickOnElement("NotificationCloseI");
				
				QaRobot.ClickOnElement("YourItinerary");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Your Itinerary</i></b>");
				Thread.sleep(5000);
//				QaExtentReport.extentScreenshot("Your Itinerary");
			}
			else if(Resultpagestep.equalsIgnoreCase("Send Quote"))
			{
				QaRobot.ClickOnElement("SendQuoteRI");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ClickOnElement("QuoteToCustomer");
				Thread.sleep(5000);
			}
				String ParentWindow1 = QaBrowser.driver.getWindowHandle();
				Set<String> handles1 = QaBrowser.driver.getWindowHandles();
				for (String childWindow1 : handles1) 
				{
					if (!childWindow1.equals(ParentWindow1))
						QaBrowser.driver.switchTo().window(childWindow1);
				}
				
				QaRobot.PassValue("QuotationTitle",QuoteTitle);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
				QaExtentReport.extentScreenshot("Quotation");
				
				QaRobot.PassValue("RemarkTitle",QuoteRemark);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
				
				QaRobot.ClickOnElement("SendQuote");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
				Thread.sleep(5000);
				
				String ParentWindow2 = QaBrowser.driver.getWindowHandle();
				Set<String> handles2 = QaBrowser.driver.getWindowHandles();
				for (String childWindow2 : handles2) 
				{
					if (!childWindow2.equals(ParentWindow2))
						QaBrowser.driver.switchTo().window(childWindow2);
				}
				String getT = QaBrowser.driver.findElement(By.xpath("//div[@id='InsQuotationModal']/div/div/div[2]/p")).getText();
//				System.out.println(getT);
				String getTxt1[]= getT.split(" ");
				String number = getTxt1[10];
//				System.out.println(number);
				QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
				
				QaRobot.ClickOnElement("NotificationCloseI");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Quote Close</i></b>");
				QaBrowser.driver.switchTo().window(ParentWindow2);
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='leftbar']");
				
				QaRobot.ClickOnElement("Bookings");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
				
				QaRobot.ClickOnElement("BookingQueues");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
				
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='toolHeader']");
				QaRobot.ClickOnElement("CorporateQueue");
				QaBrowser.driver.switchTo().parentFrame();
				QaRobot.switchframe("//frame[@id='frm2']");
				
				QaRobot.ClickOnElement("EnquiryQueue");
				Thread.sleep(3000);
				
				QaRobot.PassValue("EnterEnquiryId",number);
//				QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
				
				QaRobot.ClickOnElement("SearchEnquiryId");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
				Thread.sleep(3000);
				QaExtentReport.extentScreenshot("Search Enquiry Id");
				
				QaRobot.ClickOnElement("EnquiryView");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
				Thread.sleep(8000);
				
				String ParentWindow7 = QaBrowser.driver.getWindowHandle();
				Set<String> handles7 = QaBrowser.driver.getWindowHandles();
				for (String childWindow7 : handles7) 
				{
					if (!childWindow7.equals(ParentWindow7))
						QaBrowser.driver.switchTo().window(childWindow7);
				}
				QaExtentReport.extentScreenshot("Quotation View");
				QaBrowser.driver.close();
				Thread.sleep(7000);
				
				QaBrowser.driver.switchTo().window(ParentWindow7);
				
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				
				QaRobot.ClickOnElement("ApproveButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
				Thread.sleep(13000);
				
				String ParentWindow8 = QaBrowser.driver.getWindowHandle();
				Set<String> handles8 = QaBrowser.driver.getWindowHandles();
				for (String childWindow8 : handles8) 
				{
					if (!childWindow8.equals(ParentWindow8))
						QaBrowser.driver.switchTo().window(childWindow8);
				}
				Thread.sleep(3000);
				QaRobot.ClickOnElement("SelectItineraryI");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
				QaExtentReport.extentScreenshot("Itinerary View");
				
				JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
				mo1.executeScript("window.scrollBy(0,500)", "");
				
				QaRobot.ClickOnElement("FinalApproveButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
				
				QaRobot.PassValue("TextArea","Ok");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
				
				QaRobot.ClickOnElement("OKButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
				Thread.sleep(13000);
				QaBrowser.driver.switchTo().window(ParentWindow8);
				QaRobot.switchframe("//frame[@name='login']");
				QaRobot.switchframe("//frame[@name='main']");
				QaRobot.switchframe("//frame[@id='frm2']");
				
				QaRobot.ClickOnElement("FinalBookButton");
//				QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
				Thread.sleep(8000);
				
				String ParentWindow9 = QaBrowser.driver.getWindowHandle();
				Set<String> handles9 = QaBrowser.driver.getWindowHandles();
				for (String childWindow9 : handles9) 
				{
					if (!childWindow9.equals(ParentWindow9))
						QaBrowser.driver.switchTo().window(childWindow9);
				}
				 
				QaRobot.ClickOnElement("EnquiryProcced");
				Thread.sleep(30000);
				
				if(TravellerType.equalsIgnoreCase("Individual"))
				{
					DnataCheckoutPage.individualforInsurance(TravellerType,SelectPax,PaxDOB,ModifySearch,SelectPaxM,PaxDOBM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
				}
				else if (TravellerType.equalsIgnoreCase("Dependent"))
				{
					DnataCheckoutPage.CheckoutForInsuranceDependent(TravellerType,SelectPax,PaxDOB,ModifySearch,SelectPaxM,PaxDOBM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
				}
		}
		else if(Resultpagestep.equalsIgnoreCase("Book Now"))
		{
			QaRobot.ClickOnElement("BookNowRI");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
			Thread.sleep(5000);
			
			if(TravellerType.equalsIgnoreCase("Individual"))
			{
				DnataCheckoutPage.individualforInsurance(TravellerType,SelectPax,PaxDOB,ModifySearch,SelectPaxM,PaxDOBM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
			}
			else if (TravellerType.equalsIgnoreCase("Dependent"))
			{
				DnataCheckoutPage.CheckoutForInsuranceDependent(TravellerType,SelectPax,PaxDOB,ModifySearch,SelectPaxM,PaxDOBM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
			}
		}
	}
	
	public static void ResultPageForFlight_Hotel(String ModifySearch,String ChangeTripLocation,String MarketTypeM,String OriginCityCodeM,
			String OriginLocationM,String DestinationCityCodeM,String DestinationLocationM,String ChangeTripDate,String DepartureDateM,
			String ReturnDateM,String ChangeRooms,String RoomsM,String AdultM,String ChildM,String ChildAgeM,String InfantM,String InfantAgeM,
			String MyHotelDiffenrentDateM,String ChangeCheckInM,String ChangeCheckOutM,String ChangeCurrency,String CurrencyM,
			String ChangeClass,String ClassM,String ChangeAirline,String PANumberM,String PreferredAirlineSelectM,String ShowDirectFlightM,
			String Applyfilter,String StarRating,String PropertyType,String RateType,String ChooseAnotherFlight,String FlightFilter,
			String FareType,String AirLine) throws Exception
	{
		Thread.sleep(15000);
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		String DateSelection[]= DepartureDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= ReturnDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1= DateSelection1[0];
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			QaRobot.ClickOnElement("ModifySearchFH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");
			
			if(ChangeTripLocation.equalsIgnoreCase("Yes"))
			{
					TestBase.listofautosuggestion4(By.xpath("//div[@id='dymModifyfromDiv']/p"), OriginCityCodeM, OriginLocationM,By.xpath("//input[@id='ctl00_contentMain_ctl00_dymModifyfromText']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Departure city : </i></b>"+OriginCityCodeM+" - " + OriginLocationM);
					Thread.sleep(2000);
						
					TestBase.listofautosuggestion4(By.xpath("//div[@id='dymModifytoDiv']/p"), DestinationCityCodeM, DestinationLocationM,By.xpath("//input[@id='ctl00_contentMain_ctl00_dymModifytoText']"));
					QaExtentReport.test.log(Status.INFO, "<b><i>Modified Arrival city : </i></b>"+DestinationCityCodeM+" - " + DestinationLocationM);
					Thread.sleep(2000);
			}
			
			if(ChangeTripDate.equalsIgnoreCase("Yes"))
			{
					QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
					Thread.sleep(2000);
					
					selectDateInCalendarFlight_Hotel(expDate,month,year,expDate1,month1,year1);
			}
			
			if(ChangeRooms.equalsIgnoreCase("Yes"))
			{
				int room=Integer.parseInt(RoomsM);
				String[] adultcount=AdultM.split(",");
				String[] childcount=ChildM.split(",");
				String[] infantcount=InfantM.split(",");
				
				if(room>5)
				{
					throw new Exception("Invalid Number of Rooms provided "+" : "+room);
				}
				else
				{
					WebElement roomelement=QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ctl00_DymModifySltHtlRooms']"));
					Select selectroom=new Select(roomelement);
					selectroom.selectByValue(RoomsM);
					Thread.sleep(2000);
					
					for(int i=1;i<=room;i++)
					{
						WebElement adultelement=QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ctl00_DymModifySltAdult"+i+"']"));
						Select selectadult=new Select(adultelement);
						selectadult.selectByValue(adultcount[i-1]);
						Thread.sleep(2000);
						
						WebElement childelement=QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ctl00_DymModifySltHtlChild"+i+"']"));
						Select selectchild=new Select(childelement);
						selectchild.selectByValue(childcount[i-1]);
						Thread.sleep(2000);
						
						WebElement infantelement=QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ctl00_DymModifySltHtlInfant"+i+"']"));
						Select selectinfant=new Select(infantelement);
						selectinfant.selectByValue(infantcount[i-1]);
						Thread.sleep(2000);
					}
					
					String[] ageofchild=ChildAgeM.split(",");
					for(String chd:childcount)
					{
						int chdcount=Integer.parseInt(chd);
						for(int i=1;i<=chdcount;i++)
						{
							String ac = ageofchild[i-1];
							int ac1 = Integer.parseInt(ac);
							
							if(ac1>11)
							{
								QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>"+" : "+ac1);
								throw new Exception("Invalid Child Age Selection"+" : "+ac1);
							}
							else
							{
								WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_ctl00_DymModifyChildAge"+chdcount+"_"+i+"']"));
								Select selectage=new Select(childrenage);
								selectage.selectByValue(ageofchild[i-1]);
								Thread.sleep(2000);
							}
						}
					} 
					
//					String[] ageofinfant=InfantAgeM.split(",");
//					for(String ift:infantcount)
//					{
//						int iftcount=Integer.parseInt(ift);
//						for(int i=1;i<=iftcount;i++)
//						{
//							String ai = ageofinfant[i-1];
//							int ai1 = Integer.parseInt(ai);
//							
//							if(ai1>2)
//							{
//								QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Infant Age Selection</i></b>"+" : "+ai1);
//								throw new B2cExceptionClass("Invalid Infant Age Selection"+" : "+ai1);
//							}
//							else
//							{
//								WebElement infantrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltInfantAge"+iftcount+"_"+i+"']"));
//								Select selectage=new Select(infantrenage);
//								selectage.selectByValue(ageofinfant[i-1]);
//								Thread.sleep(2000);
//							}
//						}
//					}
				}
			}
			
			if(MyHotelDiffenrentDateM.equalsIgnoreCase("Yes")) 
			{
				QaRobot.ClickOnElement("MyDatesAreFlexibleFH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on My Hotel Check in Check out dates different</i></b>");
				
				String DateSelection2[]= ChangeCheckInM.split("-");
				String year2 = DateSelection2[2];
				String month2 = DateSelection2[1];
				String expDate2 = DateSelection2[0];
				
				String DateSelection3[]= ChangeCheckOutM.split("-");
				String year3 = DateSelection3[2];
				String month3 = DateSelection3[1];
				String expDate3= DateSelection3[0];
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[3]")).click();
				Thread.sleep(2000);
				
				selectDateInCalendarFlight_Hotel1(expDate2,month2,year2,expDate3,month3,year3);
			}
			
			if(ChangeCurrency.equalsIgnoreCase("Yes"))
			{
				QaRobot.selectValueFromDropdown("CurrencyMFH", CurrencyM, "<b><i>Select Modified Currency for booking</i></b>");
				Thread.sleep(2000);
			}
			
			if(ChangeClass.equalsIgnoreCase("Yes"))
			{
				QaRobot.selectTextByLocator("//select[@id='ctl00_contentMain_ctl00_DymModifyBusclass']", ClassM, "<b><i>Select Modified Class for booking</i></b>");
				Thread.sleep(2000);
			}
			
			if(ChangeAirline.equalsIgnoreCase("Yes")) 
			{
				QaRobot.ClickOnElement("PreferredAirlineMFH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified PreferredAirline</i></b>");
				Thread.sleep(2000);
				
				int pAS = Integer.parseInt(PANumberM);
				for (int i = 1; i <= pAS; i++) 
				{
					String[] tN = PreferredAirlineSelectM.split(",");
					String b = tN[i-1];
					TestBase.listofautosuggestion1(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li/label"),b,By.xpath("/html/body/form/div[4]/div[2]/div[2]/section/div[2]/div/div[1]/div[1]/div/div/div[12]/div/div/div/div[1]/input"));
				}
				QaRobot.ClickOnElement("PreferredAirlineMFH");
			}
			
			if(ShowDirectFlightM.equalsIgnoreCase("Yes")) 
			{
				QaRobot.ClickOnElement("ShowDirectFlightMFH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Show Direct Flight</i></b>");
			}
			
			QaRobot.ClickOnElement("ModifySearchMFH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
		}
		Thread.sleep(10000);
		
		if(Applyfilter.equalsIgnoreCase("Yes"))
		{
			if(StarRating.equalsIgnoreCase("All"))
			{
				
			}
			else if(StarRating.equalsIgnoreCase("1 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			else if(StarRating.equalsIgnoreCase("2 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("3 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("4 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("5 Star"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FourStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("NotRatedStar"))
			{
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FourStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FiveStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			if(PropertyType.equalsIgnoreCase("All"))
			{
				
			}
			
			else if(PropertyType.equalsIgnoreCase("Hotel"))
			{
				QaRobot.ClickOnElement("Apartment");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(PropertyType.equalsIgnoreCase("Apartment"))
			{
				QaRobot.ClickOnElement("Hotel");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			if(RateType.equalsIgnoreCase("All"))
			{
				
			}
			
			else if(RateType.equalsIgnoreCase("RoomRate"))
			{
				QaRobot.ClickOnElement("PackageRate");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(RateType.equalsIgnoreCase("PackageRate"))
			{
				QaRobot.ClickOnElement("RoomRate");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
		}
		QaRobot.ScreenshotMethod("Applyfilter","<b><i>Screenshot for Apply filter</i></b>");
		QaExtentReport.extentScreenshot("Apply filter");
		
		if(ChooseAnotherFlight.equalsIgnoreCase("Yes"))
		{
			QaRobot.ClickOnElement("chooseAnotherFlight");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
			Thread.sleep(3000);
			
			if(FlightFilter.equalsIgnoreCase("Yes"))
			{
				if(FareType.equalsIgnoreCase("All"))
				{
					QaRobot.ClickOnElement("RefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
					Thread.sleep(3000);
					
					QaRobot.ClickOnElement("NonRefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
					Thread.sleep(3000);
				}
				else if(FareType.equalsIgnoreCase("Refundable"))
				{
					QaRobot.ClickOnElement("RefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
					Thread.sleep(3000);
				}
				else if(FareType.equalsIgnoreCase("Non-Refundable"))
				{
					QaRobot.ClickOnElement("NonRefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
					Thread.sleep(3000);
				}
				
				List<WebElement> listOfAirLine = QaBrowser.driver.findElements(By.xpath("//div[@id='tdContainerTblAirlines']//li//span"));
				
				for (WebElement autoAirline : listOfAirLine) 
				  {
					if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
					{
						autoAirline.click();
						break;
					} 
					else 
					{
						
					}
				  }
			}
			QaRobot.ScreenshotMethod("FlightFilter","<b><i>Screenshot for Flight Filter</i></b>");
			
			WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[contains(@title,'Fare Rules')])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", FareRules);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Fare Rules");
			QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
			
			String ParentWindow = QaBrowser.driver.getWindowHandle();
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) 
			{
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules Close</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow);
			
			WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@id='BaggageDetails_1'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", BaggegeInformation);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Baggege Information</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Baggege Information");
			QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
			
			String ParentWindow1 = QaBrowser.driver.getWindowHandle();
			Set<String> handles1 = QaBrowser.driver.getWindowHandles();
			for (String childWindow1 : handles1) 
			{
				if (!childWindow1.equals(ParentWindow1))
					QaBrowser.driver.switchTo().window(childWindow1);
			}
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information Close</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow1);
			
			WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath("(//a[@id='fl_1'])[1]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", MoreDetails);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("More Details");
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'Anchor_01UAP')])[1]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", BookNow);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Book Flight</i></b>");
			Thread.sleep(50000);
		}
		
		else if(ChooseAnotherFlight.equalsIgnoreCase("No"))
		{
			QaRobot.ClickOnElement("FlightFareRule");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Flight Fare Rule");
			QaRobot.ScreenshotMethod("FlightFareRule","<b><i>Screenshot for Flight Fare Rule</i></b>");
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules Close</i></b>");
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("BaggegeDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Baggege Details");
			QaRobot.ScreenshotMethod("BaggegeDetails","<b><i>Screenshot for Baggege Details</i></b>");
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information Close</i></b>");
			Thread.sleep(2000);
		}
		
		QaRobot.ClickOnElement("FHSelectRoom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select Room</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ClickOnElement("RoomCancellationPolicy");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Room Cancellation Policy</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Room Cancellation Policy");
		QaRobot.ScreenshotMethod("RoomCancellationPolicy","<b><i>Screenshot for Room Cancellation Policy</i></b>");
		
		QaRobot.ClickOnElement("RoomCancellationPolicyClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Room Cancellation Policy Close</i></b>");
		Thread.sleep(2000);
		
		QaRobot.ClickOnElement("FHBook");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
		Thread.sleep(15000);
	}
	
	public static void selectDateInCalendarOneWay(String Day,String Month,String Year) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
            currentMonthNumber = "01";
        } else if (Month.equalsIgnoreCase("Feb")) {
            currentMonthNumber = "02";
        } else if (Month.equalsIgnoreCase("Mar")) {
            currentMonthNumber = "03";
        } else if (Month.equalsIgnoreCase("Apr")) {
            currentMonthNumber = "04";
        } else if (Month.equalsIgnoreCase("May")) {
            currentMonthNumber = "05";
        } else if (Month.equalsIgnoreCase("Jun")) {
            currentMonthNumber = "06";
        } else if (Month.equalsIgnoreCase("Jul")) {
            currentMonthNumber = "07";
        } else if (Month.equalsIgnoreCase("Aug")) {
            currentMonthNumber = "08";
        } else if (Month.equalsIgnoreCase("Sep")) {
            currentMonthNumber = "09";
        } else if (Month.equalsIgnoreCase("Oct")) {
            currentMonthNumber = "10";
        } else if (Month.equalsIgnoreCase("Nov")) {
            currentMonthNumber = "11";
        } else if (Month.equalsIgnoreCase("Dec")) {
            currentMonthNumber = "12";
        }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Modified Select Date  </i></b>"+Day+"-"+Month+"-"+Year);
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid Modified date provided "+Day+"/"+Month+"/"+Year);
		}
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		
		String currentMonthNumber2 ="00";
		 if (month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber2 = "01";
     } else if (month.equalsIgnoreCase("Feb")) {
   	  currentMonthNumber2 = "02";
     } else if (month.equalsIgnoreCase("Mar")) {
   	  currentMonthNumber2 = "03";
     } else if (month.equalsIgnoreCase("Apr")) {
   	  currentMonthNumber2 = "04";
     } else if (month.equalsIgnoreCase("May")) {
   	  currentMonthNumber2 = "05";
     } else if (month.equalsIgnoreCase("Jun")) {
   	  currentMonthNumber2 = "06";
     } else if (month.equalsIgnoreCase("Jul")) {
   	  currentMonthNumber2 = "07";
     } else if (month.equalsIgnoreCase("Aug")) {
   	  currentMonthNumber2 = "08";
     } else if (month.equalsIgnoreCase("Sep")) {
   	  currentMonthNumber2 = "09";
     } else if (month.equalsIgnoreCase("Oct")) {
   	  currentMonthNumber2 = "10";
     } else if (month.equalsIgnoreCase("Nov")) {
   	  currentMonthNumber2 = "11";
     } else if (month.equalsIgnoreCase("Dec")) {
   	  currentMonthNumber2 = "12";
     }
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber2)&& year.equals(Year))
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			else
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
					List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
					
					for(WebElement ele : allDates)
					{
						String dt = ele.getText();
						
						if(dt.equalsIgnoreCase(Day))
						{
							ele.click();
							break;
						}
					}
		}
	  }
	
	public static void selectDateInCalendarRoundTrip(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
            currentMonthNumber = "01";
        } else if (Month.equalsIgnoreCase("Feb")) {
            currentMonthNumber = "02";
        } else if (Month.equalsIgnoreCase("Mar")) {
            currentMonthNumber = "03";
        } else if (Month.equalsIgnoreCase("Apr")) {
            currentMonthNumber = "04";
        } else if (Month.equalsIgnoreCase("May")) {
            currentMonthNumber = "05";
        } else if (Month.equalsIgnoreCase("Jun")) {
            currentMonthNumber = "06";
        } else if (Month.equalsIgnoreCase("Jul")) {
            currentMonthNumber = "07";
        } else if (Month.equalsIgnoreCase("Aug")) {
            currentMonthNumber = "08";
        } else if (Month.equalsIgnoreCase("Sep")) {
            currentMonthNumber = "09";
        } else if (Month.equalsIgnoreCase("Oct")) {
            currentMonthNumber = "10";
        } else if (Month.equalsIgnoreCase("Nov")) {
            currentMonthNumber = "11";
        } else if (Month.equalsIgnoreCase("Dec")) {
            currentMonthNumber = "12";
        }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
		 if (Month1.equalsIgnoreCase("Jan")) {
           currentMonthNumber1 = "01";
       } else if (Month1.equalsIgnoreCase("Feb")) {
           currentMonthNumber1 = "02";
       } else if (Month1.equalsIgnoreCase("Mar")) {
           currentMonthNumber1 = "03";
       } else if (Month1.equalsIgnoreCase("Apr")) {
           currentMonthNumber1 = "04";
       } else if (Month1.equalsIgnoreCase("May")) {
           currentMonthNumber1 = "05";
       } else if (Month1.equalsIgnoreCase("Jun")) {
           currentMonthNumber1 = "06";
       } else if (Month1.equalsIgnoreCase("Jul")) {
           currentMonthNumber1 = "07";
       } else if (Month1.equalsIgnoreCase("Aug")) {
           currentMonthNumber1 = "08";
       } else if (Month1.equalsIgnoreCase("Sep")) {
           currentMonthNumber1 = "09";
       } else if (Month1.equalsIgnoreCase("Oct")) {
           currentMonthNumber1 = "10";
       } else if (Month1.equalsIgnoreCase("Nov")) {
           currentMonthNumber1 = "11";
       } else if (Month1.equalsIgnoreCase("Dec")) {
           currentMonthNumber1 = "12";
       }
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Modified Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Modified Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid Modified date provided "+Day+"/"+Month+"/"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid Modified date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid Modified date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid Modified date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid Modified date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		
		String currentMonthNumber2 ="00";
		 if (month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber2 = "01";
      } else if (month.equalsIgnoreCase("Feb")) {
    	  currentMonthNumber2 = "02";
      } else if (month.equalsIgnoreCase("Mar")) {
    	  currentMonthNumber2 = "03";
      } else if (month.equalsIgnoreCase("Apr")) {
    	  currentMonthNumber2 = "04";
      } else if (month.equalsIgnoreCase("May")) {
    	  currentMonthNumber2 = "05";
      } else if (month.equalsIgnoreCase("Jun")) {
    	  currentMonthNumber2 = "06";
      } else if (month.equalsIgnoreCase("Jul")) {
    	  currentMonthNumber2 = "07";
      } else if (month.equalsIgnoreCase("Aug")) {
    	  currentMonthNumber2 = "08";
      } else if (month.equalsIgnoreCase("Sep")) {
    	  currentMonthNumber2 = "09";
      } else if (month.equalsIgnoreCase("Oct")) {
    	  currentMonthNumber2 = "10";
      } else if (month.equalsIgnoreCase("Nov")) {
    	  currentMonthNumber2 = "11";
      } else if (month.equalsIgnoreCase("Dec")) {
    	  currentMonthNumber2 = "12";
      }
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Modified date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid Modified date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber2)&& year.equals(Year))
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
				
			}
			else
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[2]")).click();
				Thread.sleep(2000);
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Return Modified date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new Exception("Invalid Return Modified date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
							
							monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
							
							month1 = monthYear1.split(" ")[0];
							year1 = monthYear1.split(" ")[1];
						}
					
							List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
							
							for(WebElement ele1 : allDates1)
							{
								String dt1 = ele1.getText();
								
								if(dt1.equalsIgnoreCase(Day1))
								{
									ele1.click();
									break;
								}
							}
				}
		}
	  }
	
	public static void selectDateInCalendarHotel(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
           currentMonthNumber = "01";
       } else if (Month.equalsIgnoreCase("Feb")) {
           currentMonthNumber = "02";
       } else if (Month.equalsIgnoreCase("Mar")) {
           currentMonthNumber = "03";
       } else if (Month.equalsIgnoreCase("Apr")) {
           currentMonthNumber = "04";
       } else if (Month.equalsIgnoreCase("May")) {
           currentMonthNumber = "05";
       } else if (Month.equalsIgnoreCase("Jun")) {
           currentMonthNumber = "06";
       } else if (Month.equalsIgnoreCase("Jul")) {
           currentMonthNumber = "07";
       } else if (Month.equalsIgnoreCase("Aug")) {
           currentMonthNumber = "08";
       } else if (Month.equalsIgnoreCase("Sep")) {
           currentMonthNumber = "09";
       } else if (Month.equalsIgnoreCase("Oct")) {
           currentMonthNumber = "10";
       } else if (Month.equalsIgnoreCase("Nov")) {
           currentMonthNumber = "11";
       } else if (Month.equalsIgnoreCase("Dec")) {
           currentMonthNumber = "12";
       }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
		 if (Month1.equalsIgnoreCase("Jan")) {
          currentMonthNumber1 = "01";
      } else if (Month1.equalsIgnoreCase("Feb")) {
          currentMonthNumber1 = "02";
      } else if (Month1.equalsIgnoreCase("Mar")) {
          currentMonthNumber1 = "03";
      } else if (Month1.equalsIgnoreCase("Apr")) {
          currentMonthNumber1 = "04";
      } else if (Month1.equalsIgnoreCase("May")) {
          currentMonthNumber1 = "05";
      } else if (Month1.equalsIgnoreCase("Jun")) {
          currentMonthNumber1 = "06";
      } else if (Month1.equalsIgnoreCase("Jul")) {
          currentMonthNumber1 = "07";
      } else if (Month1.equalsIgnoreCase("Aug")) {
          currentMonthNumber1 = "08";
      } else if (Month1.equalsIgnoreCase("Sep")) {
          currentMonthNumber1 = "09";
      } else if (Month1.equalsIgnoreCase("Oct")) {
          currentMonthNumber1 = "10";
      } else if (Month1.equalsIgnoreCase("Nov")) {
          currentMonthNumber1 = "11";
      } else if (Month1.equalsIgnoreCase("Dec")) {
          currentMonthNumber1 = "12";
      }
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Check In Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Check Out Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		
		String currentMonthNumber2 ="00";
		 if (month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber2 = "01";
    } else if (month.equalsIgnoreCase("Feb")) {
  	  currentMonthNumber2 = "02";
    } else if (month.equalsIgnoreCase("Mar")) {
  	  currentMonthNumber2 = "03";
    } else if (month.equalsIgnoreCase("Apr")) {
  	  currentMonthNumber2 = "04";
    } else if (month.equalsIgnoreCase("May")) {
  	  currentMonthNumber2 = "05";
    } else if (month.equalsIgnoreCase("Jun")) {
  	  currentMonthNumber2 = "06";
    } else if (month.equalsIgnoreCase("Jul")) {
  	  currentMonthNumber2 = "07";
    } else if (month.equalsIgnoreCase("Aug")) {
  	  currentMonthNumber2 = "08";
    } else if (month.equalsIgnoreCase("Sep")) {
  	  currentMonthNumber2 = "09";
    } else if (month.equalsIgnoreCase("Oct")) {
  	  currentMonthNumber2 = "10";
    } else if (month.equalsIgnoreCase("Nov")) {
  	  currentMonthNumber2 = "11";
    } else if (month.equalsIgnoreCase("Dec")) {
  	  currentMonthNumber2 = "12";
    }
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber2)&& year.equals(Year))
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			else
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[2]")).click();
				Thread.sleep(2000);
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				
				String currentMonthNumber3 ="00";
				 if (month1.equalsIgnoreCase("Jan")) {
					 currentMonthNumber3 = "01";
		    } else if (month1.equalsIgnoreCase("Feb")) {
		    	currentMonthNumber3 = "02";
		    } else if (month1.equalsIgnoreCase("Mar")) {
		    	currentMonthNumber3 = "03";
		    } else if (month1.equalsIgnoreCase("Apr")) {
		    	currentMonthNumber3 = "04";
		    } else if (month1.equalsIgnoreCase("May")) {
		    	currentMonthNumber3 = "05";
		    } else if (month1.equalsIgnoreCase("Jun")) {
		    	currentMonthNumber3 = "06";
		    } else if (month1.equalsIgnoreCase("Jul")) {
		    	currentMonthNumber3 = "07";
		    } else if (month1.equalsIgnoreCase("Aug")) {
		    	currentMonthNumber3 = "08";
		    } else if (month1.equalsIgnoreCase("Sep")) {
		    	currentMonthNumber3 = "09";
		    } else if (month1.equalsIgnoreCase("Oct")) {
		    	currentMonthNumber3 = "10";
		    } else if (month1.equalsIgnoreCase("Nov")) {
		    	currentMonthNumber3 = "11";
		    } else if (month1.equalsIgnoreCase("Dec")) {
		    	currentMonthNumber3 = "12";
		    }
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Check out date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new Exception("Invalid Check out date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber3)&& year.equals(Year))
					{
						while(!(month1.equals(Month1) && year1.equals(Year1)))
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();
							
							monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
							
							month1 = monthYear1.split(" ")[0];
							year1 = monthYear1.split(" ")[1];
						}
					}
					else
					{
						while(!(month1.equals(Month1) && year1.equals(Year1)))
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
							
							monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
							
							month1 = monthYear1.split(" ")[0];
							year1 = monthYear1.split(" ")[1];
						}
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
	
	public static void selectDateInCalendarPassenger(String Day,String Month,String Year) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
           currentMonthNumber = "01";
       } else if (Month.equalsIgnoreCase("Feb")) {
           currentMonthNumber = "02";
       } else if (Month.equalsIgnoreCase("Mar")) {
           currentMonthNumber = "03";
       } else if (Month.equalsIgnoreCase("Apr")) {
           currentMonthNumber = "04";
       } else if (Month.equalsIgnoreCase("May")) {
           currentMonthNumber = "05";
       } else if (Month.equalsIgnoreCase("Jun")) {
           currentMonthNumber = "06";
       } else if (Month.equalsIgnoreCase("Jul")) {
           currentMonthNumber = "07";
       } else if (Month.equalsIgnoreCase("Aug")) {
           currentMonthNumber = "08";
       } else if (Month.equalsIgnoreCase("Sep")) {
           currentMonthNumber = "09";
       } else if (Month.equalsIgnoreCase("Oct")) {
           currentMonthNumber = "10";
       } else if (Month.equalsIgnoreCase("Nov")) {
           currentMonthNumber = "11";
       } else if (Month.equalsIgnoreCase("Dec")) {
           currentMonthNumber = "12";
       }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		LocalDate date3 = LocalDate.of(Integer.parseInt(Year), Integer.parseInt(currentMonthNumber), Integer.parseInt(Day));
		LocalDate today = LocalDate.now();
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>"+Day+"-"+Month+"-"+Year);
		
		Assert.assertFalse(Integer.parseInt(Day)>31, "Invalid date provided "+Day+"-"+Month+"-"+Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day)>28, "Invalid date provided "+Day+"-"+Month+"-"+Year);
		Assert.assertTrue(date2.before(date1), "Invalid date provided "+Day+"-"+Month+"-"+Year);
		Assert.assertTrue(date3.isBefore(today.minusYears(1)), "Invalid date provided "+Day+"-"+Month+"-"+Year);
		
		WebElement SelectMonth=QaBrowser.driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[1]"));
		Select M=new Select(SelectMonth);
		M.selectByVisibleText(Month);
		
		WebElement SelectYear=QaBrowser.driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[2]"));
		Select Y=new Select(SelectYear);
		Y.selectByVisibleText(Year);
		
		List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
		
		for(WebElement ele : allDates)
		{
			String dt = ele.getText();
			
			if(dt.equalsIgnoreCase(Day))
			{
				ele.click();
				break;
			}
		}
	  }
	
	
	
	public static void selectDateInCalendarFlight_Hotel(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
           currentMonthNumber = "01";
       } else if (Month.equalsIgnoreCase("Feb")) {
           currentMonthNumber = "02";
       } else if (Month.equalsIgnoreCase("Mar")) {
           currentMonthNumber = "03";
       } else if (Month.equalsIgnoreCase("Apr")) {
           currentMonthNumber = "04";
       } else if (Month.equalsIgnoreCase("May")) {
           currentMonthNumber = "05";
       } else if (Month.equalsIgnoreCase("Jun")) {
           currentMonthNumber = "06";
       } else if (Month.equalsIgnoreCase("Jul")) {
           currentMonthNumber = "07";
       } else if (Month.equalsIgnoreCase("Aug")) {
           currentMonthNumber = "08";
       } else if (Month.equalsIgnoreCase("Sep")) {
           currentMonthNumber = "09";
       } else if (Month.equalsIgnoreCase("Oct")) {
           currentMonthNumber = "10";
       } else if (Month.equalsIgnoreCase("Nov")) {
           currentMonthNumber = "11";
       } else if (Month.equalsIgnoreCase("Dec")) {
           currentMonthNumber = "12";
       }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
		 if (Month1.equalsIgnoreCase("Jan")) {
          currentMonthNumber1 = "01";
      } else if (Month1.equalsIgnoreCase("Feb")) {
          currentMonthNumber1 = "02";
      } else if (Month1.equalsIgnoreCase("Mar")) {
          currentMonthNumber1 = "03";
      } else if (Month1.equalsIgnoreCase("Apr")) {
          currentMonthNumber1 = "04";
      } else if (Month1.equalsIgnoreCase("May")) {
          currentMonthNumber1 = "05";
      } else if (Month1.equalsIgnoreCase("Jun")) {
          currentMonthNumber1 = "06";
      } else if (Month1.equalsIgnoreCase("Jul")) {
          currentMonthNumber1 = "07";
      } else if (Month1.equalsIgnoreCase("Aug")) {
          currentMonthNumber1 = "08";
      } else if (Month1.equalsIgnoreCase("Sep")) {
          currentMonthNumber1 = "09";
      } else if (Month1.equalsIgnoreCase("Oct")) {
          currentMonthNumber1 = "10";
      } else if (Month1.equalsIgnoreCase("Nov")) {
          currentMonthNumber1 = "11";
      } else if (Month1.equalsIgnoreCase("Dec")) {
          currentMonthNumber1 = "12";
      }
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='ctl00_contentMain_ctl00_DymModifyflightFrom']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"/"+Month+"/"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		
		String currentMonthNumber2 ="00";
		 if (month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber2 = "01";
     } else if (month.equalsIgnoreCase("Feb")) {
   	  currentMonthNumber2 = "02";
     } else if (month.equalsIgnoreCase("Mar")) {
   	  currentMonthNumber2 = "03";
     } else if (month.equalsIgnoreCase("Apr")) {
   	  currentMonthNumber2 = "04";
     } else if (month.equalsIgnoreCase("May")) {
   	  currentMonthNumber2 = "05";
     } else if (month.equalsIgnoreCase("Jun")) {
   	  currentMonthNumber2 = "06";
     } else if (month.equalsIgnoreCase("Jul")) {
   	  currentMonthNumber2 = "07";
     } else if (month.equalsIgnoreCase("Aug")) {
   	  currentMonthNumber2 = "08";
     } else if (month.equalsIgnoreCase("Sep")) {
   	  currentMonthNumber2 = "09";
     } else if (month.equalsIgnoreCase("Oct")) {
   	  currentMonthNumber2 = "10";
     } else if (month.equalsIgnoreCase("Nov")) {
   	  currentMonthNumber2 = "11";
     } else if (month.equalsIgnoreCase("Dec")) {
   	  currentMonthNumber2 = "12";
     }
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber2)&& year.equals(Year))
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[1]/a[1]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			else
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[1]/a[3]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[2]")).click();
				Thread.sleep(2000);
				
				QaBrowser.driver.findElement(By.xpath("//input[@id='ctl00_contentMain_ctl00_DymModifyflightTo']")).clear();
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Return date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new Exception("Invalid Return date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[1]/a[3]")).click();
							
							monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
							
							month1 = monthYear1.split(" ")[0];
							year1 = monthYear1.split(" ")[1];
						}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
	
	public static void selectDateInCalendarInsurance(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber = "01";
   } else if (Month.equalsIgnoreCase("Feb")) {
   	currentMonthNumber = "02";
   } else if (Month.equalsIgnoreCase("Mar")) {
   	currentMonthNumber = "03";
   } else if (Month.equalsIgnoreCase("Apr")) {
   	currentMonthNumber = "04";
   } else if (Month.equalsIgnoreCase("May")) {
   	currentMonthNumber = "05";
   } else if (Month.equalsIgnoreCase("Jun")) {
   	currentMonthNumber = "06";
   } else if (Month.equalsIgnoreCase("Jul")) {
   	currentMonthNumber = "07";
   } else if (Month.equalsIgnoreCase("Aug")) {
   	currentMonthNumber = "08";
   } else if (Month.equalsIgnoreCase("Sep")) {
   	currentMonthNumber = "09";
   } else if (Month.equalsIgnoreCase("Oct")) {
   	currentMonthNumber = "10";
   } else if (Month.equalsIgnoreCase("Nov")) {
   	currentMonthNumber = "11";
   } else if (Month.equalsIgnoreCase("Dec")) {
   	currentMonthNumber = "12";
   }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
//		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
		 if (Month1.equalsIgnoreCase("Jan")) {
        currentMonthNumber1 = "01";
    } else if (Month1.equalsIgnoreCase("Feb")) {
        currentMonthNumber1 = "02";
    } else if (Month1.equalsIgnoreCase("Mar")) {
        currentMonthNumber1 = "03";
    } else if (Month1.equalsIgnoreCase("Apr")) {
        currentMonthNumber1 = "04";
    } else if (Month1.equalsIgnoreCase("May")) {
        currentMonthNumber1 = "05";
    } else if (Month1.equalsIgnoreCase("Jun")) {
        currentMonthNumber1 = "06";
    } else if (Month1.equalsIgnoreCase("Jul")) {
        currentMonthNumber1 = "07";
    } else if (Month1.equalsIgnoreCase("Aug")) {
        currentMonthNumber1 = "08";
    } else if (Month1.equalsIgnoreCase("Sep")) {
        currentMonthNumber1 = "09";
    } else if (Month1.equalsIgnoreCase("Oct")) {
        currentMonthNumber1 = "10";
    } else if (Month1.equalsIgnoreCase("Nov")) {
        currentMonthNumber1 = "11";
    } else if (Month1.equalsIgnoreCase("Dec")) {
        currentMonthNumber1 = "12";
    }
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
//		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Modified Start Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Modified End Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		Assert.assertFalse(Integer.parseInt(Day)>31, "Invalid date provided "+Day+"-"+Month+"-"+Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day)>28, "Invalid date provided "+Day+"-"+Month+"-"+Year);
		Assert.assertFalse(Integer.parseInt(Day1)>31, "Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1)>28, "Invalid date provided "+Day1+"-"+Month1+"-"+Year1);

		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		Assert.assertFalse(date2.before(date1), "Invalid date provided "+Day+"-"+Month+"-"+Year);
		while(!(month.equals(Month) && year.equals(Year)))
		{
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			
			monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}
		
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele : allDates)
			{
				String dt = ele.getText();
				
				if(dt.equalsIgnoreCase(Day))
				{
					ele.click();
					break;
				}
			}
			
			QaBrowser.driver.findElement(By.xpath("//div[@id='Arrival']/div/div/div[1]/div[1]/div[2]/div/div[2]/div/div/span[1]/img")).click();
			Thread.sleep(2000);
			
			String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			
			String month1 = monthYear1.split(" ")[0];
			String year1 = monthYear1.split(" ")[1];
			
			Assert.assertFalse(date3.before(date2), "Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			
			while(!(month1.equals(Month1) && year1.equals(Year1)))
			{
				QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
				
				monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
				
				month1 = monthYear1.split(" ")[0];
				year1 = monthYear1.split(" ")[1];
			}
			
				List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele1 : allDates1)
				{
					String dt1 = ele1.getText();
					
					if(dt1.equalsIgnoreCase(Day1))
					{
						ele1.click();
						break;
					}
				}
	  }
	
	public static void selectDateInCalendarFlight_Hotel1(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws Exception
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
		 if (Month.equalsIgnoreCase("Jan")) {
          currentMonthNumber = "01";
      } else if (Month.equalsIgnoreCase("Feb")) {
          currentMonthNumber = "02";
      } else if (Month.equalsIgnoreCase("Mar")) {
          currentMonthNumber = "03";
      } else if (Month.equalsIgnoreCase("Apr")) {
          currentMonthNumber = "04";
      } else if (Month.equalsIgnoreCase("May")) {
          currentMonthNumber = "05";
      } else if (Month.equalsIgnoreCase("Jun")) {
          currentMonthNumber = "06";
      } else if (Month.equalsIgnoreCase("Jul")) {
          currentMonthNumber = "07";
      } else if (Month.equalsIgnoreCase("Aug")) {
          currentMonthNumber = "08";
      } else if (Month.equalsIgnoreCase("Sep")) {
          currentMonthNumber = "09";
      } else if (Month.equalsIgnoreCase("Oct")) {
          currentMonthNumber = "10";
      } else if (Month.equalsIgnoreCase("Nov")) {
          currentMonthNumber = "11";
      } else if (Month.equalsIgnoreCase("Dec")) {
          currentMonthNumber = "12";
      }
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
		 if (Month1.equalsIgnoreCase("Jan")) {
         currentMonthNumber1 = "01";
     } else if (Month1.equalsIgnoreCase("Feb")) {
         currentMonthNumber1 = "02";
     } else if (Month1.equalsIgnoreCase("Mar")) {
         currentMonthNumber1 = "03";
     } else if (Month1.equalsIgnoreCase("Apr")) {
         currentMonthNumber1 = "04";
     } else if (Month1.equalsIgnoreCase("May")) {
         currentMonthNumber1 = "05";
     } else if (Month1.equalsIgnoreCase("Jun")) {
         currentMonthNumber1 = "06";
     } else if (Month1.equalsIgnoreCase("Jul")) {
         currentMonthNumber1 = "07";
     } else if (Month1.equalsIgnoreCase("Aug")) {
         currentMonthNumber1 = "08";
     } else if (Month1.equalsIgnoreCase("Sep")) {
         currentMonthNumber1 = "09";
     } else if (Month1.equalsIgnoreCase("Oct")) {
         currentMonthNumber1 = "10";
     } else if (Month1.equalsIgnoreCase("Nov")) {
         currentMonthNumber1 = "11";
     } else if (Month1.equalsIgnoreCase("Dec")) {
         currentMonthNumber1 = "12";
     }
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='ctl00_contentMain_ctl00_DymModifyHotelCheckIn']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"/"+Month+"/"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new Exception("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		
		String currentMonthNumber2 ="00";
		 if (month.equalsIgnoreCase("Jan")) {
			 currentMonthNumber2 = "01";
    } else if (month.equalsIgnoreCase("Feb")) {
  	  currentMonthNumber2 = "02";
    } else if (month.equalsIgnoreCase("Mar")) {
  	  currentMonthNumber2 = "03";
    } else if (month.equalsIgnoreCase("Apr")) {
  	  currentMonthNumber2 = "04";
    } else if (month.equalsIgnoreCase("May")) {
  	  currentMonthNumber2 = "05";
    } else if (month.equalsIgnoreCase("Jun")) {
  	  currentMonthNumber2 = "06";
    } else if (month.equalsIgnoreCase("Jul")) {
  	  currentMonthNumber2 = "07";
    } else if (month.equalsIgnoreCase("Aug")) {
  	  currentMonthNumber2 = "08";
    } else if (month.equalsIgnoreCase("Sep")) {
  	  currentMonthNumber2 = "09";
    } else if (month.equalsIgnoreCase("Oct")) {
  	  currentMonthNumber2 = "10";
    } else if (month.equalsIgnoreCase("Nov")) {
  	  currentMonthNumber2 = "11";
    } else if (month.equalsIgnoreCase("Dec")) {
  	  currentMonthNumber2 = "12";
    }
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			if(Integer.parseInt(currentMonthNumber)<Integer.parseInt(currentMonthNumber2)&& year.equals(Year))
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[1]/a[1]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			else
			{
				while(!(month.equals(Month) && year.equals(Year)))
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[3]")).click();
					
					monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
					
					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[4]")).click();
				Thread.sleep(2000);
				
				QaBrowser.driver.findElement(By.xpath("//input[@id='ctl00_contentMain_ctl00_DymModifyHotelCheckout']")).clear();
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Return date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new Exception("Invalid Return date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
					{
						QaBrowser.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a[3]")).click();
						
						monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div/div/div[2]/div[1]/div")).getText();
						
						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
}



























