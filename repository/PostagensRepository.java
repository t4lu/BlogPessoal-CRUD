package br.com.generation.blogPessoal.repository;
/*Função: CRUD blog pessoal no Spring + Postman
 * Autora: Talu - Turma 25
 * Data: 25.06.2021
*/

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.generation.blogPessoal.model.Postagens;

@Repository
public interface PostagensRepository extends JpaRepository<Postagens, Long>{
							
	public List<Postagens> findAll();
	public List <Postagens> findAllByTituloContainingIgnoreCase(String titulo);

}