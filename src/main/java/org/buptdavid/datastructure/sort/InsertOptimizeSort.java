/**
 * 
 */
package org.buptdavid.datastructure.sort;

/**
 * 插入排序优化实现
 * @author weijielu
 *
 */
public class InsertOptimizeSort implements ISort {

	@Override
	public void sort(int[] array) {
		for(int i = 1; i < array.length; i++){
			int index = getInsertIndex(array, i, array[i]);
					
			if(i != index){
				int j = i;
				int temp = array[i];
				while(j > index){
					array[j] = array[j - 1];
					j--;
				}
				
				array[j] = temp;
			}
		}
	}
	
	/**
	 * 使用二分查找法返回插入的位置
	 * @param array
	 * @param value
	 * @return
	 */
	private int getInsertIndex(int[] array, int length, int value){
		int low = 0;
		int high = length - 1;
		int middle = -1;
		
		while(low <= high){
			middle = (low + high) / 2;
			
			if(array[middle] > value){
				high = middle - 1;
			}else if(array[middle] < value){
				low = middle + 1;
			}else{
				return middle;
			}
		}
		
		if(array[middle] <= value){
			middle++;
		}
		
		return middle;
	}

}
