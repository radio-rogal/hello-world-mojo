package ua.pico.tools.maven.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Properties;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("fast")
public class HelloWorldMojoTest {

  private static final String HELLO_PROPERTY = "hello.message";
  private static final String TEST_MESSAGE = "544553545F4D455353414745";

  @Mock
  private Log log;
  @Mock
  private MavenProject project;

  @InjectMocks
  private HelloWorldMojo testInstance;

  private Properties projectProperties;

  @BeforeEach
  public void setUp() {
    projectProperties = new Properties();
    testInstance.setMessage(TEST_MESSAGE);

    when(project.getProperties()).thenReturn(projectProperties);
  }

  @Test
  public void testExecute() {
    testInstance.execute();

    verify(log).info(eq(TEST_MESSAGE));
    assertEquals(TEST_MESSAGE, projectProperties.get(HELLO_PROPERTY));
  }

}
