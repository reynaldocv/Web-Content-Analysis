package br.ime.uris.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ime.uris.dao.NoticiaDao;
import br.ime.uris.domain.persistence.Noticia;
import br.ime.uris.repository.persistence.NoticiaRepository;
import br.ime.uris.util.dto.NoticiaDto;


@Component
public class NoticiaDaoImp  implements NoticiaDao{

	@Autowired
	private NoticiaRepository noticiaRepository;
	
	@Override
	public List<NoticiaDto> listNoticia() {
		
		List<Noticia> lNoticia = noticiaRepository.findByEstado();
		
		List<NoticiaDto> lNoticiaDto = new ArrayList<>();
		
		for (Noticia noticia: lNoticia){
			
			NoticiaDto noticiaDto = new NoticiaDto();
			
			BeanUtils.copyProperties(noticia, noticiaDto);
			
			lNoticiaDto.add(noticiaDto);
		}
		
		return lNoticiaDto;
		
	}

}
