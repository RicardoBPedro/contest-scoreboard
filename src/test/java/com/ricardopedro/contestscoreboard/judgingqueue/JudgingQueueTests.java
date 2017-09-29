package com.ricardopedro.contestscoreboard.judgingqueue;

import com.ricardopedro.contestscoreboard.judgment.Judgment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JudgingQueueTests {

    private StringBuilder input1;
    private StringBuilder result1;
    private StringBuilder stringBuilder;
    private JudgingQueueServiceImpl judgingQueueService = new JudgingQueueServiceImpl();

    @Before
    public void setUp() {
        input1 = new StringBuilder();
        input1.append("1\n");
        input1.append("\n");
        input1.append("1 2 10 I\n");
        input1.append("3 1 11 C\n");
        input1.append("1 2 19 R\n");
        input1.append("1 2 21 C\n");
        input1.append("1 1 25 C\n");
        input1.append("\n");

        result1 = new StringBuilder();
        result1.append("1 2 66\n");
        result1.append("3 1 11\n");
    }

    @Test
    public void fullTest() {
        stringBuilder = new StringBuilder();
        JudgingQueue judgingQueue = judgingQueueService.parse(input1.toString());

        judgingQueueService.getWinners(judgingQueue).forEach(winner -> stringBuilder.append(winner.toString()));

        assertEquals(stringBuilder.toString(), result1.toString());
    }

    @Test
    public void parseTest() {
        JudgingQueue judgingQueue = judgingQueueService.parse(input1.toString());
        assertNotNull(judgingQueue);
        assertEquals(judgingQueue.getJudgments().size(), 5);

        Judgment judgment = judgingQueue.getJudgments().get(0);
        assertEquals(judgment.getContestant().intValue(), 1);
        assertEquals(judgment.getProblem().intValue(), 2);
        assertEquals(judgment.getTime().intValue(), 10);
        assertEquals(judgment.getStatus(), "I");
    }
}
