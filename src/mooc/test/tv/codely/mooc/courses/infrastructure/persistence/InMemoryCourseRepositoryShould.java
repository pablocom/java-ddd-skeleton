package tv.codely.mooc.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CoursesModuleInfrastructureTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseIdCreator;
import tv.codely.mooc.courses.domain.CourseMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryCourseRepositoryShould extends CoursesModuleInfrastructureTestCase {
    @Test
    void return_an_existing_course() {
        Course course = CourseMother.random();

        inMemoryCourseRepository.save(course);

        assertEquals(Optional.of(course), inMemoryCourseRepository.search(course.id()));
    }

    @Test
    void does_not_return_a_non_existing_course() {
        assertFalse(inMemoryCourseRepository.search(CourseIdCreator.random()).isPresent());
    }
}
