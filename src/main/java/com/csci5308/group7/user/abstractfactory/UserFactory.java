package com.csci5308.group7.user.abstractfactory;

import com.csci5308.group7.user.interfaces.*;
import com.csci5308.group7.user.*;

public class UserFactory extends AbstractUserFactory {

    @Override
    public IUser createUser() {
        return new User();
    }

    @Override
    public IUserModel createUserModel() {
        return UserModel.instance();
    }

    @Override
    public ISignup createSignup() {
        return new Signup();
    }

    @Override
    public ILogin createLogin() {
        return new Login();
    }
}
