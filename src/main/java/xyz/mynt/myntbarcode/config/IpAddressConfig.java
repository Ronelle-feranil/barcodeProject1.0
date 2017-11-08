package xyz.mynt.myntbarcode.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.security.enabled")
public class IpAddressConfig {
	
	private List<String> ipAddresses;

	public List<String> getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(List<String> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}


}
