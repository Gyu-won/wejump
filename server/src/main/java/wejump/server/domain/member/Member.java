package wejump.server.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import wejump.server.domain.assignment.Submit;
import wejump.server.domain.course.EnrollCourse;
import wejump.server.domain.lesson.Attend;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@DynamicUpdate
@Entity
@Getter
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = true, unique = true)
    private String nickname;

    @Column(name = "profile_image", nullable = true)
    private String image;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EnrollCourse> enrolledCourses = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Submit> submits;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attend> attends;

    @Builder
    public Member(Long id, String name, String email, String nickname, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.image = image;
    }

    public Member update(String name, String email) {
        this.name = name;
        this.email = email;
        return this;
    }
}