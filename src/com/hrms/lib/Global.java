package com.hrms.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global {
// std rule :  test data and objects for whole application
	public WebDriver driver;
//	public WebDriverWait wait;
	// test data
	public String url = "https://www.agoda.com/";
	public String validUserName = "subashchandrabose0289@gmail.com";
	public String validPassWord = "Jesus@777";
	public String invalidUserName = "Su@asd.com";
	public String invalidPassWord = "123qwerty";
	public String newFstname = "Satish";
	public String newLstname = "Bose";
	public String emailId = "satishkumar@gmail.com";
	public String crtPassword = "Jesus@123";
	public String confirmPassword = "Jesus@123";
	
	
	// objects
	public String txt_loginname = "email";
	public String txt_password = "password";
	public String btn_login = "//*[@class='sc-fzoiQi hsJTpM']";
	public String btn_create = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 kEwbED global-header-signup-button']";
	public String link_logout = "Logout";
	public String frame_emp = "rightMenu";
	public String add_emp = "//input[@value='Add']";
	public String first_name = "txtEmpFirstName";
	public String last_name = "txtEmpLastName";
	public String btn_save = "btnEdit";
	public String emp_name = "Suresh sir Selenium";
	public String btn_edit = "//input[@id='btnEditPers']";
	public String editemp_fname = "//input[@value='Suresh sir']";
	public String editemp_lname = "//input[@value='Selenium']";
	public String newbtn_save = "//input[@id='btnEditPers']";
	public String dropdwn_name = "loc_code";
	public String emp_id = "Emp. ID";
	public String search_box = "loc_name";
	public String searchable_id = "0512";
	public String search_button = "//input[@value='Search']";
	public String check_box = "chkLocID[]";
	public String delete_btn = "//input[@value='Delete']";
	public String popup_close1 = "//button[@aria-label='Close Message']";
	public String popup_close2 = "ab-close-button";
	public String hh_nightstay = "Buttonstyled__ButtonStyled-sc-5gjk6l-0 dBEzsf"; 
	public String day_book = "//span[@class='DayPicker-Day__label'][@data-selenium-date='2023-04-01']";
	public String city_search = "textInput";
	public String chennai = "Chennai";
	public String select_Day = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 jyYkKC'][@data-element-name='time-selector-btn'][1]";
	public String dayusestay = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 blZwOh'][@data-element-name='funnel-switcher']";
	public String logoutmain = "//div[@class='UserMenustyled__UserMenuDisplay-sc-14cll85-1 hJSdLP'][@data-element-name='user-menu']";
	public String logoutBtn = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 jxFsnW'][@data-element-name='sign-out-btn']";
	public String booknowBtn = "//button[@class='ChildRoomsList-bookButtonInput'][@data-element-master-room-id='3343939']";
	public String registerBtn = "//button[@data-element-crossedout-rate='19999'][@data-element-master-room-id='15157221'][1]";
	public String select_hotel = "//h3[@data-selenium='hotel-name']";
	public String select_chennai = "//li[@class='Suggestion Suggestion__categoryName'][@data-text='Chennai'][@data-element-search-type='1']";
	public String night_book = "//div[@aria-label='Fri Feb 21 2023']";
	public String adultroom_select = "//div[@class='TravellerSegment TravellerSegment--active']";
	public String noofroom_select = "//div[@id='occupancy-box']";
	public String hotelsearch_button = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 hKHQVh Box-sc-kv6pi1-0 fDMIuA']";
	public String confirmroom_click = "//div[@class='SearchBoxTextDescription SearchBoxTextDescription--occupancy']";
	public String book_from = "//span[@class='PriceSurgePicker-Day__label PriceSurgePicker-Day__label--wide' and text()='20']";
	public String book_to = "//span[@class='PriceSurgePicker-Day__label PriceSurgePicker-Day__label--wide' and text()='26']";
	public String hotel_popup = "//span[@class='Spanstyled__SpanStyled-sc-16tp9kb-0 kkSkZk kite-js-Span'][1]";
	public String nextfinalstep = "//button[@class='Buttonstyled__ButtonStyled-sc-5gjk6l-0 kQOJVT sc-pZOBi gagPGR']";
	public String nosmoking = "//span[@class='Radio__radioIcon--11Vjw']";
	public String carddrpdwn = "//div[@class='Box-sc-kv6pi1-0 Selectstyled__SelectHeader-sc-1vfjv54-0 doiZyA Box-sc-kv6pi1-0 iSZIoo'][@tabindex='0']";
	public String selectRS = "//select[@class='Selectstyled__StyledSelect-sc-h8hbk-0 eAcHDu kite-js-Select ']";
}
