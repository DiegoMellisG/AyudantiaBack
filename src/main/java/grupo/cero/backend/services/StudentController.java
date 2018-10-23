package grupo.cero.backend.services;


import grupo.cero.backend.model.Student;
import grupo.cero.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //Aquí había un NAME en vez de un value.
    //@RequestMapping(name = ....)
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam("nombre") String name)
    {
        return studentRepository.findByName(name);
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }

}
