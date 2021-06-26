package br.com.generation.blogPessoal.controller;
/*Função: CRUD blog pessoal no Spring + Postman
 * Autora: Talu - Turma 25
 * Data: 25.06.2021
*/

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.generation.blogPessoal.model.Postagens;
import br.com.generation.blogPessoal.repository.PostagensRepository;

@RestController
@RequestMapping ("/postagens")
@CrossOrigin ("*")
public class PostagensController {
	
	@Autowired
	private	PostagensRepository repository;
	
	@GetMapping ("/listar")
	public @ResponseBody List<Postagens> listar(){
		return repository.findAll();
	}
	// buscar por titulo
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> getByTitulo (@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	//buscar por id
	@GetMapping("ifelse/{id}")
	public ResponseEntity<Postagens> GetByIdIfElse (@PathVariable long id) {
	Optional<Postagens> postagem = repository.findById(id);
	if (postagem.isPresent()) {
		return ResponseEntity.ok(postagem.get());
	}
	return ResponseEntity.notFound().build();			
	}
	
	//novo post
	@PostMapping ("/postar")
	public ResponseEntity<Postagens> postPostagem (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagens));
	}
	// put - editar postagem
	@PutMapping 
	public ResponseEntity<Postagens> putPostagem (@RequestBody Postagens postagens){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagens));
	}
	// deletar postagem
	@DeleteMapping ("/{id}")
	public void deletePostagem (@PathVariable long id) {
		repository.deleteById(id);
	}
}