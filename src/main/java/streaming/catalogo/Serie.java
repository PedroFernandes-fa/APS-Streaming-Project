package main.java.streaming.catalogo;

import main.java.streaming.enums.StatusSerie;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Conteudo{
    private String          criador;
    private int             anoEstreia;
    private List<Temporada> temporadas;
    private StatusSerie status;

    public Serie(int idConteudo, String titulo, String descricao, int classificacaoIndicativa, String criador, int anoEstreia) {
        super(idConteudo, titulo, descricao, classificacaoIndicativa);
        this.criador    = criador;
        this.anoEstreia = anoEstreia;
        this.temporadas = new ArrayList<>();
        this.status     = StatusSerie.EM_ANDAMENTO;
    }

    public void adicionarTemporada(Temporada temporada) {
        if (temporada == null) { throw new IllegalArgumentException("A temporada não pode ser nula!"); }
        if (obterTemporada(temporada.getNumero()) != null) { throw new IllegalArgumentException("Já existe uma temporada com o ID: " + temporada.getNumero()); }
        temporadas.add(temporada);
    }

    public Temporada obterTemporada(int numero) {
        if(numero < 0) { throw new IllegalArgumentException("O Numero da Temporada deve ser maior que zero!"); }
        for (Temporada temporada : temporadas) { if (temporada.getNumero() == numero) { return temporada; } }
        return null;
    }

    public String      getCriador()          { return criador;           }
    public int         getAnoEstreia()       { return anoEstreia;        }
    public int         getNumeroTemporadas() { return temporadas.size(); }
    public StatusSerie getStatus()           { return status;            }

    @Override
    public String toString() {
        return "Serie: " + getTitulo() + " - Criador: " + criador + " - Ano de Estreia: " + anoEstreia;
    }
}
