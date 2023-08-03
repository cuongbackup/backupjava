package Lauch;

public class Semaphore {
	private int value;/* the value of semaphore */

	public Semaphore()/* Constructor */
	{
		value = 0;
	}

	public Semaphore(int i) {
		value = i;
	}

	/* Wait() implemented as synchronized to ensure that it is done atomically */
	public synchronized void Wait() {
		/* decrement the semaphore */
		value--;
		/* force the process to wait if value<0 */
		if (value < 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.exit(-1);
			}
		}
	}

	/* Signal() is implemented as synchronized to ensure it is done atomically */
	public synchronized void Signal() {
		value++; /* increment semaphore value */
		/* wake up any waiting processes */
		if (value <= 0)
			notify();
	}
}
