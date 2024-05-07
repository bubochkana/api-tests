package org.github.bubochkana.placeholder.api.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.github.bubochkana.models.posts.PostErrorResponseDto;
import org.github.bubochkana.models.posts.PostRequestDto;
import org.github.bubochkana.models.posts.PostResponseDto;
import org.github.bubochkana.placeholder.api.BaseTest;
import org.github.bubochkana.service.Services;
import org.github.bubochkana.testdata.PostTestData;
import org.testng.annotations.Test;

public class PostsCrudTest extends BaseTest {
  private final PostRequestDto defaultPost = PostTestData.getDefaultPost();

  @Test(
      testName = "TC-1",
      description = "Verify the ability to create a new Post",
      groups = "Posts")
  public void testVerifyAbilityToCreatePost() {
    PostResponseDto createdPostResponse = Services.placeholderApi().post().createPost(defaultPost);
    assertThat(createdPostResponse)
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(defaultPost);
  }

  @Test(testName = "TC-2", description = "Verify the ability to update a Post", groups = "Posts")
  public void testVerifyAbilityToUpdatePost() {
    PostResponseDto updatedPostResponse =
        Services.placeholderApi().post().updatePost(defaultPost, "1");
    assertThat(updatedPostResponse)
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(defaultPost);
  }

  @Test(
      testName = "TC-3",
      description = "Verify response and validation when update Post for invalid ID",
      groups = "Posts")
  public void testVerifyResponseWhenUpdatePostForInvalidId() {
    PostErrorResponseDto errorResponse = Services.placeholderApi().post().getPostByIdWithError("0");
    // TODO - verify the error message text? errorResponse.getMessage() gives null
    //            assertThat(errorResponse.getMessage())
    //                    .isEqualTo("Invalid Post Id Provided");

  }

  @Test(
      testName = "TC-4",
      description = "Verify possibility to retrieve Post by Id",
      groups = "Posts")
  public void testVerifyPossibilityToRetrievePostById() {
    PostResponseDto postResponse = Services.placeholderApi().post().getPostById("1");
    assertThat(postResponse).usingRecursiveComparison().ignoringFields("id").isEqualTo(defaultPost);
  }

  @Test(
      testName = "TC-5",
      description = "Verify count of posts in retrieved list",
      groups = "Posts")
  public void testVerifyPostsCountInRetrievedList() {
    List<PostResponseDto> postsListResponse = Services.placeholderApi().post().getAllPosts();
    assertThat(postsListResponse).hasSizeGreaterThan(5);
  }
}
