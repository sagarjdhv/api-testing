package nz.co.testing;

import java.util.Map;

public class Config {

    Map<String, String> env;
    Map<String, String> testData;


    public Map<String, String> getEnv() {
        return env;
    }

    public void setEnv(Map<String, String> env) {
        this.env = env;
    }

    public Map<String, String> getTestData() {
        return testData;
    }

    public void setTestData(Map<String, String> testData) {
        this.testData = testData;
    }

}
