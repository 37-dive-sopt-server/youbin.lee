package org.sopt.ui;

import org.sopt.application.MemberService;
import org.sopt.application.dto.request.MemberCreateRequest;
import org.sopt.application.dto.response.MemberCreateResponse;
import org.sopt.application.dto.response.MemberFindResponse;
import org.sopt.application.dto.response.MembersGetResponse;
import org.sopt.common.validator.EmailValidator;
import org.sopt.common.validator.NameValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.sopt.common.SuccessMessage.*;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<SuccessResponse<MemberCreateResponse>> createMember(
            @RequestBody MemberCreateRequest request
    ) {
        NameValidator.validateName(request.name());
        EmailValidator.validateFormat(request.email());

        MemberCreateResponse response = memberService.join(request);

        return ResponseEntity.ok(SuccessResponse.of(SUCCESS_CREATE_MEMBER, response));
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<SuccessResponse<MemberFindResponse>> findMember(
            @PathVariable Long id
    ) {
        MemberFindResponse response = memberService.findById(id);

        return ResponseEntity.ok(SuccessResponse.of(SUCCESS_FIND_MEMBER, response));
    }

    @GetMapping("/members")
    public ResponseEntity<SuccessResponse<MembersGetResponse>> getAllMembers() {
        MembersGetResponse response = memberService.findAllMembers();

        return ResponseEntity.ok(SuccessResponse.of(SUCCESS_GET_MEMBERS, response));
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<SuccessResponse> deleteMemberById(
            @PathVariable Long id
    ) {
        memberService.deleteId(id);

        return ResponseEntity.ok(SuccessResponse.of(SUCCESS_DELETED_MEMBERS));
    }

}
