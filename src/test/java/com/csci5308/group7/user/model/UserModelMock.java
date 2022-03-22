package com.csci5308.group7.user.model;

import com.csci5308.group7.user.interfaces.IUser;
import com.csci5308.group7.user.abstractfactory.AbstractUserFactory;
import com.csci5308.group7.user.abstractfactory.UserFactory;
import com.csci5308.group7.user.interfaces.IUserModel;

public class UserModelMock implements IUserModel {

    AbstractUserFactory userFactory = new UserFactory();

    @Override
    public boolean insertUser(IUser iUser) {
        if(iUser.getEmail().equals("test@gmail.com")){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(IUser iUser) {
        if (iUser.getEmail().equals("test@gmail.com")){
            return true;
        }
        return false;
    }

    @Override
    public IUser getUser(String email) {
        IUser user = userFactory.createUser();

        user.setFirstName("Willem");
        user.setLastName("Dafoe");
        user.setEmail(email);
        user.setPassword("password");
        user.setMobileNo("1234567890");
        user.setUserType(1);
        user.setAddress("123 Main St");
        user.setDob("01/01/1990");
        user.setPhotoId("ALKp23");
        user.setGender("M");

        return user;
    }

    @Override
    public boolean checkCredentials(IUser iUser) {
        if(iUser != null){
            return true;
        } else {
            return false;
        }
    }
}
