package org.buptdavid.datastructure.sort;

/**
 * 快速排序<br>
 * 时间复杂度: 平均情况是O(nlog(n)),最差情况是O(n^2)<br>
 * 空间复杂度: O(nlog(n))
 * @author weijielu
 * @see ISort
 * @see SortTest
 */
public class QuickSort implements ISort {

	public void sort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * 从left到right排序数组array
	 * @param array
	 * @param left
	 * @param right
	 */
	private void quickSort(int[] array, int left, int right){
		int index = partition(array, left, right);
		if(left < index - 1){
			quickSort(array, left, index - 1);
		}
		if(index + 1 < right){
			quickSort(array, index, right);
		}
	}
	
	/**
	 * 找出一个基准点，排列数组array左边的都小于它，右边的都大于它
	 * @param array
	 * @param left
	 * @param right
	 * @return 基准值数组索引
	 */
	private int partition(int[] array, int left, int right){
		int pivot = array[(left + right) / 2];
		int temp;
		
		while(left < right){
			while(array[left] < pivot) left++;
			while(array[right] > pivot) right--;
			
			if(left < right){
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
	}
}
