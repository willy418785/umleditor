package edu.ncu.csie.umleditor.util;

public enum ButtonState {
    // record corresponding operation of a button
    // "State" indicates that ONLY ONE operation can be selected at a time
    SELECT("SELECT"),
    ASSOCIATE("ASSOCIATION"), 
    GENARALIZE("GENARALIZATION"), 
    COMPOSE("COMPOSITION"), 
    CLASS("CLASS"), 
    USECASE("USE CASE");

    private final String name;

    ButtonState(String name){
        this.name = new String(name);
    }

    public String getName(){
        return this.name;
    }
}
