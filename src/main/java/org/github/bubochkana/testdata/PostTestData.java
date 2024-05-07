package org.github.bubochkana.testdata;

import org.github.bubochkana.models.posts.PostRequestDto;

public class PostTestData {
  public static PostRequestDto getDefaultPost() {
    return PostRequestDto.builder()
        .userId(1)
        .title("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
        .body(
            "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")
        .build();
  }
}
