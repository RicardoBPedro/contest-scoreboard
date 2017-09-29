package com.ricardopedro.contestscoreboard.judgment;

public class Judgment {

    private Integer contestant;
    private Integer problem;
    private Integer time;
    private String status;

    public Judgment() {
        //constructor
    }

    public Judgment(Integer contestant, Integer problem, Integer time, String status) {
        if (contestant == null || problem == null || time == null || status == null || status.isEmpty()) {
            return;
        }

        this.contestant = contestant;
        this.problem = problem;
        this.time = time;
        this.status = status;
    }

    public Boolean isEmpty() {

        return this.contestant == null && this.problem == null && time == null && status == null || status.isEmpty();
    }

    public Integer getContestant() {
        return contestant;
    }

    public void setContestant(Integer contestant) {
        this.contestant = contestant;
    }

    public Integer getProblem() {
        return problem;
    }

    public void setProblem(Integer problem) {
        this.problem = problem;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
