package reflection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    @Test
    public void testThatProblemExist(){
        Problem problem = new Problem("money",typeOfProblems.EDUCATION);
        Problem problem1 = new Problem("CAR",typeOfProblems.BUSINESS);
        Person person = new Person();
        person.addProblems(problem);
        person.addProblems(problem1);

        assertEquals(2,person.problems.size());
    }

@Test
    public void testThatProblemCanBeRemoved(){
        Problem problem2 = new Problem("GOLD",typeOfProblems.EDUCATION);
        Problem problem1 = new Problem("CAR",typeOfProblems.BUSINESS);
        Person person = new Person();
        person.addProblems(problem1);
        person.addProblems(problem2);
        person.removeProblem(problem1);
        person.addProblems(problem1,1);
        person.addProblems(problem2,3);
        System.out.println(person.countProblem());
        System.out.println(person.problemsHashMap);
        assertTrue(problem1.isSolved);
        assertFalse(problem2.isSolved);
    }








}
