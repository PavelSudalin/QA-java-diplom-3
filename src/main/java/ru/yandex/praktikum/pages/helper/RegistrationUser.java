package ru.yandex.praktikum.pages.helper;

import ru.yandex.praktikum.pages.model.User;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.pages.helper.UserData.defaultUserData;

public class RegistrationUser {
    private final User user = defaultUserData();
    String baseURL = "https://stellarburgers.nomoreparties.site";
    public void registrationUser() {
        given()
                .header("Content-type", "application/json")
                .baseUri(baseURL)
                .body(user)
                .when()
                .post("/api/auth/register")
                .then().statusCode(200);
    }
}
