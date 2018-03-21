package tests;

import game.SomePageObject;
import org.junit.Test;

public class Test01_Example extends BaseTest {
    private SomePageObject somePageObject;

    @Override
    public void setUp() throws Exception {
        super.setUp();

        somePageObject = new SomePageObject(driver);
    }

    @Test
    public void testSomeAwesomeFeature() throws Exception {
        somePageObject.doSomeAction("test_image_name");
    }
}