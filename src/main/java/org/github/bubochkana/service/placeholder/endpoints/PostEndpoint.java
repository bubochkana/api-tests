package org.github.bubochkana.service.placeholder.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.github.bubochkana.enums.HttpStatus;
import org.github.bubochkana.models.posts.PostErrorResponseDto;
import org.github.bubochkana.models.posts.PostRequestDto;
import org.github.bubochkana.models.posts.PostResponseDto;
import org.github.bubochkana.service.common.AbstractWebEndpoint;

public class PostEndpoint extends AbstractWebEndpoint {
  private static final String POSTS = "/posts";
  private static final String POST_ID = POSTS + "/%s";

  public PostEndpoint(RequestSpecification requestSpecification) {
    super(requestSpecification);
  }

  /**
   * Method to create a post
   *
   * @param postRequestDto the model with parameters to crete a post
   * @return PostResponseDto
   */
  public PostResponseDto createPost(PostRequestDto postRequestDto) {
    return createPost(postRequestDto, HttpStatus.CREATED).extract().as(PostResponseDto.class);
  }

  /**
   * Method to create a post
   *
   * @param postRequestDto the model with parameters to crete a post
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse createPost(PostRequestDto postRequestDto, HttpStatus statusCode) {
    return post(this.requestSpecification, POSTS, postRequestDto)
        .statusCode(statusCode.getStatusCode());
  }

  /**
   * Method to update a post
   *
   * @param postUpdateRequest the model with parameters to update a post
   * @param postIdToUpdate the post id to update
   * @return PostResponseDto
   */
  public PostResponseDto updatePost(PostRequestDto postUpdateRequest, String postIdToUpdate) {
    return updatePost(postUpdateRequest, postIdToUpdate, HttpStatus.OK)
        .extract()
        .as(PostResponseDto.class);
  }

  /**
   * Method to update a post
   *
   * @param postUpdateRequest the model with parameters to update a post
   * @param postIdToUpdate the post id to update
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse updatePost(
      PostRequestDto postUpdateRequest, String postIdToUpdate, HttpStatus statusCode) {
    return put(this.requestSpecification, String.format(POST_ID, postIdToUpdate), postUpdateRequest)
        .statusCode(statusCode.getStatusCode());
  }

  /**
   * Method to get the post by id
   *
   * @param postId the post id to get
   * @return PostResponseDto
   */
  public PostResponseDto getPostById(String postId) {
    return getPostById(postId, HttpStatus.OK).extract().as(PostResponseDto.class);
  }

  /**
   * Method to get the invalid post
   *
   * @param postId the invalid post id to get
   * @return PostErrorResponseDto
   */
  public PostErrorResponseDto getPostByIdWithError(String postId) {
    return getPostById(postId, HttpStatus.NOT_FOUND).extract().as(PostErrorResponseDto.class);
  }

  /**
   * Method to get the post by id
   *
   * @param postId the post id to get
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse getPostById(String postId, HttpStatus statusCode) {
    return get(this.requestSpecification, String.format(POST_ID, postId))
        .statusCode(statusCode.getStatusCode());
  }

  /**
   * Method to get all posts
   *
   * @return List of PostResponseDto
   */
  public List<PostResponseDto> getAllPosts() {
    return List.of(getAllPosts(HttpStatus.OK).extract().as(PostResponseDto[].class));
  }

  /**
   * Method to get all posts
   *
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse getAllPosts(HttpStatus statusCode) {
    return get(this.requestSpecification, POSTS).statusCode(statusCode.getStatusCode());
  }
}
