package edu.ncu.csie.umleditor.util;

public enum MenuType {
    // record all possible menu types of this app window
    EDIT("Edit");

    private final String name;

    MenuType(String name){
        this.name = new String(name);
    }

    public String getName(){
        return this.name;
    }
}
