import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class Filer {

	Desktop desktop;

	public Filer() {
		desktop = Desktop.getDesktop();
	}

	public void open(String filename) {
		try {
			desktop.edit(new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void create(String filename) {
		try {
			File f = new File(filename);
			f.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String... args) {
		Filer f = new Filer();
		f.create("create_test.txt");
		f.open("tes.txt");
	}
}
