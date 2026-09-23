package main.java.streaming.catalogo;

import main.java.streaming.interfaces.*;

public class Episodio implements Reproduzivel {
    private int    numero;
    private String titulo;
    private int    duracao;
    private String sinopse;
    private int    dataLancamento;

    public Episodio(int numero, String titulo, int duracao, String sinopse, int dataLancamento) {
        this.numero         = numero;
        this.titulo         = titulo;
        this.duracao        = duracao;
        this.sinopse        = sinopse;
        this.dataLancamento = dataLancamento;
    }

    public void reproduzir(){ System.out.println("Reprodunzindo o episodio: " + getTitulo()); }

    public int    getNumero()         { return numero;         }
    public String getTitulo()         { return titulo;         }
    public int    obterDuracao()      { return duracao;        }
    public String getSinopse()        { return sinopse;        }
    public int    getDataLancamento() { return dataLancamento; }

    @Override
    public String toString() {
        return "Episodio{" +
                "numero=" + numero +
                ", titulo='" + titulo + '\'' +
                ", duracao=" + duracao +
                ", sinopse='" + sinopse + '\'' +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
