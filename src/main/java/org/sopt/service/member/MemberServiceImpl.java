package org.sopt.service.member;

import lombok.RequiredArgsConstructor;
import org.sopt.domain.member.Member;
import org.sopt.global.execption.CustomException;
import org.sopt.global.message.ErrorMessage;
import org.sopt.repository.member.MemberRepository;
import org.sopt.service.member.dto.request.MemberCreateRequest;
import org.sopt.service.member.dto.response.MemberCreateResponse;
import org.sopt.service.member.dto.response.MemberGetResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberCreateResponse join(MemberCreateRequest request) {
        validateDuplicateEmail(request.email());
        validateMemberAge(request.birthDate());

        Member member = Member.create(
                request.name(),
                request.birthDate(),
                request.email(),
                request.gender()
        );

        memberRepository.save(member);

        return new MemberCreateResponse(member.getId());
    }

    @Override
    public MemberGetResponse findById(Long memberId) {
        Member member = findByIdOrThrow(memberId);

        return new MemberGetResponse(member.getId());
    }

    @Override
    public List<MemberGetResponse> findAllMembers() {
        List<Member> members = memberRepository.findAll();

        return members.stream()
                .map(member -> new MemberGetResponse(member.getId()))
                .toList();
    }

    @Override
    public void deleteById(Long memberId) {
        Member member = findByIdOrThrow(memberId);
        memberRepository.deleteById(member.getId());
    }

    private void validateDuplicateEmail(String email) {
        if (memberRepository.existsByEmail(email)) throw new CustomException(ErrorMessage.EMAIL_ALREADY_EXIST);
    }

    private void validateMemberAge(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        if (age < 20) throw new CustomException(ErrorMessage.AGE_IS_UNDERAGE);
    }

    private Member findByIdOrThrow(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomException(ErrorMessage.MEMBER_NOT_FOUND));
    }
}
