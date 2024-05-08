package runners;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features={"src/test/java/features/hooksbackground.feature"},
		dryRun =false,
		snippets =io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true,
		glue={"hookstep"})

public class Testrunner extends AbstractTestNGCucumberTests {

	
}
