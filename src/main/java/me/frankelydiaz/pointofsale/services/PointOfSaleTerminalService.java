package me.frankelydiaz.pointofsale.services;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public interface PointOfSaleTerminalService {
    void scan(final String productCode);
    BigDecimal calculateTotal();
    void scan(final List<String> products);
}
