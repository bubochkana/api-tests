package org.github.bubochkana.models.users;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserResponseDto extends UserRequestDto {
  private int id;
}
