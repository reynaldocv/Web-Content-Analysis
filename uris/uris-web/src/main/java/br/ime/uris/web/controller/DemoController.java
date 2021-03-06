package br.ime.uris.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ime.uris.dao.NoticiaDao;
import br.ime.uris.util.dto.NoticiaDto;

@RestController
@RequestMapping("/")
public class DemoController {
	
	@Autowired
	private NoticiaDao noticiaDao;
 
    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<NoticiaDto> sayHello() {
    		
        return noticiaDao.listNoticia();
    }
    
    @RequestMapping(value = "/hello", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> sayHello2()
    {
        return new ResponseEntity<>(noticiaDao.listNoticia(), HttpStatus.NOT_FOUND);
    }
}
