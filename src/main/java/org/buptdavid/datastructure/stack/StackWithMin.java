package org.buptdavid.datastructure.stack;

import org.buptdavid.datastructure.Node;


/**
 * 一个能随时获取栈中最小值的栈的实现
 * 
 * @author weijielu
 * @see StackTest
 * @see IStack
 * @see Node
 */
public class StackWithMin extends Stack<Integer> {
	Stack<Integer> stackMin;
	
	public StackWithMin(){
		stackMin = new Stack<Integer>();
	}
	
	public void push(Integer item){
        if(item <= min()){
            stackMin.push(item);
        }
        super.push(item);
    }
	
	public Integer pop(){
        int value = super.pop();
        if(value == min()){
        	stackMin.pop();
        }
        return value;
    }
	
	/**
	 * 取得栈中的最小值
	 * @return
	 */
	public Integer min(){
        if(stackMin.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return stackMin.peek();
        }
    }
}
