package testRunners;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/carro.feature",glue={"stepDefinitions"})

public class carroRunner {

}
