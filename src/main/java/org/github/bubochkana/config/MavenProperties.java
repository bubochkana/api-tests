package org.github.bubochkana.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MavenProperties {
  private Properties properties;
  private static final String MAVEN_PROPERTIES = "/maven.properties";

  private MavenProperties() {
    properties = loadProperties();
  }

  /**
   * Method to get properties from maven.properties file
   *
   * @return Properties
   */
  public static Properties getMavenProperties() {
    return getInstance().properties;
  }

  private static class SingletonHelper {
    private static final ThreadLocal<MavenProperties> INSTANCE =
        ThreadLocal.withInitial(MavenProperties::new);
  }

  public static MavenProperties getInstance() {
    return SingletonHelper.INSTANCE.get();
  }

  private Properties loadProperties() {
    Properties props = new Properties();

    try (InputStream in = MavenProperties.class.getResourceAsStream(MAVEN_PROPERTIES)) {
      props.load(in);
    } catch (IOException e) {
      e.getStackTrace();
    }
    return props;
  }
}
