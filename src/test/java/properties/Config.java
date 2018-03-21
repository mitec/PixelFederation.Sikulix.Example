package properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.pixelfederation.qa.automation.core.properties.*;

public class Config extends com.pixelfederation.qa.automation.core.properties.Config<SikuliXDriverConfig> {

    @JsonCreator
    public Config(
            @JsonProperty("Driver") SikuliXDriverConfig driver
    ) {
        super(driver);
    }
}