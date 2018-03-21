package com.pixelfederation.qa.automation.core.driver;

import com.pixelfederation.qa.automation.core.properties.SikuliXDriverConfig;
import com.pixelfederation.qa.automation.core.utils.StackTrace;
import org.sikuli.basics.Settings;
import org.sikuli.script.*;

public final class SikuliXDriver implements Driver {
    private final SikuliXDriverConfig config;
    private final Region orgRegion;
    private Region region;

    public SikuliXDriver(SikuliXDriverConfig config, Region region) {
        this.config = config;
        this.orgRegion = region;
        this.region = region;
    }

    @Override
    public Driver clone(String topLeftImagePath, String bottomRightImagePath) throws DriverException {
        return clone(topLeftImagePath, bottomRightImagePath, (float) config.MinSimilarity);
    }

    @Override
    public Driver clone(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException {
        Region region = createRegion(topLeftImagePath, bottomRightImagePath, minSimilarity);

        return new SikuliXDriver(config, region);
    }

    @Override
    public void changeRegion(String topLeftImagePath, String bottomRightImagePath) throws DriverException {
        region = createRegion(topLeftImagePath, bottomRightImagePath, (float) config.MinSimilarity);
    }

    @Override
    public void changeRegion(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException {
        region = createRegion(topLeftImagePath, bottomRightImagePath, minSimilarity);
    }

    @Override
    public void resetToOriginRegion() {
        region = orgRegion;
    }

    @Override
    public void wait(double timeout) {
        region.wait(timeout);
    }

    @Override
    public void verifyImageDisappears(String imagePath, double timeout) throws DriverException {
        verifyImageDisappears(imagePath, timeout, (float) config.MinSimilarity);
    }

    @Override
    public void verifyImageDisappears(String imagePath, float minSimilarity) throws DriverException {
        verifyImageDisappears(imagePath, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public void verifyImageDisappears(String imagePath, double timeout, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        if (!region.waitVanish(createPattern(imagePath, minSimilarity), timeout)) {
            throw new DriverException(String.format("Image '%s' did't vanish", imagePath));
        }
    }

    @Override
    public void clickImage(String imagePath) throws DriverException {
        clickImage(imagePath, config.AutoWaitTimeout, 0, 0, (float) config.MinSimilarity);
    }

    @Override
    public void clickImage(String imagePath, double timeout) throws DriverException {
        clickImage(imagePath, timeout, 0, 0, (float) config.MinSimilarity);
    }

    @Override
    public void clickImage(String imagePath, int offsetX, int offsetY) throws DriverException {
        clickImage(imagePath, config.AutoWaitTimeout, offsetX, offsetY, (float) config.MinSimilarity);
    }

    @Override
    public void clickImage(String imagePath, float minSimilarity) throws DriverException {
        clickImage(imagePath, config.AutoWaitTimeout, 0, 0, minSimilarity);
    }

    @Override
    public void clickImage(String imagePath, double timeout, int offsetX, int offsetY) throws DriverException {
        clickImage(imagePath, timeout, offsetX, offsetY, (float) config.MinSimilarity);
    }

    @Override
    public void clickImage(String imagePath, double timeout, float minSimilarity) throws DriverException {
        clickImage(imagePath, timeout, 0, 0, minSimilarity);
    }

    @Override
    public void clickImage(String imagePath, int offsetX, int offsetY, float minSimilarity) throws DriverException {
        clickImage(imagePath, config.AutoWaitTimeout, offsetX, offsetY, minSimilarity);
    }

    @Override
    public void clickImage(String imagePath, double timeout, int offsetX, int offsetY, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        Pattern pattern = createPattern(imagePath, minSimilarity);
        Match match = findPattern(pattern, timeout);

        Region offset = match.offset(offsetX, offsetY);

        // click delay must be set before each click action (see comment for Settings.ClickDelay)
        Settings.ClickDelay = config.ClickDelay;
        offset.click();
    }

    @Override
    public boolean imageExists(String imagePath) throws DriverException {
        return imageExists(imagePath, config.AutoWaitTimeout, (float) config.MinSimilarity);
    }

    @Override
    public boolean imageExists(String imagePath, double timeout) throws DriverException {
        return imageExists(imagePath, timeout, (float) config.MinSimilarity);
    }

    @Override
    public boolean imageExists(String imagePath, float minSimilarity) throws DriverException {
        return imageExists(imagePath, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public boolean imageExists(String imagePath, double timeout, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        //return (region.exists(createPattern(imagePath, minSimilarity), timeout) != null);

        try {
            verifyImageExists(imagePath, timeout, minSimilarity);

            return true;
        }
        // region.exists should be used for this situation, but it returns silently false also in case, when image doesn't exist (couldn't be loaded)
        // therefore we'll use verifyImageExist and swallow the exception in case image couldn't be found, but can be loaded
        catch (DriverException e) {
            if (e.getMessage().contains("not loaded")) {
                throw e;
            }

            return false;
        }
    }

    @Override
    public void verifyImageExists(String imagePath) throws DriverException {
        verifyImageExists(imagePath, config.AutoWaitTimeout, (float) config.MinSimilarity);
    }

    @Override
    public void verifyImageExists(String imagePath, double timeout) throws DriverException {
        verifyImageExists(imagePath, timeout, (float) config.MinSimilarity);
    }

    @Override
    public void verifyImageExists(String imagePath, float minSimilarity) throws DriverException {
        verifyImageExists(imagePath, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public void verifyImageExists(String imagePath, double timeout, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        // findPattern is used instead of imageExists to preserve consistency of SikuliX logging
        findPattern(createPattern(imagePath, minSimilarity), timeout);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths) throws DriverException {
        verifyImagesExist(imagePaths, config.AutoWaitTimeout, (float) config.MinSimilarity);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths, double timeout) throws DriverException {
        verifyImagesExist(imagePaths, timeout, (float) config.MinSimilarity);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths, float minSimilarity) throws DriverException {
        verifyImagesExist(imagePaths, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public void verifyImagesExist(String[] imagePaths, double timeout, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        for (String imagePath : imagePaths) {
            findPattern(createPattern(imagePath, minSimilarity), timeout);
        }

        // todo: apply this when there is findAnyList available (from version 1.1.2) but also with timeout functionality (from version ?)
//        try {
//            waitTimeBeforeAction();
//
//            double timeout = config.AutoWaitTimeout;
//            float minSimilarity = (float)config.MinSimilarity;
//
//            List<Object> patterns = new ArrayList<>();
//            for (String imagePath : imagePaths) {
//                patterns.add(createPattern(imagePath, minSimilarity));
//            }
//
//            List<Match> matches = region.findAnyList(patterns, timeout);
//
//            if (matches.size() != imagePaths.length) {
//                throw new FindFailed("Failed to find all images");
//            }
//        } catch (FindFailed e) {
//            throw new DriverException(e);
//        }
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY) throws DriverException {
        dragImage(imagePath, dragOffsetX, dragOffsetY, config.AutoWaitTimeout, (float) config.MinSimilarity);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, double timeout) throws DriverException {
        dragImage(imagePath, dragOffsetX, dragOffsetY, timeout, (float) config.MinSimilarity);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, float minSimilarity) throws DriverException {
        dragImage(imagePath, dragOffsetX, dragOffsetY, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public void dragImage(String imagePath, int dragOffsetX, int dragOffsetY, double timeout, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        Pattern pattern = createPattern(imagePath, minSimilarity);
        Match match = findPattern(pattern, timeout);

        Location dragStart = match.getCenter();

        dragInternal(dragStart.x, dragStart.y, dragStart.x + dragOffsetX, dragStart.y + dragOffsetY);
    }

    @Override
    public void dragScreen(int startOffsetX, int startOffsetY, int dragOffsetX, int dragOffsetY) throws DriverException {
        dragInternal(startOffsetX, startOffsetY, startOffsetX + dragOffsetX, dragOffsetY + dragOffsetY);
    }

    @Override
    public void dragScreen(double startOffsetX, double startOffsetY, double endOffsetX, double endOffsetY) throws DriverException {
        dragInternal(
                (int) (region.w * startOffsetX), (int) (region.h * startOffsetY),
                (int) (region.w * endOffsetX), (int) (region.h * endOffsetY)
        );
    }

    @Override
    public void dragScreenAroundCenter(int dragOffsetX, int dragOffsetY) throws DriverException {
        int startOffsetX = region.w / 2 - dragOffsetX / 2;
        int startOffsetY = region.h / 2 - dragOffsetY / 2;

        dragInternal(startOffsetX, startOffsetY, startOffsetX + dragOffsetX, startOffsetY + dragOffsetY);
    }

    @Override
    public void mouseMoveToPosition(int x, int y) {
        waitTimeBeforeAction();

        mouseMoveToPositionFast(x, y);
    }

    @Override
    public void mouseMoveToPositionFast(int x, int y) {
        try {
            region.mouseMove(new Location(x, y));
        } catch (FindFailed e) {
            // there is no exception for this case
        }
    }

    @Override
    public void mouseMove(int xOffset, int yOffset) {
        waitTimeBeforeAction();

        mouseMoveFast(xOffset, yOffset);
    }

    @Override
    public void mouseMoveFast(int xOffset, int yOffset) {
        region.mouseMove(xOffset, yOffset);
    }

    @Override
    public void type(String text) {
        type(null, text);
    }

    @Override
    public void type(String modifierKeys, String text) {
        waitTimeBeforeAction();

        if (modifierKeys == null) {
            region.type(text);
        } else {
            region.type(text, modifierKeys);
        }
    }

    @Override
    public void typeInto(String imagePath, String text) throws DriverException {
        typeInto(imagePath, text, config.AutoWaitTimeout, (float) config.MinSimilarity);
    }

    @Override
    public void typeInto(String imagePath, String text, double timeout) throws DriverException {
        typeInto(imagePath, text, timeout, (float) config.MinSimilarity);
    }

    @Override
    public void typeInto(String imagePath, String text, float minSimilarity) throws DriverException {
        typeInto(imagePath, text, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public void typeInto(String imagePath, String text, double timeout, float minSimilarity) throws DriverException {
        try {
            waitTimeBeforeAction();

            Match match = findPattern(createPattern(imagePath, minSimilarity), timeout);
            region.type(match, text);
        } catch (FindFailed e) {
            throw new DriverException(e);
        }
    }

    @Override
    public void paste(String text) {
        waitTimeBeforeAction();

        region.paste(text);
    }

    @Override
    public void pasteInto(String imagePath, String text) throws DriverException {
        pasteInto(imagePath, text, config.AutoWaitTimeout, (float) config.MinSimilarity);
    }

    @Override
    public void pasteInto(String imagePath, String text, double timeout) throws DriverException {
        pasteInto(imagePath, text, timeout, (float) config.MinSimilarity);
    }

    @Override
    public void pasteInto(String imagePath, String text, float minSimilarity) throws DriverException {
        pasteInto(imagePath, text, config.AutoWaitTimeout, minSimilarity);
    }

    @Override
    public void pasteInto(String imagePath, String text, double timeout, float minSimilarity) throws DriverException {
        try {
            waitTimeBeforeAction();

            Match match = findPattern(createPattern(imagePath, minSimilarity), timeout);
            region.paste(match, text);
        } catch (FindFailed e) {
            throw new DriverException(e);
        }
    }

    @Override
    public String imageToText(String imagePath) throws DriverException {
        return imageToText(imagePath, config.AutoWaitTimeout, 0, 0, 0, 0, (float) config.MinSimilarity);
    }

    @Override
    public String imageToText(String imagePath, double timeout) throws DriverException {
        return imageToText(imagePath, timeout, 0, 0, 0, 0, (float) config.MinSimilarity);
    }

    @Override
    public String imageToText(String imagePath, int marginLeft, int marginTop, int marginRight, int marginBottom) throws DriverException {
        return imageToText(imagePath, config.AutoWaitTimeout, marginLeft, marginTop, marginRight, marginBottom, (float) config.MinSimilarity);
    }

    @Override
    public String imageToText(String imagePath, float minSimilarity) throws DriverException {
        return imageToText(imagePath, config.AutoWaitTimeout, 0, 0, 0, 0, minSimilarity);
    }

    @Override
    public String imageToText(String imagePath, double timeout, int marginLeft, int marginTop, int marginRight, int marginBottom) throws DriverException {
        return imageToText(imagePath, timeout, marginLeft, marginTop, marginRight, marginBottom, (float) config.MinSimilarity);
    }

    @Override
    public String imageToText(String imagePath, double timeout, float minSimilarity) throws DriverException {
        return imageToText(imagePath, timeout, 0, 0, 0, 0, minSimilarity);
    }

    @Override
    public String imageToText(String imagePath, int marginLeft, int marginTop, int marginRight, int marginBottom, float minSimilarity) throws DriverException {
        return imageToText(imagePath, config.AutoWaitTimeout, marginLeft, marginTop, marginRight, marginBottom, minSimilarity);
    }

    @Override
    public String imageToText(String imagePath, double timeout, int marginLeft, int marginTop, int marginRight, int marginBottom, float minSimilarity) throws DriverException {
        waitTimeBeforeAction();

        Pattern pattern = createPattern(imagePath, minSimilarity);
        Match match = findPattern(pattern, timeout);

        Region resizedRegion = match.grow(marginLeft, marginRight, marginTop, marginBottom);

        highlightRegionIfCan(resizedRegion);

        return resizedRegion.text();
    }

    private Region createRegion(String topLeftImagePath, String bottomRightImagePath, float minSimilarity) throws DriverException {
        Pattern pattern;
        Match match;

        double timeout = config.AutoWaitTimeout;

        pattern = createPattern(topLeftImagePath, minSimilarity);
        match = findPattern(pattern, timeout);
        int x = match.x;
        int y = match.y;

        pattern = createPattern(bottomRightImagePath, minSimilarity);
        match = findPattern(pattern, timeout);
        int w = match.x + match.w - x;
        int h = match.y + match.h - y;

        Region r = Region.create(x, y, w, h);

        highlightRegionIfCan(r);

        return r;
    }

    private void waitTimeBeforeAction() {
        wait(config.WaitTimeBeforeAction);
    }

    private Pattern createPattern(String imagePath, float minSimilarity) {
        Pattern pattern = new Pattern(imagePath);
        pattern.similar(minSimilarity);

        return pattern;
    }

    private Match findPattern(Pattern pattern, double timeout) throws DriverException {
        try {
            String callingMethod = StackTrace.getLastClassMethodCall(getClass());
            if (callingMethod.equals("")) callingMethod = "finding";

            log("%s '%s' for %fs", callingMethod, pattern.getFilename(), timeout);

            Match match = region.wait(pattern, timeout);

            highlightRegionIfCan(match);

            return match;

        } catch (FindFailed e) {
            throw new DriverException(e);
        }
    }

    private void dragInternal(int startOffsetX, int startOffsetY, int endOffsetX, int endOffsetY) throws DriverException {
        waitTimeBeforeAction();

        Location dragStart = new Location(
                Math.min(Math.max(0, region.x + startOffsetX), region.x + region.w),
                Math.min(Math.max(0, region.y + startOffsetY), region.y + region.h)
        );

        Location dragEnd = new Location(
                Math.min(Math.max(0, region.x + endOffsetX), region.x + region.w),
                Math.min(Math.max(0, region.y + endOffsetY), region.y + region.h)
        );

        try {
            region.dragDrop(dragStart, dragEnd);
        } catch (FindFailed e) {
            throw new DriverException(e);
        }
    }

    private void highlightRegionIfCan(Region r) {
        if (config.CanHighlight) {
            r.highlight((float) config.HighlightTime);
        }
    }

    private void log(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}