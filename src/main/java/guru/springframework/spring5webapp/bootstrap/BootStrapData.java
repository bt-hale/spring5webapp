package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.EBook;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("eric","evans");
		EBook ddd = new EBook("Domain Driven Designs", "12345");
		
		ddd.getAuthors().add(eric);
		eric.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);

		Author rod = new Author("Rod","Johnson");
		EBook noEJB = new EBook("J2EE Development", "54321");
		
		ddd.getAuthors().add(rod);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);

		System.out.println("Bootstrap Startup");
		System.out.println("number of books = " + bookRepository.count());
		
		Publisher pub = new Publisher("Book Publishers, Inc", "123 Main", "Dallas", "TX", "75123");
		
		publisherRepository.save(pub);
		System.out.println("number of authors = " + authorRepository.count());
		System.out.println("number of publishers = " + publisherRepository.count());
		
	}
	
	

}
