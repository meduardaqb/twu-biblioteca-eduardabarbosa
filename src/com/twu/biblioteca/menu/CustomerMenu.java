package com.twu.biblioteca.menu;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.UserNonExistsException;
import com.twu.biblioteca.model.Auth;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.util.IoOperationInterface;

public class CustomerMenu implements CustomerMenuInterface {
    private UserTypeMenuInterface userTypeMenu;
    private LoginMenu loginMenu;
    private IoOperationInterface io;
    private Library library;
    private ApiInterface api;

    public CustomerMenu(UserTypeMenuInterface userTypeMenu, IoOperationInterface io, Library library, ApiInterface api) {
        this.userTypeMenu = userTypeMenu;
        this.io = io;
        this.library = library;
        this.api = api;
        this.loginMenu = new LoginMenu(new AuthResponseInterface() {
            @Override
            public void onSignInSuccess() {
                try {
                    showUserInformation(getUser());
                    customerMenu();
                } catch (UserNonExistsException e) {
                   io.printMessage(Constants.USER_NON_EXISTS);
                   customerMenu();
                }
            }

            @Override
            public void onSignInError() {
                customerMenu();
            }
        }, io, api);
    }


    @Override
    public void customerMenu() {
        io.printMessage(Constants.WELCOME_MESSAGE);
        io.printMessage(Constants.LIST_BOOKS);
        io.printMessage(Constants.USER_INFORMATION);
        io.printMessage(Constants.BACK);

        handleCustomerMenuChoice(io.getInput());
    }

    private void handleCustomerMenuChoice(String input) {
        if (input.equals("l")) {
            bookListMenu();
        } else if (input.equals("b")) {
            this.userTypeMenu.userTypeChoiceMenu();
        } else if (input.equals("u")) {
            this.loginMenu.signInForm();
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

    private User getUser() throws UserNonExistsException {
        Auth auth = new Auth(this.api);
        return auth.getUser(this.loginMenu.getUserRegistration(), this.loginMenu.getUserPassword());
    }

    private void showUserInformation(User user) {
        io.printMessage("Name: " + user.getName());
        io.printMessage("Email: " + user.getEmail());
        io.printMessage("Registration: " + user.getRegistration());
        io.printMessage("Phone Number: " + user.getPhoneNumber());
        io.printMessage("Address: " + user.getAddress());
        io.printMessage("");
    }
}
