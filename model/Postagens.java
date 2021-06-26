package br.com.generation.blogPessoal.model;
/*Função: CRUD blog pessoal no Spring + Postman
 * Autora: Talu - Turma 25
 * Data: 25.06.2021
*/
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Postagens")
public class Postagens {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min = 5, max = 100)
	private String titulo;
	
	@NotNull
	@Size (min = 10, max = 1000)
	private String texto;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.util.Date(System.currentTimeMillis());
						
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}; 
	
}