package ObjectConfigInputs;

public class ObjectConfigClass {
	//Configurable Variable
	public static final String testSiteURL="https://in.yahoo.com/";
	public static final String sheetName="LoginPage";
	
	public static String server="plus.smtp.mail.yahoo.com";
	public static String from = "vaikuntam.malini@yahoo.com"; //enter your username
	public static String password = "Dec$2017"; //enter your password
	public static String[] to ={"v_malini@rocketmail.com"};
	public static String subject = "Test Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath=System.getProperty("user.dir")+"\\target\\surefire-reports\\emailable-report.html";
	public static String attachmentName="Report.html";
	
	//Object Repository
	public static final String signInFrist="//*[@id='uh-signin']";
	public static final String usernameObj="//*[@id='login-username']";
	public static final String nextObj= "//*[@id='login-signin'][@value='Next']";
	public static final String passwordObj="//*[@id='login-passwd']";
	public static final String signInObj= "//*[@id='login-signin']";
	public static final String userName="//div[@id='mega-uh']/ul/li[@id='uh-profile']/button/span[text()='Malini']";		
	public static final String signOutObj="//*[@id='uh-signout']";
	public static final String addAccountObj="//*[@id='manage-account']/a";
	
	
	

}
