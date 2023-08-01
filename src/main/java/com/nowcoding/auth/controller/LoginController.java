package com.nowcoding.auth.controller;

import com.nowcoding.auth.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Login Controller")
@RequestMapping("/api")
public class LoginController {

    private final MemberService memberService;

    public LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Operation(summary = "테스트 API", description = "스웨거 적용 테스트 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Server Error")
    })
    @GetMapping("/test")
    public String test(
    ) {
        return "Hello World!";
    }


    @PostMapping("/insert/member")
    public String insertMember(){
        memberService.insertMember();

        return "success";
    }

}
