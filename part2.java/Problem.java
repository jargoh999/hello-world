package reflection;

public class Problem {

    private String description;

    private typeOfProblems typeOfProblem;
    public boolean isSolved;

    public  Problem (String description,typeOfProblems typeOfProblem){

              this.description = description;
              this.typeOfProblem = typeOfProblem;

    }

   public String getDescription(){
        return description;
   }




    public String toString(){
      return String.format("%s", getDescription());
    }



}
