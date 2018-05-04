package com.twu.biblioteca;

import com.twu.biblioteca.exception.RegistrationFormatException;
import com.twu.biblioteca.exception.UserAuthException;
import com.twu.biblioteca.exception.UserNonExistsException;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.model.Auth;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest {

    @Test
    public void successfulSignInTest() {
        ApiMock apiMock = new ApiMock();
        Auth auth = new Auth(apiMock);

        try {
            auth.signIn("123-4567", "123");
        } catch (UserAuthException | RegistrationFormatException e) {
            Assert.fail();
        }
    }

    @Test (expected = UserAuthException.class)
    public void unsuccessfulSignInWithNonExistingUserTest() throws UserAuthException {
        ApiMock apiMock = new ApiMock();
        Auth auth = new Auth(apiMock);

        try {
            auth.signIn("000-0000", "123");
        } catch (RegistrationFormatException e) {
            Assert.fail();
        }
    }

    @Test (expected = UserAuthException.class)
    public void unsuccessfulSignInWithWrongPasswordTest() throws UserAuthException {
        ApiMock apiMock = new ApiMock();
        Auth auth = new Auth(apiMock);

        try {
            auth.signIn("123-4567", "000");
        } catch (RegistrationFormatException e) {
            Assert.fail();
        }
    }

    @Test (expected = RegistrationFormatException.class)
    public void unsuccessfulSignInWithWrongRegistrationFormatTest() throws RegistrationFormatException {
        ApiMock apiMock = new ApiMock();
        Auth auth = new Auth(apiMock);

        try {
            auth.signIn("0", "123");
        } catch (UserAuthException e) {
            Assert.fail();
        }
    }

    @Test
    public void getUserSuccessfulTest()  {
        ApiMock apiMock = new ApiMock();
        Auth auth = new Auth(apiMock);

        try {
            auth.getUser("123-4567", "123");
        } catch (UserNonExistsException e) {
            Assert.fail();
        }
    }

    @Test (expected = UserNonExistsException.class)
    public void getUserUnsuccessfulTest() throws UserNonExistsException {
        ApiMock apiMock = new ApiMock();
        Auth auth = new Auth(apiMock);

        auth.getUser("000-0000", "123");
    }
}
