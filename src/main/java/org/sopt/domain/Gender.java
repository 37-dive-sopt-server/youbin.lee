package org.sopt.domain;

public enum Gender {
    MALE("남"),
    FEMALE("여");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender from(String input) {
        for (Gender g : values()) {
            if (g.gender.equalsIgnoreCase(input)) {
                return g;
            }
        }
        throw new IllegalArgumentException("⚠️ 올바르지 않은 성별 값입니다.");
    }
}
