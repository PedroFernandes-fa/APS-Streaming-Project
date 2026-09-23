package test.java.test.streaming.catalogo;

import org.junit.jupiter.api.Test;
import main.java.streaming.catalogo.*;

import static org.junit.jupiter.api.Assertions.*;

public class TemporadaTest {
    @Test
    void deveAdicionarEpisodioNaTemporada() {
        // Arrange
        Temporada temporada = criarTemporada(1, "Temporada 1");
        Episodio episodio = criarEpisodio(1, "Episodio 1");

        // Act
        temporada.adicionarEpisodio(episodio);

        // Assert
        assertEquals(1, temporada.getNumeroEpisodios());
        assertSame(episodio, temporada.obterEpisodio(1));
    }

    @Test
    void naoDeveAdicionarEpisodiosComMesmoNumero() {
        // Arrange
        Temporada temporada = criarTemporada(2, "Temporada 1");
        Episodio episodio1 = criarEpisodio(2, "Episodio 1");
        Episodio episodio2 = criarEpisodio(2, "Episodio 2");

        // Act
        temporada.adicionarEpisodio(episodio1);
        try {
            temporada.adicionarEpisodio(episodio2);

            fail("Deveria lançar uma excessão");
        } catch (IllegalArgumentException excessao) {
            assertEquals("Já existe um episodio com o ID: 2", excessao.getMessage());
        }
        // Assert
        assertEquals(1, temporada.getNumeroEpisodios());
        assertSame(episodio1, temporada.obterEpisodio(1));
    }

    @Test
    void deveRetornarNullQuandoEpisodioNaoExistir() {
        // Arrange
        Temporada temporada = criarTemporada(3, "Temporada 3");
        Episodio episodio = null;

        // Act
        try {
            temporada.adicionarEpisodio(episodio);

            fail("Deveria lançar uma excessão");
        } catch (IllegalArgumentException excessao) {
            assertEquals("O episodio não pode ser nulo!", excessao.getMessage());
        }
        // Assert
        assertEquals(0, temporada.getNumeroEpisodios());
    }

    private Temporada criarTemporada(int id, String titulo) { return new Temporada(id, titulo, 2030, 500); }
    private Episodio criarEpisodio(int id, String titulo) { return new Episodio(id, titulo, 40, "", 2030);}
}
