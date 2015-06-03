# README #

This README would normally document whatever steps are necessary to get your application up and running.


## Prerequisites ##

* Java 8 SDK
* Maven 3.0


## Run Tests ##

Run the following command in the project root folder where is located pom.xml

```
#!
mvn test

```

## Use API ##

In order to use the API you need an instance of PointOfSaleFacade

### Add a new product


```
#!java

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

```