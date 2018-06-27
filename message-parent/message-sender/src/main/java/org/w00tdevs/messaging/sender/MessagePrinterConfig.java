package org.w00tdevs.messaging.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;

/**
 * @author agisbert
 *
 */
public class MessagePrinterConfig {

	  @Autowired
	  IClientConfig ribbonClientConfig;

	  @Bean
	  public IRule ribbonRule(IClientConfig config) {
	    return new AvailabilityFilteringRule();
	  }

}
