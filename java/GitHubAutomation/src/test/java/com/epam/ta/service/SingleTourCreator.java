package com.epam.ta.service;

import com.epam.ta.model.SingleTour;

public class SingleTourCreator {

    private final static String TESTDATA_MAX_PRICE = "testdata.singleTour.maxPrice";
    private final static String TESTDATA_MIN_PRICE = "testdata.singleTour.minPrice";

    public static SingleTour withNotEmptyPrice() {
        return new SingleTour(TestDataReader.getTestData(TESTDATA_MIN_PRICE),
                TestDataReader.getTestData(TESTDATA_MAX_PRICE));
    }

    public static SingleTour withEmptyMinPrice() {
        return new SingleTour("", TestDataReader.getTestData(TESTDATA_MAX_PRICE));
    }

    public static SingleTour withEmptyMaxPrice() {
        return new SingleTour(TestDataReader.getTestData(TESTDATA_MIN_PRICE), "");
    }
}