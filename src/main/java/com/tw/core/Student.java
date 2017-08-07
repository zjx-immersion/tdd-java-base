package com.tw.core;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by jxzhong on 2017/7/26.
 */
public class Student {

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setMathsScore(int mathsScore) {
        this.mathsScore = mathsScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public void setProgramScore(int programScore) {
        this.programScore = programScore;
    }

    private String name;
    @NotEmpty
    private String number;
    private int mathsScore;
    private int chineseScore;
    private int englishScore;
    private int programScore;

    public Student() {

    }

    public Student(String name, String number, int mathsScore, int chineseScore, int englishScore, int programScore) {

        this.name = name;
        this.number = number;
        this.mathsScore = mathsScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }

    public Student(String num) {
        this.number = num;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getMathsScore() {
        return mathsScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public int getProgramScore() {
        return programScore;
    }
}
