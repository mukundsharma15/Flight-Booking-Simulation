package com.csci5308.group7.user.abstractfactory;

import com.csci5308.group7.user.interfaces.*;

public abstract class AbstractUserFactory {

    private static AbstractUserFactory singleInstance = null;

    protected AbstractUserFactory() {
    }

    public static AbstractUserFactory instance (){
        if(singleInstance == null){
            singleInstance = new UserFactory();
        }
        return singleInstance;
    }

    public abstract IUser createUser();
    public abstract IUserModel createUserModel();
    public abstract ISignup createSignup();
    public abstract ILogin createLogin();
}
