package br.com.linoox.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.linoox.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	// Usando os query methods do Spring Boot com IgnoreCase
	List<Post> findByTitleContainingIgnoreCase(String text);
}
