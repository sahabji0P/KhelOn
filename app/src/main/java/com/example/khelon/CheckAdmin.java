package com.example.khelon;


public class CheckAdmin {

    public final static String admin1 = "ChhYdLOyhdYd9XIX7nAe3hDdbmY2";
    public final static String admin2 = "q0HgPGJUuPO6P4a59Fpmdv93VB42";


    public static boolean checkAdmin(String uid){

        if (uid.equals(admin1) || uid.equals(admin2)){
            return true;

        }
        return false;

    }
}
