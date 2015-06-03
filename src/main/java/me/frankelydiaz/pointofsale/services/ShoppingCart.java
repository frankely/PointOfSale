package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.models.Product;

import java.math.BigDecimal;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public interface ShoppingCart {
    void add(final Product product);

    BigDecimal calculateTotal();

    void clear();
}

