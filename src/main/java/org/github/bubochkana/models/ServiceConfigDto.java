package org.github.bubochkana.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceConfigDto {
    private String apiUrl;
    private int apiPort;
    private String apiBasePath;

    public ServiceConfigDto(){
        //somehow set fields from the maven config file, MavenProperties.getInstance()?
    }


}
