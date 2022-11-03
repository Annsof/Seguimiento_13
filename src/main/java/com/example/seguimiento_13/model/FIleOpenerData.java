package com.example.seguimiento_13.model;

public class FIleOpenerData {
    private static FIleOpenerData instance;
    private FIleOpenerData(){
        user = new User("");
    }
    public static FIleOpenerData getInstance(){
        if(instance == null){
            instance = new FIleOpenerData();
        }
        return instance;
    }
    //Los atributos de la clase
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
