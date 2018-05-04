package com.twu.biblioteca.menu;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.RegistrationFormatException;
import com.twu.biblioteca.exception.UserAuthException;
import com.twu.biblioteca.model.Auth;
import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.util.IoOperationInterface;

public class LoginMenu implements LoginMenuInterface {

    private AuthResponseInterface authResponse;
    private IoOperationInterface io;
    private ApiInterface api;
    private String userRegistration;
    private String userPassword;

    public LoginMenu(AuthResponseInterface authResponse, IoOperationInterface io, ApiInterface api) {
        this.authResponse = authResponse;
        this.io = io;
        this.api = api;
    }

    @Override
    public void signInForm() {
        io.printMessage(Constants.USER_REGISTRATION);
        this.userRegistration = io.getInput();

        io.printMessage(Constants.USER_PASSWORD);
        this.userPassword = io.getInput();

        handleSignIn();
    }

    public String getUserRegistration() {
        return userRegistration != null ? userRegistration : "";
    }

    public String getUserPassword() {
        return userPassword != null ? userPassword : "";
    }

    private void handleSignIn() {
        Auth auth = new Auth(this.api);
        try {
            auth.signIn(this.userRegistration, this.userPassword);
            authResponse.onSignInSuccess();
        } catch (UserAuthException e) {
            io.printMessage(Constants.AUTH_ERROR);
            authResponse.onSignInError();
        } catch (RegistrationFormatException e) {
            io.printMessage(Constants.INVALID_REGISTRATION);
            authResponse.onSignInError();
        }
    }
}
