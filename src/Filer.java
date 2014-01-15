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
		File f = new File(filename);
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void delete(String filename) {
		File f = new File(filename);
		f.delete();
	}

	public boolean move(String source, String target) {
		File f = new File(source);
		File tof = new File(target);
		return f.renameTo(tof);
	}

	public String[] getFiles (String path) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		String[] filenames = new String[files.length];
		for (int i = 0; i < files.length; i++)
			filenames[i] = files[i].getName();
		return filenames;
	}
}
