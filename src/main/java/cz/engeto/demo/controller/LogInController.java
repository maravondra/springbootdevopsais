package cz.engeto.demo.controller;

import cz.engeto.demo.controller.dto.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity makeLogIn(
        @RequestBody Login dataForLogin
    ){
        Optional<Login> findUserAccordingUsername =
                ldap
                .stream()
                .filter((oneElement) -> oneElement.getUsername().equals(dataForLogin.getUsername()))
                .findFirst();

        if(findUserAccordingUsername.isEmpty()){
            return new ResponseEntity(
                    "The user "+dataForLogin.getUsername() + " was not found",
                    HttpStatus.UNAUTHORIZED);
        }else {
            if (findUserAccordingUsername.get().getPassword().equals(dataForLogin.getPassword())){
                return new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity(
                        "The password for the user (" + dataForLogin.getUsername() + ") is not valid",
                        HttpStatus.UNAUTHORIZED);
            }
        }


    }


}
