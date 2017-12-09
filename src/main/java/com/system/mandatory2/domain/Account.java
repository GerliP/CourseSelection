package com.system.mandatory2.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;


/**
 * Created by gerli on 26/11/2017.
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   //@Column(name = "account_id")
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String studyProgramme;
    private boolean active;
    private boolean isTeacher;
    private boolean isStudent;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Role role;
    @OneToMany(mappedBy = "student")
    private Collection<CourseRequest> courseRequest;

    @ManyToMany
    @JoinTable(
            name="account_course",
            joinColumns=@JoinColumn(name="account_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="course_id", referencedColumnName="id"))
    private List<Course> courseList;


public Account(){

}
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getisTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }
    @OneToOne
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList){
    this.courseList = courseList;
    }


    public String toString(){
        return firstName + " " + lastName;
    }
}
