package com.system.mandatory2.domain;

import com.system.mandatory2.repositories.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by gerli on 16/11/2017.
 */
@Entity
@Table(name = "course")
public class Course {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
   // @Column(name = "course_id")
    private int id;
    private String danishName;
    private String englishName;
    private String studyProgramme;
    private int ects;
    private String type;
    private String language;
    private int minNumber;
    private int expNumber;
    private int maxNumber;
    private String prereq;
    private String outcome;
    private String content;
    private String activities;
    private String exam;
    @ManyToMany(mappedBy = "courseList", targetEntity=Account.class)
    private List<Account> accounts;

    public Course(){

    }
    public Course(int id, String danishName, String englishName, String studyProgramme, int ects,
                  String type, String language, int minNumber, int expNumber,
                  int maxNumber, String prereq, String outcome, String content, String activities, String exam, List<Account> accounts) {
        this.danishName = danishName;
        this.englishName = englishName;
        this.type = type;
        this.ects = ects;
        this.studyProgramme = studyProgramme;
        this.language = language;
        this.minNumber = minNumber;
        this.expNumber = expNumber;
        this.maxNumber = maxNumber;
        this.prereq = prereq;
        this.outcome = outcome;
        this.content = content;
        this.accounts = accounts;
        this.activities = activities;
        this.exam = exam;
    }

    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getDanishName() {
        return danishName;
    }

    public void setDanishName(String courseNameD) {
        this.danishName = danishName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String courseNameE) {
        this.englishName = englishName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getStudyProgramme() {
        return studyProgramme;
    }

    public void setStudyProgramme(String studyProgramme) {
        this.studyProgramme = studyProgramme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public int getExpNumber() {
        return expNumber;
    }

    public void setExpNumber(int expNumber) {
        this.expNumber = expNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getPrereq() {
        return prereq;
    }

    public void setPrereq(String prereq) {
        this.prereq = prereq;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }


    public int getId() {
        return id;
    }

    public void setActivities(String activities){
        this.activities = activities;
}
    public String getActivities(){
        return activities;
    }
    public String getExam(){
        return exam;
    }
    public void setExam(String exam){
        this.exam = exam;
    }

    public List<Account> getAccounts() {


        return accounts;
    }

    public void setAccounst(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isTeacher(Account teacher) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).getRole().equals(teacher.getRole())) {
                return true;
            }
        }
        return false;
    }
}





