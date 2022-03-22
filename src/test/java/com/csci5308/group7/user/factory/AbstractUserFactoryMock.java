package com.csci5308.group7.user.factory;

import com.csci5308.group7.user.interfaces.IUser;
import com.csci5308.group7.user.interfaces.ILogin;
import com.csci5308.group7.user.interfaces.IUserModel;
import com.csci5308.group7.user.interfaces.ISignup;

public abstract class AbstractUserFactoryMock {
    private static AbstractUserFactoryMock singleInstance = null;

    protected AbstractUserFactoryMock() {
    }

    public static AbstractUserFactoryMock instance (){
        if(singleInstance == null){
            return new UserFactoryMock();
        }else {
            return singleInstance;
        }
    }

    public abstract IUser createUserMock();
    public abstract IUserModel createUserModelMock();
    public abstract ILogin createLoginMock();
    public abstract ISignup createSignupMock();
}
