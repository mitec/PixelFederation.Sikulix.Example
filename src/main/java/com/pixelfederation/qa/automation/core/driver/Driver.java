package com.pixelfederation.qa.automation.core.driver;

public interface Driver {
    Driver clone(String topLeftImagePath, String bottomRightImagePath) throws DriverException;
    Driver clone(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException;

    void changeRegion(String topLeftImagePath, String bottomRightImagePath) throws DriverException;
    void changeRegion(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException;
    void resetToOriginRegion();

    void wait(double timeout);

    void clickImage(String imagePath) throws DriverException;
    void clickImage(String imagePath, double timeout) throws DriverException;
    void clickImage(String imagePath, int offsetX, int offsetY) throws DriverException;
    void clickImage(String imagePath, float minSimilarity) throws DriverException;
    void clickImage(String imagePath, double timeout, int offsetX, int offsetY) throws DriverException;
    void clickImage(String imagePath, double timeout, float minSimilarity) throws DriverException;
    void clickImage(String imagePath, int offsetX, int offsetY, float minSimilarity) throws DriverException;
    void clickImage(String imagePath, double timeout, int offsetX, int offsetY, float minSimilarity) throws DriverException;

    boolean imageExists(String imagePath) throws DriverException;
    boolean imageExists(String imagePath, double timeout) throws DriverException;
    boolean imageExists(String imagePath, float minSimilarity) throws DriverException;
    boolean imageExists(String imagePath, double timeout, float minSimilarity) throws DriverException;

    void verifyImageExists(String imagePath) throws DriverException;
    void verifyImageExists(String imagePath, double timeout) throws DriverException;
    void verifyImageExists(String imagePath, float minSimilarity) throws DriverException;
    void verifyImageExists(String imagePath, double timeout, float minSimilarity) throws DriverException;

    void verifyImagesExist(String[] imagePaths) throws DriverException;
    void verifyImagesExist(String[] imagePaths, double timeout) throws DriverException;
    void verifyImagesExist(String[] imagePaths, float minSimilarity) throws DriverException;
    void verifyImagesExist(String[] imagePaths, double timeout, float minSimilarity) throws DriverException;

    void verifyImageDisappears(String imagePath, double timeout) throws DriverException;
    void verifyImageDisappears(String imagePath, float minSimilarity) throws DriverException;
    void verifyImageDisappears(String imagePath, double timeout, float minSimilarity) throws DriverException;

    void dragImage(String imagePath, int dragOffsetX, int dragOffsetY) throws DriverException;
    void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, double timeout) throws DriverException;
    void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, float minSimilarity) throws DriverException;
    void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, double timeout, float minSimilarity) throws DriverException;

    void dragScreen(int startOffsetX, int startOffsetY, int dragOffsetX, int dragOffsetY) throws DriverException;
    void dragScreen(double startOffsetX, double startOffsetY, double endOffsetX, double endOffsetY) throws DriverException;
    void dragScreenAroundCenter(int dragOffsetX, int dragOffsetY) throws DriverException;

    void mouseMoveToPosition(int x, int y);
    void mouseMoveToPositionFast(int x, int y);
    void mouseMove(int xOffset, int yOffset);
    void mouseMoveFast(int xOffset, int yOffset);

    void type(String text);
    void type(String modifierKeys, String text);
    void typeInto(String imagePath, String text) throws DriverException;
    void typeInto(String imagePath, String text, double timeout) throws DriverException;
    void typeInto(String imagePath, String text, float minSimilarity) throws DriverException;
    void typeInto(String imagePath, String text, double timeout, float minSimilarity) throws DriverException;

    void paste(String text);
    void pasteInto(String imagePath, String text) throws DriverException;
    void pasteInto(String imagePath, String text, double timeout) throws DriverException;
    void pasteInto(String imagePath, String text, float minSimilarity) throws DriverException;
    void pasteInto(String imagePath, String text, double timeout, float minSimilarity) throws DriverException;

    String imageToText(String imagePath) throws DriverException;
    String imageToText(String imagePath, double timeout) throws DriverException;
    String imageToText(String imagePath, int marginLeft, int marginTop, int marginRight, int marginBottom) throws DriverException;
    String imageToText(String imagePath, float minSimilarity) throws DriverException;
    String imageToText(String imagePath, double timeout, int marginLeft, int marginTop, int marginRight, int marginBottom) throws DriverException;
    String imageToText(String imagePath, double timeout, float minSimilarity) throws DriverException;
    String imageToText(String imagePath, int marginLeft, int marginTop, int marginRight, int marginBottom, float minSimilarity) throws DriverException;
    String imageToText(String imagePath, double timeout, int marginLeft, int marginTop, int marginRight, int marginBottom, float minSimilarity) throws DriverException;
}