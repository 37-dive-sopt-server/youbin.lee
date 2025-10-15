package org.sopt;

import org.sopt.common.execption.CustomException;
import org.sopt.controller.MemberController;
import org.sopt.domain.Member;
import org.sopt.repository.FileMemberRepository;
import org.sopt.repository.MemberRepository;
import org.sopt.service.MemberService;
import org.sopt.service.MemberServiceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MemberRepository memberRepository = new FileMemberRepository();
        MemberService memberService = new MemberServiceImpl(memberRepository);
        MemberController memberController = new MemberController(memberService);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printDefaultMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("등록할 회원 이름을 입력하세요: ");
                        String name = scanner.nextLine();

                        System.out.print("등록할 회원 생년월일을 입력해주세요(YYYY-MM-DD): ");
                        LocalDate birthDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

                        System.out.print("등록할 회원 이메일을 입력해주세요: ");
                        String email = scanner.nextLine();

                        System.out.print("등록할 회원 성별을 입력해주세요(남/여): ");
                        String gender = scanner.nextLine();

                        Long createdId = memberController.createMember(name, birthDate, email, gender);

                        System.out.println("✅ 회원 등록 완료 (ID: " + createdId + ")");
                        break;
                    case "2":
                        try {
                            System.out.print("조회할 회원 ID를 입력하세요: ");
                            Long id = Long.parseLong(scanner.nextLine());
                            Member foundMember = memberController.findMemberByIdOrThrow(id);

                            System.out.println("✅ 조회된 회원: ID=" + foundMember.getId() + ", 이름=" + foundMember.getName());
                        } catch (NumberFormatException e) {
                            System.out.println("❌ 유효하지 않은 ID 형식입니다. 숫자를 입력해주세요.");
                        }
                        break;
                    case "3":
                        List<Member> allMembers = memberController.getAllMembers();
                        if (allMembers.isEmpty()) {
                            System.out.println("ℹ️ 등록된 회원이 없습니다.");
                        } else {
                            System.out.println("--- 📋 전체 회원 목록 📋 ---");
                            for (Member member : allMembers) {
                                System.out.println("👤 ID=" + member.getId() + ", 이름=" + member.getName());
                            }
                            System.out.println("--------------------------");
                        }
                        break;
                    case "4":
                        System.out.print("삭제할 회원 ID를 입력하세요: ");
                        Long id = Long.parseLong(scanner.nextLine());

                        memberController.findMemberByIdOrThrow(id);

                        memberController.deleteMemberById(id);
                        break;
                    case "5":
                        System.out.println("👋 서비스를 종료합니다. 안녕히 계세요!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("🚫 잘못된 메뉴 선택입니다. 다시 시도해주세요.");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printDefaultMenu() {
        System.out.println("\n✨ --- DIVE SOPT 회원 관리 서비스 --- ✨");
        System.out.println("---------------------------------");
        System.out.println("1️⃣. 회원 등록 ➕");
        System.out.println("2️⃣. ID로 회원 조회 🔍");
        System.out.println("3️⃣. 전체 회원 조회 📋");
        System.out.println("4️⃣. 회원 삭제 🗑️");
        System.out.println("5️⃣. 종료 🚪");
        System.out.println("---------------------------------");
        System.out.print("메뉴를 선택하세요: ");
    }
}
