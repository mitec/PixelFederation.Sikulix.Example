package tests;

import com.pixelfederation.qa.automation.core.driver.Driver;
import com.pixelfederation.qa.automation.core.driver.SikuliXDriver;
import com.pixelfederation.qa.automation.core.properties.ConfigLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.sikuli.script.Screen;
import properties.Config;

import java.io.IOException;

public abstract class BaseTest {
    protected static Config config;
    protected static Driver driver;

    @BeforeClass
    public void setUpAll() throws IOException {
        ConfigLoader configLoader = new ConfigLoader();

        config = configLoader.loadFromYaml(Config.class, "config.yaml");
        driver = new SikuliXDriver(config.Driver, new Screen(0));

        // todo: add anything what should be executed before all tests in class
    }

    @Before
    public void setUp() throws Exception {
        // todo: delete or add anything what should be executed before each test in class
    }

    @After
    public void tearDown() {
        // todo: delete or add anything what should be executed after each test in class
    }
}