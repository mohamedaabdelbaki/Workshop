package runner;

import io.cucumber.testng.CucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions
        //        features = "src/test/resources/features/register.feature",
        //  /test/resources/features"
        //login.feature

        //features = "src/test/resources//features/Filter.feature",
        (features = "src/test/resources/features",
    glue={"stepDefs","hooks"},
    plugin={
          "pretty",
            "html:test-output/report.html"
    },

monochrome= true
        )
public class TestRunner  extends AbstractTestNGCucumberTests {

}
