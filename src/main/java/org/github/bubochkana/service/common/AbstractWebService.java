package org.github.bubochkana.service.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.github.bubochkana.models.ServiceConfigDto;

public abstract class AbstractWebService {
    private ServiceConfigDto serviceConfigDto = new ServiceConfigDto();

    protected RequestSpecification getDefaultSpecification(){
        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(serviceConfigDto.getApiUrl())
                .setPort(serviceConfigDto.getApiPort());
        if (!StringUtils.isEmpty(serviceConfigDto.getApiBasePath())) {
            specBuilder.setBasePath(serviceConfigDto.getApiBasePath());
        }
        specBuilder
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ErrorLoggingFilter());

        return specBuilder.build();
    }
}
