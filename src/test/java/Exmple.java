
import io.restassured.http.ContentType;
import models.requestModels.LoginRequest;
import models.requestModels.UserRequest;
import models.responseModels.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Exmple extends BaseTest {
    @Test
    public void test() {
        UserListResponse user = USER_STEPS.getUserList();
        System.out.println(user);
    }

    @Test
    public void test1() {
        UserResponse user = USER_STEPS.getUserById(2, 200);
        System.out.println(user);
    }

    @Test
    public void test2() {
        UserResponse user = USER_STEPS.getUserById(23, 404);
        System.out.println(user);
    }

    @Test
    public void test3() {
        UnknownList user = USER_STEPS.getUnknownList();
        System.out.println(user);
    }

    @Test
    public void test4() {
        UnknownSingle user = USER_STEPS.getUnknownById(2, 200);
        System.out.println(user);
    }

    @Test
    public void test5() {
        UnknownSingle user = USER_STEPS.getUnknownById(23, 404);
        System.out.println(user);
    }

    @Test
    public void test6() {
        UserRequest userRequest = new UserRequest("morpheus", "leader");
        CreatedUserResponse user = USER_STEPS.postUser(userRequest);
        System.out.println(user);
    }

    @Test
    public void test7() {
        UserRequest userRequest = new UserRequest("morpheus", "leader");
        UserChangedResponse user = USER_STEPS.putUser(userRequest);
        System.out.println(user);
    }

    @Test
    public void test8() {
        UserRequest userRequest = new UserRequest("morpheus", "leader");
        UserChangedResponse user = USER_STEPS.patchUser(userRequest);
        System.out.println(user);
    }

    @Test
    public void test9() {
        USER_STEPS.deleteUser();
    }

    @Test
    public void test10() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", "pistol");
        RegisterResponse registerResponse = USER_STEPS.userRegisterAndNot(loginRequest,200);
        System.out.println(registerResponse);
        Assert.assertTrue(registerResponse.toString().contains("id=4"));
    }
    @Test
    public void test11() {
        LoginRequest loginRequest = new LoginRequest("sydney@fife", null);
        RegisterResponse registerResponse = USER_STEPS.userRegisterAndNot(loginRequest, 400);
        System.out.println(registerResponse);
        Assert.assertTrue(registerResponse.toString().contains("Missing password"));
    }
    @Test
    public void test12() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", "cityslicka");
        LoginResponse loginResponse = USER_STEPS.userLoginAndNot(loginRequest,200);
        System.out.println(loginResponse);
        Assert.assertTrue(loginResponse.toString().contains("token"));
    }
    @Test
    public void test13() {
        LoginRequest loginRequest = new LoginRequest("eve.holt@reqres.in", null);
        LoginResponse registerResponse = USER_STEPS.userLoginAndNot(loginRequest, 400);
        System.out.println(registerResponse);
        Assert.assertTrue(registerResponse.toString().contains("Missing password"));
    }
    @Test
    public void test14() {
        UserListResponse user = USER_STEPS.getDelay();
        System.out.println(user);
    }
}
