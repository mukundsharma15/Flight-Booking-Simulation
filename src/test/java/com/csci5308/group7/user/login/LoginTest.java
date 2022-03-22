package com.csci5308.group7.user.login;

import com.csci5308.group7.user.interfaces.IUser;
import com.csci5308.group7.user.factory.AbstractUserFactoryMock;
import com.csci5308.group7.user.interfaces.ILogin;
import com.csci5308.group7.user.interfaces.IUserModel;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginTest {

    static AbstractUserFactoryMock userFactoryMock = AbstractUserFactoryMock.instance();


    private static IUser iUser;
    private static IUserModel iUserModel;
    private static ILogin iLogin;

    @BeforeAll
    public static void init() {
        iUser = userFactoryMock.createUserMock();
        iUserModel = userFactoryMock.createUserModelMock();
        iLogin = userFactoryMock.createLoginMock();

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
        iLogin = null;
    }

    @Test
    public void checkCredentialsTest() {
        Assert.assertNotEquals(false, iLogin.checkCredentials(iUser, iUserModel));
    }

}
