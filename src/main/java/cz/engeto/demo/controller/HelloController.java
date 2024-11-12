package cz.engeto.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class HelloController {

    @GetMapping("hello")
    public String sayHello(){
        return "Hello everybody from controller";
    }

    @PostMapping("hello")
    public String createHello(){
        // workflow
        return "The object for hello was created";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "hello")
    public String updateHello(){
        // workflow
        return "The object for hello was updated";
    }

    @RequestMapping(method = RequestMethod.GET, value = "helloDE")
    public String sayHelloInGerman(){
        return "Begruessen vom Kontroller";
    }


}
