
//Complexity ::O(n+m)  

class Solution {

    public int strStr(String haystack, String needle) {
        if(needle.length()==0)return 0;
        int[] pi=new int[needle.length()+1];
        
        //preprocessing needle to generate pi table
        preprocess(needle,pi);
        
         int p=0;
        int len=0;
       
        while(p<haystack.length()&&len<needle.length())
        {
            if(needle.charAt(len)==haystack.charAt(p))
            {
                len++;
                p++;
            }
            else
            {
                if(len==0)
                {
                    p++;
                }
                else
                {
                    len=pi[len-1];
                }
            }
            if(len==needle.length())return p-needle.length();
        } 
        return -1;
       
    }
    public void preprocess(String needle,int[] lps)
    {
    
        int p=1;
        int len=0;
        lps[0]=0;
        while(p<needle.length())
        {
            if(needle.charAt(p)==needle.charAt(len))
            {
                len++;
                lps[p]=len;
                p++;
            }
            else
            {
                if(len==0)
                {
                    lps[p]=len;
                    p++;
                }
                else
                {
                    len=lps[len-1];
                }
            }
        }
    }
}
