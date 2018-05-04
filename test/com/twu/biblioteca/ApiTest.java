package com.twu.biblioteca;

import com.twu.biblioteca.data.Api;
import org.junit.Assert;
import org.junit.Test;

public class ApiTest
{
    @Test
    public void getBooksTest() {
        Api api = new Api();
        Assert.assertNotNull(api.getBooks());
    }

    @Test
    public void getUsers() {
        Api api = new Api();
        Assert.assertNotNull(api.getUsers());
    }
}
