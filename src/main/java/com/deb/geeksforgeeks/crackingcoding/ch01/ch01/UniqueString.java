package com.deb.geeksforgeeks.crackingcoding.ch01.ch01;

import java.util.HashMap;

/**
 * Created by deb on 10/10/15.
 */
public class UniqueString {
    String string;
    UniqueString(String string){
        this.string =  string;
    }

    boolean isUnique1(){
        HashMap<Character,Boolean> map = new HashMap<Character, Boolean>();

        for (int i = 0; i < string.length(); i++){
            char  c = string.charAt(i);
            if (map.containsKey(c)){
                return false;
            }
            else{
                map.put(c,true);
            }
        }
        return  true;
    }

    boolean isUnique2(){
        long check = 0;
        System.out.println("Assuming we only check for ascii characters with ordinal greter than 64");
        for (int i = 0; i < string.length(); i++){
            int ordinal = string.charAt(i) - 'A';
            if (ordinal < 0 ){
                continue;
            }
            if ((check & ( 1 << ordinal)) > 0 ){
                return false;
            }
            check = check | ( 1<< ordinal);
        }
        return  true;
    }

    boolean isMatching(String string1, String string2){
        for (int i= 0 ; i< string1.length(); i++){
            if (string1.charAt(i) == string2.charAt(i) ){
                return false;
            }
        }
        return true;
    }

    boolean isUnique3(){
        CircularShiftString circularShift = new CircularShiftString(string);
        for (int i =0; i< string.length() -1; i++){
            String str1 = circularShift.shiftLeft().getString();
//            System.out.println(str1);
            if (!isMatching(str1, string)) {
                return false;
            };
        }
        return true;
    }

    public static void main(String args[]){
        UniqueString uniqueString = new UniqueString("Hello");
        System.out.println(uniqueString.isUnique3());
        uniqueString = new UniqueString("Helo ! dan ");
        System.out.println(uniqueString.isUnique3());
        uniqueString = new UniqueString("Helo dan");
        System.out.println(uniqueString.isUnique3());

    }
}
