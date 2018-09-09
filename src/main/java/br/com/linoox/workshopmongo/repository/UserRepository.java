package br.com.linoox.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.linoox.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
