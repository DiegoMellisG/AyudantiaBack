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

    /*  Aquí había un NAME en vez de un value. Por eso no resultó el swagger.
        El motivo, es porque al escribir el parámetro name, se sobreescribía la ruta del aplication.properties.
        @RequestMapping(name = ....)*/
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public Student getStudentByName(@RequestParam("nombre") String name)
    {
        return studentRepository.findByName(name);
    }

    /*  Para el metodo POST, que es cuando se desea crear el objeto en cuestión,
        en este caso Student, al poner en los parámetros un @RequestBody seguido del objeto
        (Student student) Spring asume que el JSON en cuestión que se debe ingresar será
        con los atributos de la clase Student, de la siguiente forma:
        {
          "name": "el nombre que quieren guardar",
          "rut" : "el rut"
        }
        Lo más probable es que swagger muestre el formato automáticamente, junto con el idStudent
        ustedes borrenlo, ya que pusimos que era auto-incremental.
     */
    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Student createStudent(@RequestBody Student student)
    {
        return studentRepository.save(student);
    }

}
