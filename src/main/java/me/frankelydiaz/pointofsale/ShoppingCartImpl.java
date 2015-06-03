package me.frankelydiaz.pointofsale;

import me.frankelydiaz.pointofsale.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class ShoppingCartImpl implements ShoppingCart {

    private List<Product> products;

    public ShoppingCartImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public BigDecimal calculateTotal() {
        return null;
    }
}
