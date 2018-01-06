package com.bdqn.entity;

/**
 * Created by 佳 on 2018/1/5.
 */
public class Score3 {
    /**
     FieldTypeComment
     idint(11) NOT NULL成绩id
     student_idint(11) NULL学生id
     course_idint(11) NULL课程id
     scoredouble NULL成绩
     */
    private Integer id;
    private Double score;
    private Student3 student3;
    private Course3 course3;

    @Override
    public String toString() {
        return "Score3{" +
                "id=" + id +
                ", score=" + score +
                ", student3=" + student3 +
                ", course3=" + course3 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student3 getStudent3() {
        return student3;
    }

    public void setStudent3(Student3 student3) {
        this.student3 = student3;
    }

    public Course3 getCourse3() {
        return course3;
    }

    public void setCourse3(Course3 course3) {
        this.course3 = course3;
    }
}
