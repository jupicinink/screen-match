package src.Main;

import src.models.Movie;
import src.models.Serie;        
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import src.models.Title;
import java.util.List;



public class MainWithList {

    public static void main(String[] args) {
        Movie meuFilme = new Movie("O poderoso chefão", 1970);
        Movie outroFilme = new Movie("Avatar", 2023);
        Serie lost = new Serie("Lost", 2000);

        List<Title> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for(Title item : lista){
            System.out.println(item.getNome());
            if(item instanceof Movie){
            Movie filme = (Movie) item;
            System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> searchByArtist = new ArrayList<>();
        searchByArtist.add("Adam Sandler");
        searchByArtist.add("Paulo Gustavo");
        searchByArtist.add("Jennifer Aniston");
        System.out.println(searchByArtist);     

        Collections.sort(searchByArtist);
        System.out.println(searchByArtist);
        Collections.sort(lista);
        System.out.println("Ordenado por nome: " + lista);



        lista.sort(Comparator.comparing(Title::getAnoDeLancamento));
        System.out.println("Ordenado por ano de lançamento: " + lista);
    }
}