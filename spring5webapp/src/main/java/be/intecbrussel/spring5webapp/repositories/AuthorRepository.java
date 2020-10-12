package be.intecbrussel.spring5webapp.repositories;

import be.intecbrussel.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long>{
}
