package org.github.bubochkana.config;

import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.github.bubochkana.config.models.ServiceConfigDto;

public class ServiceConfigLoader {
  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * Method to set ServiceConfigDto model with maven properties
   *
   * @return ServiceConfigDto
   */
  public ServiceConfigDto loadServiceConfig() {
    Properties mavenProperties = MavenProperties.getMavenProperties();
    ServiceConfigDto serviceConfigDto = new ServiceConfigDto();

    String executionEnvironment = mavenProperties.getProperty("execution.environment");
    LOGGER.info("The tests are running on {} environment", executionEnvironment);

    for (String key : mavenProperties.stringPropertyNames()) {
      if (key.contains(executionEnvironment + ".placeholder.service.url")) {
        serviceConfigDto.apiUrl(mavenProperties.getProperty(key));
      }
      if (key.contains(executionEnvironment + ".placeholder.service.port")) {
        serviceConfigDto.apiPort(Integer.parseInt(mavenProperties.getProperty(key)));
      }
      if (key.contains(executionEnvironment + ".placeholder.service.basepath")) {
        serviceConfigDto.apiBasePath(mavenProperties.getProperty(key));
      }
    }
    return serviceConfigDto;
  }
}
