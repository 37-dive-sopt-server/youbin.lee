package org.sopt;

import org.sopt.ui.MemberController;
import org.sopt.repository.MemberRepository;
import org.sopt.repository.MemoryMemberRepository;
import org.sopt.application.MemberService;
import org.sopt.application.MemberServiceImpl;

public class AppConfig {

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        return new MemberServiceImpl();
    }

    public MemberController memberController() {
        return new MemberController();
    }
}