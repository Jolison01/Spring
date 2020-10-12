package be.intecbrussel.spring5webapp.repositories;

import be.intecbrussel.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
