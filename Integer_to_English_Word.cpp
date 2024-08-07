class Solution {
    //Time Complexity=O(Log(Num))
    //Space Complexity=O(1)
public:
        unordered_map<int,string> belowten{{9, "Nine"}, {8, "Eight"},  {7, "Seven"}, {6, "Six"}, {5, "Five"},{4, "Four"}, {3, "Three"}, {2, "Two"}, {1, "One"},{0,""}};
        unordered_map<int,string> belowtwenty{{19, "Nineteen"}, {18, "Eighteen"},{17, "Seventeen"}, {16, "Sixteen"}, {15, "Fifteen"}, {14, "Fourteen"}, {13, "Thirteen"}, {12, "Twelve"}, {11, "Eleven"},{10,"Ten"}};
unordered_map<int,string> belowhundred{{9, "Ninety"}, {8, "Eighty"},  {7, "Seventy"}, {6, "Sixty"}, {5, "Fifty"},{4, "Forty"}, {3, "Thirty"}, {2, "Twenty"}, {1, "Ten"}};

string solve(int num)
{
    if(num<10)
    return belowten[num];
    if(num<20)
    return belowtwenty[num];
    if(num<100)//89 "Eighty Nine"
    {
        return belowhundred[num/10]+((num%10!=0)?" "+solve(num%10):"");
    }
    if(num<1000)
    {
        return solve(num/100)+" Hundred"+((num%100!=0)?" "+solve(num%100):"");
    }
     if(num<1000000)
    {
        return solve(num/1000)+" Thousand"+((num%1000!=0)?" "+solve(num%1000):"");
    }
     if(num<1000000000)
    {
        return solve(num/1000000)+" Million"+((num%1000000!=0)?" "+solve(num%1000000):"");
    }
  
return solve(num/1000000000)+" Billion"+((num%1000000000!=0)?" "+solve(num%1000000000):"");
    

}
    string numberToWords(int num) {
        if(num==0)
        return "Zero";
        return solve(num);
        
    }
};
