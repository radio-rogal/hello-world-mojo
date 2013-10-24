package ua.pico.tools.maven.hello;

import java.util.Properties;

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HelloWorldMojoTest {

	private static final String HELLO_PROPERTY = "hello.message";
	private static final String TEST_MESSAGE = "544553545F4D455353414745";

	@Mock private Log log;
	@Mock private MavenProject project;

	private Properties projectProperties;
	private HelloWorldMojo testInstance;


	@Before
	public void setUp() {
		projectProperties = new Properties();
		testInstance = new HelloWorldMojo();
		testInstance.setLog(log);
		testInstance.setMessage(TEST_MESSAGE);
		testInstance.setProject(project);

		when(project.getProperties()).thenReturn(projectProperties);
	}

	@After
	public void teadDown() {
		projectProperties = null;
		testInstance = null;
	}

	@Test
	public void testExecute() {
		testInstance.execute();

		verify(log).info(eq(TEST_MESSAGE));
		assertEquals(TEST_MESSAGE, projectProperties.get(HELLO_PROPERTY));
	}

}
