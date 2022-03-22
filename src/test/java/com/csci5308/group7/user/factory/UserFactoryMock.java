package com.csci5308.group7.user.factory;

import com.csci5308.group7.user.interfaces.IUser;
import com.csci5308.group7.user.User;
import com.csci5308.group7.user.interfaces.ILogin;
import com.csci5308.group7.user.Login;
import com.csci5308.group7.user.interfaces.IUserModel;
import com.csci5308.group7.user.model.UserModelMock;
import com.csci5308.group7.user.interfaces.ISignup;
import com.csci5308.group7.user.Signup;

public class UserFactoryMock extends AbstractUserFactoryMock {

    @Override
    public IUser createUserMock() {
        return new User();
    }

    @Override
    public IUserModel createUserModelMock() {
        return new UserModelMock();
    }

    @Override
    public ILogin createLoginMock() {
        return new Login();
    }

    @Override
    public ISignup createSignupMock() {
        return new Signup();
    }

}
