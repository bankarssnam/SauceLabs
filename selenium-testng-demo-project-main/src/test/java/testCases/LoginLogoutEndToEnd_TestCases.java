package testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.util.Assert;
import pageObjectRepository.PageObjects;
import testData.TestDataProvider;

public class LoginLogoutEndToEnd_TestCases extends PageObjects {


	@Test(priority = 0, dataProvider="active-user-credentials", dataProviderClass = TestDataProvider.class)
	public void loginToApplication(String username, String password) {

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
	}

	@Test(priority = 1, dependsOnMethods = "loginToApplication")
	public void verifyProductPageTitle() {
		String actualTitle = productPage.getProductPageTitle();
		String expectedTitle = "Products";
		assertThat("The Title on Product page is expected.", actualTitle, is(expectedTitle));
		System.out.println("Verify title successful:"+actualTitle+" vs "+ expectedTitle);	
	}
	
//	demonstrates expected set of data taken from properties file.

	@Test(priority = 2, dependsOnMethods = "loginToApplication")
	public void verifyDowndownValuesOfSortOnProductsPage() throws InterruptedException {
		String abd[] = propObj.getPropertyValueByKey("expected_values_in_sort").split(",");
		List<String> expectedValues = Arrays.asList(abd);
		List<String> actualValues = productPage.getDropdownOptions_sort();
		assertThat("The Sort dropdown values are not as expected.", actualValues, contains(expectedValues.toArray()));
		System.out.println("The Sort dropdown values are :"+actualValues+" vs "+ expectedValues);
		Thread.sleep(5000);
		
	}

	@Test(priority = 3, dependsOnMethods = "verifyDowndownValuesOfSortOnProductsPage")
	public void selectDowndownValues() throws Exception {
		String visibleText = "Price (low to high)";
		productPage.selectOptionFromDropdown(visibleText);
		System.out.println("selectOptionFromDropdown :"+visibleText);
		Thread.sleep(5000);
		assertEquals(productPage.getPriceOfAllOptionsAndVerify(), true);
		
	}

	@Test(priority = 4, dependsOnMethods = "selectDowndownValues")
	public void addTwoItemsInCartRemoveOneCheckSummaryPage() throws Exception {
		String abd[] = propObj.getPropertyValueByKey("add_cart_options").split(",");
		List<String> expectedValues = Arrays.asList(abd);
		productPage.addToCartS(expectedValues.get(0));
		Thread.sleep(1000);
		productPage.addToCartS2(expectedValues.get(1));
		Thread.sleep(1000);
		productPage.clickshoppingCart();
		productPage.getshopingCartItemsNameAndVerify(expectedValues.get(0));
		Thread.sleep(1000);
		
		productPage.RemoveItemFromCheckout();
		Thread.sleep(2000);
		productPage.clickCheckoutButton();
		
		productPage.enterFirstName(propObj.getPropertyValueByKey("first_name"));
		productPage.enterLastname(propObj.getPropertyValueByKey("last_name"));
		productPage.enterZip(propObj.getPropertyValueByKey("zip_code"));
		productPage.clickContinue();
		
		productPage.summaryInformationLabel();
		productPage.finshOrder();
		
		productPage.successOrderVerification();
	}
	
	
	@Test(priority = 9, dependsOnMethods = "loginToApplication")
	public void logoutFromoApplication() throws InterruptedException {
		sideMenu.clickOnSideMenuToOpen();
		Thread.sleep(5000);
		sideMenu.clickLogout();
		System.out.println("Done Logged Out of the application :");
		Thread.sleep(5000);
	}
	/*@Test(priority = 10, dependsOnMethods = "loginToApplication")
	public void closeSessionAndQuiet() throws InterruptedException {
		driver.close();
		driver.quit();
		System.out.println("close browser and all session");
		Thread.sleep(5000);
	}*/
}
