package me.frankelydiaz.pointofsale;

import me.frankelydiaz.pointofsale.repositories.InMemoryProductRepositoryImpl;
import me.frankelydiaz.pointofsale.services.*;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class PointOfSaleFacade {

    private ProductService productService;
    private PointOfSaleTerminalService pointOfSaleTerminaService;

    public PointOfSaleFacade() {
        this.productService = new ProductServiceImpl(InMemoryProductRepositoryImpl.getInstance());
        this.pointOfSaleTerminaService = new PointOfSaleTerminalServiceImpl(new ShoppingCartImpl(), InMemoryProductRepositoryImpl.getInstance());
    }

    public PointOfSaleTerminalService getPointOfSaleTerminaService() {
        return pointOfSaleTerminaService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
