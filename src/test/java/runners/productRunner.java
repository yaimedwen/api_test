package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/java/features/product.feature"},
		dryRun =false,
		snippets =io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true,
		glue={"products"})


public class productRunner extends AbstractTestNGCucumberTests{

}
