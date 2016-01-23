package com.deb.geeksforgeeks.crackingcoding.ch01.ch02;

/**
 * Created by deb on 10/15/15.
 */
public class CompressString {
    String string;

    CompressString(String string){
        this.string = string;
    }

    String getCompressed(){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i =0; i< string.length(); i ++){
            char c  = string.charAt(i);
            int count = 1;
            while(  i+1 < string.length() && string.charAt(i+1) == c ){
                count++;
                i++;
            }
            stringBuilder.append(c + Integer.toString(count));
        }
        return stringBuilder.toString();
    }


    public static void main(String args[]){
        CompressString compressString = new CompressString("aadadddbbbbc c hajjj");
        System.out.println(compressString.getCompressed());
    }
}
