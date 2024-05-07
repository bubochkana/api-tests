package org.github.bubochkana.config.models;

import lombok.*;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceConfigDto {
  private String apiUrl;
  private int apiPort;
  private String apiBasePath;
}
