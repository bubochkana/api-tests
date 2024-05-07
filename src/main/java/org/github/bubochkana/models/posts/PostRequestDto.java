package org.github.bubochkana.models.posts;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostRequestDto {
  private int userId;
  private String title;
  private String body;
}
