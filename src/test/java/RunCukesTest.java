/**
 * Created by frankelydiaz on 6/3/15.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        format = { "json:target/report.json" },
        glue = "me.frankelydiaz.pointofsale.tests",
        features = "src/test/resources/features/PointOfSaleCheckout.feature")
public class RunCukesTest {
}