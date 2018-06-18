package org.w00tdevs.messaging.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

/**
 * @author agisbert
 *
 */
public class MessagePrinterConfig {

	  @Autowired
	  IClientConfig ribbonClientConfig;

	  @Bean
	  public IPing ribbonPing(IClientConfig config) {
	    return new PingUrl(false, "/health");
	  }

	  @Bean
	  public IRule ribbonRule(IClientConfig config) {
	    return new AvailabilityFilteringRule();
	  }

}
