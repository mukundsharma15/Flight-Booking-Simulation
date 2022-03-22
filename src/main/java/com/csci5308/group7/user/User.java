package com.csci5308.group7.user;

import com.csci5308.group7.user.interfaces.IUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class User  implements IUser {

    private int userId;
    private int userType;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String dob;
    private String photoId;
    private String mobileNo;
    private String email;
    private String gender;
    private int activeStatus;

    public User () {
    }

    @Override
    public String getSuccessResponse(String message) {
        return "{  \"success\" : true, \"data\" : " + message + " }";
    }

    @Override
    public String getBooleanResponse(boolean status) {
        return "{  \"success\" : " + status + " }";
    }

    public String getLoginResponse (boolean status, String message) {
        return "{  \"success\" : true, \"validCredentials\": " + status + ", \"user\": " + message + " }";
    }

    @Override
    public String prepareResponse() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{  \"success\" : false }";
        }
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int getUserType() {
        return userType;
    }
    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getDob() {
        return dob;
    }

    @Override
    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String getPhotoId() {
        return photoId;
    }

    @Override
    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    @Override
    public String getMobileNo() {
        return mobileNo;
    }

    @Override
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int getActiveStatus() {
        return activeStatus;
    }

    @Override
    public void setActiveStatus(int status) {
        this.activeStatus = status;
    }

}
