package ru.yandex.praktikum.pages.helper;

import io.restassured.path.json.JsonPath;
import ru.yandex.praktikum.pages.model.User;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.pages.helper.UserData.defaultUserLogin;

public class DeleteUser {
    User user = defaultUserLogin();
    String baseURL = "https://stellarburgers.nomoreparties.site";

    public void deleteDefaultUser() {
        String token;
        token = given()
                .header("Content-type", "application/json")
                .baseUri(baseURL)
                .body(user)
                .when()
                .post("/api/auth/login").then().extract().path("accessToken");


        given()
                .header("Authorization", token)
                .baseUri(baseURL)
                .when()
                .delete("/api/auth/user")
              .then().statusCode(202);
    }
}
