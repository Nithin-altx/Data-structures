// class Solution {
//     public int minLength(String s) {
//         while(s.contains("AB")||s.contains("CD"))
//         {
//             if(s.contains("AB"))
//             {
//                 s=s.replace("AB","");
//             }
//             else if(s.contains("CD"))
//             {
//                 s=s.replace("CD","");
//             }
//         }
//         return s.length();
        
//     }
// }

class Solution {
    public int minLength(String s) {
        int len=s.length();
        //Tc=O(N)
        //SC=O(1)
        Stack<Character> st=new Stack<>();
        for(char x:s.toCharArray())
        {
            if(!st.isEmpty())
            {
                String pair=""+st.peek()+x;
                if(pair.equals("AB")||pair.equals("CD"))
                {
                    st.pop();
                    continue;
                }
        }
          st.push(x);
       
        
    }
     return st.size();
}
}
