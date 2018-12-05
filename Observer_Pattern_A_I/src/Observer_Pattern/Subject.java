package Observer_Pattern;

public interface Subject {
	
	public void subscribePerson(Observer observer);
	public void unsubscribePerson(Observer observer);
	public void notifyObserver();
}
