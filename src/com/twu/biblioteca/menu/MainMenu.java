package com.twu.biblioteca.menu;

import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.model.Library;

public class MainMenu extends Menu {

    protected Library library;
    private CustomerMenu customerMenu;
    private LibrarianMenu librarianMenu;

    public MainMenu() {
        this.library = new Library();
        this.customerMenu = new CustomerMenu(this);
        this.librarianMenu = new LibrarianMenu(this);
    }

    public void main() {
        printMessage(Constants.SELECT_USER_TYPE);
        printMessage(Constants.CUSTOMER);
        printMessage(Constants.LIBRARIAN);

        handleMenuChoice(getInput());
    }

    private void handleMenuChoice(String input) {
        if (input.equals("c")) {
            this.customerMenu.customerMenu();
        } else if (input.equals("l")) {
            this.librarianMenu.librarianMenu();
        } else {
            printErrorMessage();
            main();
        }
    }
}
