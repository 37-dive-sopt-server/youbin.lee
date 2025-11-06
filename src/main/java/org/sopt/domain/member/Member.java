package org.sopt.domain.member;

import jakarta.persistence.*;
import lombok.*;
import org.sopt.domain.article.Article;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "member")
    private List<Article> articles = new ArrayList<>();

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
