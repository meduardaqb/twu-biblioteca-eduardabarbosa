package com.twu.biblioteca;

import com.twu.biblioteca.menu.LoginMenu;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.mocks.AuthResponseMock;
import com.twu.biblioteca.mocks.IoOperationMock;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


public class LoginMenuTest {

    @Test
    public void signInFormSuccessfulTest() {

        AuthResponseMock responseMock = new AuthResponseMock();
        IoOperationMock ioOperationMock = new IoOperationMock();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("123-4567");
        linkedList.add("123");
        ioOperationMock.setInputReturn(linkedList);

        LoginMenu loginMenu = new LoginMenu(responseMock, ioOperationMock, new ApiMock());

        loginMenu.signInForm();

        Assert.assertTrue(responseMock.signInSuccessWasCalled);
    }

    @Test
    public void signInFormErrorTest() {

        AuthResponseMock responseMock = new AuthResponseMock();
        IoOperationMock ioOperationMock = new IoOperationMock();

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("0");
        linkedList.add("0");
        ioOperationMock.setInputReturn(linkedList);

        LoginMenu loginMenu = new LoginMenu(responseMock, ioOperationMock, new ApiMock());

        loginMenu.signInForm();

        Assert.assertTrue(ioOperationMock.printMessageWasCalled);
    }
}
