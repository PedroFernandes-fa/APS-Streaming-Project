package main.java.streaming.catalogo;

import main.java.streaming.interfaces.*;

public class Filme extends Conteudo implements Reproduzivel {
    private int duracao;
    private int anoLancamento;

    public Filme(int idConteudo, String titulo, String descricao, int classificacaoIndicativa, int duracao, int anoLancamento) {
        super(idConteudo, titulo, descricao, classificacaoIndicativa);
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
    }

    public void reproduzir() { System.out.println("Reprodunzindo o filme: " + getTitulo()); }

    public int obterDuracao()     { return duracao;       }
    public int getAnoLancamento() { return anoLancamento; }

    @Override
    public String toString() { return "Filme: " + getTitulo() + " - Duracao: " + duracao + " - Ano de Lancamento: " + anoLancamento; }
}
