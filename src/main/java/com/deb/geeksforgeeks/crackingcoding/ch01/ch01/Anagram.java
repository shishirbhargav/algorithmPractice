package com.deb.geeksforgeeks.crackingcoding.ch01.ch01;

/**
 * Created by deb on 10/14/15.
 */
public class Anagram {
    String string1;
    String string2;

    Anagram(String string1, String string2){
        this.string1= string1;
        this.string2= string2;
    }

    boolean isAnagram(){
        if (string1.length() != string2.length()){
            return false;
        }
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();

        java.util.Arrays.sort(str1);
        java.util.Arrays.sort(str2);

        String s1 = new String (str1);
        String s2 = new String (str2);
        System.out.println(s1.equals(s2));
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        Anagram anagram = new Anagram("ICEMAN", "CINEMA");
        System.out.println(anagram.isAnagram());
    }
}

