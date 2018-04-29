package com.twu.biblioteca.menu;

import com.twu.biblioteca.util.Constants;

public class CustomerMenu extends Menu {
    private MainMenu mainMenu;

    public CustomerMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void customerMenu() {
        printMessage(Constants.WELCOME_MESSAGE);
        printMessage(Constants.LIST_BOOKS);
        printMessage(Constants.BACK);

        handleCustomerMenuChoice(getInput());
    }

    private void handleCustomerMenuChoice(String input) {
        if (input.equals("l")) {
            bookListMenu();
        } else if (input.equals("b")) {
            this.mainMenu.main();
        } else {
            printErrorMessage();
            customerMenu();
        }
    }

    private void bookListMenu() {
        showBookList(this.mainMenu.library.getAvailableBookList());
        printMessage(Constants.BACK);
        handleBookListMenuChoice(getInput());
    }

    private void handleBookListMenuChoice(String input) {
        if (input.equals("b")) {
            this.mainMenu.main();
        } else {
            printErrorMessage();
            bookListMenu();
        }
    }
}
