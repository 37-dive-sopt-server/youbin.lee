package org.sopt.repository;

import org.sopt.domain.Member;

import java.util.*;

// todo: 인터페이스 추가하기, Spring data JPA
public class MemoryMemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();

    public Member save(Member member) {

        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
