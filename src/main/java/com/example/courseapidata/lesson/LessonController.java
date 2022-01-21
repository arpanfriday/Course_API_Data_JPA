package com.example.courseapidata.lesson;

import com.example.courseapidata.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLesson(@PathVariable String courseId, @PathVariable String topicId) {
        return lessonService.getAllLessons(courseId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public Optional<Lesson> getLesson(@PathVariable String courseId, @PathVariable String lessonId, @PathVariable String topicId) {
        return lessonService.getLesson(lessonId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@PathVariable String courseId, @PathVariable String topicId, @RequestBody Lesson lesson) {
        Course course = new Course(courseId, "", "", topicId);
        lesson.setCourse(course);
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void updateLesson(@PathVariable String courseId, @PathVariable String lessonId, @PathVariable String topicId, @RequestBody Lesson lesson) {
        Course course = new Course(courseId, "", "", topicId);
        lesson.setCourse(course);
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable String courseId, @PathVariable String topicId, @PathVariable String lessonId) {
        lessonService.deleteLesson(lessonId);
    }
}
