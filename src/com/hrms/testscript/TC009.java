package com.hrms.testscript;

import com.hrms.lib.General;

public class TC009 {
	public static void main(String[] args) throws Exception{
		General genObj = new General();
		genObj.openApplications();
		genObj.closePopup1();
		genObj.login();
		genObj.closePopup2();
		genObj.searchTest();
		genObj.logout();
	}
}
