package com.system.mandatory2.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by gerli on 29/11/2017.
 */
@Entity
public class CourseRequest {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @ManyToOne
    private Account student;
    @OneToOne
    private Course course;
    private LocalDateTime localDateTime;


    public long getId(){
        return id;
    }

    public Account getStudent() {
        return student;
    }

    public void setStudent(Account student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

}
