class Solution {
public:
    string fractionAddition(string s) {
        int num=0,deno=1;
        int i=0;
        while(i<s.length())
        {
        int currnum=0,currdeno=0;
        bool isneg=(s[i]=='-');
        if(s[i]=='+'||s[i]=='-')
        {
            i++;
        }
        //build currnum 
        while(i<s.length()&&isdigit(s[i]))
        {
            int val=s[i]-'0';
            currnum=(currnum*10)+val;
            i++;
        }
        i++;//skipping the divisor char
        if(isneg==true)
        {
            currnum*=-1;
        }
        //build the denominator
        while(i<s.length()&&isdigit(s[i]))
        {
            int val=s[i]-'0';
            currdeno=(currdeno*10)+val;
            i++;
        }
        num=(num*currdeno)+(deno*currnum);
        deno=(deno*currdeno);
    }
    int gcd=abs(__gcd(num,deno));
    num/=gcd;
    deno/=gcd;
    return to_string(num)+"/"+to_string(deno);
       
        
    }
};
