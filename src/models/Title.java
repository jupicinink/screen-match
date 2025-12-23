package src.models;

public class Title {

    private String nome;


    private int anoDeLancamento;

    private boolean incluidoNoPlano;


    private double somaDasAvaliacoes;


    private int totalDeAvaliacoes;

    private int duracaoEmMinutos;

    public Title(TitleOmdb omdb) throws ErroDeConversaoDeAnoException {
        this.nome = omdb.getTitle();
        // extrair ano (ex: "2003–" ou "2003")
        String anoRaw = omdb.getYear();
        if (anoRaw == null) {
            throw new ErroDeConversaoDeAnoException("Ano nulo");
        }
        java.util.regex.Matcher mAno = java.util.regex.Pattern.compile("(\\d{4})").matcher(anoRaw);
        if (mAno.find()) {
            try {
                this.anoDeLancamento = Integer.parseInt(mAno.group(1));
            } catch (NumberFormatException ex) {
                throw new ErroDeConversaoDeAnoException("Erro ao converter ano: " + anoRaw);
            }
        } else {
            throw new ErroDeConversaoDeAnoException("Ano inválido: " + anoRaw);
        }

        // extrair duração em minutos (ex: "171 min")
        String runtimeRaw = omdb.getRuntime();
        if (runtimeRaw != null) {
            java.util.regex.Matcher mRun = java.util.regex.Pattern.compile("(\\d+)").matcher(runtimeRaw);
            if (mRun.find()) {
                try {
                    this.duracaoEmMinutos = Integer.parseInt(mRun.group(1));
                } catch (NumberFormatException ex) {
                    this.duracaoEmMinutos = 0;
                }
            } else {
                this.duracaoEmMinutos = 0;
            }
        } else {
            this.duracaoEmMinutos = 0;
        }

        // ...existing code to set outros campos...
    }
    

    public Title(String nome2, int anoDeLancamento2) {
        //TODO Auto-generated constructor stub
    }


    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    public int getClassificacao() {
        throw new UnsupportedOperationException("Unimplemented method 'getClassificacao'");
    }
    public int compareTo(Title o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public String toString() {
        // evita importar Gson se quiser menos mudanças:
        return new com.google.gson.Gson().toJson(this);
    }
}
