package com.pixelfederation.qa.automation.core;

import com.pixelfederation.qa.automation.core.driver.Driver;
import com.pixelfederation.qa.automation.core.driver.SikuliXDriverWithImageDir;

public abstract class PageObject {
    protected final Driver driver;

    protected PageObject(Driver driver, String relativeImageDir) {
        this.driver = initDriver(driver, getAbsoluteImageDir(relativeImageDir));
    }

    protected Driver initDriver(Driver driver, String imageDir) {
        return new SikuliXDriverWithImageDir(driver, imageDir);
    }

    protected String getAbsoluteImageDir(String relativeObjImageDir) {
        String baseImagDir = getClass().getResource("").getPath();

        baseImagDir = baseImagDir.replace("classes/java", "resources");
        baseImagDir = baseImagDir.replace("libs/core.jar!", "resources/main");
        baseImagDir = baseImagDir.replace("file:", "");
        if (baseImagDir.startsWith("/")) baseImagDir = baseImagDir.substring(1);

        return baseImagDir + relativeObjImageDir;
    }
}