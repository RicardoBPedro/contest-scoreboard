package com.ricardopedro.contestscoreboard.judgingqueue;

import com.ricardopedro.contestscoreboard.contestant.Contestant;

import java.util.List;

public interface JudgingQueueService {

    JudgingQueue parse(String judgingQueue);

    List<Contestant> getWinners(JudgingQueue judgingQueue);
}
