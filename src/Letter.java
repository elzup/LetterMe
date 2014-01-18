import java.lang.reflect.Field;


public class Letter {
	private int fromTime;
	private int toTime;

	public int getFromTime () {
		return this.fromTime;
	}

	public int getToTime () {
		return this.toTime;
	}

	public String getFilename () {
		return this.fromTime + "_" + this.toString();
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
