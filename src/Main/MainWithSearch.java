package src.Main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import src.models.ErroDeConversaoDeAnoException;
import src.models.Title;
import src.models.TitleOmdb;

public class MainWithSearch {
    public static void main (String[] args) throws IOException{
        
        Scanner leitura = new Scanner(System.in);
        String buscar = "";
        List<Title> listDeTitles = new ArrayList<>();
        
        while(!buscar.equalsIgnoreCase("sair")){
            System.out.println("Digite um filme para busca: ");
            String busca = leitura.nextLine();
            
            if(busca.equalsIgnoreCase("sair")){
                break;
            }   
            String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=48d5096a";
            try{
                HttpURLConnection con = null;
                StringBuilder content = new StringBuilder(); // movido para cá
                try {
                    URL url = new URL(endereco);
                    con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setConnectTimeout(5000);
                    con.setReadTimeout(5000);
                    
                    int status = con.getResponseCode();
                    InputStream is = (status >= 200 && status < 400) ? con.getInputStream() : con.getErrorStream();
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                    String line;
                    while ((line = in.readLine()) != null) {
                        content.append(line).append("\n"); // usa o content declarado fora
                    }
                    in.close();

                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();  
                } finally {
                    if (con != null) {
                        con.disconnect();
                    }
                }
                
                
                String json = content.toString(); 
                System.out.println(json);
                Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
                
                
                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println( myTitleOmdb);
                

                Title myTitle = new Title (myTitleOmdb);
                System.out.println("Título: " + myTitle);
                FileWriter escrita = new FileWriter("filmes.txt");
                escrita.write(myTitle.toString());
                escrita.close();
                
                listDeTitles.add(myTitle);
            } catch(NumberFormatException e){
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            } catch(IllegalArgumentException e){
                System.out.println("Aconteceu um erro: ");
                System.out.println(e.getMessage());
            }  catch(ErroDeConversaoDeAnoException e){
                System.out.println("Aconteceu um erro inesperado: ");
                System.out.println(e.getMessage());
            }
            
        }      
        System.out.println(listDeTitles);
        
        leitura.close(); // fechar
    }
}