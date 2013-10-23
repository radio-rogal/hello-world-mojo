package ua.pico.util.maven.hello;

import org.apache.maven.plugin.AbstractMojo;

import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import org.apache.maven.project.MavenProject;

/**
 * Print hello message in the log and set the project property `hello.message`.
 */
@Mojo(name = "hello", defaultPhase = LifecyclePhase.PROCESS_SOURCES)
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

}
