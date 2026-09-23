import main.java.streaming.catalogo.*;

void main() {
//    Criar um filme
    Filme filme = new Filme(1, "Sharknado", "Um tornado de Tubarões surge para causa o terror!", 10, 120, 2005);

//    Criar dois episódios
    Episodio episodio1 = new Episodio(1, "O Primeiro", 43, "O Primeiro", 2026);
    Episodio episodio2 = new Episodio(2, "O Segundo", 41, "O Segundo", 2026);

//    Criar uma temporada e adicionar episódios
    Temporada temporada = new Temporada(1, "A Jornada", 2026, 84);
    temporada.adicionarEpisodio(episodio1);
    temporada.adicionarEpisodio(episodio2);

//    Criar uma série e adicionar a temporada
    Serie serie = new Serie(2, "Desaventuras em Serie", "Uma serie que conta varias desaventuras", 12, "Dorgival Netto, grande escritor comteporaneo", 2030);
    serie.adicionarTemporada(temporada);

//    Criar um catálogo
    Catalogo catalogo = new Catalogo();

//    Cadastrar o filme e a série
    catalogo.adicionarConteudo(filme);
    catalogo.adicionarConteudo(serie);

//    Exibir todos os conteúdos
    for (Conteudo c : catalogo.listaConteudos()) { System.out.println(c.toString()); }

//    Pesquisar conteúdos por uma palavra
    for (Conteudo c : catalogo.pesquisarPorTitulo("Shark")) { System.out.println(c.toString()); }

}