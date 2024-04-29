package org.github.bubochkana.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceConfigDto {
  private String apiUrl;
  private int apiPort;
  private String apiBasePath;
}
