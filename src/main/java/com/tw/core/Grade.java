package com.tw.core;

/**
 * Created by jxzhong on 2017/8/9.
 */
public class Grade {

    private Integer mathsScore;
    private Integer programScore;
    private Integer chineseScore;
    private Integer englishScore;

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
}
