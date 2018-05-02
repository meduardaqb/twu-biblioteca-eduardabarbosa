package com.twu.biblioteca.mocks;

import com.twu.biblioteca.menu.UserTypeMenuInterface;

public class UserTypeMenuMock implements UserTypeMenuInterface {

    public boolean userTypeChoiceMenuWasCalled = false;

    @Override
    public void userTypeChoiceMenu() {
        userTypeChoiceMenuWasCalled = true;
    }
}
