package com.example.Library.Controller;

import com.example.Library.DTO.MemberReqDTO;
import com.example.Library.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @PostMapping("/addMembers")
    public ResponseEntity<?> addMember(@RequestBody MemberReqDTO memberReqDTO){
        String msg = memberService.addMember(memberReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(msg);
    }
}
