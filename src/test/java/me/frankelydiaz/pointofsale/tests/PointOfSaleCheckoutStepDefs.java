package me.frankelydiaz.pointofsale.tests;

import me.frankelydiaz.pointofsale.models.Product;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;
import me.frankelydiaz.pointofsale.repositories.InMemoryProductRepositoryImpl;
import me.frankelydiaz.pointofsale.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class PointOfSaleCheckoutStepDefs {

    private ProductRepository productRepository = InMemoryProductRepositoryImpl.getInstance();

    @Given("^these products exists$")
    public void createProducts(List<Product> products) throws Throwable {

    }

    @And("^have these volume prices$")
    public void createProductVolumePrices(List<ProductVolumePrice> productVolumePrices) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Given("^I add these products to my shopping cart$")
    public void addToShoppingCart(List<String> products) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @When("^I process my order$")
    public void processOrder() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^the total should be (.+)$")
    public void viewTotal(BigDecimal total) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
