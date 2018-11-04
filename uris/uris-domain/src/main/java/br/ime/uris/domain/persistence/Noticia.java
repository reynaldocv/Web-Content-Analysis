package br.ime.uris.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"TrMov_Noticia\"")
public class Noticia {
	@Id
	@Column(name = "\"idNot\"", unique = true, nullable = false)
	@SequenceGenerator(name = "noticia_sequence", sequenceName = "\"TrMov_Noticia_idNot_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "noticia_sequence")
	private Integer idNoticia;
	
	@Column(name = "\"titulo\"", nullable = false, length = 100)
	private String titulo;
	
	@Column(name = "\"contenido\"", nullable = false, length = 250)
	private String contenido;
	
	@Column(name = "\"fecPub\"", nullable = false)
	private Date fecPub;
	
	@Column(name = "\"fuente\"", nullable = true, length = 250)
	private String fuente ;
	
	@Column(name = "\"autor\"", nullable = false,length = 100)
	private String autor;
	
	@Column(name = "\"link\"", nullable = true,length = 500)
	private String link;
	
	@Column(name = "\"idCategoria\"", nullable = true,length = 100)
	private Integer categoria;
	
	public Noticia(){}
	
	
	public Noticia(Integer idNoticia, String titulo, String contenido, Date fecPub, String fuente, String autor, String link) {
		super();
		this.idNoticia = idNoticia;
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecPub = fecPub;
		this.fuente = fuente;
		this.autor = autor;
		this.link = link;
	}


	public Integer getIdNoticia() {
		return idNoticia;
	}
	public void setIdNoticia(Integer idNoticia) {
		this.idNoticia = idNoticia;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	
	public Date getFecPub() {
		return fecPub;
	}
	public void setFecPub(Date fecPub) {
		this.fecPub = fecPub;
	}
	
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setCategoria(Integer categoria) {
		this.categoria=categoria;
		
	}
	public Integer getCategoria(){
		return categoria;
	}
}
