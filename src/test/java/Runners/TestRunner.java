package Runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        tags = {"@RegressionTest"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false,
        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"
                // oluşturalacak raporun yeri ve adı veriliyor.
        }

)
public class TestRunner extends AbstractTestNGCucumberTests {


        @BeforeClass
        public static void beforeClass()
        {

        }

        @AfterClass
        public static void afterClass()
        {
                // ayarlar alındı, cucumber extend reporttan haberi oldu
                Reporter.loadXMLConfig("src/test/java/XMLFiles/extendReportSet.xml");
                Reporter.setSystemInfo("User Name", "Talip Ozkurt");
                Reporter.setSystemInfo("User Name", "Zeynep Erdogan");
                Reporter.setSystemInfo("User Name", "Davut Yavas");
                Reporter.setSystemInfo("User Name", "İbrahim");
                Reporter.setSystemInfo("User Name", "Hoca Niyaz");
                Reporter.setSystemInfo("User Name", "Ramazan");
                Reporter.setSystemInfo("Application Name", "Basqar");
                Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name"));
                Reporter.setSystemInfo("Department", "Group 7");
                Reporter.setSystemInfo("Ek satır Adı", "Group 7 Staj Projesi");
                Reporter.setTestRunnerOutput("Test excetuion Cucumber report");
        }

}
