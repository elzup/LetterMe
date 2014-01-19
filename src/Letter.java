import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Letter {
	private int fromTime;
	private int toTime;

	static int today_num = new Integer(new SimpleDateFormat("yyyyMMdd").format(new Date()));

	public static final int PAST = -1;
	public static final int TODAY = 0;
	public static final int FUTURE = 1;

	public int getFromTime () {
		return this.fromTime;
	}

	public int getToTime () {
		return this.toTime;
	}

	public int getPeriod () {
		return new Integer(this.toTime).compareTo(today_num);
	}

	public String getFilename () {
		return this.fromTime + "_" + this.toString() + ".txt";
	}

	public String getId () {
		return this.fromTime + " " + this.toString();
	}

	public Letter (int fromTime, int toTime) {
		this.fromTime = fromTime;
		this.toTime   = toTime;
	}

	public Letter (String filename) {
		this(new Integer(filename.substring(0, 7)), new Integer(filename.substring(9, 17)));
	}

	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		Field[] fields = this.getClass().getDeclaredFields();
		sb.append("Letter object\n");
		for (Field field : fields) {
			try {
				sb.append(field.getName() + ":" + field.get(this) + "\n");
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static void main(String... args) {
		Letter l = new Letter("20121212_20121214");
		System.out.println(l);
		System.out.println("end");
	}
}
