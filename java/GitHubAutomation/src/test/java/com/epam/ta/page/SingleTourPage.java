package com.epam.ta.page;

import com.epam.ta.model.SingleTour;
import com.epam.ta.test.TourFirstPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class SingleTourPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static String HOMEPAGE_URL = "https://www.holiday.by/tours";

    @FindBy(xpath = "//*[@id='tour-price-start']")
    private WebElement inputMinPrice;

    @FindBy(xpath = "//*[@id='tour-price-end']")
    private WebElement inputMaxPrice;

    @FindBy(xpath = "//main")
    private WebElement mainPage;


    public SingleTourPage(WebDriver driver) {
        super(driver);
    }

    public List<Double> getFirstFindedTour(){
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id=\"search-results\"]/div[1]")));
        //div[contains(@class,' tour-thumbnail js-click-tour tour-thumbnail_hotel tour-thumbnail_transport')]
        return driver.findElements(By.className("tour-thumbnail__price-value"))
                .stream().map((div)->Double.parseDouble(div.getText().replace(" ","").replace(",",".")))
                .collect(Collectors.toList());

    }
    @Override
    public SingleTourPage openPage() {
        driver.navigate().to(HOMEPAGE_URL);
        logger.info("Login page opened");
        return this;
    }

    public SingleTourPage setPrice(String minPrice, String maxPrice) {
        inputMinPrice.sendKeys(minPrice);
        inputMaxPrice.sendKeys(maxPrice);
        mainPage.click();
        return this;
    }
}