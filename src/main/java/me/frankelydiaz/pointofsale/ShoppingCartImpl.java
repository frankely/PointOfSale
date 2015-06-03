package me.frankelydiaz.pointofsale;

import me.frankelydiaz.pointofsale.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class ShoppingCartImpl implements ShoppingCart {

    private static final long SINGLE_UNIT = 1L;
    private List<Product> products;

    public ShoppingCartImpl() {
        this.products = new ArrayList<>();
    }

    @Override
    public void add(final Product product) {
        products.add(product);
    }

    @Override
    public BigDecimal calculateTotal() {
        if (products.isEmpty())
            return BigDecimal.ZERO;

        Map<String, Long> unitsByProduct = products.stream()
                .collect(Collectors.groupingBy(o -> o.getCode(), Collectors.counting()));

        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<String, Long> unitByProduct : unitsByProduct.entrySet()) {
            total = total.add(calculateProductTotal(unitByProduct.getKey(), unitByProduct.getValue()));
        }

        return total;
    }

    private BigDecimal calculateProductTotal(final String productCode, final long units) {

        Product product = products.stream().filter(p -> p.getCode() == productCode).findFirst().get();

        if (product == null)
            return BigDecimal.ZERO;
        
        if (units == SINGLE_UNIT)
            return product.getPrice();

        return BigDecimal.ZERO;
    }

}
