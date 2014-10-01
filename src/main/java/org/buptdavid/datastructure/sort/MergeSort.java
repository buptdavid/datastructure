package org.buptdavid.datastructure.sort;

/**
 * 归并排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(nlog(n))<br>
 * 空间复杂度: It Depends
 * @author weijielu
 * @see ISort
 * @see SortTest
 */
public class MergeSort implements ISort {

	public void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * 从索引low到high归并排序数组array
	 * @param array
	 * @param low
	 * @param high
	 */
	private void mergeSort(int[] array, int low, int high){
		if(low < high){
			int middle = (low + high)/2;
			mergeSort(array, low, middle);
			mergeSort(array, middle + 1, high);
			
			merge(array, low, middle, high);
		}
	}
	
	/**
	 * 归并array
	 * @param array
	 * @param low
	 * @param middle
	 * @param high
	 */
	private void merge(int[] array, int low, int middle, int high){
		// 辅助数组
		int[] helper = new int[array.length];
		for(int i = 0; i <= high; i++){
			helper[i] = array[i];
		}
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		
		/**
		 * 迭代访问helper数组，比较左右两半元素
		 * 并将较小的元素复制到原先的数组中
		 */
		while(helperLeft <= middle && helperRight <= high){
			if(helper[helperLeft] <= helper[helperRight]){
				array[current] = helper[helperLeft];
				helperLeft++;
			} else{
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		/**
		 * 将数组左半剩余元素复制到原先的数组中
		 */
		int remaining = middle - helperLeft;
		for(int i = 0; i <= remaining; i++){
			array[current + i] = helper[helperLeft + i];
		}
	}
}
