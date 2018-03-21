package com.pixelfederation.qa.automation.core.properties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Config<T extends SikuliXDriverConfig> {
    public final T Driver;

    @JsonCreator
    public Config(
            @JsonProperty("Driver") T driver
    ) {
        Driver = driver;
    }
}