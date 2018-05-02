package com.twu.biblioteca.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.util.IoOperationInterface;

public class CustomerMenu implements CustomerMenuInterface {
    private UserTypeMenuInterface userTypeMenu;
    private IoOperationInterface io;
    private Library library;

    public CustomerMenu(UserTypeMenuInterface userTypeMenu, IoOperationInterface io, Library library) {
        this.userTypeMenu = userTypeMenu;
        this.io = io;
        this.library = library;
    }

    @Override
    public void customerMenu() {
        io.printMessage(Constants.WELCOME_MESSAGE);
        io.printMessage(Constants.LIST_BOOKS);
        io.printMessage(Constants.BACK);

        handleCustomerMenuChoice(io.getInput());
    }

    private void handleCustomerMenuChoice(String input) {
        if (input.equals("l")) {
            bookListMenu();
        } else if (input.equals("b")) {
            this.userTypeMenu.userTypeChoiceMenu();

        } else {
            io.printErrorMessage();
            customerMenu();
        }
    }

    private void bookListMenu() {
        io.showBookList(this.library.getAvailableBookList());
        io.printMessage(Constants.BACK);
        handleBookListMenuChoice(io.getInput());
    }

    private void handleBookListMenuChoice(String input) {
        if (input.equals("b")) {
            this.userTypeMenu.userTypeChoiceMenu();
        } else {
            io.printErrorMessage();
            bookListMenu();
        }
    }
}
