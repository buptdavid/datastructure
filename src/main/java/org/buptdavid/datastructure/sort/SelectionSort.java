package org.buptdavid.datastructure.sort;

/**
 * 选择排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 * @author weijielu
 * @see ISort
 * @see SortTest
 */
public class SelectionSort implements ISort {

	public void sort(int[] array) {
		int temp = 0;
		
		for(int i = 0; i < array.length; i++){
			temp = array[i];
			for(int j = i; j < array.length; j++){
				if(temp > array[j]){
					temp = array[j];
				}
			}
			
			if(temp != array[i]){
				array[i] = temp;
			}
		}
	}

}
