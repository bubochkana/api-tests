package org.github.bubochkana.models.users;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
  private String name;
  private String catchPhrase;
  private String bs;
}
