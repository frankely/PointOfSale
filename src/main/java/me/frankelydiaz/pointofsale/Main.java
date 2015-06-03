package me.frankelydiaz.pointofsale;

import me.frankelydiaz.pointofsale.exceptions.EntryNotFoundException;
import me.frankelydiaz.pointofsale.models.Product;
import me.frankelydiaz.pointofsale.models.ProductVolumePrice;

import java.math.BigDecimal;

/**
 * Created by frankelydiaz on 6/3/15.
 */
public class Main {
    public static void main(String[] args) throws EntryNotFoundException {

        //Get a new instance of PointOfSaleFacade
        PointOfSaleFacade pointOfSaleFacade = new PointOfSaleFacade();

        pointOfSaleFacade.getProductService().add(new Product("A",new BigDecimal(2.00)));
        pointOfSaleFacade.getProductService().addVolumePrice(new ProductVolumePrice("A",4,new BigDecimal(7.00)));


        pointOfSaleFacade.getProductService().add(new Product("B",new BigDecimal(12.00)));

        pointOfSaleFacade.getProductService().add(new Product("C",new BigDecimal(1.25)));
        pointOfSaleFacade.getProductService().addVolumePrice(new ProductVolumePrice("C",6,new BigDecimal(6.00)));

        pointOfSaleFacade.getProductService().add(new Product("D",new BigDecimal(0.15)));

        pointOfSaleFacade.getPointOfSaleTerminaService().scan("A");
        pointOfSaleFacade.getPointOfSaleTerminaService().scan("B");
        pointOfSaleFacade.getPointOfSaleTerminaService().scan("C");
        pointOfSaleFacade.getPointOfSaleTerminaService().scan("D");

        System.out.println(pointOfSaleFacade.getPointOfSaleTerminaService().calculateTotal());

        pointOfSaleFacade.getPointOfSaleTerminaService().checkout();
    }
}
