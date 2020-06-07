package nz.co.testing;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TMApiTest extends BaseApiTest {

    @Test
    public void brandKiaExists(){

        /**
         * Given content to be Accepted in XML Format
         * When a valid GET request is successfully sent
         * Then a 200 response code is received
         * And element "Category.Subcategories.Category.Name" is present with a value "Kia"
         **/
        System.out.println(formatting);
        System.out.println("Test Scenario : "+name.getMethodName());
        System.out.println(formatting);

        given()
                .log().all()
                .accept(ContentType.XML)
                .when()
                .get("/v1/Categories/UsedCars.xml")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("Category.Subcategories.Category.Name", hasItem("Kia"));

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
         * Then a 200 response code is received
         * And element "Category.Subcategories.Category.Name" is not present with a value "Hispano Suiza"
         **/

        System.out.println(formatting);
        System.out.println("Test Scenario : "+name.getMethodName());
        System.out.println(formatting);

        given()
                .log().all()
                .accept(ContentType.XML)
                .when()
                .get("https://api.trademe.co.nz/v1/Categories/UsedCars.xml")
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("Category.Subcategories.Category.Name", not(hasItem("Hispano Suiza")));


    }



}



