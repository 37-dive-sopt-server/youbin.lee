package org.sopt.application;

import org.sopt.application.dto.*;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberFindResponse findById(Long memberId);

    MembersGetResponse findAllMembers();

    void deleteId(Long memberId);
}
