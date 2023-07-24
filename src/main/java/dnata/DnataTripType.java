package dnata;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class DnataTripType {
	public static WebDriver driver;

	public static void flightTriptype(String TravellerType, String TripType, String OriginCityCode,
			String OriginLocation, String DestinationCityCode, String DestinationLocation, String DepartureDate,
			String ReturnDate, String adult, String child, String infant, String Class, String PreAirline,
			String PANumber, String PreferredAirlineSelect, String FOPType, String ShowDirectFlight, String Supplier)
			throws Exception {
		String DateSelection[] = DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("OneWay");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on OneWay</i></b>");

			Assert.assertFalse(OriginCityCode == DestinationCityCode, "Origin And Destination City Code Can't Be Same");
			Assert.assertFalse(OriginLocation == DestinationLocation,
					"Origin And Destination City Location Can't Be Same");

			TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='txtDepartureCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DestinationCityCode,
					DestinationLocation, By.xpath("//input[@id='txtDestinationCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);

			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div[1]/label/span[2]/a/img"))
					.click();
			Thread.sleep(2000);

			selectDateInCalendarOneWay(expDate, month, year);

			if (TravellerType.equalsIgnoreCase("Individual")) {
			} else {
				QaRobot.ClickOnElement("Travellers");
				QaRobot.selectValueFromDropdown("DAdult", adult,
						"<b><i>Select adult for booking</i></b>" + " - " + adult);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("DChild", child,
						"<b><i>Select child for booking</i></b>" + " - " + child);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("DInfant", infant,
						"<b><i>Select infant for booking</i></b>" + " - " + infant);
				Thread.sleep(2000);

				QaRobot.ClickOnElement("Travellers");
			}

			QaRobot.selectTextByLocator("//select[@id='ddlClass']", Class,
					"<b><i>Select Class for booking </i></b>" + Class);
			Thread.sleep(2000);

			if (PreAirline.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("PreferredAirline");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on PreferredAirline</i></b>");
				Thread.sleep(2000);

				int pAS = Integer.parseInt(PANumber);
				for (int i = 1; i <= pAS; i++) {
					String[] tN = PreferredAirlineSelect.split(",");
					String b = tN[i - 1];
					TestBase.listofautosuggestion1(By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"), b,
							By.xpath("//div[@id='Commondiv']/div[1]/div[3]/div/div/div/div[1]/input"));
				}
			}

			QaRobot.selectTextFromDropdown("FOPType", FOPType, "<b><i>Select FOP for booking</i></b>" + "  " + FOPType);
			Thread.sleep(2000);

			if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ShowDirectFlightF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
			}

			QaRobot.ClickOnElement("SelectAll");

			List<WebElement> listOfSupplier = QaBrowser.driver
					.findElements(By.xpath("(//div[@id='divSuppliers'])[1]/div/label"));
			for (WebElement autoSupplier : listOfSupplier) {
				if (autoSupplier.getText().equalsIgnoreCase(Supplier)) {
					autoSupplier.click();
					break;
				}
			}
			QaExtentReport.test.log(Status.INFO, "<b><i>Select Supplier</i></b>" + " " + Supplier);
		}

		else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("RoundTrip");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on RoundTrip</i></b>");

			Assert.assertFalse(OriginCityCode == DestinationCityCode, "Origin And Destination City Code Can't Be Same");
			Assert.assertFalse(OriginLocation == DestinationLocation,
					"Origin And Destination City Location Can't Be Same");

			TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), OriginCityCode, OriginLocation,
					By.xpath("//input[@id='txtDepartureCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
			Thread.sleep(2000);

			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DestinationCityCode,
					DestinationLocation, By.xpath("//input[@id='txtDestinationCity']"));
			QaExtentReport.test.log(Status.INFO,
					"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
			Thread.sleep(2000);

			QaBrowser.driver
					.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/div/div[1]/label/span[2]/a/img"))
					.click();
			Thread.sleep(2000);

			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);

			if (TravellerType.equalsIgnoreCase("Individual")) {
			} else {
				QaRobot.ClickOnElement("Travellers");
				QaRobot.selectValueFromDropdown("DAdult", adult,
						"<b><i>Select adult for booking</i></b>" + " - " + adult);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("DChild", child,
						"<b><i>Select child for booking</i></b>" + " - " + child);
				Thread.sleep(2000);

				QaRobot.selectValueFromDropdown("DInfant", infant,
						"<b><i>Select infant for booking</i></b>" + " - " + infant);
				Thread.sleep(2000);

				QaRobot.ClickOnElement("Travellers");
			}

			QaRobot.selectTextByLocator("//select[@id='ddlClass']", Class,
					"<b><i>Select Class for booking </i></b>" + Class);
			Thread.sleep(2000);

			if (PreAirline.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("PreferredAirline");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on PreferredAirline</i></b>");
				Thread.sleep(2000);

				int pAS = Integer.parseInt(PANumber);
				for (int i = 1; i <= pAS; i++) {
					String[] tN = PreferredAirlineSelect.split(",");
					String b = tN[i - 1];
					TestBase.listofautosuggestion1(By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"), b,
							By.xpath("//div[@id='Commondiv']/div[1]/div[3]/div/div/div/div[1]/input"));
				}
			}

			QaRobot.selectTextFromDropdown("FOPType", FOPType,
					"<b><i>Select adult for booking</i></b>" + "  " + FOPType);
			Thread.sleep(2000);

			if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("ShowDirectFlightF");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
			}

			QaRobot.ClickOnElement("SelectAll");

			List<WebElement> listOfSupplier = QaBrowser.driver
					.findElements(By.xpath("(//div[@id='divSuppliers'])[1]/div/label"));

			for (WebElement autoSupplier : listOfSupplier) {
				if (autoSupplier.getText().equalsIgnoreCase(Supplier)) {
					autoSupplier.click();
					break;
				}
			}
			QaExtentReport.test.log(Status.INFO, "<b><i>Select Supplier</i></b>" + " " + Supplier);
		} else if (TripType.equalsIgnoreCase("MultiCity")) {
			QaRobot.ClickOnElement("Multicity");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Multicity</i></b>");
		} else if (TripType.equalsIgnoreCase("DirectBooking")) {
			QaRobot.ClickOnElement("DirectBooking");
//			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on DirectBooking</i></b>");
		}
		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchF");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
			QaRobot.ScreenshotMethod("FlightTrip", "<b><i>Screenshot for Flight Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void hotelTrip(String TravellerType, String CityCode, String CityTitle, String CheckInDate,
			String CheckOutDate, String Rooms, String Adult, String Child, String ChildAge, String FOPType,
			String Supplier) throws Exception {
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,
				By.xpath("//input[@id='txtHotelSearch']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//form[@id='HotelSearchCntrl']/div/div[3]/div[1]/label/span[2]/a"))
				.click();
		Thread.sleep(2000);

		String DateSelection[] = CheckInDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = CheckOutDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);

		int room = Integer.parseInt(Rooms);
		String[] adultcount = Adult.split(",");
		String[] childcount = Child.split(",");

		if (room > 5) {
			throw new Exception("Invalid Number of Rooms provided " + " : " + room);
		} else {
			WebElement RoomsH = QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
			Select selectRooms = new Select(RoomsH);
			selectRooms.selectByVisibleText(Rooms);
			if (TravellerType.equalsIgnoreCase("Individual")) {
			} else {
				for (int i = 1; i <= room; i++) {
					WebElement adultelement = QaBrowser.driver
							.findElement(By.xpath("//select[@id='htlsltadult" + i + "']"));
					Select selectadult = new Select(adultelement);
					selectadult.selectByVisibleText(adultcount[i - 1]);
					Thread.sleep(2000);

					WebElement childelement = QaBrowser.driver
							.findElement(By.xpath("//select[@id='HtlChildSlt" + i + "']"));
					Select selectchild = new Select(childelement);
					selectchild.selectByValue(childcount[i - 1]);
					Thread.sleep(2000);
				}

				String[] ageofchild = ChildAge.split(",");
				for (String chd : childcount) {
					int chdcount = Integer.parseInt(chd);
					for (int i = 1; i <= chdcount; i++) {
						String ac = ageofchild[i - 1];
						int ac1 = Integer.parseInt(ac);

						if (ac1 > 17) {
							QaExtentReport.test.log(Status.FAIL,
									"<b><i>Invalid Child Age Selection</i></b>" + " : " + ac1);
							throw new Exception("Invalid Child Age Selection" + " : " + ac1);
						} else {
							WebElement childrenage = QaBrowser.driver
									.findElement(By.xpath("//select[@id='htl" + chdcount + "child" + i + "age']"));
							Select selectage = new Select(childrenage);
							selectage.selectByValue(ageofchild[i - 1]);
							Thread.sleep(2000);
						}
					}
				}
			}
		}

		QaRobot.selectTextFromDropdown("FOPType", FOPType, "<b><i>Select FOP</i></b>" + "  " + FOPType);
		Thread.sleep(2000);

		QaRobot.ClickOnElement("SelectAllHotel");

		List<WebElement> listOfSupplier = QaBrowser.driver
				.findElements(By.xpath("//div[@id='divSuppliers']/div/label"));

		for (WebElement autoSupplier : listOfSupplier) {
			if (autoSupplier.getText().equalsIgnoreCase(Supplier)) {
				autoSupplier.click();
				break;
			} else {

			}
		}
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Supplier</i></b>" + " " + Supplier);

		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchH");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
			QaRobot.ScreenshotMethod("HotelTrip", "<b><i>Screenshot for Hotel Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void InsuranceTriptype(String TravellerType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String StartDate, String EndDate, String PolicyFor,
			String SelectPax, String PaxDOB, String FOPType) throws Exception {
		String DateSelection[] = StartDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = EndDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		String DateSelection2[] = PaxDOB.split("-");
		String Year = DateSelection2[2];
		String Month = DateSelection2[1];
		String Day = DateSelection2[0];

		Assert.assertFalse(OriginCityCode == DestinationCityCode, "Origin And Destination City Code Can't Be Same");
		Assert.assertFalse(OriginLocation == DestinationLocation, "Origin And Destination City Location Can't Be Same");

		TestBase.listofautosuggestion(By.xpath("//div[@id='divIDepartureCity']/p"), OriginCityCode, OriginLocation,
				By.xpath("//input[@id='txtINSDepartureCity']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>Origin city : </i></b>" + OriginCityCode + " - " + OriginLocation);
		Thread.sleep(2000);

		TestBase.listofautosuggestion(By.xpath("//div[@id='divIDestinationCity']/p"), DestinationCityCode,
				DestinationLocation, By.xpath("//input[@id='txtINSDestinationCity']"));
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Destination city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/label/span[2]/div/span[1]/img"))
				.click();
		Thread.sleep(2000);

		selectDateInCalendarInsurance(expDate, month, year, expDate1, month1, year1);

		if (TravellerType.equalsIgnoreCase("Individual")) {
		} else {
			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='policyfor']"));
			Select s = new Select(element);
			s.selectByVisibleText(PolicyFor);
			QaExtentReport.test.log(Status.INFO, "<b><i>Select Policy for</i></b>" + " - " + PolicyFor);
			Thread.sleep(2000);
		}

		if (TravellerType.equalsIgnoreCase("Individual")) {
		} else {
			if (PolicyFor.equalsIgnoreCase("Individual") || PolicyFor.equalsIgnoreCase("Family")) {
				Assert.assertFalse(Integer.parseInt(SelectPax) > 9, "Invalid Pax Selected " + "-" + SelectPax);

				WebElement PaxNo = QaBrowser.driver.findElement(By.xpath("//select[@id='pax']"));
				Select s = new Select(PaxNo);
				s.selectByVisibleText(SelectPax);

				for (int i = 2; i <= Integer.parseInt(SelectPax); i++) {
					QaBrowser.driver.findElement(By.xpath("//img[@id='imgDOB" + i + "']")).click();
					Thread.sleep(2000);

					selectDateInCalendarPassenger(Day, Month, Year);
				}
			} else if (PolicyFor.equalsIgnoreCase("Couple")) {
				Assert.assertFalse(Integer.parseInt(SelectPax) > 2, "Invalid Pax Selected " + "-" + SelectPax);

				QaBrowser.driver.findElement(By.xpath("//img[@id='imgDOB2']")).click();
				Thread.sleep(2000);

				selectDateInCalendarPassenger(Day, Month, Year);
			}
		}
		Thread.sleep(3000);

		WebElement FOP = QaBrowser.driver.findElement(By.xpath("//select[@id='ddlSearchFopINS']"));
		Select s1 = new Select(FOP);
		s1.selectByVisibleText(FOPType);

		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("SearchInsurance");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void flight_HotelTrip(String Trip, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String Rooms, String Adult, String Child, String ChildAge, String Infant, String InfantAge,
			String MoreOptions, String Nationality, String Currency, String Class, String ShowDirectFlight,
			String MyHotelDiffenrentDate, String ChangeCheckIn, String ChangeCheckOut) throws Exception {
		TestBase.listofautosuggestion(By.xpath("//div[@id='div3']/p"), OriginCityCode, OriginLocation,
				By.xpath("//input[@id='txtFlightFromDynamic']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
		Thread.sleep(2000);

		TestBase.listofautosuggestion(By.xpath("//div[@id='div7']/p"), DestinationCityCode, DestinationLocation,
				By.xpath("//input[@id='txtFlightToDynamic']"));
		QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[11]")).click();
		Thread.sleep(2000);

		String DateSelection[] = DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		selectDateInCalendarFlight_Hotel(expDate, month, year, expDate1, month1, year1);

		int room = Integer.parseInt(Rooms);
		String[] adultcount = Adult.split(",");
		String[] childcount = Child.split(",");
		String[] infantcount = Infant.split(",");

		if (room > 5) {
			throw new Exception("Invalid Number of Rooms provided " + " : " + room);
		} else {
			for (int i = 1; i < room; i++) {
				QaRobot.ClickOnElement("AddRoomFH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add Room</i></b>");
			}

			for (int i = 1; i <= room; i++) {
				WebElement adultelement = QaBrowser.driver
						.findElement(By.xpath("//select[@id='Htl_fltSltAdult" + i + "']"));
				Select selectadult = new Select(adultelement);
				selectadult.selectByValue(adultcount[i - 1]);
				Thread.sleep(2000);

				WebElement childelement = QaBrowser.driver
						.findElement(By.xpath("//select[@id='Htl_fltChildSlt" + i + "']"));
				Select selectchild = new Select(childelement);
				selectchild.selectByValue(childcount[i - 1]);
				Thread.sleep(2000);

				WebElement infantelement = QaBrowser.driver
						.findElement(By.xpath("//select[@id='Htl_fltInfantSlt" + i + "']"));
				Select selectinfant = new Select(infantelement);
				selectinfant.selectByValue(infantcount[i - 1]);
				Thread.sleep(2000);
			}

			String[] ageofchild = ChildAge.split(",");
			for (String chd : childcount) {
				int chdcount = Integer.parseInt(chd);
				for (int i = 1; i <= chdcount; i++) {
					String ac = ageofchild[i - 1];
					int ac1 = Integer.parseInt(ac);

					if (ac1 > 17) {
						QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>" + " : " + ac1);
						throw new Exception("Invalid Child Age Selection" + " : " + ac1);
					} else {
						WebElement childrenage = QaBrowser.driver
								.findElement(By.xpath("//select[@id='Htl_fltChildAge" + chdcount + "_" + i + "']"));
						Select selectage = new Select(childrenage);
						selectage.selectByValue(ageofchild[i - 1]);
						Thread.sleep(2000);
					}
				}
			}

			String[] ageofinfant = InfantAge.split(",");
			for (String ift : infantcount) {
				int iftcount = Integer.parseInt(ift);
				for (int i = 1; i <= iftcount; i++) {
					String ai = ageofinfant[i - 1];
					int ai1 = Integer.parseInt(ai);

					if (ai1 > 2) {
						QaExtentReport.test.log(Status.FAIL,
								"<b><i>Invalid Infant Age Selection</i></b>" + " : " + ai1);
						throw new Exception("Invalid Infant Age Selection" + " : " + ai1);
					} else {
						WebElement infantrenage = QaBrowser.driver
								.findElement(By.xpath("//select[@id='Htl_fltInfantAge" + iftcount + "_" + i + "']"));
						Select selectage = new Select(infantrenage);
						selectage.selectByValue(ageofinfant[i - 1]);
						Thread.sleep(2000);
					}

				}
			}
		}

		if (MoreOptions.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MoreOptionsFH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on More Options</i></b>");
			Thread.sleep(2000);

			QaRobot.selectTextFromDropdown("NationalityFH", Nationality, "<b><i>Select Nationality</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("CurrencyFH", Currency, "<b><i>Select Currency for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectTextByLocator("//select[@id='dynamic_class']", Class,
					"<b><i>Select Class for booking</i></b>");
			Thread.sleep(2000);
		}

		if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("ShowDirectFlightsOnly");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Show Direct Flights Only</i></b>");
		}

		if (MyHotelDiffenrentDate.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MyHotelCheckin");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on My Hotel Check In</i></b>");

			String DateSelection2[] = ChangeCheckIn.split("-");
			String year2 = DateSelection2[2];
			String month2 = DateSelection2[1];
			String expDate2 = DateSelection2[0];

			String DateSelection3[] = ChangeCheckOut.split("-");
			String year3 = DateSelection3[2];
			String month3 = DateSelection3[1];
			String expDate3 = DateSelection3[0];

			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[13]")).click();
			Thread.sleep(2000);

			selectDateInCalendarFlight_Hotel1(expDate2, month2, year2, expDate3, month3, year3);
		}

		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchFH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Final Search</i></b>");
			QaRobot.ScreenshotMethod("Flight_HotelTrip", "<b><i>Screenshot for Flight+Hotel Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

		String currentMonthNumber = "00";
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

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);

//		if(Integer.parseInt(Day)>31)
//		{
//			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
//			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
//			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
//		}

		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);

//		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
//		{
//			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
//			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
//			throw new Exception("Invalid date provided "+Day+"/"+Month+"/"+Year);
//		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);

//		if(date2.before(date1))
//		{
//			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
//			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
//			throw new Exception("Invalid date provided "+Day+"-"+Month+"-"+Year);
//		}
//		else
//		{
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
//		}
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

		String currentMonthNumber = "00";
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

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);

		String currentMonthNumber1 = "00";
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

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
//		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}

//			QaBrowser.driver.findElement(By.xpath("//div[@id='divReturnDate']/div/div[1]/label/span[2]/a/img")).click();
		Thread.sleep(2000);

		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();

			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}

	public static void selectDateInCalendarHotel(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

		String currentMonthNumber = "00";
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

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);

		String currentMonthNumber1 = "00";
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

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
//		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		Thread.sleep(2000);
//				System.out.println(monthYear1);
		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();

			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}

	public static void selectDateInCalendarInsurance(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("January")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("February")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("March")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("April")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("June")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("July")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("August")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("September")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("October")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("November")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("December")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("January")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("February")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("March")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("April")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("June")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("July")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("August")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("September")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("October")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("November")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("December")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
//		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Start Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select End Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}

		QaBrowser.driver.findElement(By.xpath("//div[@id='divINSReturnDate']/div/span/div/span[1]/img")).click();
		Thread.sleep(2000);

		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();

			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}

	public static void selectDateInCalendarPassenger(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
//		System.out.println(date1);

		String currentMonthNumber = "00";
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

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
//		System.out.println(date2);
		LocalDate date3 = LocalDate.of(Integer.parseInt(Year), Integer.parseInt(currentMonthNumber),
				Integer.parseInt(Day));
		LocalDate today = LocalDate.now();

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertTrue(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertTrue(date3.isBefore(today.minusYears(1)),
				"Invalid date provided " + Day + "-" + Month + "-" + Year);

		WebElement SelectMonth = QaBrowser.driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[1]"));
		Select M = new Select(SelectMonth);
		M.selectByVisibleText(Month);

		WebElement SelectYear = QaBrowser.driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[2]"));
		Select Y = new Select(SelectYear);
		Y.selectByVisibleText(Year);

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
	}

	public static void selectDateInCalendarFlight_Hotel(String Day, String Month, String Year, String Day1,
			String Month1, String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
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

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
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

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartDateDomesticHpF']")).clear();

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}

		QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[12]")).click();
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnDateDomesticHpF']")).clear();

		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();

			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();

			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}

	public static void selectDateInCalendarFlight_Hotel1(String Day, String Month, String Year, String Day1,
			String Month1, String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
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

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
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

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartDateInternationalHpF']")).clear();

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];

		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();

			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}

		QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[14]")).click();
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnDateInternationalHpF']")).clear();

		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];

		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();

			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();

			month1 = monthYear1.split(" ")[0];
			year1 = monthYear1.split(" ")[1];
		}

		List<WebElement> allDates1 = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));

		for (WebElement ele1 : allDates1) {
			String dt1 = ele1.getText();

			if (dt1.equalsIgnoreCase(Day1)) {
				ele1.click();
				break;
			}
		}
	}
}
