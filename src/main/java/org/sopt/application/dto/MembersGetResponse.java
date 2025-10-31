package org.sopt.application.dto;

import java.util.List;

public record MembersGetResponse(
        List<Long> id
) {
    public static MembersGetResponse from(
            List<Long> id
    ) {
        return new MembersGetResponse(id);
    }
}
