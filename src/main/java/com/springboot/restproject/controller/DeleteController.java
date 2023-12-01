package com.springboot.restproject.controller;

import com.springboot.restproject.dto.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    @DeleteMapping("/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail: "+email;
    }
}
