package com.csci5308.group7.user;

import com.csci5308.group7.database.DBConnection;
import com.csci5308.group7.database.IDBConnection;
import com.csci5308.group7.user.interfaces.IUser;
import com.csci5308.group7.user.interfaces.IUserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserModel implements IUserModel {

    public static UserModel singleInstance = null;
    IDBConnection dbConnection = DBConnection.instance();

    public static IUserModel instance() {
        if (null == singleInstance) {
            singleInstance = new UserModel();
        }
        return singleInstance;
    }

    @Override
    public boolean insertUser(IUser iUser) {

        Connection connection = dbConnection.createConnection();

        try {
            String insertUserQuery = "INSERT INTO users(userTypeID , firstName, lastName, password, address, dob, mobile, email, gender, activeStatus, photoId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);

            preparedStatement.setInt(1, iUser.getUserType());
            preparedStatement.setString(2, iUser.getFirstName());
            preparedStatement.setString(3, iUser.getLastName());
            preparedStatement.setString(4, iUser.getPassword());
            preparedStatement.setString(5, iUser.getAddress());
            preparedStatement.setString(6, iUser.getDob());
            preparedStatement.setString(7, iUser.getMobileNo());
            preparedStatement.setString(8, iUser.getEmail());
            preparedStatement.setString(9, iUser.getGender());
            preparedStatement.setInt(10, iUser.getActiveStatus());
            preparedStatement.setString(11, iUser.getPhotoId());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean updateUser(IUser iUser) {

        Connection connection = dbConnection.createConnection();

        try {
            String updateUserQuery = "UPDATE users SET userTypeID = ?, firstName = ?, lastName = ?, password = ?, address = ?, dob = ?, mobile = ?, email = ?, gender = ?, activeStatus = ?, photoId = ? WHERE userID = " + iUser.getUserId() + ";";

            PreparedStatement preparedStatement = connection.prepareStatement(updateUserQuery);

            preparedStatement.setInt(1, iUser.getUserType());
            preparedStatement.setString(2, iUser.getFirstName());
            preparedStatement.setString(3, iUser.getLastName());
            preparedStatement.setString(4, iUser.getPassword());
            preparedStatement.setString(5, iUser.getAddress());
            preparedStatement.setString(6, iUser.getDob());
            preparedStatement.setString(7, iUser.getMobileNo());
            preparedStatement.setString(8, iUser.getEmail());
            preparedStatement.setString(9, iUser.getGender());
            preparedStatement.setInt(10, iUser.getActiveStatus());
            preparedStatement.setString(11, iUser.getPhotoId());

            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public IUser getUser(String email) {

        Connection connection = dbConnection.createConnection();

        try{

            String insertUserQuery = "SELECT userID, userTypeID, firstName, lastName, password, address, dob, mobile, email, gender, activeStatus, photoId FROM users WHERE email = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);

            preparedStatement.setString(1, email);

            ResultSet resultSet =  preparedStatement.executeQuery();


            if(resultSet.next()){
                IUser user = new User();

                user.setUserId(resultSet.getInt("userID"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getInt("userTypeID"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAddress(resultSet.getString("address"));
                user.setDob(resultSet.getString("dob"));
                user.setMobileNo(resultSet.getString("mobile"));
                user.setEmail(resultSet.getString("email"));
                user.setGender(resultSet.getString("gender"));
                user.setActiveStatus(resultSet.getInt("activeStatus"));

                return user;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean checkCredentials(IUser iUser) {

        IUser user = getUser(iUser.getEmail());

        if(user != null) {
            if (user.getPassword().equals(iUser.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
