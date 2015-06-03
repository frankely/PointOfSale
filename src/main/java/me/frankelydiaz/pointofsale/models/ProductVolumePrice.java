package me.frankelydiaz.pointofsale.models;

import java.math.BigDecimal;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class ProductVolumePrice {
    private String productCode;
    private int units;
    private BigDecimal price;

    public ProductVolumePrice() {
    }

    public ProductVolumePrice(String productCode, int units, BigDecimal price) {
        this.productCode = productCode;
        this.units = units;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
