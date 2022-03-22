package com.csci5308.group7.user;

import com.csci5308.group7.user.interfaces.*;

public class Login implements ILogin {

    @Override
    public boolean checkCredentials(IUser iUser, IUserModel iUserModel) {
        return iUserModel.checkCredentials(iUser);
    }
}
