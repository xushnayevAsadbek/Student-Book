package StudenetBook.controller;

import StudenetBook.dto.StudentDTO;
import StudenetBook.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(studentService.getStudentAll());

    }

    @GetMapping("/byid/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?>  create (@Valid @RequestBody StudentDTO dto) {
        StudentDTO responseDTO = studentService.create(dto);
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(responseDTO, HttpStatus.valueOf(200));
        return responseEntity;
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity<?> update(@PathVariable("id") String id , @RequestBody StudentDTO dto){
        boolean result = studentService.update(id,dto);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(result, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") String id ){
        boolean result = studentService.delete(id);
        return ResponseEntity.ok().body(result);
    }
}
