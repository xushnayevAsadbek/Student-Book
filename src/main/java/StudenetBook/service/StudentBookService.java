package StudenetBook.service;

import StudenetBook.dto.BookDTO;
import StudenetBook.dto.StudentBookDTO;
import StudenetBook.dto.StudentDTO;
import StudenetBook.enums.StudentBookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentBookService {
    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;
    private List<StudentBookDTO> studentBookList = new LinkedList<>();

    public StudentBookDTO create(StudentBookDTO dto){
        StudentDTO student  = studentService.get(dto.getStudentId());
        if (student == null) {
            throw new IllegalArgumentException("Student not found");
        }
        BookDTO book  = bookService.get(dto.getBookId());
        if (book == null) {
            throw new IllegalArgumentException("Student not found");
        }
    StudentBookDTO studentBook = new StudentBookDTO();
        studentBook.setId(UUID.randomUUID().toString());
        studentBook.setStudentId(dto.getStudentId());
        studentBook.setBookId(dto.getBookId());
        studentBook.setStatus(StudentBookStatus.TAKEN);
        studentBook.setCreatedDate(LocalDateTime.now());
        studentBookList.add(studentBook);
        return studentBook;
    }

    public StudentBookDTO returnbook(StudentBookDTO dto){
        for (StudentBookDTO studentBook : studentBookList) {
            if (studentBook.getStudentId().equals(dto.getStudentId()) &&
            studentBook.getBookId().equals(dto.getBookId()) &&
                    studentBook.getStatus().equals(StudentBookStatus.TAKEN))
            {
    studentBook.setStatus(StudentBookStatus.RETURNED);
    studentBook.setCreatedDate(LocalDateTime.now());
    return studentBook;
            }
        }
        throw new IllegalArgumentException("Student_Book not found");

    }
}
