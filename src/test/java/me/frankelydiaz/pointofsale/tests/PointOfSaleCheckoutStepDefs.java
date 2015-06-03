package me.frankelydiaz.pointofsale.tests;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import me.frankelydiaz.pointofsale.PointOfSaleFacade;
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

    private PointOfSaleFacade pointOfSaleFacade;


    public PointOfSaleCheckoutStepDefs() {
        pointOfSaleFacade = new PointOfSaleFacade();
    }


    @Given("^these products exists$")
    public void createProducts(List<Product> products) throws Throwable {
        pointOfSaleFacade.getProductService().add(products);
    }

    @And("^have these volume prices$")
    public void createProductVolumePrices(List<ProductVolumePrice> productVolumePrices) throws Throwable {
        pointOfSaleFacade.getProductService().addVolumePrice(productVolumePrices);
    }

    @Given("^I add these products to my shopping cart$")
    public void addToShoppingCart(List<String> products) throws Throwable {
        pointOfSaleFacade.getPointOfSaleTerminaService().scan(products);
    }


    @Then("^the total should be (.+)$")
    public void viewTotal(BigDecimal total) throws Throwable {
        total = total.setScale(2);
        assertEquals(total, pointOfSaleFacade.getPointOfSaleTerminaService().calculateTotal());
    }
}
