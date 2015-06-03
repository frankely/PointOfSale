package me.frankelydiaz.pointofsale.repositories;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public interface ProductRepository {
    public void add(Product product);
    public Product find(String productCode);
    public void addVolumePrice(ProductVolumePrice productVolumePrice) throws EntryNotFoundException;
}
