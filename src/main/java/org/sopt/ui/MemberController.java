package org.sopt.ui;

import org.sopt.application.MemberService;
import org.sopt.application.dto.MemberCreateRequest;
import org.sopt.common.validator.EmailValidator;
import org.sopt.common.validator.NameValidator;
import org.sopt.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/users")
    public Long createMember(
            @RequestBody MemberCreateRequest request
    ) {
        NameValidator.validateName(request.name());
        EmailValidator.validateFormat(request.email());

        return memberService.join(request);
    }

    @GetMapping("/users/{id}")
    public Member findMember(
            @PathVariable Long id
    ) {
        return memberService.findByIdOrThrow(id);
    }

    @GetMapping("/users/all")
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    public boolean deleteMemberById(Long id) {
        return memberService.deleteId(id);
    }

}
