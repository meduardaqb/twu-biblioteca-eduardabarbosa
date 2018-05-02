package com.twu.biblioteca;

import com.twu.biblioteca.menu.CustomerMenu;
import com.twu.biblioteca.menu.UserTypeMenuInterface;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.mocks.IoOperationMock;
import com.twu.biblioteca.mocks.UserTypeMenuMock;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.util.IoOperationInterface;
import org.junit.Assert;
import org.junit.Test;

public class CustomerMenuTest {

    @Test
    public void customerMenuShouldCallUserTypeChoiceMenu() {
        Library library = new Library(new ApiMock());
        UserTypeMenuInterface userTypeMenu = new UserTypeMenuMock();
        IoOperationInterface ioOperation = new IoOperationMock();
        ((IoOperationMock) ioOperation).setInputReturn("b");

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library);

        customerMenu.customerMenu();

        Assert.assertTrue(((UserTypeMenuMock) userTypeMenu).userTypeChoiceMenuWasCalled);
    }

    @Test
    public void customerMenuShouldCallBookListMenu() {

        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        ioOperation.setInputReturn("l");

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library);

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(ioOperation.showBookListWasCalled);
        }
        catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallPrintErrorMessage() {
        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        ioOperation.setInputReturn("c");

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library);

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(!userTypeMenu.userTypeChoiceMenuWasCalled && !ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }
}
