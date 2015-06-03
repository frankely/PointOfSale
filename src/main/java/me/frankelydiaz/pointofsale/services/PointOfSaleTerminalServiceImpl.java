package me.frankelydiaz.pointofsale.services;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;
import me.frankelydiaz.pointofsale.repositories.ProductRepository;

import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class PointOfSaleTerminalServiceImpl implements PointOfSaleTerminalService {

    private ProductRepository productRepository;

    public PointOfSaleTerminalServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void add(List<Product> products) {
        products.stream().forEach(p -> productRepository.add(p));
    }

    @Override
    public void addVolumePrice(ProductVolumePrice productVolumePrice) throws EntryNotFoundException {
        productRepository.addVolumePrice(productVolumePrice);
    }

    @Override
    public void addVolumePrice(List<ProductVolumePrice> productVolumePrices) {
        productVolumePrices.stream().forEach(p -> {
            try {
                productRepository.addVolumePrice(p);
            } catch (EntryNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
