package test;
/**
 * 
 * @author 233admincol
 *给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 *他们的最大值分别为{4,4,6,6,6,5}； 
 *针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
/*
 * 使用双向队列，poll和pop可删除两端的值
 * 对新来的元素k，将其与双端队列中的元素相比较
 * 1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 * 2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *     队列的第一个元素是滑动窗口中的最大值
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口的最大值 {
	//num为数组，size为窗口大小
public ArrayList<Integer> maxInWindows(int[] num,int size)
{	//ret保存每个窗口的最大值
	ArrayList<Integer> ret=new ArrayList<>();
	if (num==null) {
		return ret;
	}
	if (num.length<size ||size<1) {
		return ret;
	}
	//indexdeque记录窗口最大值下标
	LinkedList<Integer> indexDeque=new LinkedList<>();
	for (int i = 0; i < size-1; i++) {
		//如果当前值比最近的最大值还大，移除
		while(!indexDeque.isEmpty()&&num[i]>num[indexDeque.getLast()]) {
			indexDeque.removeLast();
		}
		//添加最大值下标到数组
		 indexDeque.addLast(i);
	}
	for (int i = size - 1; i < num.length; i++) {
        while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
            indexDeque.removeLast();
        }
        indexDeque.addLast(i);
        //超出当前窗口的下标移除
        if (i - indexDeque.getFirst() + 1 > size) {
            indexDeque.removeFirst();
        }
        ret.add(num[indexDeque.getFirst()]);
    }
    return ret;
}
}
