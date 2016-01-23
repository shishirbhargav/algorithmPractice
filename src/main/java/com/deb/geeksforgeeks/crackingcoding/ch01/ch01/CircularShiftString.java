package com.deb.geeksforgeeks.crackingcoding.ch01.ch01;

/**
 * Created by deb on 10/10/15.
 */
public class CircularShiftString {
    String string;
    CircularShiftString(String string){
        this.string = string;
    }


    CircularShiftString shiftLeft(){
        string = string.substring(1,string.length())+ string.charAt(0);
        return this;
    }

    CircularShiftString shiftRight(){
        string = string.charAt(string.length() - 1)+string.substring(0, string.length() - 1);
        return this;
    }


    CircularShiftString shiftLeft(int position){
        string = string.substring(position, string.length())+ string.substring(0,position);
        return this;
    }
    CircularShiftString shiftRight(int position){
        string = string.substring((string.length())- position,string.length()) + string.substring(0,(string.length()) - (position ) );
        return this;
    }

    String getString(){
        return string;
    }
    public static void main(String args[]){
        CircularShiftString circularShiftString = new CircularShiftString("geeksforgeeks");
        circularShiftString.shiftLeft();
        circularShiftString.shiftRight();
        circularShiftString.shiftLeft(4);
        circularShiftString.shiftRight(4);
    }
}
