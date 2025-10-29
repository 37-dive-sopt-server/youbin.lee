package org.sopt.application;

import org.sopt.application.dto.MemberCreateRequest;
import org.sopt.application.dto.MemberCreateResponse;
import org.sopt.common.execption.CustomException;
import org.sopt.common.execption.enums.ErrorMessage;
import org.sopt.domain.Gender;
import org.sopt.domain.Member;
import org.sopt.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public MemberCreateResponse join(MemberCreateRequest request) {
        validateDuplicateEmail(request.email());
        validateMemberAge(request.birthDate());

        Long id = memberRepository.createId();
        Member member = new Member(id, request.name(), request.birthDate(), request.email(), Gender.from(request.gender()));
        memberRepository.save(member);

        return MemberCreateResponse.from(member.getId());
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
    public boolean deleteId(Long memberId) {
        findByIdOrThrow(memberId);
        return memberRepository.deleteById(memberId);
    }

}
