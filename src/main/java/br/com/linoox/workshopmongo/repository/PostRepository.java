package br.com.linoox.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.linoox.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	// Consulta simples com @Query do Spring Boot
	@Query("{'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);

	// Consulta simples com query methods do Spring Boot com IgnoreCase
	List<Post> findByTitleContainingIgnoreCase(String text);
}
