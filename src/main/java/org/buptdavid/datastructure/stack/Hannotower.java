package org.buptdavid.datastructure.stack;

/**
 * 经典的汉诺塔问题,3根柱子,N个大小不同的盘子开始由下到上依次变小摞在第一个柱子上<br>
 * 实现汉诺算法,将N个盘子以相同的顺序搁到第三根柱子上
 * @author weijielu
 *
 */
public class Hannotower {
	
	/**
	 * 封装柱子为一个内部类
	 */
	public static class Tower{
		private Stack<Integer> disks;
		private char name;
		
		public Tower(char name){
			disks = new Stack<Integer>();
			this.name = name;
		}
		
		public char name(){
			return this.name;
		}
		
		/**
		 * 向此柱子上添加盘子d
		 * @param d
		 */
		public void add(int d){
			if(!disks.isEmpty() && disks.peek() <= d){
				System.out.println("不能将盘子 " + d + " 放入此柱子上");
			}else{
				disks.push(d);
			}
		}
		
		/**
		 * 将此柱子顶部的盘子移到柱子t上
		 * @param t
		 */
		public void moveTopTo(Tower t){
			int top = disks.pop();
			t.add(top);
			System.out.println("将盘子 " + top + "从柱子 " + name() +" 移动 到柱子 " + t.name());
		}
		
		/**
		 * 将n个盘子从此柱子依靠缓冲柱子buffer移到柱子destination
		 * 
		 * @param n
		 * @param destination
		 * @param buffer
		 */
		public void moveDisks(int n, Tower destination, Tower buffer){
			if(n > 0){
				// 先将n-1个盘子从此柱子依靠缓冲柱子destination移到柱子buffer
				moveDisks(n - 1, buffer, destination);
				// 然后将剩下的盘子n移到柱子destination上
				moveTopTo(destination);
				// 最后将n-1个盘子从buffer依靠本身缓冲移到柱子destination
			    buffer.moveDisks(n - 1, destination, this);
			}
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 三根柱子
		int n = 3;
		Tower[] towers = new Tower[n];
		towers[0] = new Tower('A');
		towers[1] = new Tower('B');
		towers[2] = new Tower('C');
		
		// 10个盘子
		int diskCount = 10;
		for(int i = diskCount; i > 0; i--){
			towers[0].add(i);
		}
		towers[0].moveDisks(diskCount, towers[2], towers[1]);
	}

}
