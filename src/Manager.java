import java.util.ArrayList;

import javax.swing.JButton;


public class Manager {
	public Filer filer;
	public ArrayList<Letter> letterlist;

	static final String regex_filename = "\\d{8}_\\d{8}\\.txt";
	static final String data_path = "./data/";
	public Manager() {
		filer = new Filer();
		letterlist = new ArrayList<>();
		for (String name : filer.getFiles(data_path)) {
			if (!name.matches(regex_filename)) continue;
			letterlist.add(new Letter(name));
		}
	}
	
	public void open (String name) {
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Manager Object\n");
		for (Letter letter : this.letterlist) {
			sb.append(letter);
		}
		return sb.toString();
	}

	public static void main(String... args) {
		Manager manager = new Manager();
		System.out.println(manager);
	}
}
