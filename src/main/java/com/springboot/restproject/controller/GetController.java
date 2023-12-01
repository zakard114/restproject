package com.springboot.restproject.controller;

import com.springboot.restproject.dto.MemberDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Tag(name = "Template", description = "템플릿 API Document")
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam(@RequestParam Map<String, String> param){

        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map-> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(MemberDto memberDto){
        return memberDto.toString();
    }
}
