package org.sopt.presentation.member;

import lombok.RequiredArgsConstructor;
import org.sopt.common.BaseApiResponse;
import org.sopt.common.message.SuccessMessage;
import org.sopt.domain.member.validator.EmailValidator;
import org.sopt.domain.member.validator.NameValidator;
import org.sopt.service.member.MemberService;
import org.sopt.service.member.dto.request.MemberCreateRequest;
import org.sopt.service.member.dto.response.MemberCreateResponse;
import org.sopt.service.member.dto.response.MemberGetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<BaseApiResponse<MemberCreateResponse>> createMember(
            @RequestBody MemberCreateRequest request
    ) {
        NameValidator.validateName(request.name());
        EmailValidator.validateFormat(request.email());

        MemberCreateResponse response = memberService.join(request);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_CREATE_MEMBER, response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseApiResponse<MemberGetResponse>> getMember(
            @PathVariable Long id
    ) {
        MemberGetResponse response = memberService.findById(id);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_MEMBER, response));
    }

    @GetMapping
    public ResponseEntity<BaseApiResponse<List<MemberGetResponse>>> getMemberList() {
        List<MemberGetResponse> response = memberService.findAllMembers();

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_GET_MEMBER_LIST, response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseApiResponse> deleteMemberById(
            @PathVariable Long id
    ) {
        memberService.deleteById(id);

        return ResponseEntity.ok(BaseApiResponse.of(SuccessMessage.SUCCESS_DELETED_MEMBERS));
    }

}
