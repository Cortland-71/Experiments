package experiments;


public class Experiments {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		boolean running = true;
		while(running) {
			running = menu.showMenu();
		}
	}
}
