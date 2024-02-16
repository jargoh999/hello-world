package reflection;


    public enum typeOfProblems {
        FINANCIAL("financial"),
        SPIRITUAL("spiritual"),
        EDUCATION("education"),
        BUSINESS("business"),
        TECHNICAL("technical");


        private  String values;
        typeOfProblems(String values) {
               this.values = values;
        }

       public String getValue(){

            return values;
       }




    };




