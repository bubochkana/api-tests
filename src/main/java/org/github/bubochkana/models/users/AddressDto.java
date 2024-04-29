package org.github.bubochkana.models.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private GeoDto geo;
}
