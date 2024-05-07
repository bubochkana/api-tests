package org.github.bubochkana.models.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostResponseDto extends PostRequestDto {
  private int id;
}
