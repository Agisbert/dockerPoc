package org.w00tdevs.messaging.registry;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

/**
 * @author agisbert
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class MessageServiceRegistryApp {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MessageServiceRegistryApp.class, args);
	}
	
	
	/**
	 * @author agisbert
	 *
	 */
	@RestController
	class ServiceInstanceRestController {

		/**
		 * @return
		 */
		@ResponseBody
		@RequestMapping("/services")
		public List<InstanceInfo> serviceInstancesByApplicationName() {
			PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext().getRegistry();
			return registry.getApplications().getRegisteredApplications()
					.stream().map(app -> app.getInstances())
					.flatMap(List::stream)
					.collect(Collectors.toList());
		}
	}
}
