package servidor;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;




public class servidor {
     ServerSocket serverSocket;

     public static void main(String[] args) throws ClassNotFoundException, IOException {
    	 		
           
            	
                 ServerSocket servidor = new ServerSocket(4027);
                 System.out.println("Servidor iniciado na porta: "+ servidor.getLocalPort());
              
         
               Socket cliente = servidor.accept();
               System.out.println("Cliente conectado IP: " + Arrays.toString(cliente.getInetAddress().getAddress()));
               
             
               Scanner input = new Scanner(cliente.getInputStream());
               while(input.hasNextLine()){
                  System.out.println(input.nextLine());
               }
               
         
               
               input.close();
               servidor.close();
               
     
}}
