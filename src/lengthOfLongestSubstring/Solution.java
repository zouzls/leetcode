package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	/**
	 * 暴力破解，时间复杂度O(n^2)，100ms左右
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
    	//Character 类用于对单个字符进行操作。Character 类在对象中包装一个基本类型 char 的值
    	HashSet<Character> strset=new HashSet<>();
    	int maxlen=0;
    	for(int i=0;i<s.length();i++){
    		for(int j=i;j<s.length();j++){
    			if(!strset.contains(s.charAt(j))){
    				strset.add(s.charAt(j));
    				if(strset.size()>maxlen)
    					maxlen=strset.size();
    			}else break;
    		}
    		strset.clear();
    	}
        return maxlen;
    }
    /**
     * 采用两个变量，分别指向字符串的首尾，并且都从左向右移动
     * 每次left重新开始扫描的地方都是从左边重复字符的后一位开始
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
    	if (s == null || s.length() == 0) {
    		//加上边界条件之后，竟然又提高了4ms，太神奇了，不加22ms；
    		//update：经过再次实验，重新提交一样的代码，，同样没有边界条件，居然是17ms，(⊙o⊙)
            return 0;
        }
    	int left=0,right=0,maxlen=0;//初始化最大字符串的左右，以及长度
    	HashSet<Character> charset=new HashSet<>();
    	for(right=0;right<s.length();right++){
    		if(!charset.contains(s.charAt(right))){//当没有遇到重复字符串时
    			charset.add(s.charAt(right));
    			maxlen=Math.max(maxlen, right-left+1);
    		}else {//遇到重复字符
				while(s.charAt(left)!=s.charAt(right)){//将重复字符之前的全部删掉，直到遇到重复的那个字符
					charset.remove(s.charAt(left));
					left++;
				}
				left++;//跳过重复字符
			}
    	}
    	return maxlen;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring_2("abcabcbb"));
	}
}
