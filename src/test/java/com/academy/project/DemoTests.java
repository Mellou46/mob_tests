package com.academy.project;

import com.academy.core.test.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.academy.project.page.HomePage.startFromHome;

public class DemoTests extends BaseTest {
    private static final Logger LOG =  LogManager.getLogger(DemoTests.class);

//    @Test(dataProvider = "testDataProvider")
//    public void testFeature(String value) {
//        String title = startFromHome(driver, baseUrl)
//                .inputSearch(value)
//                .clickSearch()
//                .getTitle();
//
//        Assert.assertTrue(title.contains(value));
//    }


    @Test(dataProvider = "testDataProvider")
    public void testGetFirstSubscriber(String exp) {
        driver.get("http://localhost:8081/subscribers");
        String act = driver.findElement(By.xpath("//tbody/tr[1]/td[3]")).getText();
        Assert.assertEquals(exp, act);
        System.out.println(exp);
        System.out.println(act);
    }

    @DataProvider(name="testDataProvider")
    public Object[][] testDataProvider() {
        return new Object[][] {
                {"Peter"}
        };
    }
}
