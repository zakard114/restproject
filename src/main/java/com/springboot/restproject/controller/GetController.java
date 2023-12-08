package com.springboot.restproject.controller;

import com.springboot.restproject.data.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

//@Tag(name = "Template", description = "템플릿 API Document")
@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable("variable") String var){
        LOGGER.info("Value received through @PathVariable : {}", var);
        return var;
    }

//    @GetMapping(value = "/request1")
//    public String getRequestParam(@RequestParam Map<String, String> param){
//        StringBuilder sb = new StringBuilder();
//
//        param.entrySet().forEach(map-> {
//            sb.append(map.getKey() + " : " + map.getValue() + "\n");
//        });
//
//        return sb.toString();
//    }

    @Operation(summary = "GET Method example", description = "@GET Method using @RequestParam")
    @GetMapping("/request1")
    public String getRequestParam1(@Parameter(description = "name", required = true) @RequestParam String name,
                                   @Parameter(description = "email", required = true) @RequestParam String email,
                                   @Parameter(description = "organization", required = true) @RequestParam String organization){

        return name + " " + email + " " + organization;
    }
    // Relevant sources:
    // https://springdoc.org/
    // https://dev-youngjun.tistory.com/258,
    // https://oingdaddy.tistory.com/272
    // https://stackoverflow.com/questions/67297184/parameterrequired-false-not-working-in-swagger-open-api-v3

    @GetMapping(value = "/request2")
    public String getRequestParam2(MemberDto memberDto){
        return memberDto.toString();
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        LOGGER.info("'getHello' method called");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        LOGGER.info("'getName' method called");
        return "Heeju";
    }
}
