package com.csci5308.group7.user.interfaces;

public interface IUser {

    int getUserId();
    void setUserId(int userId);

    int getUserType();
    void setUserType(int userType);

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    String getPassword();
    void setPassword(String password);

    String getAddress();
    void setAddress(String address);

    String getDob();
    void setDob(String dob);

    String getPhotoId();
    void setPhotoId(String photoId);

    String getMobileNo();
    void setMobileNo(String mobileNo);

    String getEmail();
    void setEmail(String email);

    String getGender();
    void setGender(String gender);

    int getActiveStatus();
    void setActiveStatus(int status);

    String getSuccessResponse(String message);
    String getBooleanResponse(boolean status);
    String prepareResponse();
    String getLoginResponse (boolean status, String message);

}
