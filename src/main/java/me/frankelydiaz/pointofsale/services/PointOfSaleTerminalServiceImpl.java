package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.ShoppingCart;
import me.frankelydiaz.pointofsale.ShoppingCartImpl;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class PointOfSaleTerminalServiceImpl implements PointOfSaleTerminalService {

    private ShoppingCart shoppingCart;
    private ProductRepository productRepository;

    public PointOfSaleTerminalServiceImpl(ShoppingCart shoppingCart, ProductRepository productRepository) {
        this.shoppingCart = shoppingCart;
        this.productRepository = productRepository;
    }

    @Override
    public void scan(final String productCode) {
        Product product = productRepository.find(productCode);

        if (product == null)
            return;

        shoppingCart.add(product);
    }

    @Override
    public BigDecimal calculateTotal() {
        return shoppingCart.calculateTotal();
    }

    @Override
    public void scan(final List<String> products) {
        if (products == null || products.isEmpty())
            return;

        products.stream().forEach(p -> scan(p));
    }
}
