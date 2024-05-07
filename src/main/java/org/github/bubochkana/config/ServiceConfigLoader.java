package org.github.bubochkana.config;

import java.util.Properties;
import org.github.bubochkana.config.models.ServiceConfigDto;

public class ServiceConfigLoader {

  /**
   * Method to set ServiceConfigDto model with maven properties
   *
   * @return ServiceConfigDto
   */
//  public ServiceConfigDto loadServiceConfig() {
//    Properties mavenProperties = MavenProperties.getMavenProperties();
//    return new ServiceConfigDto()
//        .apiUrl(mavenProperties.getProperty("dev.placeholder.service.url"))
//        .apiPort(Integer.parseInt(mavenProperties.getProperty("dev.placeholder.service.port")))
//        .apiBasePath(mavenProperties.getProperty("dev.placeholder.service.basepath"));
//  }

  public ServiceConfigDto loadServiceConfig() {
    Properties mavenProperties = MavenProperties.getMavenProperties();
    ServiceConfigDto serviceConfigDto = new ServiceConfigDto();

    for (String key : mavenProperties.stringPropertyNames()) {
      if (key.contains("dev.placeholder.service.url")) {
        serviceConfigDto.apiUrl(mavenProperties.getProperty(key));
      }
      if (key.contains("dev.placeholder.service.port")) {
        serviceConfigDto.apiPort(Integer.parseInt(mavenProperties.getProperty(key)));
      }
      if (key.contains("dev.placeholder.service.basepath")) {
        serviceConfigDto.apiBasePath(mavenProperties.getProperty(key));
      }
    }
    return serviceConfigDto;
  }
}
