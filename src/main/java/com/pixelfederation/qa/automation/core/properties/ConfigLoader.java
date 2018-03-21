package com.pixelfederation.qa.automation.core.properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.io.InputStream;

public final class ConfigLoader {
    public <T> T loadFromYaml(Class<T> configClass, String configFileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        InputStream resourceStream = configClass.getResourceAsStream(configFileName);

        return mapper.readValue(resourceStream, configClass);
    }
}