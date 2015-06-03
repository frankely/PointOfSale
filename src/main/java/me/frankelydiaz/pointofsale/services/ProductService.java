package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;

import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public interface ProductService {
    void add(final Product product);
    void add(final List<Product> products);
    void addVolumePrice(final ProductVolumePrice productVolumePrice) throws EntryNotFoundException;
    void addVolumePrice(final List<ProductVolumePrice> productVolumePrices);
}
