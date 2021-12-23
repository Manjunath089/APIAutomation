package cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "C:/Users/chaithra.muniswamaia/eclipse-workspace/APIFramework2/src/test/java/features/installment.feature", 
plugin = "json:target/jsonReports/cucumber-report.json", 
glue= {"stepDefinations"}
)

public class TestRunner {

	//tags = {"@DeletePalce"}C:/Users/chaithra.muniswamaia/eclipse-workspace/APIFramework/src/test/java/features
}

