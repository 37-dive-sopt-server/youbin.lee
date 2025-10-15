package org.sopt.controller;

import org.sopt.domain.Member;
import org.sopt.service.MemberService;

import java.time.LocalDate;
import java.util.List;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public Long createMember(String name, LocalDate birthDate, String email, String gender) {
        return memberService.join(name, birthDate, email, gender);
    }

    public Member findMemberByIdOrThrow(Long id) {
        return memberService.findByIdOrThrow(id);
    }

    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }

    public void deleteMemberById(Long id) {
        memberService.deleteId(id);
    }

}
