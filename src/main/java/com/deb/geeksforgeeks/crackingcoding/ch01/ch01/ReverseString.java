package com.deb.geeksforgeeks.crackingcoding.ch01.ch01;

/**
 * Created by deb on 10/10/15.
 */
public class ReverseString {

    String string;
    StringBuilder stringBuilder;

    ReverseString(String string){
        this.string = string;
        this.stringBuilder = new StringBuilder(string);
    }

    String getReverse(){

        reverseHelper(0, string.length() - 1);
        string = stringBuilder.toString();
        return string;
    }

    void merge (int start, int mid, int end ){
        System.out.println("Merging " + start + " " + mid + " " +  end);
        StringBuilder stringBuildertemp = new StringBuilder();
        for(int i=start; i<= mid ; i++){
            stringBuildertemp.append(stringBuilder.charAt(start+i));
        }
        for (int i = mid+1, j =0 ; i <= end ; i++,j++ ){
            stringBuilder.setCharAt(start + j ,stringBuilder.charAt(i));
        }
        for (int i = start,j=0; i <=mid ; i++,j++){
            stringBuilder.setCharAt(i, stringBuildertemp.charAt(j));
        }

        System.out.println( stringBuilder);
    }
    void reverseHelper(int start, int end){
        System.out.println("Starting " + start + " " + end );
        int len = end - start +1;
        if (len <= 0 ){
            System.out.println("ERROR: length should be positive integer ");
            return;
        }
        if (len == 1){
            System.out.println(stringBuilder);
            return;
        }
        if (len == 2){
            char c = stringBuilder.charAt(start);
            stringBuilder.setCharAt(start,stringBuilder.charAt(end));
            stringBuilder.setCharAt(end,c);
            System.out.println(stringBuilder);
            return;
        }
        int mid = start + (end - start) /2 ;

        reverseHelper(start, mid);
        reverseHelper(mid+1, end);

        merge(start,mid,end);



    }

    public  static void main(String args[]){
        ReverseString reverseString = new ReverseString("0123456789");

        System.out.println(reverseString.getReverse());
    }
}
