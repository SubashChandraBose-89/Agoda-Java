package com.hrms.testscript;

import com.hrms.lib.General;

public class TC001 {

	public static void main(String[] args) throws Exception {
		General genObj = new General();
		genObj.openApplications();
		genObj.closePopup1();
		genObj.signINCheck();
		genObj.closeApplication();
	}
}