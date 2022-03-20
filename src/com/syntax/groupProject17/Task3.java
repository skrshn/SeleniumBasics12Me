package com.syntax.groupProject17;

interface Car {
    double carPrice = 0;
    String color = null;

    double calculateSalePrice(double carPrice);
}

class Sedan implements Car {
    double sedanLength;

    @Override
    public double calculateSalePrice(double carPrice) {
        if (sedanLength > 20) {
            return (carPrice * 5) / 100;
        } else
            return (carPrice * 10) / 100;
    }
}

class Truck implements Car {
    double weight;

    @Override
    public double calculateSalePrice(double carPrice) {
        if (weight > 2000) {
            return (carPrice * 10) / 100;
        } else
            return (carPrice * 20) / 100;
    }
}