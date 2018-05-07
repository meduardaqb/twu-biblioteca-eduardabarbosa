package com.twu.biblioteca.menu;

import com.twu.biblioteca.data.ApiInterface;
import com.twu.biblioteca.exception.ItemCheckedOutException;
import com.twu.biblioteca.exception.ItemReturnException;
import com.twu.biblioteca.exception.NonExistItemException;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.model.Item;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.model.RentalAgency;
import com.twu.biblioteca.util.Constants;
import com.twu.biblioteca.util.IoOperationInterface;


public class LibrarianMenu implements LibrarianMenuInterface {
    private UserTypeMenuInterface userTypeMenu;
    private IoOperationInterface io;
    private RentalAgency rentalAgency;
    private LoginMenu loginMenuCheckout;
    private LoginMenu loginMenuReturn;

    public LibrarianMenu(UserTypeMenuInterface userTypeMenu, IoOperationInterface io, RentalAgency rentalAgency, ApiInterface api) {
        this.userTypeMenu = userTypeMenu;
        this.io = io;
        this.rentalAgency = rentalAgency;

        this.loginMenuCheckout = new LoginMenu(new AuthResponseInterface() {
            @Override
            public void onSignInSuccess() {
                checkoutBookMenu();
                librarianMenu();
            }

            @Override
            public void onSignInError() {
                librarianMenu();
            }
        }, io, api);

        this.loginMenuReturn = new LoginMenu(new AuthResponseInterface() {
            @Override
            public void onSignInSuccess() {
                returnBookMenu();
                librarianMenu();
            }

            @Override
            public void onSignInError() {
                librarianMenu();
            }
        }, io, api);
    }

    @Override
    public void librarianMenu() {
        io.printMessage(Constants.SELECT_ACTION);
        io.printMessage(Constants.CHECKOUT_BOOK);
        io.printMessage(Constants.RETURN_BOOK);
        io.printMessage(Constants.CHECKOUT_MOVIE);
        io.printMessage(Constants.RETURN_MOVIE);
        io.printMessage(Constants.BACK);

        handleLibrarianMenu(io.getInput());
    }

    private void handleLibrarianMenu(String input) {
        if (input.equals("c")) {
            this.loginMenuCheckout.signInForm();
        } else if (input.equals("r")) {
            this.loginMenuReturn.signInForm();
        } else if (input.equals("b")) {
            this.userTypeMenu.userTypeChoiceMenu();
        } else if (input.equals("t")) {
            returnMovieMenu();
        } else if (input.equals("p")) {
            checkoutMovieMenu();
        } else {
            io.printErrorMessage();
            librarianMenu();
        }
    }

    private void checkoutBookMenu() {
        io.printMessage(Constants.SELECT_ITEM_CHECKOUT);
        io.showBookList(this.rentalAgency.getBookList());
        io.printMessage(Constants.BACK);
        handleCheckoutBook(io.getInput());
    }

    private void checkoutMovieMenu() {
        io.printMessage(Constants.SELECT_ITEM_CHECKOUT);
        io.showMovieList(this.rentalAgency.getMovieList());
        io.printMessage(Constants.BACK);

        handleCheckoutMovie(io.getInput());
    }

    private void handleCheckoutMovie(String input) {
        try {
            int index = Integer.parseInt(input);
            Movie movie = this.rentalAgency.getMovieList().get(index);
            handleInputNumberCheckOut(movie);
        } catch(NumberFormatException e) {
            handleInputStringCheckout(input);
        }
    }

    private void handleCheckoutBook(String input) {
        try {
            int index = Integer.parseInt(input);
            Book book = this.rentalAgency.getBookList().get(index);
            handleInputNumberCheckOut(book);
        } catch(NumberFormatException e) {
            handleInputStringCheckout(input);
        }
    }

    private void handleInputNumberCheckOut(Item item) {
        try {
            this.rentalAgency.checkOutItem(item);
            showResult(Constants.SUCCESSFUL_CHECKOUT);
        } catch (ItemCheckedOutException e) {
            showResult(Constants.UNSUCCESSFUL_CHECKOUT);
        } catch (NonExistItemException | IndexOutOfBoundsException e) {
            showResult(Constants.INVALID_CARACTER);
        }
    }

    private void handleInputStringCheckout(String input) {
        if (input.equals("b")) {
            librarianMenu();
        } else {
            io.printErrorMessage();
            checkoutBookMenu();
        }
    }

    private void returnBookMenu() {
        io.printMessage(Constants.SELECT_ITEM_RETURN);
        io.showBookList(this.rentalAgency.getBookList());
        io.printMessage(Constants.BACK);
        handleReturnBook(io.getInput());
    }

    private void returnMovieMenu() {
        io.printMessage(Constants.SELECT_ITEM_RETURN);
        io.showMovieList(this.rentalAgency.getMovieList());
        io.printMessage(Constants.BACK);
        handleReturnMovie(io.getInput());
    }

    private void handleReturnBook(String input) {
        try {
            int index = Integer.parseInt(input);
            Book book = this.rentalAgency.getBookList().get(index);
            handleInputNumberReturn(book);
        } catch(NumberFormatException e) {
            handleInputStringReturn(input);
        }
    }

    private void handleReturnMovie(String input) {
        try {
            int index = Integer.parseInt(input);
            Movie movie = this.rentalAgency.getMovieList().get(index);
            handleInputNumberReturn(movie);
        } catch(NumberFormatException e) {
            handleInputStringReturn(input);
        }
    }

    private void handleInputNumberReturn(Item item) {
        try {
            this.rentalAgency.returnItem(item);
            showResult(Constants.SUCCESSFUL_RETURN);
        } catch (ItemReturnException e) {
            showResult(Constants.UNSUCCESSFUL_RETURN);
        } catch (NonExistItemException | IndexOutOfBoundsException e) {
            showResult(Constants.INVALID_CARACTER);
        }
    }

    private void handleInputStringReturn(String input) {
        if (input.equals("b")) {
            librarianMenu();
        } else {
            io.printErrorMessage();
            returnBookMenu();
        }
    }

    private void showResult(String message) {
        io.printMessage(message);
        librarianMenu();
    }
}
