class Q
{
	int n;
	boolean valueSet = false;
	
	//Keyword "synchronized" makes sure that only one thread at a time will execute this block. All other threads are 
	 //blocked until this thread exits
	//get() method is used by the consumer to access an item produced by the producer 
	synchronized int get()
	{
		//!valueSet - cart is empty.Producer hasn't filled an item. Hence consumer need to wait until producer notifies 
		//that the cart is filled with an item
		while(!valueSet)
		try
		{	//wait() - defined in Object class
			//       - makes current thread to wait until another thread invokes notify()
			wait();
		}
		catch(InterruptedException e)
		{
			System.out.println("InterruptedException caught");
		}
		System.out.println("Got:" + n);
		valueSet = false;
		notify();
		return n;
	}
	
	synchronized void put(int n)
	{
		while(valueSet)
		try
		{
			wait();
		}
		catch(InterruptedException e)
		{
			System.out.println("InterruptedException caught");
		}
		this.n = n;
		valueSet = true;
		System.out.println("Put:" + n);
		notify();
	}
}

class Producer implements Runnable
{
	Q q;
	Thread t;
	
	Producer(Q q)
	{
		this.q = q;
		t = new Thread(this,"Producer");
		t.start();
	}
	
	public void run()
	{
		int i = 0;
		while(true)
		{
			q.put(i++);
		}
	}
}

class Consumer implements Runnable
{
	Q q;
	Thread t;

	Consumer(Q q)
	{
		this.q = q;
		t = new Thread(this,"Consumer");
		t.start();
	}
	
	public void run()
	{
		while(true)
		{
			q.get();
		}
	}
}

class ProducerConsumer
{
 	public static void main(String args[])
	{
 		System.out.println("Press Control-C to stop");
 		Q q = new Q();
 		Producer p = new Producer(q);
 		Consumer c = new Consumer(q);
	}
}
