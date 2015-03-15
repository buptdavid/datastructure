/**
 * 
 */
package org.buptdavid.datastructure.sort;

/**
 * 插入排序实现
 * @author weijielu
 *
 */
public class InsertSort implements ISort {

	@Override
	public void sort(int[] array) {
		
		for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > temp){
				array[j + 1] = array[j];
				j--;
			}
			
			if(j != i - 1){
				array[j + 1] = temp;
			}
		}
	}

}
