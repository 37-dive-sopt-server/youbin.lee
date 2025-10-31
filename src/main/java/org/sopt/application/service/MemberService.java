package org.sopt.application.service;

import org.sopt.application.dto.request.MemberCreateRequest;
import org.sopt.application.dto.response.MemberCreateResponse;
import org.sopt.application.dto.response.MemberFindResponse;
import org.sopt.application.dto.response.MembersGetResponse;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberFindResponse findById(Long memberId);

    MembersGetResponse findAllMembers();

    void deleteId(Long memberId);
}
