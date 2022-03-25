package edu.ncu.csie.umleditor.util;

public enum EditType {
    // record all possible options of menu type "EDIT"
    RENAME("Rename"), 
    GROUP("Group"), 
    UNGROUP("Ungroup");

    private final String name;

    EditType(String name){
        this.name = new String(name);
    }

    public String getName(){
        return this.name;
    }
}