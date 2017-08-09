package com.tw.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by jxzhong on 2017/8/9.
 */
public class Grade {

    private Integer mathsScore;
    private Integer programScore;
    private Integer chineseScore;
    private Integer englishScore;
    private String stuNumber;

    public Grade(Grade grade) {
        this(grade.stuNumber, grade.mathsScore, grade.chineseScore, grade.englishScore, grade.programScore);
    }

    public Grade() {
    }

    public Grade(String stuNumber, Integer mathsScore, Integer chineseScore, Integer englishScore, Integer programScore) {
        this.stuNumber = stuNumber;
        this.mathsScore = mathsScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }

    public Integer getMathsScore() {
        return mathsScore;
    }

    public Integer getChineseScore() {
        return chineseScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public Integer getProgramScore() {
        return programScore;
    }

    public void setProgramScore(Integer programScore) {
        this.programScore = programScore;
    }

    public void setMathsScore(Integer mathsScore) {
        this.mathsScore = mathsScore;
    }

    public void setChineseScore(Integer chineseScore) {
        this.chineseScore = chineseScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    @JsonIgnore
    public String getStuNumber() {
        return stuNumber;
    }
}
