package reflection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person {
     private int countNumberOfProblems;
    public List<Problem> problems = new ArrayList<>();
    public HashMap<String,Integer> problemsHashMap = new HashMap<>();
      public void addProblems(Problem problem){

              problems.add(problem);
              problem.isSolved = false;
      }

      public void  addProblems(Problem problem,typeOfProblems type){
          countNumberOfProblems++;
          problemsHashMap.put(problem.getDescription(),countNumberOfProblems);

      }

      public void removeProblem(Problem problem){
             problems.remove(problem);
             problem.isSolved = true;

      }

      public  List<Problem> countProblem(){
          return problems;
      }


}
