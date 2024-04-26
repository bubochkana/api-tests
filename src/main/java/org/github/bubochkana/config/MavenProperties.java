package org.github.bubochkana.config;

import org.github.bubochkana.models.ServiceConfigDto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MavenProperties {
    private Properties properties;
    private static MavenProperties instance;
    private static final String MAVEN_PROPERTIES = "/maven.properties";

    private MavenProperties() {
        properties = loadProperties();
    }

    public static MavenProperties getInstance() {
        if (instance == null) {
            instance = new MavenProperties();
        }
        return instance;
    }

    private Properties loadProperties() {
        Properties props = new Properties();

        try (InputStream in = MavenProperties.class.getResourceAsStream(MAVEN_PROPERTIES)) {
            props.load(in);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return props;
    }

    public static ServiceConfigDto setServiceConfig() {
        ServiceConfigDto serviceConfigDto = new ServiceConfigDto();
        serviceConfigDto.setApiUrl(MavenProperties.getInstance().loadProperties().getProperty("dev.placeholder.service.url"));
        serviceConfigDto.setApiPort(Integer.parseInt(MavenProperties.getInstance().loadProperties().getProperty("dev.placeholder.service.port")));
        serviceConfigDto.setApiBasePath(MavenProperties.getInstance().loadProperties().getProperty("dev.placeholder.service.basepath"));
        return serviceConfigDto;
    }

    public ServiceConfigDto getEnvironment() {
        //Можеш створити модельку ServiceConfigDto і мати метод в MavenProperties який верне тобі цю модельку взалежності від енва: dev чи qa
        return new ServiceConfigDto();
    }
}
