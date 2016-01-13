import java.io.IOException;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

public class DefaultIpoccCache implements IpoccCache {
	

	private HazelcastInstance instance;
	private boolean started = false;
	
	private IdGenerator idGenerator;
	
	@Override
	public <K, V> Map<K, V> getMap(String name) {
		return instance.getMap(name);
	}
	
	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void start() {
		try {
			Resource resource = null;
			resource = new ClassPathResource("hazelcast.xml");
			
			Config config = new XmlConfigBuilder(resource.getInputStream()).build();
			
			instance = Hazelcast.newHazelcastInstance(config);
			idGenerator = instance.getIdGenerator("customer-ids");
			
			Hazelcast.setOutOfMemoryHandler(new IpoccHazelcastOutOfMemoryHandler());

			started = true;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void stop() {
		instance.shutdown();
		started = false;
	}
	
	@Override
	public void stop(Runnable callback) {
		this.stop();
	}

	@Override
	public boolean isRunning() {
		return started;
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public long uniqueId() {
		return idGenerator.newId();
	}
}
