package pageObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import org.openqa.selenium.devtools.v113.css.model.SelectorList;
//import org.openqa.selenium.devtools.v131.css.model.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.TestBase;
import utils.SelectDropdown;

public class ProductPageObjects {

	@FindBy(className = "title")
	WebElement txt_productPageTitle;
	@FindBy(className = "product_sort_container")
	WebElement dropDown_productSortContainer;
	@FindBy(className = "inventory_item_price")
	List<WebElement> inventory_item_price;
	@FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']/../../..//button[text()='Add to cart']")
	WebElement addToCart1;
	@FindBy(xpath = "//div[@class='inventory_item_name ' and text()='Sauce Labs Bike Light']/../../..//button[text()='Add to cart']")
	WebElement addToCart2;
	

	@FindBy(className = "shopping_cart_link")
	WebElement shoppingCartLink;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> shopingCartItemsName;
	@FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']/../..//button[text()='Remove']")
	WebElement removeItem;
	@FindBy(xpath = "//*[@id='checkout']")
	WebElement checkoutButton;
	
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	@FindBy(xpath = "//*[@id='last-name']")
	WebElement lastName;
	@FindBy(xpath = "//*[@id='postal-code']")
	WebElement zippCode;
	@FindBy(xpath = "//*[@id='continue']")
	WebElement continueE;
	@FindBy(xpath = "//*[@id='finish']")
	WebElement finish;
	
	@FindBy(className = "summary_info_label")
	List<WebElement> summary_info_labelList;
	@FindBy(className = "summary_value_label")
	List<WebElement> summary_value_labelList;
	
	
	@FindBy(className = "inventory_item_name")
	List<WebElement> inventory_item_nameS;
	@FindBy(className = "inventory_item_desc")
	List<WebElement> inventory_item_descS;
	@FindBy(className = "inventory_item_price")
	List<WebElement> inventory_item_priceS;
	
	@FindBy(xpath = "//h2[contains(text(),'Thank you for your order')]")
	WebElement successOrderVerification;
	
	
	public ProductPageObjects(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	public String getProductPageTitle() {
		return txt_productPageTitle.getText();
	}

	public List<String> getDropdownOptions_sort() {
		return SelectDropdown.getSelectClassObject().setSelectObject(dropDown_productSortContainer)
				.getDropdownOptionsAsList();
	}

	public void selectOptionFromDropdown(String visibleText) throws Exception {
		SelectDropdown.getSelectClassObject().setSelectObject(dropDown_productSortContainer)
		.selectDropdownOption(visibleText);
	}
	public boolean getPriceOfAllOptionsAndVerify() {

		boolean verify=true;
		System.out.println("loop size:"+inventory_item_price.size());
		double temp=0.00;
		for(int j=0;j<inventory_item_price.size();j++) {	

			try {
				System.out.println("Inside value loops:"+j+":"+inventory_item_price.get(j).getText());
				String value=inventory_item_price.get(j).getText();
				value=value.replace("$","");
				value=value.replace(" ","");
				double  val=Double.parseDouble(value);

				val=Double.parseDouble(value);
				System.out.println("\\nThe Sort dropdown values:"+val);
				if(temp>val) {
					verify=false;
				}
				temp=val;
			} catch (Exception e) {
				// TODO: handle exception
			}	

		}		

		return verify;
	}
	public boolean addToCartS(String elementAdd) {
		addToCart1.click();
		return true;
	}
	public boolean addToCartS2(String elementAdd) {
		addToCart2.click();
		return true;
	}
	
	public boolean clickshoppingCart() {
		shoppingCartLink.click();
		return true;
	}
	public  boolean getshopingCartItemsNameAndVerify(String elementAdded) {

		boolean verify=false;
		System.out.println("element added:" +elementAdded+"loop size:"+shopingCartItemsName.size());
		for(int j=0;j<shopingCartItemsName.size();j++) {			
			try {
				System.out.println("Inside value loops:"+j+":"+shopingCartItemsName.get(j).getText());
				if(shopingCartItemsName.get(j).getText().equals(elementAdded)) {
					verify=true;
				}				
			} catch (Exception e) {
				// TODO: handle exception
			}			
		}			
		return verify;
	}
	public boolean RemoveItemFromCheckout() {
		removeItem.click();
		return true;
	}
	public boolean clickCheckoutButton() {
		checkoutButton.click();
		return true;
	}
	public boolean enterFirstName(String fName) {
		firstName.sendKeys(fName);
		return true;
	}
	public boolean enterLastname(String lName) {
		lastName.sendKeys(lName);
		return true;
	}
	public boolean enterZip(String zipCode) {
		zippCode.sendKeys(zipCode);
		return true;
	}
	public boolean clickContinue() {
		continueE.click();
		return true;
	}
	public boolean finshOrder() {
		finish.click();
		return true;
	}
	public  boolean summaryInformationLabel() {
		boolean verify=false;
		System.out.println("loop size summary information:"+summary_info_labelList.size());
		try {
			for(int j=0;j<summary_info_labelList.size();j++) {			
				System.out.println("summary_info_labelList:"+j+":"+summary_info_labelList.get(j).getText());
				System.out.println("summary_value_labelList:"+j+":"+summary_value_labelList.get(j).getText());
			}
			for(int j=0;j<inventory_item_nameS.size();j++) {	
				System.out.println("inventory_item_nameS:"+j+":"+inventory_item_nameS.get(j).getText());
				System.out.println("inventory_item_descS:"+j+":"+inventory_item_descS.get(j).getText());
				System.out.println("inventory_item_priceS:"+j+":"+inventory_item_priceS.get(j).getText());
			    verify=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
					
		return verify;
	}
	public boolean successOrderVerification() {
		if(successOrderVerification.isDisplayed()) {
			return true;
		}
		return false;
	}
  
}
