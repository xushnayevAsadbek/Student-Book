package StudenetBook.service;

import StudenetBook.dto.StudentDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
@Service
public class StudentService {
    private List<StudentDTO> studentList= new LinkedList<>();

    public StudentService(){
        StudentDTO dto1 = new StudentDTO();
        dto1.setId("e4e34cb7-957e-4304-abf2-ef2d4d7d8171");
        dto1.setName("John");
        dto1.setSurname("Smith");
        dto1.setPhone(99891);
        dto1.setCreatedDate("2021-06-25");
        studentList.add(dto1);

        //---------

        StudentDTO dto2 = new StudentDTO();
        dto2.setId(UUID.randomUUID().toString());
        dto2.setName("Valish");
        dto2.setSurname("Valishov");
        dto2.setPhone(99891);
        dto2.setCreatedDate("2024-06-15");
        studentList.add(dto2);

        //------

        StudentDTO dto3 = new StudentDTO();
        dto3.setId(UUID.randomUUID().toString());
        dto3.setName("Alish");
        dto3.setSurname("Alishov");
        dto3.setPhone(99891);
        dto3.setCreatedDate("2023-04-25");
        studentList.add(dto3);
    }
    public List<StudentDTO> getStudentAll() {
        return studentList;
    }

    public StudentDTO getById(String id){
        StudentDTO exist = get(id);
        if(exist == null){
            throw new IllegalArgumentException("Student not  fond");
        }
//        for (StudentDTO dto : studentList){
//            if (dto.getId().equals(id)){
//                return dto;
//            }
//        }
        return exist;
    }
    public StudentDTO create (@RequestBody StudentDTO dto) {
        validate(dto);

        dto.setId(UUID.randomUUID().toString());
//        dto.setCreatedDate(LocalDateTime.now());
        studentList.add(dto);
        return dto;
    }
    public  boolean update(String id , StudentDTO dto){
        validate(dto);
        StudentDTO exist = get(id);
        if (exist == null){
            throw new IllegalArgumentException("Student not found");
        }

        exist.setName(dto.getName());
        exist.setSurname(dto.getSurname());
        exist.setPhone(dto.getPhone());

        return true;
    }

    public boolean delete (String id ){
        StudentDTO exist = get(id);
        if (exist == null){
            throw new IllegalArgumentException("Student not found");
        }
        studentList.remove(exist);
        return true;
    }

    public void validate (StudentDTO dto){
        if (dto.getName() == null || dto.getName().trim().length() <2){
            throw new IllegalArgumentException("Name required");
        }
        if (dto.getSurname()== null || dto.getSurname().trim().length() <2){
            throw new IllegalArgumentException("Surname required");
        }
//        if (dto.getAge()<18){
//            throw new IllegalArgumentException("Age required");
//        }
    }

    public StudentDTO get(String id){
        for (StudentDTO exist : studentList){
            if (exist.getId().equals(id)){

                return exist;
            }
        }
        return null;
    }

}
