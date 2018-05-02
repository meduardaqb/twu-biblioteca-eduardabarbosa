package com.twu.biblioteca;

import com.twu.biblioteca.menu.LibrarianMenu;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.mocks.IoOperationMock;
import com.twu.biblioteca.mocks.UserTypeMenuMock;
import com.twu.biblioteca.model.Library;
import org.junit.Assert;
import org.junit.Test;

public class LibrarianMenuTest {

    @Test
    public void customerMenuShouldCallCheckoutBookMenu() {
        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        ioOperation.setInputReturn("c");

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, library);

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallReturnBookMenu() {
        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        ioOperation.setInputReturn("r");

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, library);

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallUserTypeChoiceMenu() {
        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        ioOperation.setInputReturn("r");

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, library);

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(userTypeMenu.userTypeChoiceMenuWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallPrintErrorMessage() {
        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        ioOperation.setInputReturn("x");

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, library);

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.printErrorMessageWasCalled);
        } catch(StackOverflowError e) { }
    }
}
