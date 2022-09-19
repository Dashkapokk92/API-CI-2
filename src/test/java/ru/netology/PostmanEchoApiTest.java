package ru.netology;
import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;
public class PostmanEchoApiTest {
    @Test
    void shouldReturnDemoAccounts() {
        //Given - When - Then
        //Предусловия
        given()
                .baseUri("https://postman-echo.com")
                //.contentType("text/plain; charset=UTF-8")
                .body("Hellow,you have called," + //отправка данных (заголовки и query можно выставлять аналогично)
                        "to the online store." +
                        "How can I help.")
                //Выполняемые действия
                .when()
                .post("/post")
                //Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Hellow,you have called," +
                        "to the online store." +
                        "How can I help."));
    }

}
