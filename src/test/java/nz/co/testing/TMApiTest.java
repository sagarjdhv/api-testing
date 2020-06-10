package nz.co.testing;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.junit.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TMApiTest extends BaseApiTest {


    public TMApiTest() throws FileNotFoundException {
    }


    @Test
    public void brandKiaExists(){

        /**
         * Given content to be Accepted in XML Format
         * When a valid GET request is successfully sent
         * Then a success response is received
         * And element "Category.Subcategories.Category.Name" is present with a value "Kia"
         **/
        System.out.println(formatting);
        System.out.println("Test Scenario: "+name.getMethodName());
        System.out.println( "Test Data:"+testDataProvider.configYaml.testData.get("test1"));
        System.out.println(formatting);

        given()
            .log().all()
        .when()
            .get()
        .then()
            .log().all()
            .spec(successResponseSpec)
        .and()
            .assertThat()
            .body("Category.Subcategories.Category.Name", hasItem(testDataProvider.configYaml.testData.get("test1")));


        XmlPath xmlpath = get("/v1/Categories/UsedCars.xml").xmlPath();

        if(xmlpath.getList("Category.Subcategories.Category.Name").contains("Kia")) {
            System.out.println(formatting);
            System.out.println("Current Number of Kia Cars Listed : " + xmlpath.get("Category.Subcategories.Category.findAll{it.Name=='Kia'}.size()"));
            System.out.println(formatting);
        }
        else {
            System.out.println(formatting);
            System.out.println("There is no current listing of Kia Cars");
            System.out.println(formatting);
        }
    }


    @Test
    public void brandHispanoSuizaDoesNotExists(){

        /**
         * Given content to be Accepted in XML Format
         * When a valid GET request is successfully sent
         * Then a success response is received
         * And element "Category.Subcategories.Category.Name" is not present with a value "Hispano Suiza"
         **/

        System.out.println(formatting);
        System.out.println("Test Scenario: "+name.getMethodName());
        System.out.println( "Test Data:"+testDataProvider.configYaml.testData.get("test2"));
        System.out.println(formatting);

        given()
            .log().all()
        .when()
            .get()
        .then()
            .log().all()
            .spec(successResponseSpec)
        .and()
            .assertThat()
            .body("Category.Subcategories.Category.Name", not(hasItem(testDataProvider.configYaml.testData.get("test2"))));


    }



}



