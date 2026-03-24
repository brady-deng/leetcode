package main.java.lc.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author dengchenyang@tju.edu.cn
 * @date 20231215
 **/
public class L139Ans {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict){
            if (wordDict.size() == 0){
                return false;
            }
            boolean[] dp = new boolean[s.length()];
            Arrays.fill(dp,true);
            return isbreak(0,s,dp,wordDict);
        }
        public boolean isbreak(int ind,String st,boolean[] dp,List<String> wordDict){
            if (ind == st.length()){
                return true;
            }
            if(!dp[ind]){
                return false;
            }
            for (int i=ind+1;i<=st.length();i++){
                String temp = st.substring(ind,i);
                if (wordDict.contains(temp)){
                    boolean tempremark = isbreak(i,st,dp,wordDict);
                    if (tempremark){
                        return true;
                    }
//                return false;
                    dp[i] = false;
                }
            }
            return false;
        }
    }
}
