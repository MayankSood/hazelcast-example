import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("beans.xml");
		IpoccCache cache = IpoccSpringContextAware.getIpoccCache();
		
//		MyEvent event = new MyEvent();
//		event.setAge("23");
//		event.setName("Minku");
//		
//		cache.getMap(MyEvent.MY_EVENT_STORE).put("Mayank", event);
		
		System.out.println(cache.getMap(MyEvent.MY_EVENT_STORE).get("Mayank"));
	}

}
