package com.booleanuk.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date courseStartDate;
    private String courseTitle;
    private String avgGrade;

    public Student(String firstName, String lastName, Date dob, Date courseStartDate, String courseTitle, String avgGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.courseStartDate = courseStartDate;
        this.courseTitle = courseTitle;
        this.avgGrade = avgGrade;
    }

    public void update (String firstName, String lastName, Date dob, Date courseStartDate, String courseTitle, String avgGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.courseStartDate = courseStartDate;
        this.courseTitle = courseTitle;
        this.avgGrade = avgGrade;
    }

    public boolean isInValid() {
        return (StringUtils.isBlank(firstName)
                || StringUtils.isBlank(lastName)
                || dob == null
                || courseStartDate == null
                || StringUtils.isBlank(courseTitle)
                || StringUtils.isBlank(avgGrade));
    }
}
