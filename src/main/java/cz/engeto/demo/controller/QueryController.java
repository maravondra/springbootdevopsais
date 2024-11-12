package cz.engeto.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v2/")
public class QueryController {

    List<Integer> price = List.of(1,8,9,5,6,3);

    @GetMapping("hello")
    public String sayHelloWithNameFromQuery(
            @RequestParam String name
    ){
        return "Ahoj " + name + " jak se mas?";
    }

    @GetMapping("hello2")
    public String sayHelloWithNameFromQueryButDifferentText(
            @RequestParam(name = "id") String usernameOfClient
    ){
        return "Ahoj " + usernameOfClient + " jak se mas ?";
    }

    @GetMapping("price")
    public int findMinOrMax(
            @RequestParam(value = "type", required = false, defaultValue = "max") String typeOfFinding
    ) {
        if(typeOfFinding.equals("min")){
            return Collections.min(price);
        }else {
            return Collections.max(price);
        }
    }





}
