/*
 * Copyright (c) 2013,2021 Witalij Berdinskich
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

import org.apache.maven.plugin.logging.Log;
import org.apache.maven.project.MavenProject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
