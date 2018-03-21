package com.pixelfederation.qa.automation.core.vnc;

import com.pixelfederation.qa.automation.core.driver.Driver;
import com.pixelfederation.qa.automation.core.PageObject;
import com.pixelfederation.qa.automation.core.driver.DriverException;

public final class VysorAndroidVncScreen extends PageObject implements AndroidVncScreen {
    public VysorAndroidVncScreen(Driver driver) {
        super(driver, "vysor_screen/");
    }

    @Override
    public void pressBackButton() throws DriverException {
        driver.clickImage("back_button");
        driver.wait(1.0);
    }

    @Override
    public void pressHomeButton() throws DriverException {
        driver.clickImage("home_button");
        driver.wait(1.0);
    }

    @Override
    public void pressOverviewButton() throws DriverException {
        driver.clickImage("overview_button");
        driver.wait(1.0);
    }

    @Override
    public void detectOrientation() throws DriverException {
        driver.resetToOriginRegion();

        String topLeftCornerImageName = "screen_top_left_corner";
        String bottomRightCornerImageName = "screen_bottom_right_corner_p";

        if (!driver.imageExists(bottomRightCornerImageName)) {
            bottomRightCornerImageName = "screen_bottom_right_corner_ls";
        }

        driver.changeRegion(topLeftCornerImageName, bottomRightCornerImageName);
    }
}