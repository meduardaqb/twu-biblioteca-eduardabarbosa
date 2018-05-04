package com.twu.biblioteca.model;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.RegistrationFormatException;
import com.twu.biblioteca.exception.UserAuthException;
import com.twu.biblioteca.exception.UserNonExistsException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auth {

    private ApiInterface api;

    public Auth(ApiInterface api) {
        this.api = api;
    }

    public void signIn(String registration, String password) throws UserAuthException, RegistrationFormatException {
        validateRegistrationFormat(registration);
        validateUser(registration, password);
    }

    public User getUser(String registration, String password) throws UserNonExistsException {
        List<User> users = this.api.getUsers();

        for (User user : users) {
            if (isSameUser(registration, password, user))
                return user;
        }

        throw new UserNonExistsException();
    }

    private void validateRegistrationFormat(String registration) throws RegistrationFormatException {
        String stringPattern = "\\d\\d\\d-\\d\\d\\d\\d";

        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(registration);
        if (!matcher.find( )) {
           throw new RegistrationFormatException();
        }
    }

    private void validateUser(String registration, String password) throws UserAuthException {
        boolean didFindUser = false;

        List<User> users = this.api.getUsers();

        for (User user : users) {
            if (isSameUser(registration, password, user))
                didFindUser = true;
        }

        if (!didFindUser)
            throw new UserAuthException();
    }

    private boolean isSameUser(String registration, String password, User user) {
        return registration.equals(user.getRegistration()) && password.equals(user.getPassword());
    }
}
