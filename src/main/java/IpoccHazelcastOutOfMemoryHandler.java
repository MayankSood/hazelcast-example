
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.OutOfMemoryHandler;
import com.hazelcast.instance.OutOfMemoryErrorDispatcher.Helper;


public class IpoccHazelcastOutOfMemoryHandler extends OutOfMemoryHandler {
	

	@Override
	public void onOutOfMemory(OutOfMemoryError oom, HazelcastInstance[] hazelcastInstances) {
		//log.error("WARNING!!! Hazelcast out of memory", oom);
		for (HazelcastInstance instance : hazelcastInstances) {
            if (instance != null) {
                Helper.tryCloseConnections(instance);
                Helper.tryStopThreads(instance);
                Helper.tryShutdown(instance);
            }
        }
        System.err.println(oom);
	}
}
