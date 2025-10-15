package org.sopt.repository;

import org.sopt.common.execption.CustomException;
import org.sopt.common.execption.enums.ErrorMessage;
import org.sopt.domain.Gender;
import org.sopt.domain.Member;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_DIR = "members.csv";
    private final Map<Long, Member> store = new HashMap<>();
    private long maxId = 0L;

    public FileMemberRepository() {
        loadFileToStore();
    }

    private void loadFileToStore() {
        File file = new File(FILE_DIR);

        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Member member = new Member(
                        Long.parseLong(data[0]),
                        data[1],
                        LocalDate.parse(data[2]),
                        data[3],
                        Gender.valueOf(data[4])
                );
                store.put(member.getId(), member);
                maxId = Math.max(maxId, member.getId());
            }
        } catch (IOException e) {
            throw new CustomException(ErrorMessage.FILE_LOADING_FAILED);
        }
    }

    @Override
    public Member save(Member member) {
        store.put(member.getId(), member);
        saveStoreToFile();
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
        saveStoreToFile();
    }

    private void saveStoreToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_DIR))) {
            for (Member member : store.values()) {
                String line = String.join(",",
                        member.getId().toString(),
                        member.getName(),
                        member.getBirthDate().toString(),
                        member.getEmail(),
                        member.getGender().name()
                );
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new CustomException(ErrorMessage.FILE_SAVE_FAILED);
        }
    }
}
