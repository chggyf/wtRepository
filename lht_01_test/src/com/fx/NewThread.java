package com.fx;

public class NewThread implements  Runnable{

	@Override
	public synchronized void run() {
		while(true) {
			// TODO Auto-generated method stub
			System.out.println("wo1线程开始运行了.......");
			try {
				//Thread.sleep(100);//等待
				wait();//等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		NewThread n =new NewThread();
		//初始化
		Thread thread = new Thread(n);
		//启动线程可运行，就绪状态，抢到cpu资源就开始执行
		thread.start();
		thread.interrupt();//线程中断
		while(true) {
			synchronized(n) {
				//调用wait  notify 必须是synchronized块
				// TODO Auto-generated method stub
				System.out.println("wo2线程开始运行了.......");
				try {
					Thread.sleep(100);//等待
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				n.notify();
			}
			
		}
	
	}

}
