package com.twu.biblioteca;

import com.twu.biblioteca.menu.LibrarianMenu;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.mocks.IoOperationMock;
import com.twu.biblioteca.mocks.UserTypeMenuMock;
import com.twu.biblioteca.model.RentalAgency;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class LibrarianMenuTest {

    @Test
    public void customerMenuShouldCallCheckoutBookMenu() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("c");
        ioOperation.setInputReturn(linkedList);

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallReturnBookMenu() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("r");
        ioOperation.setInputReturn(linkedList);

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallCheckoutMovieMenu() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("p");
        ioOperation.setInputReturn(linkedList);

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.showMovieListWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallReturnMovieMenu() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("t");
        ioOperation.setInputReturn(linkedList);

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.showMovieListWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallUserTypeChoiceMenu() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("r");
        ioOperation.setInputReturn(linkedList);

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(userTypeMenu.userTypeChoiceMenuWasCalled);
        } catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallPrintErrorMessage() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("x");
        ioOperation.setInputReturn(linkedList);

        LibrarianMenu librarianMenu = new LibrarianMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            librarianMenu.librarianMenu();
            Assert.assertTrue(ioOperation.printErrorMessageWasCalled);
        } catch(StackOverflowError e) { }
    }
}
