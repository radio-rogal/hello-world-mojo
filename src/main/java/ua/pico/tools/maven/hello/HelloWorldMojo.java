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

import org.apache.maven.plugin.AbstractMojo;

import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import org.apache.maven.project.MavenProject;

/**
 * Print hello message in the log and set the project property `hello.message`.
 */
@Mojo(name = "hello", defaultPhase = LifecyclePhase.VALIDATE, requiresProject = true)
public class HelloWorldMojo extends AbstractMojo {

	/**
	 * Maven project
	 */
	@Component
	private MavenProject project;

	/**
	 * Hello message.
	 */
	@Parameter(defaultValue = "Hello, world!", property = "hello.message")
	private String message;

	public void execute() {
		getLog().info(message);
		project.getProperties().put("hello.message", message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public MavenProject getProject() {
		return project;
	}

	public void setProject(final MavenProject project) {
		this.project = project;
	}

}
