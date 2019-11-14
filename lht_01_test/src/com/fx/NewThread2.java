package com.fx;

public class NewThread2 {
   public static void main(String[] args) {
	   new Thread() {
		   public void run() {
			 System.out.println("匿名内部类启动一次线程");  
		   }
	   }.start();
	   
   }
}
