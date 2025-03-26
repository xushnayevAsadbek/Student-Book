package StudenetBook.controller;

import StudenetBook.dto.StudentBookDTO;
import StudenetBook.dto.StudentDTO;
import StudenetBook.service.StudentBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student-book")
@RestController
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;
    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody StudentBookDTO dto){
        StudentBookDTO result = studentBookService.create(dto);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/")
    public ResponseEntity<?> put (@Valid @RequestBody StudentBookDTO dto){
        StudentBookDTO result = studentBookService.returnbook(dto);
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("")
    public ResponseEntity<List<StudentBookDTO>> getBook(){
        List<StudentBookDTO> result = studentBookService.studentBooklist() ;
    return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentBookDTO> getById(@PathVariable("id") String id){
        StudentBookDTO result = studentBookService.getStudentBookId(id) ;
        return ResponseEntity.ok().body(result);
    }


}
