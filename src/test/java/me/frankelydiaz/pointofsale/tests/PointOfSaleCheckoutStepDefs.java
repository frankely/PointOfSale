package me.frankelydiaz.pointofsale.tests;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import me.frankelydiaz.pointofsale.ShoppingCartImpl;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;
import me.frankelydiaz.pointofsale.repositories.InMemoryProductRepositoryImpl;
import me.frankelydiaz.pointofsale.services.PointOfSaleTerminalService;
import me.frankelydiaz.pointofsale.services.PointOfSaleTerminalServiceImpl;
import me.frankelydiaz.pointofsale.services.ProductService;
import me.frankelydiaz.pointofsale.services.ProductServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class PointOfSaleCheckoutStepDefs {

    private ProductService productService;
    private PointOfSaleTerminalService pointOfSaleTerminaService;

    public PointOfSaleCheckoutStepDefs() {
        this.productService = new ProductServiceImpl(InMemoryProductRepositoryImpl.getInstance());
        this.pointOfSaleTerminaService = new PointOfSaleTerminalServiceImpl(new ShoppingCartImpl(), InMemoryProductRepositoryImpl.getInstance());
    }


    @Given("^these products exists$")
    public void createProducts(List<Product> products) throws Throwable {
        productService.add(products);
    }

    @And("^have these volume prices$")
    public void createProductVolumePrices(List<ProductVolumePrice> productVolumePrices) throws Throwable {
        productService.addVolumePrice(productVolumePrices);
    }

    @Given("^I add these products to my shopping cart$")
    public void addToShoppingCart(List<String> products) throws Throwable {
        pointOfSaleTerminaService.scan(products);
    }

    @When("^I process my order$")
    public void processOrder() throws Throwable {

    }

    @Then("^the total should be (.+)$")
    public void viewTotal(BigDecimal total) throws Throwable {
        assertEquals(total, pointOfSaleTerminaService.calculateTotal());
    }
}
