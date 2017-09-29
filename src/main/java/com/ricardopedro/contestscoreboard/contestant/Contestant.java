package com.ricardopedro.contestscoreboard.contestant;

import com.ricardopedro.contestscoreboard.judgment.Judgment;

import java.util.LinkedList;
import java.util.List;

public class Contestant {

    private Integer number;
    private Integer penalty;
    private List<Integer> solvedProblems;

    public Contestant() {
        this.number = 0;
        this.penalty = 0;
        this.solvedProblems = new LinkedList();
    }

    public void compute(Judgment judgment) {
        if (judgment == null || this.solvedProblems.contains(judgment.getProblem())) {
            return;
        }

        if ("c".equalsIgnoreCase(judgment.getStatus())) {
            this.penalty += judgment.getTime();
            this.solvedProblems.add(judgment.getProblem());
        } else if ("i".equalsIgnoreCase(judgment.getStatus())) {
            this.penalty += 20;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public List<Integer> getSolvedProblems() {
        return solvedProblems;
    }

    public void setSolvedProblems(List<Integer> solvedProblems) {
        this.solvedProblems = solvedProblems;
    }

    public int getQtdSolvedProblems() {
        return this.solvedProblems.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getNumber()).append(" ").append(getQtdSolvedProblems()).append(" ")
                .append(getPenalty()).append("\n");
        return stringBuilder.toString();
    }
}
