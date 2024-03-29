package 八种内部排序;

import java.util.Stack;

public class 快速排序 {
/*
 * 很像二分排序,只不过分界点是数组的第一个数
 */
	//递归实现快排
	public static void sort(int[] a,int low,int high)
	{
		 //如果排完了
		if(low>=high) {
				return;
		}
		int left=low;
		int right=high;
		//保存精准值
		int pivot=a[left];
		while(left<right) {
			//从后向前找到比基准小的元素
			while(left<right && a[right]>=pivot) {
				right--;
			}
			a[left]=a[right];
			//从前往后找到比基准大的元素
			while(left<right&&a[left]<=pivot) {
				left++;
			}
			a[right]=a[left];
		}
		//放置基准值,准备分治递归快排
		a[left]=pivot;
		sort(a, low, left-1);
		sort(a, left+1, high);
	}
	
	//////////
	
	//非递归实现快排
	public static void sortByStack(int[] a) {
	    Stack<Integer> stack = new Stack<Integer>();

	    //初始状态的左右指针入栈
	    stack.push(0);
	    stack.push(a.length - 1);
	    while (!stack.isEmpty()) {
	        //出栈进行划分
	        int high = stack.pop();
	        int low = stack.pop();

	        int pivotIndex = partition(a, low, high);

	        //保存中间变量
	        if (pivotIndex > low) {
	            stack.push(low);
	            stack.push(pivotIndex - 1);
	        }
	        if (pivotIndex < high && pivotIndex >= 0) {
	            stack.push(pivotIndex + 1);
	            stack.push(high);
	        }
	    }
	}

	private static int partition(int[] a, int low, int high) {
	    if (low >= high) return -1;
	    int left = low;
	    int right = high;
	    //保存基准的值
	    int pivot = a[left];
	    while (left < right) {
	        //从后向前找到比基准小的元素，插入到基准位置中
	        while (left < right && a[right] >= pivot) {
	            right--;
	        }
	        a[left] = a[right];
	        //从前往后找到比基准大的元素
	        while (left < right && a[left] <= pivot) {
	            left++;
	        }
	        a[right] = a[left];
	    }
	    //放置基准值，准备分治递归快排
	    a[left] = pivot;
	    return left;
	}
	
}
