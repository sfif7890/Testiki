package steps.apiSteps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.requestModels.LoginRequest;
import models.requestModels.UserRequest;
import models.responseModels.*;


import static io.restassured.RestAssured.given;

public class UserSteps {
    @Step
    public UserListResponse getUserList () {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().as(UserListResponse.class);
    }
        @Step
        public UserResponse getUserById (Integer id, Integer code) {
            return given()
                    .baseUri("https://reqres.in")
                    .contentType(ContentType.JSON)
                    .get("/api/users/"+id)
                    .then()
                    .assertThat()
                    .statusCode(code)
                    .extract().response().as(UserResponse.class);
    }
    @Step
    public UnknownList getUnknownList () {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .get("/api/unknown/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().as(UnknownList.class);
    }
    @Step
    public UnknownSingle getUnknownById (Integer id, Integer code) {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .get("/api/unknown/"+id)
                .then()
                .assertThat()
                .statusCode(code)
                .extract().response().as(UnknownSingle.class);
    }
    @Step
    public CreatedUserResponse postUser (UserRequest UR) {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .post("/api/users")
                .then()
                .assertThat()
                .statusCode(201)
                .extract().response().as(CreatedUserResponse.class);
    }
    @Step
    public UserChangedResponse putUser (UserRequest UR) {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .put("/api/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().as(UserChangedResponse.class);
    }
    @Step
    public UserChangedResponse patchUser (UserRequest UR) {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .patch("/api/users/2")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().as(UserChangedResponse.class);
    }
    @Step
    public void deleteUser () {
        given()
                .baseUri("https://reqres.in")
                .delete("/api/users/2")
                .then()
                .assertThat()
                .statusCode(204)
                .extract()
                .response();
    }
    @Step
    public RegisterResponse userRegisterAndNot(LoginRequest LR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(LR)
                .contentType(ContentType.JSON)
                .post("/api/register")
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(RegisterResponse.class);
    }
    @Step
    public LoginResponse userLoginAndNot(LoginRequest LR, Integer statusCode) {
        return given()
                .baseUri("https://reqres.in")
                .body(LR)
                .contentType(ContentType.JSON)
                .post("/api/login")
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(LoginResponse.class);
    }
    @Step
    public UserListResponse getDelay () {
        return given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().as(UserListResponse.class);
    }

}