package org.sopt.repository;

import org.sopt.domain.Member;

import java.util.*;

// todo: 인터페이스 추가하기
public class MemoryMemberRepository {

    private static final Map<Long, Member> store = new HashMap<>();

    public Member save(Member member) {

        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void deleteById(Long id) {
        store.remove(id);
    }

}
