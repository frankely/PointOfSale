package me.frankelydiaz.pointofsale.repositories;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class InMemoryProductRepositoryImpl implements ProductRepository {

    private static ProductRepository productRepository;

    private List<Product> products;

    private InMemoryProductRepositoryImpl() {
        this.products = new ArrayList<Product>();
    }

    public static ProductRepository getInstance() {
        if (productRepository == null)
            productRepository = new InMemoryProductRepositoryImpl();

        return productRepository;
    }

    public void add(Product product) {
        products.add(product);
    }

    public Product find(final String productCode) {
        return products.stream().filter(p -> p.getCode() == productCode).findFirst().get();
    }

    public void addVolumePrice(final ProductVolumePrice productVolumePrice) throws EntryNotFoundException {
        final Product product = find(productVolumePrice.getProductCode());

        if (product == null)
            throw new EntryNotFoundException("Product not found");

        if (product.getVolumePrices() == null)
            product.setVolumePrices(new ArrayList<>());

        product.getVolumePrices().add(productVolumePrice);

    }
}
