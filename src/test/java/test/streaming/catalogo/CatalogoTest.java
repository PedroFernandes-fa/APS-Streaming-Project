package test.java.test.streaming.catalogo;

import org.junit.jupiter.api.Test;
import main.java.streaming.catalogo.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {

    @Test
    void deveCadastrarFilmeNoCatalogo(){
        // Arrange
        Catalogo catalogo = new Catalogo();

        Filme filme = criarFilme(1, "Luigi 2, agora contra o Mario");


        // Act
        catalogo.adicionarConteudo(filme);

        // Assert
        assertEquals(1, catalogo.listaConteudos().size());
        assertSame(filme, catalogo.listaConteudos().getFirst());
    }

    @Test
    void naoDeveCadastrarConteudosComMesmoId() {
        // Arrange
        Catalogo catalogo = new Catalogo();

        Filme filme1 = criarFilme(2, "Alexnado, um tornado de Alexs");
        Filme filme2 = criarFilme(2, "Pablo, uma Maid muito perigosa");

        // Act
        catalogo.adicionarConteudo(filme1);

        try {
            catalogo.adicionarConteudo(filme2);

            fail("Deveria lançar uma excessão");
        } catch (IllegalArgumentException excecao) {
            assertEquals("Já existe um conteúdo com o ID: 2", excecao.getMessage());
        }

        // Assert
        assertEquals(1, catalogo.listaConteudos().size());
    }

    @Test
    void devePesquisarConteudoPorTitulo(){
        // Arrange
        Catalogo catalogo = new Catalogo();

        Filme filme1 = criarFilme(3, "Luisa & Luigi em Pokemon TCG NATIONAL LEAGUE");
        Filme filme2 = criarFilme(4, "Luisa & Luigi 2 em Pokemon TCG WORLD LEAGUE");
        Serie serie = criarSerie(5, "Como eu Destruir a UFPB");

        // Act
        catalogo.adicionarConteudo(filme1);
        catalogo.adicionarConteudo(filme2);
        catalogo.adicionarConteudo(serie);
        List<Conteudo> resultados = catalogo.pesquisarPorTitulo("Luigi");

        // Assert
        assertEquals(2, resultados.size());
        assertSame(filme1, resultados.getFirst());
        assertSame(filme2, resultados.getLast());
    }

    private Filme criarFilme(int id, String titulo) { return new Filme(id, titulo, "", 10, 120, 2005); }
    private Serie criarSerie(int id, String titulo) { return new Serie(id, titulo, "", 10, "Pedro Fernandes", 2028); }
}
