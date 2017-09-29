package com.ricardopedro.contestscoreboard.judgingqueue;

import com.ricardopedro.contestscoreboard.judgment.Judgment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JudgingQueue {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Long id;
    private List<Judgment> judgments;

    public JudgingQueue() {
        this.judgments = new LinkedList();
    }

    public JudgingQueue(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

        this.id = getNumberCase(input);
        this.judgments = new LinkedList();
        this.judgments.addAll(getJudgments(input));
    }

    private Long getNumberCase(String input) {
        Long numberCase = null;

        try {
            Scanner scanner = new Scanner(input);
            numberCase = scanner.nextLong();
            scanner.close();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return numberCase;
    }

    private List<Judgment> getJudgments(String input) {
        List<Judgment> judgments = new LinkedList();
        Scanner scanner = new Scanner(input);
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            try {
                Integer contestantId = scanner.nextInt();
                Integer problemNumber = scanner.nextInt();
                Integer time = scanner.nextInt();
                String status = scanner.next();

                Judgment judgment = new Judgment(contestantId, problemNumber, time, status);

                if (!judgment.isEmpty()) {
                    judgments.add(judgment);
                }

                scanner.nextLine();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        scanner.close();

        return judgments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Judgment> getJudgments() {
        return judgments;
    }

    public void setJudgments(List<Judgment> judgments) {
        this.judgments = judgments;
    }
}
