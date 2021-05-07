package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("spring", "Spring Framework", "Spring Framework Description"),
            new Course("java", "Core JAva", "JAva Description"),
            new Course("Javascript", "Spring Gagz", "Spring JAvaScript Description")));

    public List<Course> getAllCourses(String topicId) {

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    public void addCourse(Course course) {

        courseRepository.save(course);
    }

    public void updateCourse(Course course) {
//        for (int i = 0; i < topics.size(); i++) {
//            Topic t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);

    }
}
