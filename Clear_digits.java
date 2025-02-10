class Solution {
public String clearDigits(String s) { 
    //Tc=O(N)
    //Sc=O(N)  
Stack<Character> st=new Stack<>();
for(int i=0;i<s.length();i++)
{

if(Character.isDigit(s.charAt(i))&&!st.isEmpty())
{
    st.pop();
}
else{
    st.push(s.charAt(i));
}
}
String r="";
while(!st.isEmpty())
{
char k=st.peek();
st.pop();
r+=k;
}
String res="";
for(int i=r.length()-1;i>=0;i--)
{
res+=r.charAt(i);

}
return res;   
}
}
//Approach 2 brute Force
class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (i < sb.length()) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.deleteCharAt(i);
                if (i > 0) {
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
//Approach  3
class Solution {
    public String clearDigits(String s) {
        String res="";
        for(int i=0;i<s.length();i++)
        {
            if(Character.isDigit(s.charAt(i))&&!res.isEmpty())
            {
                res=res.substring(0,res.length()-1);
            }
            else{
                res+=s.charAt(i);
            }
        }
        return res;
    }
}
//Approach 4 Tc=O(N),Sc=O(1)
class Solution {
    public String clearDigits(String s) {
        int n=s.length();
        char arr[]=s.toCharArray();
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(Character.isDigit(arr[i]))
            {
                j=Math.max(j-1,0);
            }
            else{
                arr[j]=arr[i];
                j++;
            }
        }
        return new String(arr,0,j);
    }
}
