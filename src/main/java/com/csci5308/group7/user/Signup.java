package com.csci5308.group7.user;

import com.csci5308.group7.user.interfaces.*;

public class Signup implements ISignup {

    @Override
    public boolean createUser(IUser iUser, IUserModel iUserModel) {
        return iUserModel.insertUser(iUser);
    }
}
