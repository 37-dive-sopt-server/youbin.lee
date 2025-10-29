package org.sopt.application;

import org.sopt.application.dto.*;
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
    public MemberFindResponseDto findByIdOrThrow(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));

        return MemberFindResponseDto.from(member.getId());
    }

    @Override
    public MembersGetResponseDto findAllMembers() {
        List<Member> members = memberRepository.findAll();

        List<Long> ids = members.stream()
                .map(Member::getId)
                .toList();

        return MembersGetResponseDto.from(ids);
    }

    @Override
    public MemberDeleteResponseDto deleteId(Long memberId) {
        findByIdOrThrow(memberId);

        return MemberDeleteResponseDto.from(memberRepository.deleteById(memberId));
    }

}
