package test.java.test.streaming.catalogo;

import org.junit.jupiter.api.Test;
import main.java.streaming.catalogo.*;

import static org.junit.jupiter.api.Assertions.*;

public class SerieTest {
    @Test
    void deveAdicionarTemporadaNaSerie() {
        // Arrange
        Serie serie = criarSerie(1, "StarWars, a Serie Animada");
        Temporada temporada = criarTemporada(1, "Sistema Solar");

        // Act
        serie.adicionarTemporada(temporada);

        // Assert
        assertEquals(1, serie.getNumeroTemporadas());
        assertSame(temporada, serie.obterTemporada(1));
    }

    @Test
    void naoDeveAdicionarTemporadasComMesmoNumero(){
        // Arrange
        Serie serie = criarSerie(2, "Dragon Ball");
        Temporada temporada1 = criarTemporada(2, "Planeta Terra");
        Temporada temporada2 = criarTemporada(2, "Planeta Vegetta");

        // Act
        serie.adicionarTemporada(temporada1);
        try {
            serie.adicionarTemporada(temporada2);

            fail("Deveria lançar uma excessão");
        } catch (IllegalArgumentException excessao) {
            assertEquals("Já existe uma temporada com o ID: 1", excessao.getMessage());
        }
        // Assert
        assertEquals(1, serie.getNumeroTemporadas());
        assertSame(temporada1, serie.obterTemporada(1));
    }

    @Test
    void deveRetornarNullQuandoTemporadaNaoExistir(){
        // Arrange
        Serie serie = criarSerie(3, "Dragon Ball");
        Temporada temporada = null;

        // Act
        try {
            serie.adicionarTemporada(temporada);

            fail("Deveria lançar uma excessão");
        } catch (IllegalArgumentException excessao) {
            assertEquals("A temporada não pode ser nula!", excessao.getMessage());
        }
        // Assert
        assertEquals(0, serie.getNumeroTemporadas());
    }

    private Serie criarSerie(int id, String titulo) { return new Serie(id, titulo, "", 10, "Dorgival Netto", 2028); }
    private Temporada criarTemporada(int id, String titulo) { return new Temporada(id, titulo, 2030, 500); }
}
