package org.github.bubochkana.config;

import org.github.bubochkana.models.ServiceConfigDto;

public class ServiceConfigLoader {
  private ServiceConfigLoader() {}

  /**
   * method to set ServiceConfigDto model with maven properties
   *
   * @return ServiceConfigDto
   */
  public static ServiceConfigDto loadServiceConfig() {
    return ServiceConfigDto.builder()
        .apiUrl(MavenProperties.getMavenProperties().getProperty("dev.placeholder.service.url"))
        .apiPort(
            Integer.parseInt(
                MavenProperties.getMavenProperties().getProperty("dev.placeholder.service.port")))
        .apiBasePath(
            MavenProperties.getMavenProperties().getProperty("dev.placeholder.service.basepath"))
        .build();
  }
}
