import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	public ArrayList<Letter> getLetters () {
		return this.letterlist;
	}

	public ArrayList<Letter> getTermLetters (int flag) {
		ArrayList<Letter> list = new ArrayList<>();
		for (Letter letter : this.letterlist) {
			if (letter.getPeriod() == flag) {
				list.add(letter);
			}
		}
		return list;
	}

	public ArrayList<Letter> getPastLetters () {
		return this.getTermLetters(Letter.PAST);
	}
	public ArrayList<Letter> getTodayLetters () {
		return this.getTermLetters(Letter.TODAY);
	}
	public ArrayList<Letter> getFutureLetters () {
		return this.getTermLetters(Letter.FUTURE);
	}


	public void open (String filename) {
		this.filer.open(filename);
	}

	public void open (Letter letter ){
		this.open(letter.getFilename());
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
