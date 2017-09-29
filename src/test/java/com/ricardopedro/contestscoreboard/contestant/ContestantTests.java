package com.ricardopedro.contestscoreboard.contestant;

import com.ricardopedro.contestscoreboard.judgment.Judgment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContestantTests {

    private Contestant contestant;
    private Judgment judgment1, judgment2, judgment3;

    @Before
    public void setUp() {
        judgment1 = new Judgment(0, 1, 11, "I");
        judgment2 = new Judgment(0, 1, 22, "C");
        judgment3 = new Judgment(0, 1, 3, "R");
    }

    @Test
    public void computeJudgment1Test() {
        contestant = new Contestant();
        contestant.compute(judgment1);
        assertEquals(contestant.getNumber().intValue(), 0);
        assertEquals(contestant.getPenalty().intValue(), 20);
        assertEquals(contestant.getQtdSolvedProblems(), 0);
    }

    @Test
    public void computeJudgment2Test() {
        contestant = new Contestant();
        contestant.compute(judgment2);
        assertEquals(contestant.getNumber().intValue(), 0);
        assertEquals(contestant.getPenalty().intValue(), 22);
        assertEquals(contestant.getQtdSolvedProblems(), 1);
    }

    @Test
    public void computeJudgment3Test() {
        contestant = new Contestant();
        contestant.compute(judgment3);
        assertEquals(contestant.getNumber().intValue(), 0);
        assertEquals(contestant.getPenalty().intValue(), 0);
        assertEquals(contestant.getQtdSolvedProblems(), 0);
    }
}
