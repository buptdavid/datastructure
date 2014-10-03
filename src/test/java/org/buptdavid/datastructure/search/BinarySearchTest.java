package org.buptdavid.datastructure.search;

import junit.framework.Assert;

import org.junit.Test;


/**
 * 二分查找测试
 * @author weijielu
 * @see BinarySearch
 */
public class BinarySearchTest {
	int[] array = {-2, -1, 0, 2, 3, 4, 5, 8, 10};
	
	@Test
	public void testSearchCirculation(){
		Assert.assertEquals(Integer.valueOf(-2), BinarySearch.searchCirculation(array, -2));
		Assert.assertEquals(Integer.valueOf(10), BinarySearch.searchCirculation(array, 10));
		
		Assert.assertEquals(Integer.valueOf(0), BinarySearch.searchCirculation(array, 0));
		
		Assert.assertEquals(null, BinarySearch.searchCirculation(array, 1));
	}
	
	@Test
	public void testSearchRecursive(){
		Assert.assertEquals(Integer.valueOf(-2), BinarySearch.searchRecursive(array, -2));
		Assert.assertEquals(Integer.valueOf(10), BinarySearch.searchRecursive(array, 10));
		
		Assert.assertEquals(Integer.valueOf(0), BinarySearch.searchRecursive(array, 0));
		
		Assert.assertEquals(null, BinarySearch.searchRecursive(array, 1));
	}
}
