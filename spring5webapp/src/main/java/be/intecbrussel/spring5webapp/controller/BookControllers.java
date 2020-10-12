package be.intecbrussel.spring5webapp.controller;

import be.intecbrussel.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookControllers {



    private final BookRepository bookRepository;



    public BookControllers(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }




    @RequestMapping("/books")
   public String getBooks(Model model){


        model.addAttribute("books",bookRepository.findAll());


       return "book";





   }

}
