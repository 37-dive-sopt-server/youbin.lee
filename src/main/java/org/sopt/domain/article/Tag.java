package org.sopt.domain.article;

public enum Tag {
    CS("computer science"),
    DB("data base"),
    SPRING("spring"),
    ETC("etc");

    private final String tag;

    Tag(String tag) {
        this.tag = tag;
    }
}
