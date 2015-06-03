package me.frankelydiaz.pointofsale.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class Product {
    private String code;
    private BigDecimal price;
    private List<ProductVolumePrice> volumePrices;

    public Product() {
        volumePrices = new ArrayList<>();
    }

    public Product(String code, BigDecimal price) {
        this();
        this.code = code;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ProductVolumePrice> getVolumePrices() {
        return volumePrices;
    }

    public void setVolumePrices(List<ProductVolumePrice> volumePrices) {
        this.volumePrices = volumePrices;
    }
}

