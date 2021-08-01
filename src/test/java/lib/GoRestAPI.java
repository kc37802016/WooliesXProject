package test.java.lib;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GoRestAPI {
    public static Configuration conf;

    public GoRestAPI() {
        conf = new Configuration();
    }

    public RequestSpecification reqSpec() {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri(conf.getProperty("URI")).setContentType(ContentType.JSON).build();
        RequestSpecification resp = given().spec(req);
        return resp;
    }


    public String resSpec(String RequestType, String StatusCode) {
        int status = Integer.parseInt(StatusCode);
        RequestSpecification r = reqSpec();
        String resPonseD = "";
        int statusCde = 0;
        ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(status).expectContentType(ContentType.JSON).build();
        if (RequestType.equalsIgnoreCase("GET")) {
            resPonseD = r.expect().defaultParser(Parser.JSON).when().get().then().spec(resSpec).extract().response().asPrettyString();
            statusCde = r.expect().defaultParser(Parser.JSON).when().get().statusCode();
        }
        System.out.println(resPonseD);
        System.out.println("Status code displayed is: "+statusCde);
        if (statusCde == status) {
            Assert.assertTrue("Status Code is displayed correctly: " + statusCde, true);
        } else {
            Assert.fail("Name field is not displayed correctly");
        }
        return resPonseD;
    }

    public void jsonSchemaValidator(String RequestType, String StatusCode) {
        int status = Integer.parseInt(StatusCode);
        RequestSpecification r = reqSpec();
        ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(status).expectContentType(ContentType.JSON).build();
        if (RequestType.equalsIgnoreCase("GET")) {
            r.expect().defaultParser(Parser.JSON).when().get().then().spec(resSpec).body(JsonSchemaValidator.matchesJsonSchemaInClasspath("testData/JSONSchemaValidator.json"));
        }
    }
}
