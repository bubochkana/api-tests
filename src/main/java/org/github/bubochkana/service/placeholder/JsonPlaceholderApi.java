package org.github.bubochkana.service.placeholder;

import io.restassured.specification.RequestSpecification;
import org.github.bubochkana.service.common.AbstractWebService;
import org.github.bubochkana.service.placeholder.endpoints.PostEndpoint;
import org.github.bubochkana.service.placeholder.endpoints.UserEndpoint;

public class JsonPlaceholderApi extends AbstractWebService {
  private RequestSpecification requestSpecification;

  public JsonPlaceholderApi() {
    super();
    requestSpecification = getDefaultSpecification();
  }

  /**
   * Method to get the instance of the UserEndpoint
   *
   * @return the instance of the UserEndpoint
   */
  public UserEndpoint user() {
    return new UserEndpoint(requestSpecification);
  }

  /**
   * Method to get the instance of the PostEndpoint
   *
   * @return the instance of the PostEndpoint
   */
  public PostEndpoint post() {
    return new PostEndpoint(requestSpecification);
  }
}
