package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author 233admincol
 *LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 *他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 *“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 *LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 *上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 *LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 *  如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class 扑克牌顺子 {
	/*
	 * 要想解出这道题，必须知道两个限制条件：
	 * 1.max-min<5
	 * 2.除0以外没有重复的数，比如0 1 1 2 3，pass
	 * 
	 * */
	
	 public boolean isContinuous(int [] numbers) {
	       if(numbers == null)
	            return false;
	       //需要注意的是arraylist的sort方法需要自定义的comparator的compare方法，而Arrays的sort不需要
	        Arrays.sort(numbers);  //先排序
	        int zero = 0, i = 0;
	        //将i提出来可以使下一次for循环跳过0
	        for(; i < numbers.length && numbers[i] == 0; i++){
	            zero ++;  //统计0的个数
	        }
	        
	        for(; i < numbers.length - 1 && zero >= 0; i++){
	            if(numbers[i] == numbers[i+1]) //有对子，则返回false
	                return false;
	            //补牌公式
	            if(numbers[i] + 1 + zero >= numbers[i+1]){  //可以继续匹配
	                zero -= numbers[i+1] - numbers[i] - 1;
	            }
	            else
	                return false;
	        }
	        if(i == numbers.length -1)
	            return true;
	        else
	            return false;
	   }
}
