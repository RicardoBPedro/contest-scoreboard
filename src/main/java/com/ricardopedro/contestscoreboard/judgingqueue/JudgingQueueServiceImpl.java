package com.ricardopedro.contestscoreboard.judgingqueue;

import com.ricardopedro.contestscoreboard.contestant.Contestant;
import com.ricardopedro.contestscoreboard.judgment.Judgment;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JudgingQueueServiceImpl implements JudgingQueueService {

    @Override
    public JudgingQueue parse(String judgingQueue) {
        return new JudgingQueue(judgingQueue);
    }

    @Override
    public List<Contestant> getWinners(JudgingQueue judgingQueue) {
        List<Contestant> winners = new LinkedList<>();
        Map<Integer, Contestant> contestantMap = new HashMap();

         /*algorithm that use a map as an helper
            to don't duplicate contestant on winner list
            and keep the order of judgments submission*/
        for (Judgment judgment : judgingQueue.getJudgments()) {

            Integer contestantNumber = judgment.getContestant();
            Contestant contestant = contestantMap.get(contestantNumber);

            if (contestant == null) {
                contestant = new Contestant();
                contestant.setNumber(contestantNumber);
                contestantMap.put(contestant.getNumber(), contestant);
                winners.add(contestant);
            }

            contestant.compute(judgment);
        }

        winners.sort(Comparator.comparing(Contestant::getQtdSolvedProblems)
                .thenComparing(Contestant::getPenalty).reversed());

        return winners;
    }
}
