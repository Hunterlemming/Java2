/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionexamples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krisztian
 */
public class ExceptionExamples {    //interfacekbe tervezzünk bele exceptionoket 
    
    public void doSomething1(){      //abszolút rossz megoldás, nem ír semmit, a program fut tovább
        //..
        try{
            //
        }catch(Exception e){    
            
        }
    }

    public void doSomething2(){      //a program még mindig fut tovább, de már látjuk, hogy van hiba
        //..
        try{
            //
        }catch(Exception e){    
            System.err.println("Hiba");
        }
    }
    
    public void doSomething3(){      //modulon belül működhet, ha biztosak vagyunk benne, hogy le tudjuk kezelni
        //..
        try{
            //
        }catch(Exception e){    
            Logger.getAnonymousLogger("").log(Level.SEVERE, "hiba");
        }
    }
    
    // library style
    public void doSomethingElse() 
            throws FileNotFoundException, IOException{
        BufferedReader config = new BufferedReader( new FileReader("config.dat") );
        String line = config.readLine();
    }
    
    public void doSomethingElse2() throws ConfigException{  //Így kell csinálni
        try (BufferedReader config = new BufferedReader( new FileReader("config.dat") )){
            String line = config.readLine();
        }catch(IOException ex){
            throw new ConfigException(ex);
        }
    }
    
    //domain-specific exception
    private static class ConfigException extends Exception{
        
        public ConfigException(IOException ex){
            System.err.println("Hiba");
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("Hi there");
    }
    
}
