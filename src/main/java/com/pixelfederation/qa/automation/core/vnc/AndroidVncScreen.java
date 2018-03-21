package com.pixelfederation.qa.automation.core.vnc;

import com.pixelfederation.qa.automation.core.driver.DriverException;

public interface AndroidVncScreen {
    void pressBackButton() throws DriverException;

    void pressHomeButton() throws DriverException;

    void pressOverviewButton() throws DriverException;

    void detectOrientation() throws DriverException;
}