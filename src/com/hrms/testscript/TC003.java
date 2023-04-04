package com.hrms.testscript;

import com.hrms.lib.General;

public class TC003 {
	public static void main(String[] args) throws Exception {
		General genObj = new General();
		genObj.openApplications();
		genObj.closePopup1();
		genObj.blankLogin();
		genObj.closeApplication();
	}

}
