package com.learn.practiceDV;

import com.learn.practiceDV.practiceEntity.Course;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BasicSpringBootApi {
public List<Course> getAllCourses(){
    return Arrays.asList(new Course(1, "java"), new Course(2, "spring"));
}
}
