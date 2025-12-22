package src.calculos;

import src.models.Movie;
import src.models.Serie;
import src.models.Title;

public class TimeCalculator {
     private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void inclui(Movie f) {
    this.tempoTotal += f.getDuracaoEmMinutos();
    }

    public void inclui(Serie s) {
        this.tempoTotal += s.getDuracaoEmMinutos();
    }

    public void inclui(Title titulo) {
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
