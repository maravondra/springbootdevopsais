package cz.engeto.demo.controller;

import cz.engeto.demo.controller.dto.Login;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3/")
public class LogInController {

    List<Login> ldap = List.of(
            new Login("pepa", "123"),
            new Login("david", "a1a2")
    );

    @PostMapping("login")
    public boolean makeLogIn(
        @RequestBody Login dataForLogin
    ){
        Optional<Login> findUserAccordingUsername =
                ldap
                .stream()
                .filter((oneElement) -> oneElement.getUsername().equals(dataForLogin.getUsername()))
                .findFirst();

        if(findUserAccordingUsername.isEmpty()){
            return false;
        }else {
            return  (findUserAccordingUsername.get().getPassword().equals(dataForLogin.getPassword()));
        }


    }


}
