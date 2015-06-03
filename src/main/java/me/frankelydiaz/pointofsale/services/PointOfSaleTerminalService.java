package me.frankelydiaz.pointofsale.services;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public interface PointOfSaleTerminalService {
    void scan(String productCode);
    BigDecimal calculateTotal();
    void scan(List<String> products);
}
