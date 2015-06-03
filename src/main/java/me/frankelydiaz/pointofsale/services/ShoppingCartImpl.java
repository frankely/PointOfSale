package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;

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

        final Map<String, Long> unitsByProduct = products.stream()
                .collect(Collectors.groupingBy(o -> o.getCode(), Collectors.counting()));

        BigDecimal total = BigDecimal.ZERO;

        for (Map.Entry<String, Long> unitByProduct : unitsByProduct.entrySet()) {
            total = total.add(calculateProductTotal(unitByProduct.getKey(), unitByProduct.getValue()));
        }

        return total;
    }

    @Override
    public void clear() {
        products = new ArrayList<>();
    }

    private BigDecimal calculateProductTotal(final String productCode, final long units) {

        final Product product = products.stream().filter(p -> p.getCode() == productCode).findFirst().get();

        if (product == null)
            return BigDecimal.ZERO;
        
        if (units == SINGLE_UNIT)
            return product.getPrice();

        if (product.hasVolumePrices()) {
            final ProductVolumePrice volumePrice = product.getVolumePrices().stream().filter(v -> v.getUnits() <= units).findFirst().get();

            if (volumePrice == null)
                return product.getPrice().multiply(new BigDecimal(units));

            final long unitsGroupByVolume = (int) units / volumePrice.getUnits();
            final long singleUnits = (units - (unitsGroupByVolume * volumePrice.getUnits()));

            BigDecimal unitsGroupByVolumeTotal = volumePrice.getPrice().multiply(new BigDecimal(unitsGroupByVolume));
            BigDecimal singleUnitsTotal = product.getPrice().multiply(new BigDecimal(singleUnits));

            return unitsGroupByVolumeTotal.add(singleUnitsTotal);
        }

        return product.getPrice().multiply(new BigDecimal(units));
    }

}
