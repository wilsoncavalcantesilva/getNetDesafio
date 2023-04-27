package testes;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GetNet {

    @Test
    public void testPost() {
        //Preparacao
        RestAssured.baseURI = "https://reqres.in/api/";

        // Criar Request
        HashMap<String, Object> body = new HashMap<>();
        body.put("name", "Francisco");
        body.put("job", "pedreiro");
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().response();
        // Validações
        assertEquals(201, response.statusCode());
    }
    @Test
    public void testPostNomeEnviandoNumeros() {
        //Preparacao
        RestAssured.baseURI = "https://reqres.in/api/";

        // Criar Request
        HashMap<String, Object> body = new HashMap<>();
        body.put("name", 123);
        body.put("job", 123);
        Response response = RestAssured.given().log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().response();
        // Validações
        assertEquals(201, response.statusCode());
    }

}
