package cz.engeto.demo.controller;

import cz.engeto.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employee")
public class PathController {

    List<Employee> employeeList = List.of(
            new Employee(1, "Marek", "Vondra"),
            new Employee(2, "Pepa", "Omacka")
    );

    List<String> countryList = List.of(
            "DE","EN","FR"
    );


    @GetMapping()
    public String getNameOfEmployeeById(){
        Optional<Employee> findEmployee = findEmployeeById(1L);
        return this.createNameAndSurname(findEmployee);
    }

    @GetMapping("/{id}")
    public String findEmployeeByIdInPath(@PathVariable Long id){
        Optional<Employee> findEmployee = findEmployeeById(id);
        return this.createNameAndSurname(findEmployee);
    }

//    @GetMapping("/{id}")
//    public String findWithSecond(
//            @PathVariable(value = "id") Long emloyeId)
//    {
//        Optional<Employee> findEmployee = findEmployeeById(emloyeId);
//        return this.createNameAndSurname(findEmployee);
//    }

    @GetMapping("/{id}/{country}")
    public String getEmployeeByIdAndCoutnry(
            @PathVariable("id") Long employeeId,
            @PathVariable("country") String countryId
    ){
        Optional<Employee> findEmployee = this.findEmployeeById(employeeId);

        return String.format("Id uzivatele je %s a zije v %s",
                this.createNameAndSurname(findEmployee)
                ,countryId);
    }

    @GetMapping("/{id}/{country}/{state}")
    public void getEmployeeById(
            @PathVariable Map<String, String> pathVariables
    ){
        Long id = Long.valueOf(pathVariables.get("id"));
    }


    private Optional<Employee> findEmployeeById(Long id){
        return  employeeList
                .stream()
                .filter((a) -> a.getId() == id)
                .findFirst();
    }

    private String createNameAndSurname(Optional<Employee> employee){
        return employee.get().getName() + " " + employee.get().getSurname();
    }


}
