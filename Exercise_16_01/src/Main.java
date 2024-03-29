import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int capacity;
		String messages;

		System.out.println("Please input a capacity for the queue: ");
		capacity = keyboard.nextInt();
		keyboard.nextLine();

		QueueADT<String> threadSafe = new ThreadSafeBoundedQueue<>(capacity);
		System.out.println("Now enter " + capacity + " things that you like!");
		for (int i = 0; i < capacity; i++) {
			messages = keyboard.nextLine();
			threadSafe.enqueue(messages);
		}
		System.out.println(threadSafe.toString());
	}
}
