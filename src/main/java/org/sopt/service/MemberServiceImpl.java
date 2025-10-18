package org.sopt.service;

import org.sopt.common.execption.CustomException;
import org.sopt.common.execption.enums.ErrorMessage;
import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.repository.MemberRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Long join(String name, LocalDate birthDate, String email, String gender) {
        validateDuplicateEmail(email);
        validateMemberAge(birthDate);

        Long id = memberRepository.createId();
        Member member = new Member(id, name, birthDate, email, Gender.from(gender));
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateEmail(String email) {
        memberRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new CustomException(ErrorMessage.EMAIL_ALREADY_EXIST);
                });
    }

    private void validateMemberAge(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        if (age < 20) {
            throw new CustomException(ErrorMessage.AGE_IS_UNDERAGE);
        }
    }

    @Override
    public Member findByIdOrThrow(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void deleteId(Long memberId) {
        findByIdOrThrow(memberId);
        memberRepository.deleteById(memberId);
    }

}
