package com.csci5308.group7.user;

import com.csci5308.group7.user.abstractfactory.AbstractUserFactory;
import com.csci5308.group7.user.interfaces.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {

    AbstractUserFactory userFactory = AbstractUserFactory.instance();
    IUser iUser = userFactory.createUser();
    IUserModel iUserModel = userFactory.createUserModel();
    ISignup iSignup = userFactory.createSignup();
    ILogin iLogin = userFactory.createLogin();

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody String User) {

        try{
            JSONObject requestBody = new JSONObject(User);

            iUser.setFirstName(requestBody.getString("firstName"));
            iUser.setLastName(requestBody.getString("lastName"));
            iUser.setEmail(requestBody.getString("email"));
            iUser.setPassword(requestBody.getString("password"));
            iUser.setMobileNo(requestBody.getString("mobileNo"));
            iUser.setUserType(requestBody.getInt("userType"));
            iUser.setPhotoId(requestBody.getString("photoId"));
            iUser.setDob(requestBody.getString("dob"));
            iUser.setActiveStatus(1);
            iUser.setGender(requestBody.getString("gender"));
            iUser.setAddress(requestBody.getString("address"));

            iSignup.createUser(iUser, iUserModel);

        } catch(JSONException e){
            e.printStackTrace();
        }

        return iUser.getBooleanResponse(true);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUser(@RequestParam("email") String email) {

        IUser user = iUserModel.getUser(email);
        String responseData = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            responseData = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return iUser.getSuccessResponse(responseData);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody String User) {

        try {
            JSONObject requestBody = new JSONObject(User);
            IUser user = iUserModel.getUser(requestBody.getString("email"));

            iUser.setUserId(user.getUserId());
            iUser.setFirstName(requestBody.getString("firstName"));
            iUser.setLastName(requestBody.getString("lastName"));
            iUser.setEmail(requestBody.getString("email"));
            iUser.setPassword(requestBody.getString("password"));
            iUser.setMobileNo(requestBody.getString("mobileNo"));
            iUser.setUserType(requestBody.getInt("userType"));
            iUser.setPhotoId(requestBody.getString("photoId"));
            iUser.setDob(requestBody.getString("dob"));
            iUser.setActiveStatus(1);
            iUser.setGender(requestBody.getString("gender"));
            iUser.setAddress(requestBody.getString("address"));

            boolean userUpdated = iUserModel.updateUser(iUser);
            return iUser.getBooleanResponse(userUpdated);

        } catch (JSONException e) {
            e.printStackTrace();
            return iUser.getBooleanResponse(false);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody String User) {

        try {
            JSONObject requestBody = new JSONObject(User);
            String responseData = null;

            iUser.setPassword(requestBody.getString("password"));
            iUser.setEmail(requestBody.getString("email"));

            boolean credentialsCorrect = iLogin.checkCredentials(iUser, iUserModel);

            if(credentialsCorrect){
                IUser user = iUserModel.getUser(requestBody.getString("email"));
                ObjectMapper mapper = new ObjectMapper();
                responseData = mapper.writeValueAsString(user);
            }

            return iUser.getLoginResponse(credentialsCorrect, responseData);

        } catch (JSONException | JsonProcessingException e) {
            e.printStackTrace();
            return iUser.getBooleanResponse(false);
        }
    }
}
