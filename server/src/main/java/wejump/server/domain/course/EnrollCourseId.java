package wejump.server.domain.course;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EnrollCourseId implements Serializable {
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "course_id")
    private Long courseId;
}