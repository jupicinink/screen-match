package src.models;

import com.google.gson.annotations.SerializedName;

public class TitleOmdb {
    @SerializedName("Title")
    private String title;

    @SerializedName("Year")
    private String year;

    @SerializedName("Runtime")
    private String runtime;

    // construtor padrão necessário para Gson
    public TitleOmdb() { }

    // getters convencionais
    public String getTitle() { return title; }
    public String getYear() { return year; }
    public String getRuntime() { return runtime; }

    // método Title() para compatibilidade com seu Main atual
    public String Title() { return title; }

    @Override
    public String toString() {
        return "TitleOmdb{Title='" + title + "', Year='" + year + "', RunTime='" + runtime + "'}";
    }
}
