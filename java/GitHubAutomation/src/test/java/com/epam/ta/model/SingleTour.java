package com.epam.ta.model;

import java.util.Objects;

public class SingleTour {

    private String minPrice;
    private String maxPrice;

    public SingleTour(String minPrice, String maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "min price='" + minPrice + '\'' +
                ", max price='" + maxPrice + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleTour)) return false;
        SingleTour price = (SingleTour) o;
        return Objects.equals(getMinPrice(), price.getMinPrice()) &&
                Objects.equals(getMaxPrice(), price.getMaxPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaxPrice(), getMinPrice());
    }
}