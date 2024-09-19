class Solution {
    public List<Integer> solve(String s)
    {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*')
            {
                 //Solve the left part of operator
                  List<Integer> left=solve(s.substring(0,i));
                  //Solve the right part of operator
                  List<Integer> right=solve(s.substring(i+1));
                  for(int x:left)
                  {
                    for(int y:right)//Make pairs from left &right
                    {
                        if(s.charAt(i)=='+')
                        {
                            result.add(x+y);
                        }
                        else if(s.charAt(i)=='-')
                        result.add(x-y);
                        else
                        {
                            result.add(x*y);
                        }

                    }
                  }
            }
        }
        if(result.isEmpty())//Base case
        result.add(Integer.parseInt(s));
        return result;
    }
    public List<Integer> diffWaysToCompute(String s) {
        return solve(s);
        
    }
}
