import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Test_API {

    private static String requestBody =  "{'name':'test','salary':'123','age':'23'}";

    @Test
    public void get_employees() {

        given().
        when().
        get("http://dummy.restapiexample.com/api/v1/employees").
        then().
        assertThat().
        statusCode(200).
        log().body();

    }
    @Test
    public void get_one_employee() {

        given().
        when().
        get("http://dummy.restapiexample.com/api/v1/employee/2").
        then().
        assertThat().
        statusCode(200).
        log().body();

    }
    @Test
    public void create_one_employee() {
        Response response = given().
        header("Content-type", "application/json").
        and().
        body(requestBody).
        when().
        post("http://dummy.restapiexample.com/api/v1/create").
        then().
        log().body().
        extract().response();
        Assert.assertEquals( 200, response.statusCode());

    }

}
