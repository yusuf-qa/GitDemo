package stepdefinitions;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
    //imp to make veriable req as static because
    // when 2 set of test data log should maintain both run and logic of if statement.
    public static RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {
        if (req == null) {

            PrintStream log = new PrintStream(new FileOutputStream("logging.log"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter((ResponseLoggingFilter.logResponseTo(log)))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;

    }

    //property file setup and made method as static to access without creating obj in main step definitions
    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\yusuf\\automationProjects\\src\\test\\resources\\Global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }
}
