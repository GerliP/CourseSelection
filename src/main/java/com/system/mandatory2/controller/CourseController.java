package com.system.mandatory2.controller;

import com.system.mandatory2.domain.Account;
import com.system.mandatory2.repositories.AccountRepo;
import com.system.mandatory2.repositories.CourseRepo;
import com.system.mandatory2.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gerli on 19/11/2017.
 */
@Controller
public class CourseController {

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    CourseRepo courseRepo;

    @GetMapping("/addCourse")
    public ModelAndView teacherList() {
        ModelAndView mv = new ModelAndView("addCourse");
        mv.getModel().put("accountList", accountRepo.findAll());
        return mv;
    }

    @PostMapping("/course/save")
    public ModelAndView saveAndShow(
            @RequestParam(name = "id", defaultValue = "-1")
                    int id,
            @RequestParam(name = "danishName", defaultValue = "NO_NAME")
                    String danishName,
            @RequestParam(name = "name", defaultValue = "NO_NAME")
                    String englishName,
            @RequestParam(name = "studyProgramme", defaultValue = "NO_STUDY_PROGRAMME")
                    String studyProgramme,
            @RequestParam(name = "ects", defaultValue = "NO_ECTS")
                    int ects,
            @RequestParam(name = "type", defaultValue = "NOT_MANDATORY")
                    String type,
            @RequestParam(name = "language", defaultValue = "NO_LANGUAGE")
                    String language,
            @RequestParam(name = "minStudents", defaultValue = "NOT_STATED")
                    int minStudents,
            @RequestParam(name = "expStudents", defaultValue = "NOT_STATED")
                    int expStudents,
            @RequestParam(name = "maxStudents", defaultValue = "NOT_STATED")
                    int maxStudents,
            @RequestParam(name = "prereq", defaultValue = "NO_PREREQUISITES")
                    String prereq,
            @RequestParam(name = "outcome", defaultValue = "NO_OUTCOME")
                    String outcome,
            @RequestParam(name = "content", defaultValue = "NO_CONTENT")
                    String content,
            @RequestParam(name = "activities", defaultValue = "NO_LEARNING_ACTIVITIES")
                    String activities,
            @RequestParam(name = "exam", defaultValue = "NO_EXAM_FORM")
                    String exam,
            @RequestParam(name = "teachers", defaultValue = "NO_TEACHER")
                    Integer[] teachers
    ) {
        final Iterable<Account> teacherIterable = accountRepo.findAll();
        final List<Account> teacherCollection = new ArrayList<>(teachers.length);
        teacherIterable.forEach(teacher -> teacherCollection.add(teacher));

        Course c = new Course(id, danishName, englishName, studyProgramme, ects, type, language, minStudents,
                expStudents, maxStudents, prereq, outcome, content, activities, exam, teacherCollection);
        courseRepo.save(c);

        teacherIterable.forEach(account -> account.getCourseList().add(c));
        accountRepo.save(teacherIterable);

        ModelAndView mv = new ModelAndView("teacher");
        mv.getModel().put("courseList", courseRepo.findAll());
        mv.getModel().put("course", c);

        return mv;
    }

    @GetMapping("/course/edit")
    public ModelAndView edit(@RequestParam(name="id", defaultValue = "0")int id){
        ModelAndView mv = new ModelAndView("edit");
        mv.getModel().put("course", courseRepo.findOne(id));
        mv.getModel().put("accountList", accountRepo.findAll());
        return mv;
    }

    @GetMapping("/course/more")
    public ModelAndView more(@RequestParam(name="id", defaultValue = "0")int id){
        ModelAndView mv = new ModelAndView("courseInfo");

        mv.getModel().put("course", courseRepo.findOne(id));
        return mv;
    }
    @GetMapping("/course/search")
    public ModelAndView search(@RequestParam(name ="srch-term") String englishName){
            ModelAndView mv = new ModelAndView("searchResult");
            mv.getModel().put("courseList", courseRepo.findAllByEnglishName(englishName));
            return mv;
    }
    @GetMapping("/student")
    public ModelAndView studentPage(){
        ModelAndView mv = new ModelAndView("student");
        mv.getModel().put("courseList", courseRepo.findAll());
        return mv;

    }

    @GetMapping("/teacher")
    public ModelAndView teacherPage() {
        ModelAndView mv = new ModelAndView("teacher");
        mv.getModel().put("courseList", courseRepo.findAll());
        return mv;
    }
   /* @ModelAttribute("teacherList")
    public ModelAndView teacherList(){
            ModelAndView mv = new ModelAndView("addCourse");
            mv.getModel().put("teacherList", teacherRepo.findAll());
            return mv;
    }
    */

}