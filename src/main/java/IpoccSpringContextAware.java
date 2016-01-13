import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class IpoccSpringContextAware implements ApplicationContextAware {
	
	public static IpoccCache ipoccCache;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ipoccCache = applicationContext.getBean(IpoccCache.class);
	}
	
	public static IpoccCache getIpoccCache() {
		return ipoccCache;
	}

}
