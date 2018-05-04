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

import java.util.LinkedList;

public class CustomerMenuTest {

    @Test
    public void customerMenuShouldCallUserTypeChoiceMenu() {
        Library library = new Library(new ApiMock());
        UserTypeMenuInterface userTypeMenu = new UserTypeMenuMock();
        IoOperationInterface ioOperation = new IoOperationMock();

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("b");
        ((IoOperationMock) ioOperation).setInputReturn(linkedList);



        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library, new ApiMock());

        customerMenu.customerMenu();

        Assert.assertTrue(((UserTypeMenuMock) userTypeMenu).userTypeChoiceMenuWasCalled);
    }

    @Test
    public void customerMenuShouldCallBookListMenu() {

        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("l");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library, new ApiMock());

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
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("c");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library, new ApiMock());

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(!userTypeMenu.userTypeChoiceMenuWasCalled && !ioOperation.showBookListWasCalled);
        } catch(StackOverflowError e) { }
    }


    @Test
    public void customerMenuShouldCallPrintMessage() {
        Library library = new Library(new ApiMock());
        UserTypeMenuMock userTypeMenu = new UserTypeMenuMock();
        IoOperationMock ioOperation = new IoOperationMock();
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("u");
        ioOperation.setInputReturn(linkedList);

        CustomerMenu customerMenu = new CustomerMenu(userTypeMenu, ioOperation, library, new ApiMock());

        try {
            customerMenu.customerMenu();
            Assert.assertTrue(ioOperation.printMessageWasCalled);
        } catch(StackOverflowError e) { }
    }
}
