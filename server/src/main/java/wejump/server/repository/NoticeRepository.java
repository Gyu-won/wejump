package wejump.server.repository;

import wejump.server.domain.notice.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    @Override
    ArrayList<Notice> findAll();

    Notice findByCourseId(Long courseId);

    ArrayList<Notice> findAllByCourseId(Long courseId);
}
