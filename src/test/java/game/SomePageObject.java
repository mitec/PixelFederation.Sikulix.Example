package game;

import com.pixelfederation.qa.automation.core.PageObject;
import com.pixelfederation.qa.automation.core.driver.Driver;
import com.pixelfederation.qa.automation.core.driver.DriverException;

public class SomePageObject extends PageObject {
    public SomePageObject(Driver driver) {
        super(driver, "some_page_object_path/");
    }

    public void doSomeAction(String imageName) throws DriverException {
        // todo: do some action here, for example: driver.clickImage, driver.verifyImageExists, ...

        String imagePath = getAbsoluteImageDir("some_page_object_path/") + imageName;

        System.out.print("full image path based on page object path + some_page_object_path/ + imageName = " + imagePath);
    }
}