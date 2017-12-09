package com.system.mandatory2.repositories;

import com.system.mandatory2.domain.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by gerli on 18/11/2017.
 */
public interface CourseRepo extends CrudRepository<Course, Integer> {
    Collection<Course> findAllByEnglishName(String englishName);

}
