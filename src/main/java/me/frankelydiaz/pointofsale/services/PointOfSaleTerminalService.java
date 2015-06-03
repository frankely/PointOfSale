package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;

import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public interface PointOfSaleTerminalService {
    void add(Product product);
    void add(List<Product> products);
    void addVolumePrice(ProductVolumePrice productVolumePrice) throws EntryNotFoundException;
    void addVolumePrice(List<ProductVolumePrice> productVolumePrices);

}
