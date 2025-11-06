package org.sopt.service.member;

import org.sopt.service.member.dto.request.MemberCreateRequest;
import org.sopt.service.member.dto.response.MemberCreateResponse;
import org.sopt.service.member.dto.response.MemberGetResponse;

import java.util.List;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberGetResponse findById(Long memberId);

    List<MemberGetResponse> findAllMembers();

    void deleteById(Long memberId);
}
