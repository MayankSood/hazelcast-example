import java.io.Serializable;

public class MyEvent implements Serializable {

	private static final long serialVersionUID = 2733602829562245516L;

	public static final String MY_EVENT_STORE = "my.event.store";

	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
