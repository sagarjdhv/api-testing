package nz.co.testing;

import org.yaml.snakeyaml.Yaml;
import java.io.*;


public class TestDataProvider {

    Yaml yaml;
    InputStream testDataInputStream;
    Config configYaml;

    TestDataProvider() throws FileNotFoundException {
        yaml = new Yaml();
        testDataInputStream = new FileInputStream(new File(".\\src\\test\\resources\\config.yml"));
        configYaml = yaml.loadAs(testDataInputStream, Config.class);
    }


}
