

import java.util.Map;

import org.springframework.context.SmartLifecycle;

public interface IpoccCache extends SmartLifecycle {
	
	<K, V> Map<K, V> getMap(String name);
	
	long uniqueId();

}
