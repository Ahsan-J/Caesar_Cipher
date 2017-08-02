/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasarcipher;

import java.util.Scanner;

/**
 *
 * @author Xcalaiberz
 */
public class CeasarCipher {

    static final int key = 3;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String Text = scan.nextLine();
        System.out.println("");
        System.out.println(encrypt(Text));
        System.out.println(decrypt(encrypt(Text)));
    }
    
    public static String encrypt(String msg){
        msg = msg.toUpperCase();
        msg = msg.replaceAll(" ", "");
        String Result = "";
        char ch = ' ';
        for(int i=0;i<msg.length();i++){
            if(msg.charAt(i)>='A'&&msg.charAt(i)<='Z'){
                ch = (char) (((msg.codePointAt(i)-'A'+key)%26)+'A');
                Result = Result + ch;
            }
            else{
                Result = Result + msg.charAt(i);
            }
        }
        return Result.trim();
    }
    public static String decrypt(String msg){
        msg = msg.toUpperCase();
        String Result = "";
        char ch=' ';
        for(int i=0;i<msg.length();i++){
           int num = msg.codePointAt(i)-'A'-key;
           if(num>0){
               ch = (char) (((num)%26)+'A');
           }
           else{
               ch = (char) (((num+26)%26)+'A');
           }
           Result = Result + ch;
        }
        return Result.trim();
    }
}
