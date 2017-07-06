package com.creditharmony.core.thd;

import com.creditharmony.core.thd.pools.ThreadPool01;
import com.creditharmony.core.thd.pools.ThreadPoolManage;
import com.creditharmony.core.thd.runs.ThreadRun01;
import com.creditharmony.core.thd.runs.ThreadRunManage;

public class Main00 {

	public static void main(String[] args){
		
		//使用对象池的对象进行处理
		//使用单线程运行对象进行处理
		ThreadRunManage.thdrMang01 = new ThreadRun01(5);
		ThreadPoolManage.thdPool01 = new ThreadPool01<Thread01>(500, Thread01.class);
		for(int i=0; i<70; i++){
			System.out.println("main i="+i);
			new Thread(new Runnable() {
				public void run() {
					for(int j=0; j<100; j++){
						IThread00 obj = null;
						obj = (IThread00)ThreadPoolManage.thdPool01.getThread();
						obj.setMsg("Runnable_00"+j);
						ThreadRunManage.thdrMang01.putThread2Mlt((Runnable)obj);
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int j=0; j<100; j++){
						IThread00 obj = null;
						obj = (IThread00)ThreadPoolManage.thdPool01.getThread();
						obj.setMsg("Runnable_01"+j);
						ThreadRunManage.thdrMang01.putThread2Mlt((Runnable)obj);
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int j=0; j<100; j++){
						IThread00 obj = null;
						obj = (IThread00)ThreadPoolManage.thdPool01.getThread();
						obj.setMsg("Runnable_02"+j);
						ThreadRunManage.thdrMang01.putThread2Mlt((Runnable)obj);
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int j=0; j<100; j++){
						IThread00 obj = null;
						obj = (IThread00)ThreadPoolManage.thdPool01.getThread();
						obj.setMsg("Runnable_03"+j);
						ThreadRunManage.thdrMang01.putThread2Mlt((Runnable)obj);
					}
				}
			}).start();
			new Thread(new Runnable() {
				public void run() {
					for(int j=0; j<100; j++){
						IThread00 obj = null;
						obj = (IThread00)ThreadPoolManage.thdPool01.getThread();
						obj.setMsg("Runnable_04"+j);
						ThreadRunManage.thdrMang01.putThread2Mlt((Runnable)obj);
					}
				}
			}).start();
		}
		
//		使用对象池的对象进行处理
//		ThreadManage.disInitVlt();
//		ThreadPoolManage.thdPool02 = new ThreadPool01<Thread02>(500, Thread02.class);
//		for(int i=0; i<70; i++){
//			System.out.println("main i="+i);
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = null;
//						obj = (IThread00)ThreadPoolManage.thdPool02.getThread();
//						obj.setMsg("Runnable_00"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_01"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_02"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_03"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_04"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//		}
	
//		泛型化
//		ThreadManage.disInitVlt();
//		ThreadPool00.disInit(Thread01.class);
//		for(int i=0; i<70; i++){
//			System.out.println("main i="+i);
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = null;
//						obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_00"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_01"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_02"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_03"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						IThread00 obj = (IThread00)ThreadPool00.getThread(Thread01.class);
//						obj.setMsg("Runnable_04"+j);
//						ThreadManage.putThread2Mlt((Runnable)obj);
//					}
//				}
//			}).start();
//		}
		
//		指定接口
//		ThreadManage.disInitVlt();
//		ThreadPool00.disInit();
//		for(int i=0; i<70; i++){
//			System.out.println("main i="+i);
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread2Mlt(ThreadPool00.getThread("Runnable_00"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread2Mlt(ThreadPool00.getThread("Runnable_01"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread2Mlt(ThreadPool00.getThread("Runnable_02"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread2Mlt(ThreadPool00.getThread("Runnable_03"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread2Mlt(ThreadPool00.getThread("Runnable_04"+j));
//					}
//				}
//			}).start();
//		}
			
//		//Run...... 指定thread
//		ThreadPool00.disInit();
//		for(int i=0; i<70; i++){
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread(ThreadPool00.getThread("Runnable_00"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread(ThreadPool00.getThread("Runnable_01"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread(ThreadPool00.getThread("Runnable_02"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread(ThreadPool00.getThread("Runnable_03"+j));
//					}
//				}
//			}).start();
//			new Thread(new Runnable() {
//				public void run() {
//					for(int j=0; j<100; j++){
//						ThreadManage.putThread(ThreadPool00.getThread("Runnable_04"+j));
//					}
//				}
//			}).start();
//		}
	}
}
