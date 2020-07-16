package CucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//format = {"pretty" ,"html:target/html"},
		//format = {"pretty" ,"json:target/json/output.json"},
		format = {"pretty" ,"json:target/firefox/json/output.json","html:target/firefox/html"},
		//tags= {"@web"},
		features="features\\Flight_firefox.feature" ,glue="stepDefination")
public class FireFoxBrowserRunner {

}
