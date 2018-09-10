package br.com.linoox.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.linoox.workshopmongo.domain.Post;
import br.com.linoox.workshopmongo.repository.PostRepository;
import br.com.linoox.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
		// return repo.findByTitleContainingIgnoreCase(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		// Finaliza a maxDate até a 0:00 do dia posterior
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
