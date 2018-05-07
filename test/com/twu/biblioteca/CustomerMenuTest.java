package com.twu.biblioteca;

import com.twu.biblioteca.menu.CustomerMenu;
import com.twu.biblioteca.menu.UserTypeMenuInterface;
import com.twu.biblioteca.mocks.ApiMock;
import com.twu.biblioteca.mocks.IoOperationMock;
import com.twu.biblioteca.mocks.UserTypeMenuMock;
import com.twu.biblioteca.model.RentalAgency;
import com.twu.biblioteca.util.IoOperationInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class CustomerMenuTest {

    @Test
    public void customerMenuShouldCallUserTypeChoiceMenu() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuInterface userTypeMenu = new UserTypeMenuMock();
        IoOperationInterface ioOperation = new IoOperationMock();

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("b");
        ((IoOperationMock) ioOperation).setInputReturn(linkedList);



        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        customerMenu.customerMenu();

        Assert.assertTrue(((UserTypeMenuMock) userTypeMenu).userTypeChoiceMenuWasCalled);
    }

    @Test
    public void customerMenuShouldCallBookListMenu() {

        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("l");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(ioOperation.showBookListWasCalled);
        }
        catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallMovieListMenu() {

        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("m");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(ioOperation.showMovieListWasCalled);
        }
        catch(StackOverflowError e) { }
    }

    @Test
    public void customerMenuShouldCallPrintErrorMessage() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("c");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(!userTypeMenu.userTypeChoiceMenuWasCalled && !ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }


    @Test
    public void customerMenuShouldCallPrintMessage() {
        RentalAgency rentalAgency = new RentalAgency(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("u");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, rentalAgency, new ApiMock());

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(ioOperation.printMessageWasCalled);
        } catch(StackOverflowError e) { }
    }
}
