package main.java.streaming.catalogo;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private int            numero;
    private String         titulo;
    private int            anoLancamento;
    private int            duracao;
    private List<Episodio> episodios;

    public Temporada(int numero, String titulo, int anoLancamento, int duracao) {
        this.numero        = numero;
        this.titulo        = titulo;
        this.anoLancamento = anoLancamento;
        this.duracao       = duracao;
        this.episodios     = new ArrayList<>();
    }

    public void adicionarEpisodio(Episodio episodio) {
        if (episodio == null) { throw new IllegalArgumentException("O episodio não pode ser nulo!"); }
        if (obterEpisodio(episodio.getNumero()) != null) { throw new IllegalArgumentException("Já existe um episodio com o ID: " + episodio.getNumero()); }
        this.episodios.add(episodio);
    }

    public Episodio obterEpisodio(int numero) {
        if(numero < 0) { throw new IllegalArgumentException("O Numero do Episodio deve ser maior que zero!"); }
        for (Episodio episodio : episodios) { if (episodio.getNumero() == numero) { return episodio; } }
        return null;
    }

    public int    getNumero()          { return numero;           }
    public String getTitulo()          { return titulo;           }
    public int    getAnoLancamento()   { return anoLancamento;    }
    public int    getDuracao()         { return duracao;          }
    public int    getNumeroEpisodios() { return episodios.size(); }
}
