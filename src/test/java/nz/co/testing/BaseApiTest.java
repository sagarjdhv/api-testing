package nz.co.testing;

import io.restassured.path.xml.XmlPath;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import static io.restassured.RestAssured.*;

public class BaseApiTest {

    /*
     * String defined to format output
     */
    static String formatting = new String(new char[70]).replace("\0","=");


    /*
     * Setup Base URI
     */
    @Before
    public void setup(){
        baseURI = "https://api.trademe.co.nz";
    }

    /*
     * Access the Test Name
     */
    @Rule
    public TestName name = new TestName();


    /*
     * Get the current listings of Brands on Used Category
     */
    @BeforeClass
    public static void getListings(){

        //String formatting = new String(new char[70]).replace("\0","=");
        XmlPath xmlpath = get("https://api.trademe.co.nz/v1/Categories/UsedCars.xml").xmlPath();

        System.out.println(formatting);
        System.out.println("Number of Cars Currently Listed in Used Cars Category : "+xmlpath.getList("Category.Subcategories.Category.Name").size());
        System.out.println(formatting);
        System.out.println("Brand of Cars currently listed : "+xmlpath.getList("Category.Subcategories.Category.Name"));
        System.out.println(formatting);

    }




}
