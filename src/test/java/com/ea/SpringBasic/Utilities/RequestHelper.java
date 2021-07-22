package com.ea.SpringBasic.Utilities;

import com.ea.SpringBasic.models.Prospect;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RequestHelper {

    public static void SimpleGETPost(String postNumber) {
        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s", postNumber))
                .then().body("author", is("typicode"));
    }

    public static String getProspectId(Prospect prospect) {

        int response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://hcc-backoffice-staging.herokuapp.com/api/prospects/+"+prospect.getPhoneNumber()+"?campaign_id=18") // Campaign is fixed because it will always be the same for autos.
                .then()
                .log()
                .all()
                .extract()
                .path("id");

        return String.valueOf(response);

    }

    public static void sendOptinMessage(String message, String fromPhoneNumber, String toPhoneNumber) throws JSONException {

        Random rnd = new Random();
        int id = 100000 + rnd.nextInt(900000);

        String jsonBody = "[\n" +
                "  {\n" +
                "    \"type\": \"message-received\",\n" +
                "    \"time\": \"2016-09-14T18:20:16Z\",\n" +
                "    \"description\": \"Incoming message received\",\n" +
                "    \"to\": \"+"+ toPhoneNumber +"\",\n" +
                "    \"message\": {\n" +
                "      \"id\": \""+id+"\",\n" +
                "      \"time\": \"2016-09-14T18:20:16Z\",\n" +
                "      \"to\": [\"+"+ toPhoneNumber +"\"],\n" +
                "      \"from\": \"+"+ fromPhoneNumber +"\",\n" +
                "      \"text\": \""+ message +"\",\n" +
                "      \"applicationId\" : \"93de2206-9669-4e07-948d-329f4b722ee2\",\n" +
                "      \"owner\": \"+"+ toPhoneNumber +"\",\n" +
                "      \"direction\": \"in\",\n" +
                "      \"segmentCount\": 1\n" +
                "    }\n" +
                "  }\n" +
                "]";

        

                given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .log()
                .all()
                // WHEN
                .when()
                .post("https://hcc-poc-staging.herokuapp.com/webhooks/bandwidth/optin/")
                // THEN
                .then()
                        .log().all()
                .assertThat()
                .statusCode(200)
                .log()
                .all();
    }



}
