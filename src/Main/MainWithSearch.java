package src.Main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainWithSearch {
    public static void main (String[] args){

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: ");
        String busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=48d5096a";
        HttpURLConnection con = null;
        try {
            URL url = new URL(endereco);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);

            int status = con.getResponseCode();
            InputStream is = (status >= 200 && status < 400) ? con.getInputStream() : con.getErrorStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line).append("\n");
            }
            in.close();

            System.out.println("Status: " + status);
            System.out.println(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        
    }
}