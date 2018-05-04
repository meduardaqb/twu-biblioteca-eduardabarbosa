package com.twu.biblioteca.mocks;

import com.twu.biblioteca.menu.AuthResponseInterface;

public class AuthResponseMock implements AuthResponseInterface {
    public boolean signInSuccessWasCalled = false;
    public boolean signInErrorWasCalled = false;

    @Override
    public void onSignInSuccess() {
        signInSuccessWasCalled = true;
    }

    @Override
    public void onSignInError() {
        signInErrorWasCalled = false;
    }
}
