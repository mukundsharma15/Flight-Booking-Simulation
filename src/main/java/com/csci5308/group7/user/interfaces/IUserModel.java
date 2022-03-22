package com.csci5308.group7.user.interfaces;

public interface IUserModel {
    boolean insertUser(IUser iUser);
    boolean updateUser(IUser iUser);
    IUser getUser(String email);
    boolean checkCredentials(IUser iUser);
}
