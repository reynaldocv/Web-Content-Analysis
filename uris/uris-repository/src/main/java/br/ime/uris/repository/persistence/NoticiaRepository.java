package br.ime.uris.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ime.uris.domain.persistence.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

	
	@Query("from Noticia p  order by p.fecPub desc")
	public List<Noticia> findByEstado();
	
	
}
