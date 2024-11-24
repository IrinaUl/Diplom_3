package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.api.model.User;
import site.nomoreparties.stellarburgers.driver.DriverConfig;

import static io.restassured.RestAssured.given;

public class UserResponse {
    public static final String CREATE_PATH = "/api/auth/register";
    public static final String LOGIN_PATH = "/api/auth/login";
    private static final String DELETE_PATH = "/api/auth/user";
    private static final String UPDATE_PATH = "/api/auth/user";

    @Step("Регистрации нового пользователя")
    public Response create(User user) {
        RestAssured.baseURI = DriverConfig.BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(CREATE_PATH);
    }

    @Step("Логин пользователя")
    public Response login(User user) {
        RestAssured.baseURI = DriverConfig.BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(LOGIN_PATH);
    }

    @Step("Удаление пользователя")
    public Response delete(String token) {
        RestAssured.baseURI = DriverConfig.BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .delete(DELETE_PATH);
    }

    @Step("Изменение пользователя")
    public Response update (User user, String token) {
        RestAssured.baseURI = DriverConfig.BASE_URL;
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", token)
                .body(user)
                .patch(UPDATE_PATH);
    }
}
