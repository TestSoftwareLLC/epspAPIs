/**
	 * grace tshihata
	 */
package readers;

import java.io.IOException;
import java.net.MalformedURLException;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlImageInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;


public class CoreHtmlUnit {

	private HtmlPage currentPage;
	private WebClient webClient;
	//HtmlButton htmlButton;
	HtmlForm htmlForm;
	HtmlElement htmlElement;
	HtmlPage htmlPage = null;


	public HtmlPage getCurrentPage() {
		return currentPage;
	}

	public void setInputValue(String inputId, String textValue) {
		webClient.waitForBackgroundJavaScript(3000);
		HtmlTextInput input = (HtmlTextInput) currentPage.getElementById(inputId);
		while (input != null) {
			webClient.waitForBackgroundJavaScript(100);
			input = (HtmlTextInput) currentPage.getElementById(inputId);
			input.setValueAttribute(textValue);
		}

	}

	public CoreHtmlUnit(String pageAddress) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		this();
		this.goToAddress(pageAddress);
	}

	public CoreHtmlUnit() {
		// TODO Auto-generated constructor stub
	}

	public void goToAddress(String pageAddress)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		WebClient client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setJavaScriptEnabled(true);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setThrowExceptionOnFailingStatusCode(false);

		client = webClient.getPage(pageAddress);
		// String myTitle = client.getTitleText();
		// System.out.println(myTitle);

	}

	/**
	 * 
	 * @param buttonId
	 *            Button id
	 * @throws IOException
	 */
	public void clickImageButton(String xpathExpr) throws IOException {
		HtmlImageInput button = (HtmlImageInput) currentPage.getFirstByXPath(xpathExpr);
		currentPage = (HtmlPage) button.click();
	}

	/**
	 * 
	 * @param radioButtonId
	 * @param radioButtonOption
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void selectRadioButton(String radioButtonId, String radioButtonOption)
			throws IOException, InterruptedException {
		final HtmlInput radio = (HtmlInput) currentPage.getElementById(radioButtonId);
		radio.click();
		Thread.sleep(10000);
	}

	/**
	 * 
	 * @param dropListId
	 * @param dropListOption
	 */
	public void selectDropList(String dropListId, String dropListOption) {
		HtmlSelect select = (HtmlSelect) currentPage.getElementById(dropListId);
		HtmlOption option = select.getOptionByValue(dropListOption);
		select.setSelectedAttribute(option, true);
	}

	public static void main(String[] args) throws IOException {
		CoreHtmlUnit bot = new CoreHtmlUnit("http://www.amazon.com");
		bot.selectDropList("searchDropdownBox", "search-alias=stripbooks");
		bot.setInputValue("twotabsearchtextbox", "java");
		bot.clickImageButton("//div[@id='navGoButton']/input");
		bot.getCurrentPage().getTitleText();
	}

	public void clickButton(String myid) throws IOException {
		HtmlImageInput button = (HtmlImageInput) currentPage.getElementById(myid);
		currentPage = (HtmlPage) button.click();

	}

	
	public void htmlFormForCreateAccount(String pageUrl,String formId, String emailId, String emailAddress, String passwordId,
			String password, String loginBtnId) {
		System.out.println(pageUrl);
		try (final WebClient webClient = new WebClient()) {
			try {
				WebClient client = new WebClient(BrowserVersion.CHROME);
				client.getOptions().setJavaScriptEnabled(false);
				client.getOptions().setThrowExceptionOnScriptError(false);
				client.getOptions().setThrowExceptionOnFailingStatusCode(false);
				webClient.setCssErrorHandler(new SilentCssErrorHandler());
				CookieManager cookieMan = new CookieManager();
				cookieMan = webClient.getCookieManager();
				cookieMan.setCookiesEnabled(true);
				System.out.println(pageUrl);

				HtmlPage page = client.getPage(pageUrl);
				//getting form / Loading form element
				
				HtmlForm form = (HtmlForm) page.getElementById(formId);
				
				System.out.println("Got FORM");
				// passing form field data
				form.getInputByName(emailId).setValueAttribute(emailAddress);
				System.out.println("Wrote Email to FORM");
				form.getInputByName(passwordId).setValueAttribute(password);
				System.out.println("Wrote PassWord to FORM");
				String in = (String) form.getInputByValue("Log In").asXml();
				System.out.println(in);
				HtmlSubmitInput submit = (HtmlSubmitInput) form
	                    .getElementsByAttribute("input", "type", "submit")
	                    .get(0);
				page = submit.click();
//				HtmlButton htmlButton = (HtmlButton) form.getByXPath(loginBtnId);
//		        page = (HtmlPage) htmlButton.click();
				
				
				String myTitle = page.getTitleText();
				System.out.println(myTitle);
				
				System.out.println(page.asText());
			} catch (FailingHttpStatusCodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// final HtmlDivision div = page.getHtmlElementById("some_div_id");
			// final HtmlAnchor anchor = page.getAnchorByName("anchor_name");
		}
		
		
		

	}
	
	
	
/*HtmlPage htmlPage = null;
    HtmlElement htmlElement;
    WebClient webClient = null;
    HtmlButton htmlButton;
    HtmlForm htmlForm;
    try{

        // Create and initialize WebClient object
        webClient = new WebClient(BrowserVersion.FIREFOX_17 );
        webClient.setCssEnabled(false);
        webClient.setJavaScriptEnabled(false);
        webClient.setThrowExceptionOnFailingStatusCode(false);
        webClient.setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setUseInsecureSSL(true);
        webClient.getCookieManager().setCookiesEnabled(true);

        /*webClient.setRefreshHandler(new RefreshHandler() {
            public void handleRefresh(Page page, URL url, int arg) throws IOException {
                 System.out.println("handleRefresh");
            }

        });

         htmlPage = webClient.getPage("http://www.meetme.com");
         htmlForm = htmlPage.getFirstByXPath("//form[@action='https://ssl.meetme.com/login']");

         htmlForm.getInputByName("username").setValueAttribute("blah@gmail.com");
         htmlForm.getInputByName("password").setValueAttribute("blah");

         //Signing in
         htmlButton = htmlForm.getElementById("login_form_submit");
         htmlPage = (HtmlPage) htmlButton.click();

         htmlPage = webClient.getPage("http://www.meetme.com/member/1234567890");

         System.out.println("BEFORE CLICK");
         System.out.println(htmlPage.asText());


         //type message in text area
         HtmlTextArea commentArea = (HtmlTextArea)htmlPage.getFirstByXPath("//textarea[@id='profileQMBody']");
         commentArea.setText("Testing");        


         htmlButton = (HtmlButton) htmlPage.getHtmlElementById("profileQMSend");
         htmlPage = (HtmlPage)htmlButton.click();
         webClient.waitForBackgroundJavaScript(7000);

         //The print is exactly the same as the BEFORE CLICK print
         System.out.println("AFTER CLICK");
         System.out.println(htmlPage.asText());

      }catch(ElementNotFoundException e){
        e.printStackTrace();
      }catch(Exception e){
        e.printStackTrace();
      }*/
}
