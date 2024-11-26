package br.com.meuprojeto.screensound.repositoty;

import br.com.meuprojeto.screensound.model.Artista;
import br.com.meuprojeto.screensound.model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    Optional<Artista> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musicas> buscaMusicasPorArtista(String nome);
}
