package com.pixelfederation.qa.automation.core.driver;

public final class SikuliXDriverWithImageDir implements Driver {
    private final Driver driver;
    private final String imageBaseDir;

    public SikuliXDriverWithImageDir(Driver driver, String imageBaseDir) {
        this.driver = driver;
        this.imageBaseDir = imageBaseDir;
    }

    @Override
    public Driver clone(String topLeftImagePath, String bottomRightImagePath) throws DriverException {
        Driver clonedDriver = driver.clone(fullImagePath(topLeftImagePath), fullImagePath(bottomRightImagePath));

        return new SikuliXDriverWithImageDir(clonedDriver, imageBaseDir);
    }

    @Override
    public Driver clone(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException {
        Driver clonedDriver = driver.clone(fullImagePath(topLeftImagePath), fullImagePath(bottomRightImagePath), minSimilarity);

        return new SikuliXDriverWithImageDir(clonedDriver, imageBaseDir);
    }

    @Override
    public void changeRegion(String topLeftImagePath, String bottomRightImagePath) throws DriverException {
        driver.changeRegion(fullImagePath(topLeftImagePath), fullImagePath(bottomRightImagePath));
    }

    @Override
    public void changeRegion(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException {
        driver.changeRegion(fullImagePath(topLeftImagePath), fullImagePath(bottomRightImagePath), minSimilarity);
    }

    @Override
    public void resetToOriginRegion() {
        driver.resetToOriginRegion();
    }

    @Override
    public void wait(double timeout) {
        driver.wait(timeout);
    }

    @Override
    public void verifyImageDisappears(String imagePath, double timeout) throws DriverException {
        driver.verifyImageDisappears(fullImagePath(imagePath), timeout);
    }

    @Override
    public void verifyImageDisappears(String imagePath, float minSimilarity) throws DriverException {
        driver.verifyImageDisappears(fullImagePath(imagePath), minSimilarity);
    }

    @Override
    public void verifyImageDisappears(String imagePath, double timeout, float minSimilarity) throws DriverException {
        driver.verifyImageDisappears(fullImagePath(imagePath), timeout, minSimilarity);
    }

    @Override
    public void clickImage(String imagePath) throws DriverException {
        driver.clickImage(fullImagePath(imagePath));
    }

    @Override
    public void clickImage(String imagePath, double timeout) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), timeout);
    }

    @Override
    public void clickImage(String imagePath, int offsetX, int offsetY) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), offsetX, offsetY);
    }

    @Override
    public void clickImage(String imagePath, float minSimilarity) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), minSimilarity);
    }

    @Override
    public void clickImage(String imagePath, double timeout, int offsetX, int offsetY) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), timeout, offsetX, offsetY);
    }

    @Override
    public void clickImage(String imagePath, double timeout, float minSimilarity) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), timeout, minSimilarity);
    }

    @Override
    public void clickImage(String imagePath, int offsetX, int offsetY, float minSimilarity) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), offsetX, offsetY, minSimilarity);
    }

    @Override
    public void clickImage(String imagePath, double timeout, int offsetX, int offsetY, float minSimilarity) throws DriverException {
        driver.clickImage(fullImagePath(imagePath), timeout, offsetX, offsetY, minSimilarity);
    }

    @Override
    public boolean imageExists(String imagePath) throws DriverException {
        return driver.imageExists(fullImagePath(imagePath));
    }

    @Override
    public boolean imageExists(String imagePath, double timeout) throws DriverException {
        return driver.imageExists(fullImagePath(imagePath), timeout);
    }

    @Override
    public boolean imageExists(String imagePath, float minSimilarity) throws DriverException {
        return driver.imageExists(fullImagePath(imagePath), minSimilarity);
    }

    @Override
    public boolean imageExists(String imagePath, double timeout, float minSimilarity) throws DriverException {
        return driver.imageExists(fullImagePath(imagePath), timeout, minSimilarity);
    }

    @Override
    public void verifyImageExists(String imagePath) throws DriverException {
        driver.verifyImageExists(fullImagePath(imagePath));
    }

    @Override
    public void verifyImageExists(String imagePath, double timeout) throws DriverException {
        driver.verifyImageExists(fullImagePath(imagePath), timeout);
    }

    @Override
    public void verifyImageExists(String imagePath, float minSimilarity) throws DriverException {
        driver.verifyImageExists(fullImagePath(imagePath), minSimilarity);
    }

    @Override
    public void verifyImageExists(String imagePath, double timeout, float minSimilarity) throws DriverException {
        driver.verifyImageExists(fullImagePath(imagePath), timeout, minSimilarity);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths) throws DriverException {
        driver.verifyImagesExist(fullImagesPath(imagePaths));
    }

    @Override
    public void verifyImagesExist(String[] imagePaths, double timeout) throws DriverException {
        driver.verifyImagesExist(fullImagesPath(imagePaths), timeout);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths, float minSimilarity) throws DriverException {
        driver.verifyImagesExist(fullImagesPath(imagePaths), minSimilarity);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths, double timeout, float minSimilarity) throws DriverException {
        driver.verifyImagesExist(fullImagesPath(imagePaths), timeout, minSimilarity);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY) throws DriverException {
        driver.dragImage(fullImagePath(imagePath), dragOffsetX, dragOffsetY);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, double timeout) throws DriverException {
        driver.dragImage(fullImagePath(imagePath), dragOffsetX, dragOffsetY, timeout);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, float minSimilarity) throws DriverException {
        driver.dragImage(fullImagePath(imagePath), dragOffsetX, dragOffsetY, minSimilarity);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, double timeout, float minSimilarity) throws DriverException {
        driver.dragImage(fullImagePath(imagePath), dragOffsetX, dragOffsetY, timeout, minSimilarity);
    }

    @Override
    public void dragScreen(int startOffsetX, int startOffsetY, int dragOffsetX, int dragOffsetY) throws DriverException {
        driver.dragScreen(startOffsetX, startOffsetY, dragOffsetX, dragOffsetY);
    }

    @Override
    public void dragScreen(double startOffsetX, double startOffsetY, double endOffsetX, double endOffsetY) throws DriverException {
        driver.dragScreen(startOffsetX, startOffsetY, endOffsetX, endOffsetY);
    }

    @Override
    public void dragScreenAroundCenter(int dragOffsetX, int dragOffsetY) throws DriverException {
        driver.dragScreenAroundCenter(dragOffsetX, dragOffsetY);
    }

    @Override
    public void mouseMoveToPosition(int x, int y) {
        driver.mouseMoveToPosition(x, y);
    }

    @Override
    public void mouseMoveToPositionFast(int x, int y) {
        driver.mouseMoveToPositionFast(x, y);
    }

    @Override
    public void mouseMove(int xOffset, int yOffset) {
        driver.mouseMove(xOffset, yOffset);
    }

    @Override
    public void mouseMoveFast(int xOffset, int yOffset) {
        driver.mouseMoveFast(xOffset, yOffset);
    }

    @Override
    public void type(String text) {
        driver.type(text);
    }

    @Override
    public void type(String modifierKeys, String text) {
        driver.type(modifierKeys, text);
    }

    @Override
    public void typeInto(String imagePath, String text) throws DriverException {
        driver.typeInto(fullImagePath(imagePath), text);
    }

    @Override
    public void typeInto(String imagePath, String text, double timeout) throws DriverException {
        driver.typeInto(fullImagePath(imagePath), text, timeout);
    }

    @Override
    public void typeInto(String imagePath, String text, float minSimilarity) throws DriverException {
        driver.typeInto(fullImagePath(imagePath), text, minSimilarity);
    }

    @Override
    public void typeInto(String imagePath, String text, double timeout, float minSimilarity) throws DriverException {
        driver.typeInto(fullImagePath(imagePath), text, timeout, minSimilarity);
    }

    @Override
    public void paste(String text) {
        driver.paste(text);
    }

    @Override
    public void pasteInto(String imagePath, String text) throws DriverException {
        driver.pasteInto(fullImagePath(imagePath), text);
    }

    @Override
    public void pasteInto(String imagePath, String text, double timeout) throws DriverException {
        driver.pasteInto(fullImagePath(imagePath), text, timeout);
    }

    @Override
    public void pasteInto(String imagePath, String text, float minSimilarity) throws DriverException {
        driver.pasteInto(fullImagePath(imagePath), text, minSimilarity);
    }

    @Override
    public void pasteInto(String imagePath, String text, double timeout, float minSimilarity) throws DriverException {
        driver.pasteInto(fullImagePath(imagePath), text, timeout, minSimilarity);
    }

    @Override
    public String imageToText(String imagePath) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath));
    }

    @Override
    public String imageToText(String imagePath, double timeout) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), timeout);
    }

    @Override
    public String imageToText(String imagePath, int marginLeft, int marginTop, int marginRight, int marginBottom) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), marginLeft, marginTop, marginRight, marginBottom);
    }

    @Override
    public String imageToText(String imagePath, float minSimilarity) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), minSimilarity);
    }

    @Override
    public String imageToText(String imagePath, double timeout, int marginLeft, int marginTop, int marginRight, int marginBottom) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), timeout, marginLeft, marginTop, marginRight, marginBottom);
    }

    @Override
    public String imageToText(String imagePath, double timeout, float minSimilarity) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), timeout, minSimilarity);
    }

    @Override
    public String imageToText(String imagePath, int marginLeft, int marginTop, int marginRight, int marginBottom, float minSimilarity) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), marginLeft, marginTop, marginRight, marginBottom, minSimilarity);
    }

    @Override
    public String imageToText(String imagePath, double timeout, int marginLeft, int marginTop, int marginRight, int marginBottom, float minSimilarity) throws DriverException {
        return driver.imageToText(fullImagePath(imagePath), timeout, marginLeft, marginTop, marginRight, marginBottom, minSimilarity);
    }

    private String fullImagePath(String imagePath) {
        return imageBaseDir + imagePath;
    }

    private String[] fullImagesPath(String[] imagePaths) {
        String[] fullImagePaths = new String[imagePaths.length];

        for (int i = 0; i < imagePaths.length; i++) {
            fullImagePaths[i] = fullImagePath(imagePaths[i]);
        }

        return fullImagePaths;
    }
}