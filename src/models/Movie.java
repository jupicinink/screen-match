package src.models;

import src.calculos.Classifiable;

public class Movie extends Title implements Classifiable {
    private String diretor;

    public Movie (String nome, int anoDeLancamento){
        this.setNome(nome);
        this.setAnoDeLancamento(anoDeLancamento);
    }
    
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " +this.getNome() + " (" + this.getAnoDeLancamento() + ")" ;
    }
}