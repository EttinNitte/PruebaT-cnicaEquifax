package testRunners;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features/login.feature",glue={"stepDefinitions"})

public class runner {

}
