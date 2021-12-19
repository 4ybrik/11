package com.epam.ta.test;

import com.epam.ta.model.SingleTour;
import com.epam.ta.page.SingleTourPage;
import com.epam.ta.test.CommonConditions;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.epam.ta.service.SingleTourCreator;

import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TourFirstPageTest extends CommonConditions {

    private static final String MIN_PRICE="1000";
    private static final String MAX_PRICE="2000";
    //SingleTour testTour = SingleTourCreator.withEmptyPlaceOfDeparture();

    @Test
    void checkPrice() {
        List<Double> prices = new SingleTourPage(driver)
                .openPage()
                .setPrice(MIN_PRICE,MAX_PRICE)
                .getFirstFindedTour();
        Assertions.assertThat(prices)
                .allSatisfy(price->Assertions.assertThat(price).isGreaterThanOrEqualTo(Double.parseDouble(MIN_PRICE))
                .isLessThanOrEqualTo(Double.parseDouble(MAX_PRICE)));
    }
}