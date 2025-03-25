package StudenetBook.controller;

import StudenetBook.dto.BookDTO;
import StudenetBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("")
    public ResponseEntity<?> create (@RequestBody BookDTO dto){
     BookDTO responDTO = bookService.create(dto);
     return ResponseEntity.ok().body(responDTO);
    }
    @GetMapping( "/")
    public ResponseEntity<List<BookDTO>> all(){
        return ResponseEntity.ok(bookService.getBookList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> byId(@PathVariable String id){
        return ResponseEntity.ok(bookService.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody BookDTO dto){
        boolean result = bookService.update(id, dto);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id){
        boolean result = bookService.delete(id);
    return ResponseEntity.ok().body(result);
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<?> update (@PathVariable("id") String id , @RequestBody BookDTO dto){
//        boolean result = bookService.update(id, dto);
//        return ResponseEntity.ok().body(result);
//    }

}
