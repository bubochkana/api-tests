package org.github.bubochkana.service.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.github.bubochkana.config.ServiceConfigLoader;
import org.github.bubochkana.config.models.ServiceConfigDto;

public abstract class AbstractWebService {
  protected ServiceConfigDto serviceConfigDto;

  protected AbstractWebService() {
    ServiceConfigLoader serviceConfigLoader = new ServiceConfigLoader();
    this.serviceConfigDto = serviceConfigLoader.loadServiceConfig();
  }

  protected RequestSpecification getDefaultSpecification() {
    RequestSpecBuilder specBuilder =
        new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(serviceConfigDto.apiUrl())
            .setPort(serviceConfigDto.apiPort());
    if (!StringUtils.isEmpty(serviceConfigDto.apiBasePath())) {
      specBuilder.setBasePath(serviceConfigDto.apiBasePath());
    }
    specBuilder
        .addFilter(new ResponseLoggingFilter())
        .addFilter(new RequestLoggingFilter())
        .addFilter(new ErrorLoggingFilter());

    return specBuilder.build();
  }
}
