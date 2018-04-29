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
}
