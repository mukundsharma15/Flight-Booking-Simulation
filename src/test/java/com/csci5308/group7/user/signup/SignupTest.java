package com.csci5308.group7.user.signup;

import com.csci5308.group7.user.interfaces.IUser;
import com.csci5308.group7.user.factory.AbstractUserFactoryMock;
import com.csci5308.group7.user.interfaces.ISignup;
import com.csci5308.group7.user.interfaces.IUserModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SignupTest {

    static AbstractUserFactoryMock  userFactoryMock = AbstractUserFactoryMock.instance();


    private static IUser iUser;
    private static IUserModel iUserModel;
    private static ISignup iSignup;


    @BeforeAll
    public static void init() {
        iUser = userFactoryMock.createUserMock();
        iUserModel = userFactoryMock.createUserModelMock();
        iSignup = userFactoryMock.createSignupMock();

        iUser.setFirstName("Willem");
        iUser.setLastName("Dafoe");
        iUser.setEmail("willem@gmail.com");
        iUser.setPassword("password");
        iUser.setMobileNo("1234567890");
        iUser.setUserType(1);
        iUser.setAddress("123 Main St");
        iUser.setDob("01/01/1990");
        iUser.setPhotoId("ALKp23");
        iUser.setGender("M");
    }

    @AfterAll
    public static void cleanUp() {
        iUser = null;
        iUserModel = null;
        iSignup = null;
    }

    @Test
    void createUser() {
        assertNotEquals(true, iSignup.createUser(iUser, iUserModel));
    }
}
