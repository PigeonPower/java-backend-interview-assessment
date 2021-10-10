package interview.assessment.controller;

import interview.assessment.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import interview.assessment.controller.model.BookRequest;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/book"})
public class BookController {

    @Autowired
    private BookService bookService;

    Logger logger = LogManager.getLogger(BookController.class);

    @PostMapping
    public ResponseEntity bookCreation(@Valid @RequestBody BookRequest bookRequest) {
        logger.debug("Start Book Creation");
        logger.debug("Book Request : {}", bookRequest);

        return ResponseEntity.ok().body(bookService.bookCreation(bookRequest));
    }


    @GetMapping("/list")
    public ResponseEntity bookListing(@RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        logger.debug("Start Book Listing");
        return ResponseEntity.ok().body(bookService.bookListing(pageNo, pageSize));
    }

    @GetMapping
    public ResponseEntity bookDetail(@RequestParam(name = "id") int id){
        logger.debug("Start Book Retrieve");
        logger.debug("Book Id : {}", id);
        return ResponseEntity.ok().body(bookService.bookDetail(id));
    }

    @PutMapping
    public ResponseEntity bookUpdate(@RequestParam(name = "id") int id, @Valid @RequestBody BookRequest bookRequest) {
        logger.debug("Start Book Update");
        logger.debug("Book Id : {}", id);
        logger.debug("Book Request : {}", bookRequest);
        return ResponseEntity.ok().body(bookService.bookUpdate(id, bookRequest));
    }

    @DeleteMapping
    public ResponseEntity bookDeletion(@RequestParam(name = "id") int id) {
        logger.debug("Start Book Delete");
        logger.debug("Book Id : {}", id);

        bookService.bookDeletion(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/borrow")
    public ResponseEntity bookBorrow(@RequestParam(name = "id") int id) {
        logger.debug("Start Book Borrow");
        logger.debug("Book Id : {}", id);
        return ResponseEntity.ok().body(bookService.bookBorrow(id));
    }

    @PostMapping("/return")
    public ResponseEntity bookReturn(@RequestParam(name = "id") int id) {
        logger.debug("Start Book Return");
        logger.debug("Book Id : {}", id);
        return ResponseEntity.ok().body(bookService.bookReturn(id));
    }
}
