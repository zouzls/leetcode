package lengthOfLongestSubstring;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	/**
	 * �����ƽ⣬ʱ�临�Ӷ�O(n^2)��100ms����
	 * @param s
	 * @return
	 */
    public int lengthOfLongestSubstring(String s) {
    	//Character �����ڶԵ����ַ����в�����Character ���ڶ����а�װһ���������� char ��ֵ
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
     * ���������������ֱ�ָ���ַ�������β�����Ҷ����������ƶ�
     * ÿ��left���¿�ʼɨ��ĵط����Ǵ�����ظ��ַ��ĺ�һλ��ʼ
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
    	if (s == null || s.length() == 0) {
    		//���ϱ߽�����֮�󣬾�Ȼ�������4ms��̫�����ˣ�����22ms��
    		//update�������ٴ�ʵ�飬�����ύһ���Ĵ��룬��ͬ��û�б߽���������Ȼ��17ms��(��o��)
            return 0;
        }
    	int left=0,right=0,maxlen=0;//��ʼ������ַ��������ң��Լ�����
    	HashSet<Character> charset=new HashSet<>();
    	for(right=0;right<s.length();right++){
    		if(!charset.contains(s.charAt(right))){//��û�������ظ��ַ���ʱ
    			charset.add(s.charAt(right));
    			maxlen=Math.max(maxlen, right-left+1);
    		}else {//�����ظ��ַ�
				while(s.charAt(left)!=s.charAt(right)){//���ظ��ַ�֮ǰ��ȫ��ɾ����ֱ�������ظ����Ǹ��ַ�
					charset.remove(s.charAt(left));
					left++;
				}
				left++;//�����ظ��ַ�
			}
    	}
    	return maxlen;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring_2("abcabcbb"));
	}
}
