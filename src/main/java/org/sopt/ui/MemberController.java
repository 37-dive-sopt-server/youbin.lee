package org.sopt.ui;

import org.sopt.application.MemberService;
import org.sopt.application.dto.MemberCreateRequest;
import org.sopt.application.dto.MemberCreateResponse;
import org.sopt.application.dto.MemberFindResponseDto;
import org.sopt.common.validator.EmailValidator;
import org.sopt.common.validator.NameValidator;
import org.sopt.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.sopt.common.success.enums.SuccessMessage.SUCCESS_CREATE_MEMBER;
import static org.sopt.common.success.enums.SuccessMessage.SUCCESS_FIND_MEMBER;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/users")
    public ResponseEntity<SuccessResponse<MemberCreateResponse>> createMember(
            @RequestBody MemberCreateRequest request
    ) {
        NameValidator.validateName(request.name());
        EmailValidator.validateFormat(request.email());

        MemberCreateResponse response = memberService.join(request);

        return ResponseEntity.ok(SuccessResponse.of(SUCCESS_CREATE_MEMBER, response));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<SuccessResponse<MemberFindResponseDto>> findMember(
            @PathVariable Long id
    ) {
        MemberFindResponseDto response = memberService.findByIdOrThrow(id);

        return ResponseEntity.ok(SuccessResponse.of(SUCCESS_FIND_MEMBER, response));
    }

    @GetMapping("/users/all")
    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    @DeleteMapping("/users/{id}")
    public boolean deleteMemberById(
            @PathVariable Long id
    ) {
        return memberService.deleteId(id);
    }

}
