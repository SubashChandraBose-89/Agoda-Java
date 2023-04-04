package com.hrms.testscript;

import com.hrms.lib.General;

public class TC017 {
	public static void main(String[] args) throws Exception{
		General genObj = new General();
		genObj.openApplications();
		genObj.closePopup1();
		genObj.login();
		genObj.closePopup2();
		genObj.hotelSearchDay();
		genObj.selectHotel();
		genObj.bookHotelDay();
		genObj.customerInfo();
		genObj.paymentInfo();
		genObj.closeApplication();
	}

}
