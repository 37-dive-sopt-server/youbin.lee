package org.sopt.controller;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.service.MemberService;
import org.sopt.service.MemberServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MemberController {

    private MemberService memberService = new MemberServiceImpl();

    public Long createMember(String name, LocalDate birthDate, String email, Gender gender) {
        return memberService.join(name, birthDate, email, gender);
    }

    public Optional<Member> findMemberById(Long id) {
        return memberService.findOne(id);
    }

    public List<Member> getAllMembers() {
        return memberService.findAllMembers();
    }
}
