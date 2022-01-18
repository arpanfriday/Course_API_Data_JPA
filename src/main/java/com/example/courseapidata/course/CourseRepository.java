package com.example.courseapidata.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String>{
//    This is a special function which is not there in the CrudRepository
//    but if we write the function in such convention then JPA is intelligent enough to
//    know what it has to do.
//    public  List<Course> findByName(String name);
//    public  List<Course> findByDescription(String desc);

//----We use findByTopicId because
//    findBy is the phrase that are use for applying filters like this
//    Topic is the class
//    Id is the attribute of the Topic object
    public List<Course> findByTopicId(String topicId);
}
