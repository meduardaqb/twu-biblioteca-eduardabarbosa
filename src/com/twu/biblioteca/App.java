package com.twu.biblioteca;

import com.twu.biblioteca.data.Api;
import com.twu.biblioteca.menu.UserTypeMenu;
import com.twu.biblioteca.util.IoOperation;

public class App {

    public static void main(String[] args) {
        new UserTypeMenu(new IoOperation(), new Api()).userTypeChoiceMenu();
    }
}
