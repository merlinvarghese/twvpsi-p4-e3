package com.tw.vapasi;

import java.util.List;

public class Unit {

    static Unit CM = new Unit(1);
    static Unit M = new Unit(100);
    static Unit KM = new Unit(100000);
    static Unit GM = new Unit(1);
    static Unit KG = new Unit(1000);

    private final int conversionFactor;

    Unit(int conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

   double convertToBase(double value)
   {
       return value * conversionFactor;
   }

}
