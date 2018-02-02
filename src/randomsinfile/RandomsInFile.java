/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomsinfile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author S-Mercedes.Blache
 */
public class RandomsInFile {

    /**
     * @param args the command line arguments
     */
    
    public static int validateInt(String prompt)throws IllegalArgumentException {
        boolean go = true;
        int n = 0;
        while(go){
        System.out.print(prompt);
        Scanner keyboard = new Scanner(System.in);
        String str = keyboard.nextLine();
        try{
        n = Integer.parseInt(str);
        if(n>0)go = false; //making sure numbers are positive.
            else {
            throw new IllegalArgumentException();
                }
        }
        catch(IllegalArgumentException e){
            System.out.print("ERROR: Inncorect input "+ e.getMessage()+"\n");
        }
            }
        return n;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner keyboard = new Scanner(System.in);
        
        int num = 0;
        int min = 0;
        int max = 0;
        
        num = validateInt("Enter number of randoms generated: ");

        min = validateInt("Enter min for range: "); //getting the min for range.

        max = validateInt("Enter max for range: ");//getting the max for range
        if(min>max){ //swaping numbers if min is greater than max
            min = min+max;
            max = min-max;
            min = min-max;
        }
       
       System.out.print("Enter the filename to store the : ");
        
       String filename = keyboard.nextLine();  //gettting file name 
       
       int randNum;
       Random rand = new Random(); //setting up random nums
       try{
       PrintWriter outputFile = new PrintWriter(filename);
       
        for(int i = 1; i <= num; i++){
           // System.out.print("enter the name of friend"+ 
                    //"numer" +i+ ": ");
            randNum = rand.nextInt(max - min +1) + min;
            //random.nextInt(max - min + 1) + min
            outputFile.println(randNum);
        }
       
        outputFile.close();
        System.out.println("Data written to the file.");
      
       }
       catch(IOException e){
        System.out.println("Cannot open the file" +e.getMessage());
            }
    }
    
      
      
    }

