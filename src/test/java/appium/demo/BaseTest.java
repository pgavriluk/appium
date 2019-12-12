package appium.demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {


    public static void main(String[] args){

        AndroidDriver<AndroidElement> androidDriver = getAndroidDriver();

        androidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        androidDriver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        androidDriver.findElementById("android:id/checkbox").click();
        androidDriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        androidDriver.findElementByClassName("android.widget.EditText").sendKeys("hello");
        androidDriver.findElementsByClassName("android.widget.Button").get(1).click();
    }

    private static AndroidDriver<AndroidElement> getAndroidDriver(){

        File file = new File("src/main/resources/ApiDemos-debug.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PieNexus6");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());

        try{
            return new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected static IOSDriver<IOSElement> getIOSDriver(){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/pavel/Library/Developer/Xcode/DerivedData/UICatalog-gustmuihhstsoqctexqdmwdbumlx/Build/Products/Debug-iphonesimulator/UICatalog.app");

        try {
            return new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
