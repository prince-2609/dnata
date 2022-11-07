package dnata;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class DnataCheckoutPage 
{
	public static void individualforFlight(String TravellerType,String TripType,String adult,String child,String infant,String ModifySearch,String adultM,String childM,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		if(TravellerType.equalsIgnoreCase("Individual"))
		{
			QaExtentReport.extentScreenshot("Checkout Page");
			
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,300)", "");
			
			WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[7]/div[3]/div[10]/ul/li[1]/a"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", MoreDetails);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("MoreDetails");
			
			WebElement MoreDetailsClose = QaBrowser.driver.findElement(By.xpath("//body[@id='ctl00_btnMstr']/div/div/div/a"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", MoreDetailsClose);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details Close</i></b>");
			Thread.sleep(5000);
			
			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[7]/div[3]/div[10]/ul/li[2]/a"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup</i></b>");
			Thread.sleep(2000);
			
			WebElement CustomerCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[1]/a"));
			JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
			js5.executeScript("arguments[0].click()", CustomerCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Customer Cost</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CustomerCost");
			
			WebElement CompanyCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[2]/a"));
			JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
			js6.executeScript("arguments[0].click()", CompanyCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Company Cost</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CompanyCost");
			
			WebElement FareBreakupClose = QaBrowser.driver.findElement(By.xpath("//div[@id='DivfarebrekupIN']/div/div/div[1]/button"));
			JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
			js7.executeScript("arguments[0].click()", FareBreakupClose);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup Close</i></b>");
			Thread.sleep(5000);
			
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement element1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s1 = new Select(element1);
			s1.selectByIndex(1);
			
			WebElement element2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s2 = new Select(element2);
			s2.selectByIndex(1);
			
//			WebElement element3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s3 = new Select(element3);
//			s3.selectByIndex(1);
			
			WebElement element4 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s4 = new Select(element4);
			s4.selectByIndex(1);
			
			WebElement element5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s5 = new Select(element5);
			s5.selectByIndex(1);
			
			WebElement element6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s6 = new Select(element6);
			s6.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			bookForFlight(TripType,ModifySearch,QuoteTitle,QuoteRemark,Checkoutpagestep);
		}
		else if (TravellerType.equalsIgnoreCase("Dependent"))
		{
			CheckoutForFlightDependent(TripType,adult,child,infant,ModifySearch,adultM,childM,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
		}
	}
	
	public static void CheckoutForFlightDependent(String TripType,String adult, String child, String infant,String ModifySearch,String adultM,String childM,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception 
	{
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		
		QaRobot.ClickOnElement("dept_AssociatePax");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate pax</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Associate Pax");
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) 
		{
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		Thread.sleep(1000);

		WebElement FFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='DDLtravellerFFNumber']"));
		Select select = new Select(FFNumber);                                  
		select.selectByIndex(1);
		
		WebElement DocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltravellerDocNumber']"));
		Select select1 = new Select(DocumentNo);                                  
		select1.selectByIndex(1);
		
		if(ModifySearch.equalsIgnoreCase("Yes"))
		{
			String[] adtcount1 = adultM.split(",");
			int adultsum1 = 0;
			for (String adt1 : adtcount1) {
				int a1 = Integer.parseInt(adt1);
				adultsum1 = adultsum1 + a1;
			}
			String adtsum1 = String.valueOf(adultsum1);
			
			String[] chdcount1 = childM.split(",");
			int childsum1 = 0;
			for (String chd1 : chdcount1) {
				int a1 = Integer.parseInt(chd1);
				childsum1 = childsum1 + a1;
			}
			String chdsum1 = String.valueOf(childsum1);
			
			selectDependentPax(adtsum1, chdsum1, infant);
			
			QaRobot.ClickOnElement("dept_AddToList");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list button</i></b>");

			selectDependentPriority(adtsum1, chdsum1, infant);
		}
		else
		{
			String[] adtcount = adult.split(",");
			int adultsum = 0;
			for (String adt : adtcount) {
				int a = Integer.parseInt(adt);
				adultsum = adultsum + a;
			}
			String adtsum = String.valueOf(adultsum);
			
			String[] chdcount = child.split(",");
			int childsum = 0;
			for (String chd : chdcount) {
				int a = Integer.parseInt(chd);
				childsum = childsum + a;
			}
			String chdsum = String.valueOf(childsum);
			
			selectDependentPax(adtsum, chdsum, infant);
			
			QaRobot.ClickOnElement("dept_AddToList");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list button</i></b>");

			selectDependentPriority(adtsum, chdsum, infant);
		}
		
		QaRobot.ClickOnElement("dept_AssociateButton");
		QaExtentReport.test.log(Status.INFO, "<b><i>clicked on Associate button</i></b>");
		Thread.sleep(3000);
		
		QaBrowser.driver.switchTo().window(ParentWindow);
		
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		
		if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
		{
			QaRobot.switchframe("//frame[@id='frm2']");
		}
		QaExtentReport.extentScreenshot("Checkout Page");
		
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
		mo.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		
		WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[7]/div[3]/div[10]/ul/li[1]/a"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", MoreDetails);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("MoreDetails");
		
		WebElement MoreDetailsClose = QaBrowser.driver.findElement(By.xpath("//body[@id='ctl00_btnMstr']/div/div/div/a"));
		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
		js4.executeScript("arguments[0].click()", MoreDetailsClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details Close</i></b>");
		Thread.sleep(5000);
		
		WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[7]/div[3]/div[10]/ul/li[2]/a"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", FareBreakup);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup</i></b>");
		Thread.sleep(2000);
		
		WebElement CustomerCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[1]/a"));
		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", CustomerCost);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Customer Cost</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("CustomerCost");
		
		WebElement CompanyCost = QaBrowser.driver.findElement(By.xpath("//ul[@id='DivINSfareBreakup']/li[2]/a"));
		JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
		js6.executeScript("arguments[0].click()", CompanyCost);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Company Cost</i></b>");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("CompanyCost");
		
		WebElement FareBreakupClose = QaBrowser.driver.findElement(By.xpath("//div[@id='DivfarebrekupIN']/div/div/div[1]/button"));
		JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
		js7.executeScript("arguments[0].click()", FareBreakupClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup Close</i></b>");
		Thread.sleep(5000);
		
		bookForFlightDependent(TripType,infant,ModifySearch,QuoteTitle,QuoteRemark,Checkoutpagestep);
	}
	
	public static void CheckoutForHotelDependent(String adult, String child,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception 
	{
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		
//		if(QaBrowser.driver.findElement(By.xpath("//div/span/span[contains(text(),'The hotel you have selected is no more available now!!  Kindly try another hotel room.')]")).isDisplayed())
//		{
//			QaExtentReport.test.log(Status.FAIL, "<b><i>The hotel you have selected is no more available now!!  Kindly try another hotel room.</i></b>");
//			throw new DnataExceptionClass("The hotel you have selected is no more available now!!  Kindly try another hotel room.");
//		}
//		else
//		{
			QaRobot.ClickOnElement("dept_AssociatePax");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Associate pax</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Associate Pax");
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) 
			{
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			Thread.sleep(1000);

			WebElement FFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='DDLtravellerFFNumber']"));
			Select select = new Select(FFNumber);                                  
			select.selectByIndex(1);
			
			WebElement DocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='ddltravellerDocNumber']"));
			Select select1 = new Select(DocumentNo);                                  
			select1.selectByIndex(1);
			
			String[] adtcount = adult.split(",");
			int adultsum = 0;
			for (String adt : adtcount) {
				int a = Integer.parseInt(adt);
				adultsum = adultsum + a;
			}
			String adtsum = String.valueOf(adultsum);
			// total of child
			String[] chdcount = child.split(",");
			int childsum = 0;
			for (String chd : chdcount) {
				int a = Integer.parseInt(chd);
				childsum = childsum + a;
			}
			String chdsum = String.valueOf(childsum);
			
			selectDependentPaxHotel(adtsum, chdsum);
			
			QaRobot.ClickOnElement("dept_AddToList");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on add to list button</i></b>");

			selectDependentPriorityHotel(adtsum,chdsum);
			
			QaRobot.ClickOnElement("dept_AssociateButton");
			QaExtentReport.test.log(Status.INFO, "<b><i>clicked on Associate button</i></b>");
			Thread.sleep(3000);
			
			QaBrowser.driver.switchTo().window(ParentWindow);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			
			if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
			{
				QaRobot.switchframe("//frame[@id='frm2']");
			}
			
			QaExtentReport.extentScreenshot("Checkout Page");
			
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);
			
			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[7]/div[4]/ul/li/a"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup</i></b>");
			Thread.sleep(3000);
			
			WebElement CustomerCost = QaBrowser.driver.findElement(By.xpath("//li[@id='liCustomer']/a"));
			JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
			js5.executeScript("arguments[0].click()", CustomerCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Customer Cost</i></b>");
			QaExtentReport.extentScreenshot("CustomerCost");
			
			WebElement CompanyCost = QaBrowser.driver.findElement(By.xpath("//li[@id='liCompany']/a"));
			JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
			js6.executeScript("arguments[0].click()", CompanyCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Company Cost</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CompanyCost");
			
			WebElement FareBreakupClose = QaBrowser.driver.findElement(By.xpath("//body[@id='ctl00_btnMstr']/div/div/div/a"));
			JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
			js7.executeScript("arguments[0].click()", FareBreakupClose);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup Close</i></b>");
			Thread.sleep(5000);
			
			bookForHotelDependent(Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
//		}
		
	}
	
	public static void selectDependentPax(String adult, String child, String infant) 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		int inf = Integer.parseInt(infant);
		
		for (int i = 1; i < adt; i++) 
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_chk']")).click();
			WebElement AFFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_DDLFFNumber']"));
			Select select = new Select(AFFNumber);                                  
			select.selectByIndex(1);
			
			WebElement ADocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_ddlDocNumber']"));
			Select select1 = new Select(ADocumentNo);                                  
			select1.selectByIndex(1);
		}                         
		
		for (int i = 1; i <= chd; i++) 
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_chk']")).click();
			WebElement CFFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_DDLFFNumber']"));
			Select select = new Select(CFFNumber);                                  
			select.selectByIndex(1);
			
			WebElement CDocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_ddlDocNumber']"));
			Select select1 = new Select(CDocumentNo);                                  
			select1.selectByIndex(1);
		}
		
		for (int i = 1; i <= inf; i++) 
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl03_rptDetails_ctl0" + i + "_chk']")).click();
//			WebElement CFFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl03_rptDetails_ctl0" + i + "_DDLFFNumber']"));
//			Select select = new Select(CFFNumber);                                  
//			select.selectByIndex(1);
			
			WebElement CDocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl03_rptDetails_ctl0" + i + "_ddlDocNumber']"));
			Select select1 = new Select(CDocumentNo);                                  
			select1.selectByIndex(1);
		}
	}

	public static void selectDependentPaxHotel(String adult, String child) 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		
		for (int i = 1; i < adt; i++) 
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_chk']")).click();
//			WebElement AFFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_DDLFFNumber']"));
//			Select select = new Select(AFFNumber);                                  
//			select.selectByIndex(1);
			
			WebElement ADocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl01_rptDetails_ctl0" + i + "_ddlDocNumber']"));
			Select select1 = new Select(ADocumentNo);                                  
			select1.selectByIndex(1);
		}                         
		
		for (int i = 1; i <= chd; i++) 
		{
			QaBrowser.driver.findElement(By.xpath("//input[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_chk']")).click();
//			WebElement CFFNumber = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_DDLFFNumber']"));
//			Select select = new Select(CFFNumber);                                  
//			select.selectByIndex(1);
			
			WebElement CDocumentNo = QaBrowser.driver.findElement(By.xpath("//select[@id='rptPaxDetails_ctl02_rptDetails_ctl0" + i + "_ddlDocNumber']"));
			Select select1 = new Select(CDocumentNo);                                  
			select1.selectByIndex(1);
		}
	}
	
	public static void selectDependentPriority(String adult, String child, String infant) 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		int inf = Integer.parseInt(infant);
		for (int i = 1; i <= adt; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl01_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);                                     
			select.selectByIndex(i);
		}
		
		for (int i = 1; i <= chd; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl02_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);
		}
		
		for (int i = 1; i <= inf; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl03_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);
		}
	}
	
	public static void selectDependentPriorityHotel(String adult, String child) 
	{
		int adt = Integer.parseInt(adult);
		int chd = Integer.parseInt(child);
		
		for (int i = 1; i <= adt; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl01_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);                                     
			select.selectByIndex(i);
		}
		
		for (int i = 1; i <= chd; i++) 
		{
			WebElement webelement = QaBrowser.driver.findElement(By.xpath("//select[@id='rptSelectionList_ctl02_rptSelection_ctl0" + i + "_ddlPriority']"));
			Select select = new Select(webelement);
			select.selectByIndex(i);
		}
	}
	
	public static void bookForFlight(String TripType,String ModifySearch,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		if(Checkoutpagestep.equalsIgnoreCase("Quote"))
		{
			QaRobot.ClickOnElement("QuoteF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Quote Button</i></b>");
			Thread.sleep(4000);
			
			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) 
			{
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}
			
			QaRobot.switchframe("//iframe[@id='iframeQuoteAIR']");
			
			QaRobot.PassValue("QuotationTitle",QuoteTitle);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
			QaExtentReport.extentScreenshot("Quotation");
			
			QaRobot.PassValue("RemarkTitle",QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
			
			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
			Thread.sleep(7000);
			
			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[]= alertMessage.split(" ");
			String number = getTxt1[8];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
			QaBrowser.driver.switchTo().alert().accept();
			
			QaBrowser.driver.switchTo().defaultContent();
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			
			QaRobot.ClickOnElement("Bookings");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
			
			QaRobot.ClickOnElement("BookingQueues");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.switchframe("//frame[@id='toolHeader']");
			
			QaRobot.ClickOnElement("CorporateQueue");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);
			
			QaRobot.PassValue("EnterEnquiryId",number);
			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
			
			QaRobot.ClickOnElement("SearchEnquiryId");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");
			
			QaRobot.ClickOnElement("EnquiryView");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
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
			Thread.sleep(5000);
			
			QaBrowser.driver.switchTo().window(ParentWindow7);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("ApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(15000);
			
			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) 
			{
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(3000);
			
			QaRobot.ClickOnElement("SelectItinerary");
			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
			
			QaExtentReport.extentScreenshot("Itinerary View");
			
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");
			
			QaRobot.ClickOnElement("FinalApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
			
			QaRobot.PassValue("TextArea","Ok");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
			
			QaRobot.ClickOnElement("OKButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("FinalBookButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(13000);
			
			if(ModifySearch.equalsIgnoreCase("No"))
			{
				if(TripType.equalsIgnoreCase("OneWay"))
					{
					if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
							+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
					{
//					if(TripType.equalsIgnoreCase("OneWay"))
//					{
						List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
						
						for (WebElement autoAirline : listOfAirline) 
						  {
							if (autoAirline.getText().equalsIgnoreCase("GULF AIR")) 
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
						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
						Thread.sleep(8000);
					}
					}
			}
			else if(ModifySearch.equalsIgnoreCase("Yes"))
			{
				if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
						+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
				{
//				if(TripType.equalsIgnoreCase("OneWay"))
//				{
					List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
					
					for (WebElement autoAirline : listOfAirline) 
					  {
						if (autoAirline.getText().equalsIgnoreCase("GULF AIR")) 
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
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
					Thread.sleep(8000);
				}
			}
			
			QaRobot.PassValue("DestinationPhoeF","9863647257");
			
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForFlight();
			
			DnataConfirmPage.confirmpageFlight();
		}
		else if (Checkoutpagestep.equalsIgnoreCase("BookAndQuote"))
		{
			QaRobot.PassValue("DestinationPhoeF","9863647257");
			
			QaRobot.ClickOnElement("BookAndQuoteF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on BookAndQuote Button</i></b>");
			Thread.sleep(8000);
			
			DnataConfirmPage.confirmpageFlightwithBookingQueue();
		}
		else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment"))
		{
			QaRobot.PassValue("DestinationPhoeF","9863647257");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForFlight();
			
			DnataConfirmPage.confirmpageFlight();
		}
	}
	
	public static void bookForFlightDependent(String TripType,String infant,String ModifySearch,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		if(Checkoutpagestep.equalsIgnoreCase("Quote"))
		{
			QaRobot.ClickOnElement("QuoteF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Quote Button</i></b>");
			Thread.sleep(4000);
			
			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) 
			{
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}
			
			QaRobot.switchframe("//iframe[@id='iframeQuoteAIR']");
			
			QaRobot.PassValue("QuotationTitle",QuoteTitle);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
			QaExtentReport.extentScreenshot("Quotation");
			
			QaRobot.PassValue("RemarkTitle",QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
			
			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendAIREnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
			Thread.sleep(7000);
			
			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[]= alertMessage.split(" ");
			String number = getTxt1[8];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
			QaBrowser.driver.switchTo().alert().accept();
			
			QaBrowser.driver.switchTo().defaultContent();
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			
			QaRobot.ClickOnElement("Bookings");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
			
			QaRobot.ClickOnElement("BookingQueues");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.switchframe("//frame[@id='toolHeader']");
			
			QaRobot.ClickOnElement("CorporateQueue");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);
			
			QaRobot.PassValue("EnterEnquiryId",number);
			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
			
			QaRobot.ClickOnElement("SearchEnquiryId");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");
			
			QaRobot.ClickOnElement("EnquiryView");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
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
			
			QaBrowser.driver.switchTo().window(ParentWindow7);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("ApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(15000);
			
			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) 
			{
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SelectItinerary");
			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
			
			QaExtentReport.extentScreenshot("Itinerary View");
			
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");
			
			QaRobot.ClickOnElement("FinalApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
			
			QaRobot.PassValue("TextArea","Ok");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
			
			QaRobot.ClickOnElement("OKButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("FinalBookButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(20000);
			
			if(ModifySearch.equalsIgnoreCase("No"))
			{
				if(TripType.equalsIgnoreCase("OneWay"))
					{
					if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
							+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
					{
//					if(TripType.equalsIgnoreCase("OneWay"))
//					{
						List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
						
						for (WebElement autoAirline : listOfAirline) 
						  {
							if (autoAirline.getText().equalsIgnoreCase("GULF AIR")) 
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
						QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
						Thread.sleep(8000);
					}
					}
			}
			else if(ModifySearch.equalsIgnoreCase("Yes"))
			{
				if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'                            The fare that you have selected "
						+ "is no longer available. Please choose from below options to continue')]")).isDisplayed()) 
				{
//				if(TripType.equalsIgnoreCase("OneWay"))
//				{
					List<WebElement> listOfAirline = QaBrowser.driver.findElements(By.xpath("/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div[1]/div/div[3]/div[10]/div[2]/div/ul/li/label/span"));
					
					for (WebElement autoAirline : listOfAirline) 
					  {
						if (autoAirline.getText().equalsIgnoreCase("GULF AIR")) 
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
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book Now</i></b>");
					Thread.sleep(8000);
				}
			}
			
			QaRobot.PassValue("DestinationPhoeF","9863647257");
			
			int inf = Integer.parseInt(infant);
			for (int i = 1; i <= inf; i++) 
			{
				WebElement webelement = QaBrowser.driver.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
				Select sel = new Select(webelement);                              
				sel.selectByIndex(i);
			}
			
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForFlight();
			
			DnataConfirmPage.confirmpageFlight();
		}
		else if (Checkoutpagestep.equalsIgnoreCase("BookAndQuote"))
		{
			QaRobot.PassValue("DestinationPhoeF","9863647257");
			
			int inf = Integer.parseInt(infant);
			for (int i = 1; i <= inf; i++) 
			{
				WebElement webelement = QaBrowser.driver.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
				Select sel = new Select(webelement);                              
				sel.selectByIndex(i);
			}
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			QaRobot.ClickOnElement("BookAndQuoteF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on BookAndQuote Button</i></b>");
			Thread.sleep(8000);
			
			DnataConfirmPage.confirmpageFlightwithBookingQueue();
		}
		else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment"))
		{
			QaRobot.PassValue("DestinationPhoeF","9863647257");
			
			int inf = Integer.parseInt(infant);
			for (int i = 1; i <= inf; i++) 
			{
				WebElement webelement = QaBrowser.driver.findElement(By.xpath("(//select[@id='ctl00_contentMain_ddl_travell_with'])[" + i + "]"));
				Select sel = new Select(webelement);                              
				sel.selectByIndex(i);
			}

//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDL']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDL']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDL']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
//			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture84']"));
//			Select s33 = new Select(ele3);
//			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForFlight();
			
			DnataConfirmPage.confirmpageFlight();
		}
	}
	
	public static void individualforHotel(String TravellerType,String Adult,String Child,String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		if(TravellerType.equalsIgnoreCase("Individual"))
		{
			QaExtentReport.extentScreenshot("Checkout Page");
			
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,300)", "");
			
			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[7]/div[4]/ul/li/a"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup</i></b>");
			Thread.sleep(3000);
			
			WebElement CustomerCost = QaBrowser.driver.findElement(By.xpath("//li[@id='liCustomer']/a"));
			JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
			js5.executeScript("arguments[0].click()", CustomerCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Customer Cost</i></b>");
			QaExtentReport.extentScreenshot("CustomerCost");
			
			WebElement CompanyCost = QaBrowser.driver.findElement(By.xpath("//li[@id='liCompany']/a"));
			JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
			js6.executeScript("arguments[0].click()", CompanyCost);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Company Cost</i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("CompanyCost");
			
			WebElement FareBreakupClose = QaBrowser.driver.findElement(By.xpath("//body[@id='ctl00_btnMstr']/div/div/div/a"));
			JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
			js7.executeScript("arguments[0].click()", FareBreakupClose);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Fare Breakup Close</i></b>");
			Thread.sleep(5000);
			
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLH']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDLH']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDLH']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture85']"));
			Select s33 = new Select(ele3);
			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			bookForHotel(Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
		}
		else if (TravellerType.equalsIgnoreCase("Dependent"))
		{
			CheckoutForHotelDependent(Adult,Child,Resultpagestep,QuoteTitle,QuoteRemark,Checkoutpagestep);
		}
	}
	
	public static void bookForHotel(String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		if(Checkoutpagestep.equalsIgnoreCase("Quote"))
		{
			QaRobot.ClickOnElement("QuoteH");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Quote Button</i></b>");
			Thread.sleep(4000);
			
			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) 
			{
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}
			
			QaRobot.switchframe("//iframe[@id='iframeQuoteHHL']");
			
			QaRobot.PassValue("QuotationTitle",QuoteTitle);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
			QaExtentReport.extentScreenshot("Quotation");
			
			QaRobot.PassValue("RemarkTitle",QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
			
			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("(//a[@id='lnksendHHLEnqFromCorp'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
			Thread.sleep(10000);
			
			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[]= alertMessage.split(" ");
			String number = getTxt1[10];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
			QaBrowser.driver.switchTo().alert().accept();
			
			QaBrowser.driver.switchTo().defaultContent();
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			
			QaRobot.ClickOnElement("Bookings");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
			
			QaRobot.ClickOnElement("BookingQueues");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.switchframe("//frame[@id='toolHeader']");
			
			QaRobot.ClickOnElement("CorporateQueue");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);
			
			QaRobot.PassValue("EnterEnquiryId",number);
			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
			
			QaRobot.ClickOnElement("SearchEnquiryId");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");
			
			QaRobot.ClickOnElement("EnquiryView");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
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
			
			QaBrowser.driver.switchTo().window(ParentWindow7);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("ApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(13000);
			
			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) 
			{
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(5000);
			
			QaRobot.ClickOnElement("SelectItineraryH");
			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
			
			QaExtentReport.extentScreenshot("Itinerary View");
			
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");
			
			QaRobot.ClickOnElement("FinalApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
			
			QaRobot.PassValue("TextArea","Ok");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
			
			QaRobot.ClickOnElement("OKButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
			Thread.sleep(13000);
			
			QaBrowser.driver.switchTo().window(ParentWindow8);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("FinalBookButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(15000);
			
			if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Selected hotel room is no longer available or the "
					+ "hotel price has changed. You may select a different hotel room type and send another quote.')]"))
					.isDisplayed()) 
			{
				QaRobot.ClickOnElement("SelectRoom");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SelectRoom</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("BookH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(6000);
			}
			
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLH']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDLH']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDLH']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture85']"));
			Select s33 = new Select(ele3);
			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForHotel();
			
			DnataConfirmPage.confirmpageHotel();
		}
		
		else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment"))
		{
			QaRobot.ClickOnElement("FulfilmentH");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(5000);
			
			DnataPaymentPage.individualForHotel();
			
			if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
			{
				DnataConfirmPage.confirmpageHotel();
			}
			else
			{
				DnataConfirmPage.confirmpageFulfilmentHotel();
			}
		}
	}
	
	public static void bookForHotelDependent(String Resultpagestep,String QuoteTitle,String QuoteRemark,String Checkoutpagestep) throws Exception
	{
		if(Checkoutpagestep.equalsIgnoreCase("Quote"))
		{
			QaRobot.ClickOnElement("QuoteH");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Quote Button</i></b>");
			Thread.sleep(4000);
			
			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) 
			{
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}
			
			QaRobot.switchframe("//iframe[@id='iframeQuoteHHL']");
			
			QaRobot.PassValue("QuotationTitle",QuoteTitle);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Quotation Title</i></b>");
			QaExtentReport.extentScreenshot("Quotation");
			
			QaRobot.PassValue("RemarkTitle",QuoteRemark);
			QaExtentReport.test.log(Status.INFO, "<b><i>Pass Remark Title</i></b>");
			
			WebElement SendQuote = QaBrowser.driver.findElement(By.xpath("//a[@id='lnksendHHLEnqFromCorp']"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", SendQuote);
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Send Quote</i></b>");
			Thread.sleep(7000);
			
			String alertMessage = QaBrowser.driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			String getTxt1[]= alertMessage.split(" ");
			String number = getTxt1[10];
			System.out.println(number);
			QaExtentReport.test.log(Status.INFO, "<b><i>Enquiry id is </i></b>"+number);
			QaBrowser.driver.switchTo().alert().accept();
			
			QaBrowser.driver.switchTo().defaultContent();
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='leftbar']");
			
			QaRobot.ClickOnElement("Bookings");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Bookings</i></b>");
			
			QaRobot.ClickOnElement("BookingQueues");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Booking Queues</i></b>");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@name='main']");
			
			QaRobot.switchframe("//frame[@id='toolHeader']");
			
			QaRobot.ClickOnElement("CorporateQueue");
			
			QaBrowser.driver.switchTo().parentFrame();
			
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("EnquiryQueue");
			Thread.sleep(3000);
			
			QaRobot.PassValue("EnterEnquiryId",number);
			QaExtentReport.test.log(Status.INFO,"<b><i>Enter Enquiry Id</i></b>");
			
			QaRobot.ClickOnElement("SearchEnquiryId");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Search Enquiry Id </i></b>");
			Thread.sleep(3000);
			QaExtentReport.extentScreenshot("Search Enquiry Id");
			
			QaRobot.ClickOnElement("EnquiryView");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Enquiry View Button</i></b>");
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
			
			QaBrowser.driver.switchTo().window(ParentWindow7);
			
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("ApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Approve Button</i></b>");
			Thread.sleep(15000);
			
			String ParentWindow8 = QaBrowser.driver.getWindowHandle();
			Set<String> handles8 = QaBrowser.driver.getWindowHandles();
			for (String childWindow8 : handles8) 
			{
				if (!childWindow8.equals(ParentWindow8))
					QaBrowser.driver.switchTo().window(childWindow8);
			}
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SelectItineraryDH1");
			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
			
			QaRobot.ClickOnElement("SelectItineraryDH2");
			QaExtentReport.test.log(Status.INFO,"<b><i>Select Itinerary</i></b>");
			
			QaExtentReport.extentScreenshot("Itinerary View");
			
			JavascriptExecutor mo1 = (JavascriptExecutor) QaBrowser.driver;
			mo1.executeScript("window.scrollBy(0,500)", "");
			
			QaRobot.ClickOnElement("FinalApproveButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Approve Button</i></b>");
			
			QaRobot.PassValue("TextArea","Ok");
			QaExtentReport.test.log(Status.INFO,"<b><i>Click on Text Area</i></b>");
			
			QaRobot.ClickOnElement("OKButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on OK Button</i></b>");
			Thread.sleep(13000);
			QaBrowser.driver.switchTo().window(ParentWindow8);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			
			QaRobot.ClickOnElement("FinalBookButton");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on Final Book Button</i></b>");
			Thread.sleep(20000);
			
			if (QaBrowser.driver.findElement(By.xpath("//div[contains(text(),'Selected hotel room is no longer available or the "
					+ "hotel price has changed. You may select a different hotel room type and send another quote.')]"))
					.isDisplayed()) 
			{
				QaRobot.ClickOnElement("SelectRoom");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SelectRoom</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("BookH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
				Thread.sleep(6000);
			}
			
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLH']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDLH']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDLH']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture85']"));
			Select s33 = new Select(ele3);
			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForHotel();
			
			DnataConfirmPage.confirmpageHotel();
		}
		
		else if (Checkoutpagestep.equalsIgnoreCase("Fulfilment"))
		{
//			WebElement element = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateFDReasonDDLH']"));
//			Select s = new Select(element);
//			s.selectByIndex(1);
			
			WebElement ele1 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CostCenterDDLH']"));
			Select s11 = new Select(ele1);
			s11.selectByIndex(1);
			
			WebElement ele2 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_CorporateDivisionDDLH']"));
			Select s22 = new Select(ele2);
			s22.selectByIndex(1);
			
			WebElement ele3 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture85']"));
			Select s33 = new Select(ele3);
			s33.selectByIndex(1);
			
			WebElement ele44 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture127']"));
			Select s44 = new Select(ele44);
			s44.selectByIndex(1);
			
			WebElement ele5 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture128']"));
			Select s55 = new Select(ele5);
			s55.selectByIndex(1);
			
			WebElement ele6 = QaBrowser.driver.findElement(By.xpath("//select[@id='ctl00_contentMain_dynamicdatacapture126']"));
			Select s66 = new Select(ele6);
			s66.selectByIndex(1);
			
			QaRobot.PassValue("BookerName","Test");
			
			QaRobot.PassValue("TripApprover","Test");
			
			QaRobot.PassValue("SuppplierCode","Test");
			
			QaRobot.PassValue("OrderedBy","Test");
			
			QaRobot.PassValue("TravellerEmail","Test");
			
			QaRobot.PassValue("ArrangerEmail","Test"); 
			
			QaExtentReport.extentScreenshot("Checkout page");
			
			QaRobot.ClickOnElement("TermsAndConditionF");
			
			QaRobot.ClickOnElement("FulfilmentF");
			QaExtentReport.test.log(Status.INFO,"<b><i>Clicked on FulfilmentF Button</i></b>");
			Thread.sleep(3000);
			
			DnataPaymentPage.individualForHotel();
			
			if(Resultpagestep.equalsIgnoreCase("Add to Cart"))
			{
				DnataConfirmPage.confirmpageHotel();
			}
			else
			{
				DnataConfirmPage.confirmpageFulfilmentHotel();
			}
			
		}
	}
	
	public static void AdultCheckoutForFlight(String adult,String AdultTitle,String AdultName,String AdultDate,String AdultEmailAddress,
			 String PhoneNumber,String AdultPassportNumber, String AdultPassportcountry,String AdultExpiryDate,String AdultNationality) throws Exception 
	{
		int adt = Integer.parseInt(adult);
		for (int i = 1; i <= adt; i++) 
		{
			// select title
			String adultTitleElement = "//select[@id='ddlTitleAdt"+ i +"']";
			String[] adulttitle = AdultTitle.split(",");
			QaRobot.selectTextByLocator1(adultTitleElement, adulttitle[i - 1],"<b><i>Select title for adult</i></b>");
			Thread.sleep(2000);

			// Fill First name
			String NameSelection[] = AdultName.split(",");
			String NameS[]= NameSelection[i - 1].split(" ");
			String Fname = NameS[0];
			String Lname = NameS[1];
			
			String adultNameElement = "//input[@id='txt_firstNameAdt" + i + "']";
			QaRobot.PassValueByLocator(adultNameElement, Fname, "<b><i>Entered Name For adult</i></b>");
			Thread.sleep(2000);

			// Fill Last name
			String adultLNameElement = "//input[@id='txt_lastnameAdt" + i + "']";
			QaRobot.PassValueByLocator(adultLNameElement, Lname, "<b><i>Entered Last Name For adult</i></b>");
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_dobAdt"+i+"']")).click();
			Thread.sleep(5000);
			String DateSelection[] = AdultDate.split(",");
			String DateS[]= DateSelection[i - 1].split("-");
			String Date = DateS[0];
			String Month = DateS[1];
			String Year = DateS[2];
			
			String currentMonthNumber = "0";
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
			 
			LocalDate date = LocalDate.of(Integer.parseInt(Year), Integer.parseInt(currentMonthNumber), Integer.parseInt(Date));
			LocalDate today = LocalDate.now();
			
			if (date.isBefore(today.minusYears(12))) 
			{
				String text1 = "/html/body/div[3]/div/div[2]/div/div/select[2]";
				QaRobot.selectTextByLocator1(text1, Year,"<b><i>Select year for adult</i></b>"+" - "+Year);
				Thread.sleep(2000);
			
				String text = "/html/body/div[3]/div/div[2]/div/div/select[1]";
				QaRobot.selectTextByLocator1(text, Month,"<b><i>Select month for adult</i></b>"+" - "+Month);
				Thread.sleep(2000);
			
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr/td"));
	
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Date))
					{
						ele.click();
						Thread.sleep(2000);
						break;
					}
				}
			}
			else
			{
				QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Adult Date Selection</i></b>"+" - "+Date+"-"+Month+"-"+Year);
				throw new DnataExceptionClass("Invalid Adult Date Selection"+" : "+Date+"-"+Month+"-"+Year);
			}
			
			// Fill PhoneNumber
			String adultphonenumberElement = "//input[@id='txt_mobileAdt" + i + "']";
			String[] adultphone = PhoneNumber.split(",");
			QaRobot.PassValueByLocator(adultphonenumberElement, adultphone[i - 1],"<b><i>Entered Phone Number For adult</i></b>");
			Thread.sleep(2000);
			
			// Fill Passport
			String adultpassportElement = "//input[@id='txt_passportAdt" + i + "']";
			String[] adultpass = AdultPassportNumber.split(",");
			QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],"<b><i>Entered Passport Number For adult</i></b>");
			Thread.sleep(2000);
			
			// fill Passport issuing country
			String adultpasscountryElement = "//select[@id='ddl_passCountryAdt" + i + "']";
			String[] adultpc = AdultPassportcountry.split(",");
			QaRobot.selectTextByLocator1(adultpasscountryElement, adultpc[i - 1], "<b><i>Select Passport Country For adult</i></b>");
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_ex_dateAdt"+ i +"']")).click();
			Thread.sleep(5000);
			String DateSelection1[] = AdultExpiryDate.split(",");
			String DateS1[]= DateSelection1[i - 1].split("-");
			String Date1 = DateS1[0];
			String Month1 = DateS1[1];
			String Year1 = DateS1[2];
			
			String text3 = "/html/body/div[3]/div/div[2]/div/div/select[2]";
			QaRobot.selectTextByLocator1(text3, Year1,"<b><i>Select Passport year for adult</i></b>");
			Thread.sleep(2000);
			String text2 = "/html/body/div[3]/div/div[2]/div/div/select[1]";
			QaRobot.selectTextByLocator1(text2, Month1,"<b><i>Select Passport month for adult</i></b>");
			Thread.sleep(2000);
			
			List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr/td"));
			
			for(WebElement ele1 : allDates1)
			{
				String dt1 = ele1.getText();
				
				if(dt1.equalsIgnoreCase(Date1))
				{
					ele1.click();
					Thread.sleep(2000);
					break;
				}
			}
			// fill nationality
			String adultnationalityElement = "//select[@id='ddl_nationalityAdt"+i+"']";
			String[] adultnat = AdultNationality.split(",");
			QaRobot.selectTextByLocator1(adultnationalityElement, adultnat[i - 1], "<b><i>Select Nationality For adult</i></b>");
			Thread.sleep(2000);
		}
		
		String adultEmailElement = "//input[@id='txt_emailLeadPax']";
		QaRobot.PassValueByLocator(adultEmailElement, AdultEmailAddress,"<b><i>Pass Email</i></b>");
		Thread.sleep(2000);
		
		QaRobot.ScreenshotMethod("AdultDetails","<b><i>Screenshot for Adult Details</i></b>");
		QaExtentReport.extentScreenshot("Adult Details");
	}
	
	public static void GuestChildCheckoutForFlight(String child,String ChildTitle,String ChildName,String ChildPassportNumber,String ChildPassportcountry,
			 String ChildPassportDate,String ChildNationality, String ChildDOBdate) throws Exception 
	{
		int chd = Integer.parseInt(child);
		for (int i = 1; i <= chd; i++) 
		{
			// select title
			String childTitleElement = "//select[@id='ddlTitleChd"+ i +"']";
			String[] childtitle = ChildTitle.split(",");
			QaRobot.selectTextByLocator1(childTitleElement, childtitle[i - 1],"<b><i>Select title for child</i></b>");
			Thread.sleep(2000);

			// Fill First name
			String NameSelection[] = ChildName.split(",");
			String NameS[]= NameSelection[i - 1].split(" ");
			String Fcname = NameS[0];
			String Lcname = NameS[1];	
			
			String childNameElement = "//input[@id='txt_firstNameChd" + i + "']";
			QaRobot.PassValueByLocator(childNameElement, Fcname, "<b><i>Entered Name For child</i></b>");
			Thread.sleep(2000);

			// Fill Last name
			String childLNameElement = "//input[@id='txt_lastnameChd" + i + "']";
			QaRobot.PassValueByLocator(childLNameElement, Lcname, "<b><i>Entered Last Name For child</i></b>");
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_ex_dateChd"+i+"']")).click();
			Thread.sleep(5000);
			String DateSelection[] = ChildPassportDate.split(",");
			String DateS[]= DateSelection[i - 1].split("-");
			String Date = DateS[0];
			String Month = DateS[1];
			String Year = DateS[2];
			
			String text1 = "/html/body/div[3]/div/div[2]/div/div/select[2]";
			QaRobot.selectTextByLocator1(text1, Year,"<b><i>Select Passport year for child</i></b>");
			Thread.sleep(2000);
				
			String text = "/html/body/div[3]/div/div[2]/div/div/select[1]";
			QaRobot.selectTextByLocator1(text, Month,"<b><i>Select Passport month for child</i></b>");
			Thread.sleep(2000);
			
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr/td"));
			
			for(WebElement ele : allDates)
			{
				String dt = ele.getText();
				
				if(dt.equalsIgnoreCase(Date))
				{
					ele.click();
					Thread.sleep(2000);
					break;
				}
			}
		
			// Fill Passport
			String childpassportElement = "//input[@id='txt_passportChd" + i + "']";
			String[] childpass = ChildPassportNumber.split(",");
			QaRobot.PassValueByLocator(childpassportElement, childpass[i - 1],"<b><i>Entered Passport Number For child</i></b>");
			Thread.sleep(2000);
			
			// fill Passport issuing country
			String childpasscountryElement = "//select[@id='ddl_passCountryChd" + i + "']";
			String[] childpc = ChildPassportcountry.split(",");
			QaRobot.selectTextByLocator1(childpasscountryElement, childpc[i - 1], "<b><i>Selected Passport Country For child</i></b>");
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_dobChd"+ i +"']")).click();
			Thread.sleep(5000);
			String DateSelection1[] = ChildDOBdate.split(",");
			String DateS1[]= DateSelection1[i - 1].split("-");
			String Date1 = DateS1[0];
			String Month1 = DateS1[1];
			String Year1 = DateS1[2];
			
			String currentMonthNumber = "0";
			 if (Month1.equalsIgnoreCase("Jan")) {
	               currentMonthNumber = "01";
	           } else if (Month1.equalsIgnoreCase("Feb")) {
	               currentMonthNumber = "02";
	           } else if (Month1.equalsIgnoreCase("Mar")) {
	               currentMonthNumber = "03";
	           } else if (Month1.equalsIgnoreCase("Apr")) {
	               currentMonthNumber = "04";
	           } else if (Month1.equalsIgnoreCase("May")) {
	               currentMonthNumber = "05";
	           } else if (Month1.equalsIgnoreCase("Jun")) {
	               currentMonthNumber = "06";
	           } else if (Month1.equalsIgnoreCase("Jul")) {
	               currentMonthNumber = "07";
	           } else if (Month1.equalsIgnoreCase("Aug")) {
	               currentMonthNumber = "08";
	           } else if (Month1.equalsIgnoreCase("Sep")) {
	        	   currentMonthNumber = "09";
	           } else if (Month1.equalsIgnoreCase("Oct")) {
	               currentMonthNumber = "10";
	           } else if (Month1.equalsIgnoreCase("Nov")) {
	               currentMonthNumber = "11";
	           } else if (Month1.equalsIgnoreCase("Dec")) {
	               currentMonthNumber = "12";
	           }
			 
			LocalDate date = LocalDate.of(Integer.parseInt(Year1), Integer.parseInt(currentMonthNumber), Integer.parseInt(Date1));
			LocalDate today = LocalDate.now();
			
			if (date.isBefore(today.minusYears(2))&& date.isAfter(today.minusYears(12))) 
			{
				String text3 = "/html/body/div[3]/div/div[2]/div/div/select[2]";
				QaRobot.selectTextByLocator1(text3, Year1,"<b><i>Select year for child</i></b>"+" - "+Year1);
				Thread.sleep(2000);
				String text2 = "/html/body/div[3]/div/div[2]/div/div/select[1]";
				QaRobot.selectTextByLocator1(text2, Month1,"<b><i>Select month for child</i></b>"+" - "+Month1);
				Thread.sleep(2000);
				
				List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr/td"));
				
				for(WebElement ele1 : allDates1)
				{
					String dt1 = ele1.getText();
					
					if(dt1.equalsIgnoreCase(Date1))
					{
						ele1.click();
						Thread.sleep(2000);
						break;
					}
				}
			}
			else
			{
				QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Date Selection</i></b>"+" - "+Date1+"-"+Month1+"-"+Year1);
				throw new DnataExceptionClass("Invalid Child Date Selection"+" : "+Date1+"-"+Month1+"-"+Year1);
			}
			// fill nationality
			String childnationalityElement = "//select[@id='ddl_nationalityChd"+i+"']";
			String[] childnat = ChildNationality.split(",");
			QaRobot.selectTextByLocator1(childnationalityElement, childnat[i - 1], "<b><i>Select Nationality For child</i></b>");
			Thread.sleep(2000);
		}
		
		QaRobot.ScreenshotMethod("ChildDetails","<b><i>Screenshot for Child Details</i></b>");
		QaExtentReport.extentScreenshot("Child Details");
	}
	
	public static void GuestInfantCheckoutForFlight(String infant,String InfantTitle,String InfantName,String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,String InfantPassportcountry,
			 String InfantPassportDate,String InfantNationality) throws Exception 
	{
		int ift = Integer.parseInt(infant);
		for (int i = 1; i <= ift; i++) 
		{
			String infantTitleElement = "//select[@id='ddlTitleInf"+ i +"']";
			String[] infanttitle = InfantTitle.split(",");
			QaRobot.selectTextByLocator1(infantTitleElement, infanttitle[i - 1],"<b><i>Select title for infant</i></b>");
			Thread.sleep(2000);
			
			String NameSelection[] = InfantName.split(",");
			String NameS[]= NameSelection[i - 1].split(" ");
			String Fcname = NameS[0];
			String Lcname = NameS[1];
			
			String infantNameElement = "//input[@id='txt_firstNameInf" + i + "']";
			QaRobot.PassValueByLocator(infantNameElement, Fcname, "<b><i>Entered Name For infant</i></b>");
			Thread.sleep(2000);
			
			String infantLNameElement = "//input[@id='txt_lastnameInf" + i + "']";
			QaRobot.PassValueByLocator(infantLNameElement, Lcname, "<b><i>Entered Last Name For infant</i></b>");
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_dobInf"+i+"']")).click();
			Thread.sleep(5000);
			String DateSelection[] = InfantDOBdate.split(",");
			String DateS[]= DateSelection[i - 1].split("-");
			String Date = DateS[0];
			String Month = DateS[1];
			String Year = DateS[2];
			
			String currentMonthNumber = "0";
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
			 
			 	LocalDate date = LocalDate.of(Integer.parseInt(Year), Integer.parseInt(currentMonthNumber), Integer.parseInt(Date));
				LocalDate today = LocalDate.now();
				
				if (date.isAfter(today.minusYears(2))) 
				{
					String text1 = "/html/body/div[3]/div/div[2]/div/div/select[2]";
					QaRobot.selectTextByLocator1(text1, Year,"<b><i>Select year for infant</i></b>"+" - "+Year);
					Thread.sleep(2000);
				
					String text = "/html/body/div[3]/div/div[2]/div/div/select[1]";
					QaRobot.selectTextByLocator1(text, Month,"<b><i>Select month for infant</i></b>"+" - "+Month);
					Thread.sleep(2000);
					
					List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr/td"));
					
					for(WebElement ele : allDates)
					{
						String dt = ele.getText();
						
						if(dt.equalsIgnoreCase(Date))
						{
							ele.click();
							Thread.sleep(2000);
							break;
						}
					}
				}
			 	else
				{
			 		QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Infant Date Selection</i></b>"+" - "+Date+"-"+Month+"-"+Year);
					throw new DnataExceptionClass("Invalid Infant Date Selection"+" : "+Date+"-"+Month+"-"+Year);
				}
		
			String infantTravellingWith = "//select[@id='ddl_travell_with" + i + "']";
			String[] infantTw = InfantTravellingwith.split(",");
			QaRobot.selectTextByLocator1(infantTravellingWith, infantTw[i - 1], "<b><i>Select travelling with For infant</i></b>");
			Thread.sleep(2000);
			
			String infantpassportElement = "//input[@id='txt_passportInf" + i + "']";
			String[] infantpass = InfantPassportNumber.split(",");
			QaRobot.PassValueByLocator(infantpassportElement, infantpass[i - 1],"<b><i>Entered Passport Number For infant</i></b>");
			Thread.sleep(2000);
			
			String infantpasscountryElement = "//select[@id='ddl_passCountryInf" + i + "']";
			String[]infantpc = InfantPassportcountry.split(",");
			QaRobot.selectTextByLocator1(infantpasscountryElement, infantpc[i - 1], "<b><i>Selected Passport Country For infant</i></b>");
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_ex_dateInf"+ i +"']")).click();
			Thread.sleep(5000);
			String DateSelection1[] = InfantPassportDate.split(",");
			String DateS1[]= DateSelection1[i - 1].split("-");
			String Date1 = DateS1[0];
			String Month1 = DateS1[1];
			String Year1 = DateS1[2];
			
			String text3 = "/html/body/div[3]/div/div[2]/div/div/select[2]";
			QaRobot.selectTextByLocator1(text3, Year1,"<b><i>Select year for infant</i></b>");
			Thread.sleep(2000);
			String text2 = "/html/body/div[3]/div/div[2]/div/div/select[1]";
			QaRobot.selectTextByLocator1(text2, Month1,"<b><i>Select month for infant</i></b>");
			Thread.sleep(2000);
			
			List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[3]/div/div[2]/div/table/tbody/tr/td"));
			
			for(WebElement ele1 : allDates1)
			{
				String dt1 = ele1.getText();
				
				if(dt1.equalsIgnoreCase(Date1))
				{
					ele1.click();
					Thread.sleep(2000);
					break;
				}
			}
			
			String infuntnationalityElement = "//select[@id='ddl_nationalityInf"+i+"']";
			String[] infuntnat = InfantNationality.split(",");
			QaRobot.selectTextByLocator1(infuntnationalityElement, infuntnat[i - 1], "<b><i>Selected Nationality For infant</i></b>");
			Thread.sleep(2000);
		}
		
		QaRobot.ScreenshotMethod("InfantDetails","<b><i>Screenshot for Infant Details</i></b>");
		QaExtentReport.extentScreenshot("Infant Details");
	}
	
	public static void GuestAdultCheckoutForHotel(String Emailid,String Adult,String AdultTitle, String AdultName,String Phone) throws Exception 
	{
		QaRobot.PassValue("email_address", Emailid);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Email</i></b>");	
		
		String[] adt = Adult.split(",");
		int adtTotal = 0;
		for (int j = 0; j <adt.length; j++) 
		{
			adtTotal = Integer.parseInt(adt[j]) + adtTotal;
		}
		for (int i = 1; i <= adtTotal; i++)
		{ 
			String adultTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddl_titleAdt_H')])[" + i + "]";
			String[] adulttitle = AdultTitle.split(",");
			QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 1],"<b><i>Select Title For Adult</i></b>");

			String NameSelection[] = AdultName.split(",");
			String NameS[]= NameSelection[i-1].split(" ");
			String Faname = NameS[0];
			String Laname = NameS[1];
			
			String adultNameElement = "(//input[contains(@id,'txt_firstNameAdt_H')])[" + i + "]";
			QaRobot.PassValueByLocator(adultNameElement, Faname, "<b><i>Write Name For Adult</i></b>");

			String adultLNameElement = "(//input[contains(@id,'txt_lastnameAdt_H')])[" + i + "]";
			QaRobot.PassValueByLocator(adultLNameElement, Laname, "<b><i>Write Last Name For Adult</i></b>");
		}
		
		QaRobot.PassValue("Phone_number",Phone);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write PhoneNumber</i></b>");
		
		QaRobot.ScreenshotMethod("AdultDetails","<b><i>Screenshot for Adult Details</i></b>");
		QaExtentReport.extentScreenshot("Adult Details");
	}
	
	public static void GuestChildCheckoutForHotel(String CheckInDate,String Child,String ChildAge, String ChildTitle, String ChildName,String ChildDOBdate) throws Exception 
	{
		String[] chd = Child.split(",");
		int chdTotal = 0;
		for (int j = 0; j <chd.length; j++) 
		{
			chdTotal = Integer.parseInt(chd[j]) + chdTotal;
		}
		for (int i = 1; i <= chdTotal; i++)
		{ 
			String childTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddl_titleChd_H')])[" + i + "]";
			String[] childtitle =ChildTitle.split(",");
			QaRobot.selectValueByLocator(childTitleElement, childtitle[i - 1],"<b><i>Select Title For Child</i></b>");

			String NameSelection[] = ChildName.split(",");
			String NameS[]= NameSelection[i-1].split(" ");
			String Fcname = NameS[0];
			String Lcname = NameS[1];
			
			String childNameElement = "(//input[contains(@id,'txt_firstnameChd_H')])[" + i + "]";
			QaRobot.PassValueByLocator(childNameElement, Fcname, "<b><i>Write Name For Child</i></b>");

			String childLNameElement = "(//input[contains(@id,'txt_lastnameChd_H')])[" + i + "]";
			QaRobot.PassValueByLocator(childLNameElement, Lcname, "<b><i>Write Last Name For Child</i></b>");
			
			String DateSelection[] = ChildDOBdate.split(",");
			String DateS[]= DateSelection[i - 1].split("-");
			String Dcname = DateS[0];
			String Mcname = DateS[1];
			String Ycname = DateS[2];
			
			String currentMonthNumber = "0";
			 if (Mcname.equalsIgnoreCase("Jan")) {
	               currentMonthNumber = "01";
	           } else if (Mcname.equalsIgnoreCase("Feb")) {
	               currentMonthNumber = "02";
	           } else if (Mcname.equalsIgnoreCase("Mar")) {
	               currentMonthNumber = "03";
	           } else if (Mcname.equalsIgnoreCase("Apr")) {
	               currentMonthNumber = "04";
	           } else if (Mcname.equalsIgnoreCase("May")) {
	               currentMonthNumber = "05";
	           } else if (Mcname.equalsIgnoreCase("Jun")) {
	               currentMonthNumber = "06";
	           } else if (Mcname.equalsIgnoreCase("Jul")) {
	               currentMonthNumber = "07";
	           } else if (Mcname.equalsIgnoreCase("Aug")) {
	               currentMonthNumber = "08";
	           } else if (Mcname.equalsIgnoreCase("Sep")) {
	        	   currentMonthNumber = "09";
	           } else if (Mcname.equalsIgnoreCase("Oct")) {
	               currentMonthNumber = "10";
	           } else if (Mcname.equalsIgnoreCase("Nov")) {
	               currentMonthNumber = "11";
	           } else if (Mcname.equalsIgnoreCase("Dec")) {
	               currentMonthNumber = "12";
	           }
			 
			 String[] cAge = ChildAge.split(",");
			 String age1 = cAge[i-1];
			 int ag1 = Integer.parseInt(age1);
			 int ag2 = Integer.parseInt(age1)+1;
			
			LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
			String DateSelection1[]= CheckInDate.split("-");
			String year = DateSelection1[2];
			String month = DateSelection1[1];
			String expDate = DateSelection1[0];
			
			String currentMonthNumber1 = "0";
				if (month.equalsIgnoreCase("Jan")) {
	               currentMonthNumber1 = "01";
	           } else if (month.equalsIgnoreCase("Feb")) {
	               currentMonthNumber1 = "02";
	           } else if (month.equalsIgnoreCase("Mar")) {
	               currentMonthNumber1 = "03";
	           } else if (month.equalsIgnoreCase("Apr")) {
	               currentMonthNumber1 = "04";
	           } else if (month.equalsIgnoreCase("May")) {
	               currentMonthNumber1 = "05";
	           } else if (month.equalsIgnoreCase("Jun")) {
	               currentMonthNumber1 = "06";
	           } else if (month.equalsIgnoreCase("Jul")) {
	               currentMonthNumber1 = "07";
	           } else if (month.equalsIgnoreCase("Aug")) {
	               currentMonthNumber1 = "08";
	           } else if (month.equalsIgnoreCase("Sep")) {
	        	   currentMonthNumber1 = "09";
	           } else if (month.equalsIgnoreCase("Oct")) {
	               currentMonthNumber1 = "10";
	           } else if (month.equalsIgnoreCase("Nov")) {
	               currentMonthNumber1 = "11";
	           } else if (month.equalsIgnoreCase("Dec")) {
	               currentMonthNumber1 = "12";
	           }
				
			LocalDate bDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(currentMonthNumber1), Integer.parseInt(expDate));
			
			if (date.isAfter(bDate.minusYears(17))) 
			{
				if (date.isAfter(bDate.minusYears(ag2))&&date.isBefore(bDate.minusYears(ag1))) 
				{
					String childdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_DobChd_H_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(childdayElement,Dcname, "<b><i>Select Day For Child</i></b>");

					String childmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_DobChd_H_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(childmonthElement,Mcname, "<b><i>Select Month For Child</i></b>");

					String childyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_DobChd_H_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(childyearElement,Ycname,"<b><i>Select Year of Child</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Child Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
			}
			else
			{
				QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
				throw new DnataExceptionClass("Invalid Child Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
			}
			
		}
		QaRobot.ScreenshotMethod("ChildDetails","<b><i>Screenshot for Child Details</i></b>");
		QaExtentReport.extentScreenshot("Check Out Page");
	}
	
	public static void GuestBillingDetailsCheckoutForHotel(String BillingTitle, String BillingUserName, String BillingAddress,String BillingCountry,String BillingCity) throws Exception 
	{
		String BTitle = "//select[@id='ctl00_contentMain_ddl_titleAdt']";
		QaRobot.selectTextByLocator1(BTitle, BillingTitle,"<b><i>Select Billing User Title</i></b>");
		Thread.sleep(2000);
		
		String NameSelection[] = BillingUserName.split(" ");
		String BFname = NameSelection[0];
		String BLname = NameSelection[1];
		
		QaRobot.PassValue("BFName",BFname);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing User First Name</i></b>");
		
		QaRobot.PassValue("BLName",BLname);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing User Last Name</i></b>");
		
		QaRobot.PassValue("BAddress",BillingAddress);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing User Address</i></b>");
		
		String BCountry = "//select[@id='ctl00_contentMain_txt_country']";
		QaRobot.selectTextByLocator1(BCountry, BillingCountry,"<b><i>Select Country</i></b>");
		Thread.sleep(2000);
		
		String BCity[] = BillingCity.split(",");
		String BCode = BCity[0];
		String BLocation = BCity[1];
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divHTCity']/p"), BCode, BLocation,By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));
	
		QaRobot.ClickOnElement("chkExpediaTerms");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on chkExpediaTerms</i></b>");
		
		QaRobot.ClickOnElement("Terms_conditions");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on chkExpediaTerms</i></b>");
		
		QaRobot.ScreenshotMethod("BillingDetails","<b><i>Screenshot for Billing Details</i></b>");
		QaExtentReport.extentScreenshot("Billing Details");
		
		QaRobot.ClickOnElement("Confirm");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Confirm</i></b>");
		Thread.sleep(20000);
	}
	
	public static void GuestAdultCheckoutForFlight_Hotel(String Adult,String Trip,String Emailid,String AdultTitle,String AdultName, String Phone,String AdultDOBdate,
			String AdultRoomSelection,String AdultPassportNumber, String AdultPassportcountry,String AdultExpiryDate,String AdultNationality) throws Exception 
	{
		String[] adt = Adult.split(",");
		int adtTotal = 0;
		for (int j = 0; j <adt.length; j++) 
		{
			adtTotal = Integer.parseInt(adt[j]) + adtTotal;
		}
		for (int i = 1; i <= adtTotal; i++) 
		{
			if (Trip.equalsIgnoreCase("Domestic"))
			{
				String adultTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddlTitle')])[" + i + "]";
				String[] adulttitle = AdultTitle.split(",");
				QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 1],"<b><i>Select Title For Adult</i></b>");

				String NameSelection[] = AdultName.split(",");
				String NameS[]= NameSelection[i-1].split(" ");
				String Faname = NameS[0];
				String Laname = NameS[1];
				
				String adultNameElement = "(//input[contains(@id,'txt_firstNameAdt')])[" + i + "]";
				QaRobot.PassValueByLocator(adultNameElement, Faname, "<b><i>Write Name For Adult</i></b>");

				String adultLNameElement = "(//input[contains(@id,'txt_lastnameAdt')])[" + i + "]";
				QaRobot.PassValueByLocator(adultLNameElement, Laname, "<b><i>Write Last Name For Adult</i></b>");
				
				String DateSelection[] = AdultDOBdate.split(",");
				String DateS[]= DateSelection[i - 1].split("-");
				String Dcname = DateS[0];
				String Mcname = DateS[1];
				String Ycname = DateS[2];
				
				String currentMonthNumber = "0";
				 if (Mcname.equalsIgnoreCase("Jan")) {
		               currentMonthNumber = "01";
		           } else if (Mcname.equalsIgnoreCase("Feb")) {
		               currentMonthNumber = "02";
		           } else if (Mcname.equalsIgnoreCase("Mar")) {
		               currentMonthNumber = "03";
		           } else if (Mcname.equalsIgnoreCase("Apr")) {
		               currentMonthNumber = "04";
		           } else if (Mcname.equalsIgnoreCase("May")) {
		               currentMonthNumber = "05";
		           } else if (Mcname.equalsIgnoreCase("Jun")) {
		               currentMonthNumber = "06";
		           } else if (Mcname.equalsIgnoreCase("Jul")) {
		               currentMonthNumber = "07";
		           } else if (Mcname.equalsIgnoreCase("Aug")) {
		               currentMonthNumber = "08";
		           } else if (Mcname.equalsIgnoreCase("Sep")) {
		        	   currentMonthNumber = "09";
		           } else if (Mcname.equalsIgnoreCase("Oct")) {
		               currentMonthNumber = "10";
		           } else if (Mcname.equalsIgnoreCase("Nov")) {
		               currentMonthNumber = "11";
		           } else if (Mcname.equalsIgnoreCase("Dec")) {
		               currentMonthNumber = "12";
		           }
				 
				LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
				LocalDate today = LocalDate.now();
				
				if (date.isBefore(today.minusYears(12))) 
				{
					String adultdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateAdt_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(adultdayElement,Dcname, "<b><i>Select Day For Adult</i></b>");

					String adultmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateAdt_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(adultmonthElement,Mcname, "<b><i>Select Month For Adult</i></b>");

					String adultyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateAdt_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(adultyearElement,Ycname,"<b><i>Select Year of Adult</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Adult Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Adult Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
				
				String adultRoomElement = "(//select[contains(@id,'ctl00_contentMain_ddl_roomNo_Adt')])[" + i + "]";
				String[] adultRoom = AdultRoomSelection.split(",");
				QaRobot.selectTextByLocator(adultRoomElement, adultRoom[i - 1],"<b><i>Select Room For Adult</i></b>");
			}
			else if (Trip.equalsIgnoreCase("International"))
			{
				String adultTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddlTitle')])[" + i + "]";
				String[] adulttitle = AdultTitle.split(",");
				QaRobot.selectValueByLocator(adultTitleElement, adulttitle[i - 1],"<b><i>Select Title For Adult</i></b>");

				String NameSelection[] = AdultName.split(",");
				String NameS[]= NameSelection[i-1].split(" ");
				String Faname = NameS[0];
				String Laname = NameS[1];
				
				String adultNameElement = "(//input[contains(@id,'txt_firstNameAdt')])[" + i + "]";
				QaRobot.PassValueByLocator(adultNameElement, Faname, "<b><i>Write Name For Adult</i></b>");

				String adultLNameElement = "(//input[contains(@id,'txt_lastnameAdt')])[" + i + "]";
				QaRobot.PassValueByLocator(adultLNameElement, Laname, "<b><i>Write Last Name For Adult</i></b>");
				
				String DateSelection[] = AdultDOBdate.split(",");
				String DateS[]= DateSelection[i - 1].split("-");
				String Dcname = DateS[0];
				String Mcname = DateS[1];
				String Ycname = DateS[2];
				
				String currentMonthNumber = "0";
				 if (Mcname.equalsIgnoreCase("Jan")) {
		               currentMonthNumber = "01";
		           } else if (Mcname.equalsIgnoreCase("Feb")) {
		               currentMonthNumber = "02";
		           } else if (Mcname.equalsIgnoreCase("Mar")) {
		               currentMonthNumber = "03";
		           } else if (Mcname.equalsIgnoreCase("Apr")) {
		               currentMonthNumber = "04";
		           } else if (Mcname.equalsIgnoreCase("May")) {
		               currentMonthNumber = "05";
		           } else if (Mcname.equalsIgnoreCase("Jun")) {
		               currentMonthNumber = "06";
		           } else if (Mcname.equalsIgnoreCase("Jul")) {
		               currentMonthNumber = "07";
		           } else if (Mcname.equalsIgnoreCase("Aug")) {
		               currentMonthNumber = "08";
		           } else if (Mcname.equalsIgnoreCase("Sep")) {
		        	   currentMonthNumber = "09";
		           } else if (Mcname.equalsIgnoreCase("Oct")) {
		               currentMonthNumber = "10";
		           } else if (Mcname.equalsIgnoreCase("Nov")) {
		               currentMonthNumber = "11";
		           } else if (Mcname.equalsIgnoreCase("Dec")) {
		               currentMonthNumber = "12";
		           }
				 
				LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
				LocalDate today = LocalDate.now();
				
				if (date.isBefore(today.minusYears(12))) 
				{
					String adultdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateAdt_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(adultdayElement,Dcname, "<b><i>Select Day For Adult</i></b>");

					String adultmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateAdt_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(adultmonthElement,Mcname, "<b><i>Select Month For Adult</i></b>");

					String adultyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateAdt_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(adultyearElement,Ycname,"<b><i>Select Year of Adult</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Adult Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Adult Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
				
				String adultRoomElement = "(//select[contains(@id,'ctl00_contentMain_ddl_roomNo_Adt')])[" + i + "]";
				String[] adultRoom = AdultRoomSelection.split(",");
				QaRobot.selectTextByLocator(adultRoomElement, adultRoom[i - 1],"<b><i>Select Room For Adult</i></b>");
				
				String adultpassportElement = "(//input[contains(@id,'txt_passportAdt')])[" + i + "]";
				String[] adultpass = AdultPassportNumber.split(",");
				QaRobot.PassValueByLocator(adultpassportElement, adultpass[i - 1],"<b><i>Entered Passport Number For adult</i></b>");
				Thread.sleep(2000);
				
				String adultpasscountryElement = "(//select[contains(@id,'ctl00_contentMain_ddl_passCountryAdt')])[" + i + "]";
				String[] adultpc = AdultPassportcountry.split(",");
				QaRobot.selectTextByLocator1(adultpasscountryElement, adultpc[i - 1], "<b><i>Selected Passport Country For adult</i></b>");
				Thread.sleep(2000);
				
				String DateSelection1[] = AdultExpiryDate.split(",");
				String DateS1[]= DateSelection1[i - 1].split("-");
				String Dcname1 = DateS1[0];
				String Mcname1 = DateS1[1];
				String Ycname1 = DateS1[2];
				
				String adultEdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateAdt_ddlDay')])[" + i + "]";
				QaRobot.selectTextByLocator(adultEdayElement,Dcname1, "<b><i>Select Day For Adult</i></b>");

				String adultEmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateAdt_ddlMonth')])[" + i + "]";
				QaRobot.selectTextByLocator(adultEmonthElement,Mcname1, "<b><i>Select Month For Adult</i></b>");

				String adultEyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateAdt_ddlYear')])[" + i + "]";
				QaRobot.selectValueByLocator(adultEyearElement,Ycname1,"<b><i>Select Year of Adult</i></b>");
				
				String adultnationalityElement = "(//select[contains(@id,'ctl00_contentMain_ddl_nationalityAdt')])[" + i + "]";
				String[] adultnat = AdultNationality.split(",");
				QaRobot.selectTextByLocator1(adultnationalityElement, adultnat[i - 1], "<b><i>Selected Nationality For adult</i></b>");
				Thread.sleep(2000);
			}
		}
		
		QaRobot.PassValue("PhoneNumberFH",Phone);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write PhoneNumber</i></b>");
		
		QaRobot.PassValue("EmailFH",Emailid);
		QaExtentReport.test.log(Status.INFO,"<b><i>Write Email</i></b>");
		
		QaRobot.ScreenshotMethod("AdultDetails","<b><i>Screenshot for Adult Details</i></b>");
		QaExtentReport.extentScreenshot("Adult Details");
	}
	
	public static void GuestChildCheckoutFlight_Hotel(String Child,String Trip, String ChildTitle, String ChildName,String ChildDOBdate,String ChildRoomSelection,
			String ChildPassportNumber,String ChildPassportcountry,String ChildPassportDate,String ChildNationality) throws Exception 
	{
		String[] chd = Child.split(",");
		int chdTotal = 0;
		for (int j = 0; j <chd.length; j++) 
		{
			chdTotal = Integer.parseInt(chd[j]) + chdTotal;
		}
		for (int i = 1; i <= chdTotal; i++)
		{ 
			if (Trip.equalsIgnoreCase("Domestic"))
			{
				String childTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddl_titleChd')])[" + i + "]";
				String[] childtitle =ChildTitle.split(",");
				QaRobot.selectValueByLocator(childTitleElement, childtitle[i - 1],"<b><i>Select Title For Child</i></b>");

				String NameSelection[] = ChildName.split(",");
				String NameS[]= NameSelection[i-1].split(" ");
				String Fcname = NameS[0];
				String Lcname = NameS[1];
				
				String childNameElement = "(//input[contains(@id,'txt_firstNameChd')])[" + i + "]";
				QaRobot.PassValueByLocator(childNameElement, Fcname, "<b><i>Write Name For Child</i></b>");

				String childLNameElement = "(//input[contains(@id,'txt_lastnameChd')])[" + i + "]";
				QaRobot.PassValueByLocator(childLNameElement, Lcname, "<b><i>Write Last Name For Child</i></b>");
				
				String DateSelection[] = ChildDOBdate.split(",");
				String DateS[]= DateSelection[i - 1].split("-");
				String Dcname = DateS[0];
				String Mcname = DateS[1];
				String Ycname = DateS[2];
				
				String currentMonthNumber = "0";
				 if (Mcname.equalsIgnoreCase("Jan")) {
		               currentMonthNumber = "01";
		           } else if (Mcname.equalsIgnoreCase("Feb")) {
		               currentMonthNumber = "02";
		           } else if (Mcname.equalsIgnoreCase("Mar")) {
		               currentMonthNumber = "03";
		           } else if (Mcname.equalsIgnoreCase("Apr")) {
		               currentMonthNumber = "04";
		           } else if (Mcname.equalsIgnoreCase("May")) {
		               currentMonthNumber = "05";
		           } else if (Mcname.equalsIgnoreCase("Jun")) {
		               currentMonthNumber = "06";
		           } else if (Mcname.equalsIgnoreCase("Jul")) {
		               currentMonthNumber = "07";
		           } else if (Mcname.equalsIgnoreCase("Aug")) {
		               currentMonthNumber = "08";
		           } else if (Mcname.equalsIgnoreCase("Sep")) {
		        	   currentMonthNumber = "09";
		           } else if (Mcname.equalsIgnoreCase("Oct")) {
		               currentMonthNumber = "10";
		           } else if (Mcname.equalsIgnoreCase("Nov")) {
		               currentMonthNumber = "11";
		           } else if (Mcname.equalsIgnoreCase("Dec")) {
		               currentMonthNumber = "12";
		           }
				 
				LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
				LocalDate today = LocalDate.now();
				
				if (date.isBefore(today.minusYears(2))&& date.isAfter(today.minusYears(12))) 
				{
					String childdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateChd_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(childdayElement,Dcname, "<b><i>Select Day For Child</i></b>");

					String childmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateChd_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(childmonthElement,Mcname, "<b><i>Select Month For Child</i></b>");

					String childyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateChd_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(childyearElement,Ycname,"<b><i>Select Year of Child</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Child Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
				
				String childRoomElement = "(//select[contains(@id,'ctl00_contentMain_ddl_roomNo_Chd')])[" + i + "]";
				String[] adultRoom = ChildRoomSelection.split(",");
				QaRobot.selectTextByLocator(childRoomElement, adultRoom[i - 1],"<b><i>Select Room For Child</i></b>");
			}
			else if (Trip.equalsIgnoreCase("International"))
			{
				String childTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddl_titleChd')])[" + i + "]";
				String[] childtitle =ChildTitle.split(",");
				QaRobot.selectValueByLocator(childTitleElement, childtitle[i - 1],"<b><i>Select Title For Child</i></b>");

				String NameSelection[] = ChildName.split(",");
				String NameS[]= NameSelection[i-1].split(" ");
				String Fcname = NameS[0];
				String Lcname = NameS[1];
				
				String childNameElement = "(//input[contains(@id,'txt_firstNameChd')])[" + i + "]";
				QaRobot.PassValueByLocator(childNameElement, Fcname, "<b><i>Write Name For Child</i></b>");

				String childLNameElement = "(//input[contains(@id,'txt_lastnameChd')])[" + i + "]";
				QaRobot.PassValueByLocator(childLNameElement, Lcname, "<b><i>Write Last Name For Child</i></b>");
				
				String DateSelection[] = ChildDOBdate.split(",");
				String DateS[]= DateSelection[i - 1].split("-");
				String Dcname = DateS[0];
				String Mcname = DateS[1];
				String Ycname = DateS[2];
				
				String currentMonthNumber = "0";
				 if (Mcname.equalsIgnoreCase("Jan")) {
		               currentMonthNumber = "01";
		           } else if (Mcname.equalsIgnoreCase("Feb")) {
		               currentMonthNumber = "02";
		           } else if (Mcname.equalsIgnoreCase("Mar")) {
		               currentMonthNumber = "03";
		           } else if (Mcname.equalsIgnoreCase("Apr")) {
		               currentMonthNumber = "04";
		           } else if (Mcname.equalsIgnoreCase("May")) {
		               currentMonthNumber = "05";
		           } else if (Mcname.equalsIgnoreCase("Jun")) {
		               currentMonthNumber = "06";
		           } else if (Mcname.equalsIgnoreCase("Jul")) {
		               currentMonthNumber = "07";
		           } else if (Mcname.equalsIgnoreCase("Aug")) {
		               currentMonthNumber = "08";
		           } else if (Mcname.equalsIgnoreCase("Sep")) {
		        	   currentMonthNumber = "09";
		           } else if (Mcname.equalsIgnoreCase("Oct")) {
		               currentMonthNumber = "10";
		           } else if (Mcname.equalsIgnoreCase("Nov")) {
		               currentMonthNumber = "11";
		           } else if (Mcname.equalsIgnoreCase("Dec")) {
		               currentMonthNumber = "12";
		           }
				 
				LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
				LocalDate today = LocalDate.now();
				
				if (date.isBefore(today.minusYears(2))&& date.isAfter(today.minusYears(12))) 
				{
					String childdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateChd_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(childdayElement,Dcname, "<b><i>Select Day For Child</i></b>");

					String childmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateChd_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(childmonthElement,Mcname, "<b><i>Select Month For Child</i></b>");

					String childyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateChd_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(childyearElement,Ycname,"<b><i>Select Year of Child</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Child Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
				
				String childRoomElement = "(//select[contains(@id,'ctl00_contentMain_ddl_roomNo_Chd')])[" + i + "]";
				String[] adultRoom = ChildRoomSelection.split(",");
				QaRobot.selectTextByLocator(childRoomElement, adultRoom[i - 1],"<b><i>Select Room For Child</i></b>");
				
				String childpassportElement = "(//input[contains(@id,'txt_passportChd')])[" + i + "]";
				String[] childtpass = ChildPassportNumber.split(",");
				QaRobot.PassValueByLocator(childpassportElement, childtpass[i - 1],"<b><i>Entered Passport Number For Child</i></b>");
				Thread.sleep(2000);
				
				String childpasscountryElement = "(//select[contains(@id,'ctl00_contentMain_ddl_passCountryChd')])[" + i + "]";
				String[] childpc = ChildPassportcountry.split(",");
				QaRobot.selectTextByLocator1(childpasscountryElement, childpc[i - 1], "<b><i>Selected Passport Country For Child</i></b>");
				Thread.sleep(2000);
				
				String DateSelection1[] = ChildPassportDate.split(",");
				String DateS1[]= DateSelection1[i - 1].split("-");
				String Dcname1 = DateS1[0];
				String Mcname1 = DateS1[1];
				String Ycname1 = DateS1[2];
				
				String childEdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateChd_ddlDay')])[" + i + "]";
				QaRobot.selectTextByLocator(childEdayElement,Dcname1, "<b><i>Select Day For Child</i></b>");

				String childEmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateChd_ddlMonth')])[" + i + "]";
				QaRobot.selectTextByLocator(childEmonthElement,Mcname1, "<b><i>Select Month For Child</i></b>");

				String childEyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateChd_ddlYear')])[" + i + "]";
				QaRobot.selectValueByLocator(childEyearElement,Ycname1,"<b><i>Select Year of Child</i></b>");
				
				String childnationalityElement = "(//select[contains(@id,'ctl00_contentMain_ddl_nationalityChd')])[" + i + "]";
				String[] childnat = ChildNationality.split(",");
				QaRobot.selectTextByLocator1(childnationalityElement, childnat[i - 1], "<b><i>Selected Nationality For Child</i></b>");
				Thread.sleep(2000);
			}
		}
		
		QaRobot.ScreenshotMethod("ChildDetails","<b><i>Screenshot for Child Details</i></b>");
		QaExtentReport.extentScreenshot("Child Details");
	}
	
	public static void GuestInfantCheckoutFlight_Hotel(String Infant,String Trip,String InfantTitle,String InfantName,String InfantDOBdate,String InfantTravellingwith,
			String InfantPassportNumber,String InfantPassportcountry,String InfantPassportDate,String InfantNationality) throws Exception 
	{
		String[] ift = Infant.split(",");
		int iftTotal = 0;
		for (int j = 0; j <ift.length; j++) 
		{
			iftTotal = Integer.parseInt(ift[j]) + iftTotal;
		}
		for (int i = 1; i <= iftTotal; i++)
		{ 
			if (Trip.equalsIgnoreCase("Domestic"))
			{
				String infantTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddl_titleInf')])[" + i + "]";
				String[] infanttitle =InfantTitle.split(",");
				QaRobot.selectValueByLocator(infantTitleElement, infanttitle[i - 1],"<b><i>Select Title For Infant</i></b>");

				String NameSelection[] = InfantName.split(",");
				String NameS[]= NameSelection[i-1].split(" ");
				String Fcname = NameS[0];
				String Lcname = NameS[1];
				
				String infantNameElement = "(//input[contains(@id,'txt_firstNameInf')])[" + i + "]";
				QaRobot.PassValueByLocator(infantNameElement, Fcname, "<b><i>Write Name For Infant</i></b>");

				String infantLNameElement = "(//input[contains(@id,'txt_lastnameInf')])[" + i + "]";
				QaRobot.PassValueByLocator(infantLNameElement, Lcname, "<b><i>Write Last Name For Infant</i></b>");
				
				String DateSelection[] = InfantDOBdate.split(",");
				String DateS[]= DateSelection[i - 1].split("-");
				String Dcname = DateS[0];
				String Mcname = DateS[1];
				String Ycname = DateS[2];
				
				String currentMonthNumber = "0";
				 if (Mcname.equalsIgnoreCase("Jan")) {
		               currentMonthNumber = "01";
		           } else if (Mcname.equalsIgnoreCase("Feb")) {
		               currentMonthNumber = "02";
		           } else if (Mcname.equalsIgnoreCase("Mar")) {
		               currentMonthNumber = "03";
		           } else if (Mcname.equalsIgnoreCase("Apr")) {
		               currentMonthNumber = "04";
		           } else if (Mcname.equalsIgnoreCase("May")) {
		               currentMonthNumber = "05";
		           } else if (Mcname.equalsIgnoreCase("Jun")) {
		               currentMonthNumber = "06";
		           } else if (Mcname.equalsIgnoreCase("Jul")) {
		               currentMonthNumber = "07";
		           } else if (Mcname.equalsIgnoreCase("Aug")) {
		               currentMonthNumber = "08";
		           } else if (Mcname.equalsIgnoreCase("Sep")) {
		        	   currentMonthNumber = "09";
		           } else if (Mcname.equalsIgnoreCase("Oct")) {
		               currentMonthNumber = "10";
		           } else if (Mcname.equalsIgnoreCase("Nov")) {
		               currentMonthNumber = "11";
		           } else if (Mcname.equalsIgnoreCase("Dec")) {
		               currentMonthNumber = "12";
		           }
				 
				LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
				LocalDate today = LocalDate.now();
				
				if (date.isAfter(today.minusYears(2))) 
				{
					String infantdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateInf_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(infantdayElement,Dcname, "<b><i>Select Day For Infant</i></b>");

					String infantmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateInf_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(infantmonthElement,Mcname, "<b><i>Select Month For Infant</i></b>");

					String infantyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateInf_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(infantyearElement,Ycname,"<b><i>Select Year of Infant</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Infant Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Infant Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
				
				String infantTravellingWith = "(//select[contains(@id,'ctl00_contentMain_ddl_travell_with')])[" + i + "]";
				String[] infantTW = InfantTravellingwith.split(",");
				QaRobot.selectTextByLocator(infantTravellingWith, infantTW[i - 1],"<b><i>Select Room For Infant</i></b>");
			}
			else if (Trip.equalsIgnoreCase("International"))
			{
				String infantTitleElement = "(//select[contains(@id,'ctl00_contentMain_ddl_titleInf')])[" + i + "]";
				String[] infanttitle =InfantTitle.split(",");
				QaRobot.selectValueByLocator(infantTitleElement, infanttitle[i - 1],"<b><i>Select Title For Infant</i></b>");

				String NameSelection[] = InfantName.split(",");
				String NameS[]= NameSelection[i-1].split(" ");
				String Fcname = NameS[0];
				String Lcname = NameS[1];
				
				String infantNameElement = "(//input[contains(@id,'txt_firstNameInf')])[" + i + "]";
				QaRobot.PassValueByLocator(infantNameElement, Fcname, "<b><i>Write Name For Infant</i></b>");

				String infantLNameElement = "(//input[contains(@id,'txt_lastnameInf')])[" + i + "]";
				QaRobot.PassValueByLocator(infantLNameElement, Lcname, "<b><i>Write Last Name For Infant</i></b>");
				
				String DateSelection[] = InfantDOBdate.split(",");
				String DateS[]= DateSelection[i - 1].split("-");
				String Dcname = DateS[0];
				String Mcname = DateS[1];
				String Ycname = DateS[2];
				
				String currentMonthNumber = "0";
				 if (Mcname.equalsIgnoreCase("Jan")) {
		               currentMonthNumber = "01";
		           } else if (Mcname.equalsIgnoreCase("Feb")) {
		               currentMonthNumber = "02";
		           } else if (Mcname.equalsIgnoreCase("Mar")) {
		               currentMonthNumber = "03";
		           } else if (Mcname.equalsIgnoreCase("Apr")) {
		               currentMonthNumber = "04";
		           } else if (Mcname.equalsIgnoreCase("May")) {
		               currentMonthNumber = "05";
		           } else if (Mcname.equalsIgnoreCase("Jun")) {
		               currentMonthNumber = "06";
		           } else if (Mcname.equalsIgnoreCase("Jul")) {
		               currentMonthNumber = "07";
		           } else if (Mcname.equalsIgnoreCase("Aug")) {
		               currentMonthNumber = "08";
		           } else if (Mcname.equalsIgnoreCase("Sep")) {
		        	   currentMonthNumber = "09";
		           } else if (Mcname.equalsIgnoreCase("Oct")) {
		               currentMonthNumber = "10";
		           } else if (Mcname.equalsIgnoreCase("Nov")) {
		               currentMonthNumber = "11";
		           } else if (Mcname.equalsIgnoreCase("Dec")) {
		               currentMonthNumber = "12";
		           }
				 
				LocalDate date = LocalDate.of(Integer.parseInt(Ycname), Integer.parseInt(currentMonthNumber), Integer.parseInt(Dcname));
				LocalDate today = LocalDate.now();
				
				if (date.isAfter(today.minusYears(2))) 
				{
					String infantdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateInf_ddlDay')])[" + i + "]";
					QaRobot.selectTextByLocator(infantdayElement,Dcname, "<b><i>Select Day For Infant</i></b>");

					String infantmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateInf_ddlMonth')])[" + i + "]";
					QaRobot.selectTextByLocator(infantmonthElement,Mcname, "<b><i>Select Month For Infant</i></b>");

					String infantyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_birthDateInf_ddlYear')])[" + i + "]";
					QaRobot.selectValueByLocator(infantyearElement,Ycname,"<b><i>Select Year of Infant</i></b>");
				}
				else
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Infant Date Selection</i></b>"+" - "+Dcname+"-"+Mcname+"-"+Ycname);
					throw new DnataExceptionClass("Invalid Infant Date Selection"+" : "+Dcname+"-"+Mcname+"-"+Ycname);
				}
				
				String infantTravellingWith = "(//select[contains(@id,'ctl00_contentMain_ddl_travell_with')])[" + i + "]";
				String[] infantTW = InfantTravellingwith.split(",");
				QaRobot.selectTextByLocator(infantTravellingWith, infantTW[i - 1],"<b><i>Select Room For Infant</i></b>");
				
				String infantpassportElement = "(//input[contains(@id,'txt_passportInf')])[" + i + "]";
				String[] inafnttpass = InfantPassportNumber.split(",");
				QaRobot.PassValueByLocator(infantpassportElement, inafnttpass[i - 1],"<b><i>Entered Passport Number For Infant</i></b>" + i + "");
				Thread.sleep(2000);
				
				String infantpasscountryElement = "(//select[contains(@id,'ctl00_contentMain_ddl_passCountryInf')])[" + i + "]";
				String[] infantpc = InfantPassportcountry.split(",");
				QaRobot.selectTextByLocator1(infantpasscountryElement, infantpc[i - 1], "<b><i>Selected Passport Country For Infant</i></b>");
				Thread.sleep(2000);
				
				String DateSelection1[] = InfantPassportDate.split(",");
				String DateS1[]= DateSelection1[i - 1].split("-");
				String Dcname1 = DateS1[0];
				String Mcname1 = DateS1[1];
				String Ycname1 = DateS1[2];
				
				String infantEdayElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateInf_ddlDay')])[" + i + "]";
				QaRobot.selectTextByLocator(infantEdayElement,Dcname1, "<b><i>Select Day For Infant</i></b>");

				String infantEmonthElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateInf_ddlMonth')])[" + i + "]";
				QaRobot.selectTextByLocator(infantEmonthElement,Mcname1, "<b><i>Select Month For Infant</i></b>");

				String infantEyearElement = "(//select[contains(@id,'ctl00_contentMain_txt_ex_dateInf_ddlYear')])[" + i + "]";
				QaRobot.selectValueByLocator(infantEyearElement,Ycname1,"<b><i>Select Year of Infant</i></b>");
				
				String infantnationalityElement = "(//select[contains(@id,'ctl00_contentMain_ddl_nationalityInf')])[" + i + "]";
				String[] infantnat = InfantNationality.split(",");
				QaRobot.selectTextByLocator1(infantnationalityElement, infantnat[i - 1], "<b><i>Selected Nationality For Infant</i></b>");
				Thread.sleep(2000);
			}
		}
		QaRobot.ScreenshotMethod("InfantDetails","<b><i>Screenshot for Infant Details</i></b>");
		QaExtentReport.extentScreenshot("Infant Details");
	}
	
	public static void GuestDetailsCheckoutFlight_Hotel() throws Exception 
	{
		WebElement OMoreDetails = QaBrowser.driver.findElement(By.xpath("//div[@class='Mobilediv_class']//div[2]//div[10]//ul[1]//li[1]//a[1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
		js1.executeScript("arguments[0].click()", OMoreDetails);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("More Details");
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) 
		{
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
		
		WebElement OMoreDetailsClose = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", OMoreDetailsClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on OMoreDetailsClose</i></b>");
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().window(ParentWindow);
		
		WebElement ORuleBaggage = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[5]/div[2]/div[2]/div[10]/ul/li[2]/a"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", ORuleBaggage);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Rule Baggage</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Rule Baggage");
		QaRobot.ScreenshotMethod("RuleBaggage","<b><i>Screenshot for Rule Baggage</i></b>");
		
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) 
		{
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		
		WebElement ORuleBaggageClose = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
		js4.executeScript("arguments[0].click()", ORuleBaggageClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on OMoreDetailsClose</i></b>");
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().window(ParentWindow);
		
		WebElement IMoreDetails = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[5]/div[2]/div[4]/div[10]/ul/li[1]/a"));
		JavascriptExecutor js5 = (JavascriptExecutor) QaBrowser.driver;
		js5.executeScript("arguments[0].click()", IMoreDetails);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("More Details");
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) 
		{
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		
		WebElement IMoreDetailsClose = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js6 = (JavascriptExecutor) QaBrowser.driver;
		js6.executeScript("arguments[0].click()", IMoreDetailsClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on OMoreDetailsClose</i></b>");
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().window(ParentWindow);
		
		WebElement IRuleBaggage = QaBrowser.driver.findElement(By.xpath("//div[@id='ctl00_contentMain_incartDiv']/div[5]/div[2]/div[4]/div[10]/ul/li[2]/a"));
		JavascriptExecutor js7 = (JavascriptExecutor) QaBrowser.driver;
		js7.executeScript("arguments[0].click()", IRuleBaggage);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on Rule Baggage</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Rule Baggage");
		QaRobot.ScreenshotMethod("RuleBaggage","<b><i>Screenshot for Rule Baggage</i></b>");
		
		String ParentWindow3 = QaBrowser.driver.getWindowHandle();
		Set<String> handles3 = QaBrowser.driver.getWindowHandles();
		for (String childWindow3 : handles3) 
		{
			if (!childWindow3.equals(ParentWindow3))
				QaBrowser.driver.switchTo().window(childWindow3);
		}
		
		WebElement IRuleBaggageClose = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js8 = (JavascriptExecutor) QaBrowser.driver;
		js8.executeScript("arguments[0].click()", IRuleBaggageClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on OMoreDetailsClose</i></b>");
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().window(ParentWindow);
		
		WebElement HMoreDetails = QaBrowser.driver.findElement(By.xpath("//a[@id='htlDetailMainDiv']"));
		JavascriptExecutor js9 = (JavascriptExecutor) QaBrowser.driver;
		js9.executeScript("arguments[0].click()", HMoreDetails);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("More Details");
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
		for (String childWindow4 : handles4) 
		{
			if (!childWindow4.equals(ParentWindow4))
				QaBrowser.driver.switchTo().window(childWindow4);
		}
		
		WebElement HMoreDetailsClose = QaBrowser.driver.findElement(By.xpath("//a[@title='Close']"));
		JavascriptExecutor js10 = (JavascriptExecutor) QaBrowser.driver;
		js10.executeScript("arguments[0].click()", HMoreDetailsClose);
		QaExtentReport.test.log(Status.INFO, "<b><i>Click on OMoreDetailsClose</i></b>");
		Thread.sleep(3000);
		QaBrowser.driver.switchTo().window(ParentWindow);
	}
	
	public static void GuestBillingDetailsCheckoutFlight_Hotel(String BillingTitle, String BillingUserName, String BillingAddress,String BillingCountry,String BillingCity) throws Exception 
	{
		String BTitle = "//select[@id='ctl00_contentMain_ddl_titleAdt']";
		QaRobot.selectTextByLocator1(BTitle, BillingTitle,"<b><i>Select Billing User Title</i></b>");
		Thread.sleep(2000);
		
		String NameSelection[] = BillingUserName.split(" ");
		String BFname = NameSelection[0];
		String BLname = NameSelection[1];
		
		QaRobot.PassValue("BFNameFH",BFname);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing User First Name</i></b>");
		
		QaRobot.PassValue("BLNameFH",BLname);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing User Last Name</i></b>");
		
		QaRobot.PassValue("BAddressFH",BillingAddress);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing User Address</i></b>");
		
		String BCountry = "//select[@id='ctl00_contentMain_txt_country']";
		QaRobot.selectTextByLocator1(BCountry, BillingCountry,"<b><i>Select Country</i></b>");
		Thread.sleep(2000);
		
		String BCity[] = BillingCity.split(",");
		String BCode = BCity[0];
		String BLocation = BCity[1];
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divHTCity']/p"), BCode, BLocation,By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));
	
		QaRobot.ClickOnElement("chkExpediaTermsFH");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on chkExpediaTerms</i></b>");
		
		QaRobot.ClickOnElement("Terms_conditions");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on chkExpediaTerms</i></b>");
		
		QaRobot.ClickOnElement("Confirm");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Confirm</i></b>");
		Thread.sleep(20000);
		
		QaRobot.ScreenshotMethod("BillingDetails","<b><i>Screenshot for Billing Details</i></b>");
		QaExtentReport.extentScreenshot("Billing Details");
	}
}


