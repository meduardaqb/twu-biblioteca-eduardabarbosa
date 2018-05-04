package com.twu.biblioteca.menu;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.util.IoOperationInterface;

public class UserTypeMenu implements UserTypeMenuInterface {

    private CustomerMenuInterface customerMenu;
    private LibrarianMenuInterface librarianMenu;
    private IoOperationInterface io;
    private Library library;

    public UserTypeMenu(IoOperationInterface io, ApiInterface api) {
        this.library = new Library(api);
        this.customerMenu = new CustomerMenu(this, io, this.library, api);
        this.librarianMenu = new LibrarianMenu(this, io, this.library);
        this.io = io;
    }

    @Override
    public void userTypeChoiceMenu() {
        io.printMessage(Constants.SELECT_USER_TYPE);
        io.printMessage(Constants.CUSTOMER);
        io.printMessage(Constants.LIBRARIAN);

        handleMenuChoice(io.getInput());
    }


    private void handleMenuChoice(String input) {
        if (input.equals("c")) {
            this.customerMenu.customerMenu();
        } else if (input.equals("l")) {
            this.librarianMenu.librarianMenu();
        } else {
            io.printErrorMessage();
            userTypeChoiceMenu();
        }
    }
}
