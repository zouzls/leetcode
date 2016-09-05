package addTwoNumbers;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * @author Gs
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int carry=0;
    	ListNode res=null;
    	ListNode p=null;
    	ListNode prep=null;
    	while(l1!=null&&l2!=null){
    		p=new ListNode((l1.val+l2.val+carry)%10);
    		carry=(l1.val+l2.val+carry)/10;
    		if(prep==null){
    			prep=p;
    			res=p;
    		} else {
    			prep.next=p;
    			prep=p;
    		}

    		l1=l1.next;
    		l2=l2.next;
    	}
    	while(l1!=null){
    		p=new ListNode((l1.val+carry)%10);
    		carry=(l1.val+carry)/10;
			prep.next=p;
			prep=p;
    		l1=l1.next;
    	}
    	while(l2!=null){
    		p=new ListNode((l2.val+carry)%10);
    		carry=(l2.val+carry)/10;
			prep.next=p;
			prep=p;
    		l2=l2.next;
    	}
    	if(carry==1){
    		p=new ListNode(1);
    		prep.next=p;
    	}
        return res;
    }
    public static void main(String[] args) {
    	ListNode l1=new ListNode(2);
    	l1.next=new ListNode(4);
    	l1.next.next=new ListNode(3);
    	
    	ListNode l2=new ListNode(5);
    	l2.next=new ListNode(6);
    	l2.next.next=new ListNode(4);
    	
    	ListNode res=new Solution().addTwoNumbers(l1, l2);
    	while(res!=null){
    		System.out.println(res.val);
    		res=res.next;
    	}
	}
}