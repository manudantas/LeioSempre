package Leiosempre;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LerEsc {


    public static void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                System.out.println(linha);
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
 

    public static void escritor(String path, String string) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        buffWrite.append(string);
        buffWrite.newLine();
        buffWrite.close();
    }
    
    public static boolean leitorEspecifico(String path, String string) throws IOException{
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        int line = 0;  
        while((linha = buffRead.readLine())!= null) {  
            line++;
            if (linha.equals(string))  
                return true;
        }  
        return false;
    }
    
}