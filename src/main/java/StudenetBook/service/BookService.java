package StudenetBook.service;

import StudenetBook.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    private List<BookDTO> bookList = new LinkedList<>();
    public BookService() {
        BookDTO dto1 = new BookDTO();
        dto1.setId(UUID.randomUUID().toString());
        dto1.setTitle("Title 1");
        dto1.setAuthor("Author 1");
        dto1.setPublisher(LocalDate.of(1991, 1,12));
        bookList.add(dto1);
        //-----------
        BookDTO dto2 = new BookDTO();
        dto2.setId(UUID.randomUUID().toString());
        dto2.setTitle("Title 2");
        dto2.setAuthor("Author 2");
        dto2.setPublisher(LocalDate.of(1995, 5,15));
        bookList.add(dto2);

        //--------------
        BookDTO dto3 = new BookDTO();
        dto3.setId(UUID.randomUUID().toString());
        dto3.setTitle("Title 3");
        dto3.setAuthor("Author 3");
        dto3.setPublisher(LocalDate.of(2021, 7,22));
        bookList.add(dto3);

        //----------------
        BookDTO dto4 = new BookDTO();
        dto4.setId(UUID.randomUUID().toString());
        dto4.setTitle("Title 4");
        dto4.setAuthor("Author 4");
        dto4.setPublisher(LocalDate.of(2005, 3,26));
        bookList.add(dto4);
    }
    public BookDTO create (BookDTO dto) {
        validate(dto);

        dto.setId(UUID.randomUUID().toString());
        bookList.add(dto);
        return dto;
    }
    public List<BookDTO> getBookList() {
        return bookList;
    }
    public BookDTO getById(String id){
        BookDTO exist = get(id);
        if(exist == null){
            throw new IllegalArgumentException("Book not  fond");
        }
//        for (StudentDTO dto : studentList){
//            if (dto.getId().equals(id)){
//                return dto;
//            }
//        }
        return exist;
    }

    public  boolean update(String id , BookDTO dto){
        validate(dto);
        BookDTO exist = get(id);
        if (exist == null){
            throw new IllegalArgumentException("Book not found");
        }

        exist.setTitle(dto.getTitle());
        exist.setAuthor(dto.getAuthor());
        exist.setPublisher(dto.getPublisher());


        return true;
    }

    public boolean delete (String id ){
        BookDTO exist = get(id);
        if (exist == null){
            throw new IllegalArgumentException("Book not found");
        }
        bookList.remove(exist);
        return true;
    }

    public void validate (BookDTO dto){
        if (dto.getTitle() == null || dto.getTitle().trim().length() <2){
            throw new IllegalArgumentException("Name required");
        }
        if (dto.getAuthor()== null || dto.getAuthor().trim().length() <2){
            throw new IllegalArgumentException("Surname required");
        }
//        if (dto.getPublisher()<18){
//            throw new IllegalArgumentException("Age required");
//        }
    }

    public BookDTO get(String id){
        for (BookDTO exist : bookList){
            if (exist.getId().equals(id)){

                return exist;
            }
        }
        return null;
    }
}
