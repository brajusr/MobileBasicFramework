package apidemo.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import apidemo.AppiumFramework.TestData;
import apidemo.AppiumFramework.base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preferences;

public class ApiDemoTest extends base {

	@Test(dataProvider = "InputData", dataProviderClass = TestData.class)
	public void apiDemoTest(String input) throws IOException, InterruptedException {

		service = startServer();

		AndroidDriver<AndroidElement> driver = capabilities("apiDemo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
		HomePage h = new HomePage(driver);
	

		h.Preferences.click();

		Preferences p = new Preferences(driver);
		// driver.findElementByXPath("//android.widget.TextView[@text='3. Preference
		// dependencies']").click();
		p.dependencies.click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys(input);
		// driver.findElementsByClassName("android.widget.Button").get(1).click();
		p.buttons.get(1).click();
		service.stop();

	}

}
