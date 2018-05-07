package com.twu.biblioteca.model;

import com.twu.biblioteca.util.ITEM_TYPE;

public abstract class Item {
    protected String name;
    protected boolean available;

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    abstract ITEM_TYPE getType();
}
