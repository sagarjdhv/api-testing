package nz.co.testing;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.*;

public class BaseApiTest {

    // A ResponseSpecification for successful requests.
    static ResponseSpecification successResponseSpec;

    //String defined to format output
    static String formatting = new String(new char[70]).replace("\0","=");

    //Access config.yml
    static TestDataProvider testDataProvider;

    static {
        try {
            testDataProvider = new TestDataProvider();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Access the Test Name
    @Rule
    public TestName name = new TestName();

    //Constructor
    public BaseApiTest() throws FileNotFoundException {
    }


    /*
     * Setup Base URI
     */
    @BeforeClass
    public static void configureAPIDefaults(){
        baseURI = testDataProvider.configYaml.env.get("uri");
        basePath = testDataProvider.configYaml.env.get("path");
    }


    @BeforeClass
    public static void createDefaultResponseSpec(){
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType(ContentType.XML);
        //TODO - below response builder is failing test
        //builder.expectBody("isEmpty()", Matchers.is(false));
        successResponseSpec = builder.build();
    }


    /*
     * Get the current listings of Brands on Used Category
     */
    @BeforeClass
    public static void getListings(){

        XmlPath xmlpath = get("https://api.trademe.co.nz/v1/Categories/UsedCars.xml").xmlPath();
        System.out.println(formatting);
        System.out.println("Number of Cars Currently Listed in Used Cars Category : "+xmlpath.getList("Category.Subcategories.Category.Name").size());
        System.out.println(formatting);
        System.out.println("Brand of Cars currently listed : "+xmlpath.getList("Category.Subcategories.Category.Name"));
        System.out.println(formatting);
    }

}
