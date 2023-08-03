package Lauch;

public class Launch {
	/* the number of philosophers */
	public static int Num = 5;
	/* array of semaphores representing chopsticks */
	public static Semaphore chopstick[] = new Semaphore[Num];
	public static Semaphore Mutex = new Semaphore(1);
	/* N philosophers */
	public static Philosophers philosophers[] = new Philosophers[Num];
	/* The Main program */

	public static void main(String args[]) {
		/* Initializing & Launching threads */
		int i;
		for (i = 0; i < Num; i++) {
			chopstick[i] = new Semaphore(1);
			philosophers[i] = new Philosophers(i);
			philosophers[i].start();
		}
		System.out.println("Phil. 1        Phil. 2        Phil. 3        Phil. 4        Phil. 5");
	}
}

class P {
	public static void Print() {
		for (int i = 0; i < Launch.Num; i++)
			System.out.print(Launch.philosophers[i].Status + "       ");
		System.out.println("");
	}
}

class Philosophers extends Thread {
	/* Id of the philosopher */
	private int Id;
	public String Status;
	/* factor of sleep time */
	private int Factor = 3000;

	/* constructor */
	public Philosophers(int x) {
		Id = x;
		Status = "IsHungry";
	}

	public void run() {
		while (true) {

			/* wait for Mutex then left & right chopsticks */
			Launch.Mutex.Wait();
			Launch.chopstick[Id].Wait();
			Launch.chopstick[(Id + 1) % (Launch.Num)].Wait();

			/* start of eating stage */
			Status = "IsEating";
			P.Print();
			int SleepTime = (int) (Math.random() * Factor);
			try {
				Thread.sleep(SleepTime);
			} catch (InterruptedException e) {
				System.exit(-1);
			}
			/* end of eating stage */
			/* signals the left & right chopstick then Mutex */

			Launch.chopstick[Id].Signal();
			Launch.chopstick[(Id + 1) % (Launch.Num)].Signal();
			Status = "Thinking";
			P.Print();
			Launch.Mutex.Signal();
			/* the philosopher is thinking now */
			SleepTime = (int) (Math.random() * Factor);
			try {
				Thread.sleep(SleepTime);
			} catch (InterruptedException e) {
				System.exit(-1);
			}
			Status = "IsHungry";
			P.Print();
		}
	}
}
