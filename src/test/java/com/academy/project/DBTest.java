package com.academy.project;

import com.academy.core.test.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DBTest extends BaseTest {
    private static final Logger LOG = LogManager.getLogger(DBTest.class);
    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://localhost/rest/json";
        RestAssured.port = 8081;
    }

    @Test
    public void testGetSubscribers(){
        Response response = RestAssured.given()
                .get("/subscribers");

        int code = response.getStatusCode();
        String body = response.getBody().print();
        int size = (int)response.getBody().path("size()");
        int id = response.getBody().path("[0].id");
        String fname = response.getBody().path("[0].firstName");
        String lname = response.getBody().path("[0].lastName");

        System.out.println(code + size);
        System.out.println("*************");
        System.out.println(id);
        System.out.println(fname);
        System.out.println(lname);
    }

}
