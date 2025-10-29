package org.sopt.application;

import org.sopt.application.dto.*;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberFindResponseDto findById(Long memberId);

    MembersGetResponseDto findAllMembers();

    void deleteId(Long memberId);
}
