import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;


public class LetterMe extends JFrame {
	public Manager manager;
	public JList<String> list;
	public LetterMe() {

		manager = new Manager();
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Letter letter : manager.getLetters()) {
			System.out.println(letter.getFilename());
			model.addElement(letter.getFilename());
		}
		list = new JList<String>(model);

		JPanel pane = (JPanel) this.getContentPane();
		pane.add(list);
		pane.add(new JLabel("test"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 640, 480);
		setTitle("LetterMe");
		setVisible(true);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("LetterMe Object\n");
		sb.append(this.manager.toString());
		return sb.toString();
	}

	public static void main(String... args) {
		LetterMe lm = new LetterMe();
//		System.out.println(lm);
	}
}
