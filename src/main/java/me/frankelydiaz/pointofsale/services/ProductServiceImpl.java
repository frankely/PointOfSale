package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;
import me.frankelydiaz.pointofsale.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(final Product product) {

        if (product.getVolumePrices() == null)
            product.setVolumePrices(new ArrayList<>());

        productRepository.add(product);
    }

    @Override
    public void add(final List<Product> products) {
        products.stream().forEach(p -> productRepository.add(p));
    }

    @Override
    public void addVolumePrice(final ProductVolumePrice productVolumePrice) throws EntryNotFoundException {
        productRepository.addVolumePrice(productVolumePrice);
    }

    @Override
    public void addVolumePrice(final List<ProductVolumePrice> productVolumePrices) {
        productVolumePrices.stream().forEach(p -> {
            try {
                productRepository.addVolumePrice(p);
            } catch (EntryNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
