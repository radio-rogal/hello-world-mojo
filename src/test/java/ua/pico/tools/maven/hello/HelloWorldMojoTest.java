/*
 * Copyright (c) 2013 Vitaliy Berdinskikh AKA UR6LAD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
