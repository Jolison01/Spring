package be.intecbrussel.spring5webapp.bootstrap;

import be.intecbrussel.spring5webapp.model.Author;
import be.intecbrussel.spring5webapp.model.Book;
import be.intecbrussel.spring5webapp.model.Publisher;
import be.intecbrussel.spring5webapp.repositories.AuthorRepository;
import be.intecbrussel.spring5webapp.repositories.BookRepository;
import be.intecbrussel.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("JolisonBooks");
        publisher.setAddressLine1("HoustonStreet");
        publisher.setState("New-York");
        publisher.setZip("NYC200");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric",  "Evans");
        Book ddd = new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "39393958969");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of books: " + publisher.getBooks().size());


    }
}
