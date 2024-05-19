package org.github.bubochkana.placeholder.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.github.bubochkana.config.MavenProperties;

public class BaseUiTest {

  private static final Logger LOGGER = LogManager.getLogger();

  protected String getUrl() {
    String executionEnvironment =
        MavenProperties.getMavenProperties().getProperty("execution.environment");
    LOGGER.info("The tests are running on {} environment", executionEnvironment);
    return executionEnvironment + "placeholder.ui.url";
  }
}
