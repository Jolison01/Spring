package be.intecbrussel.spring5webapp.repositories;

import be.intecbrussel.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
