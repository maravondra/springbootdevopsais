package cz.engeto.demo.controller;

import cz.engeto.demo.controller.dto.Login;
import cz.engeto.demo.controller.dto.LoginResponse;
import cz.engeto.demo.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v3/")
public class LogInController {

    @Autowired
    private LogInService logInService;

    @PostMapping("login")
    public ResponseEntity makeLogIn(
        @RequestBody Login dataForLogin
    ){
        return logInService.makeAuthentication(dataForLogin);
    }

}
