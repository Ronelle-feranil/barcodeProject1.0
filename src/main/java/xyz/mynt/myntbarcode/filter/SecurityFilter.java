package xyz.mynt.myntbarcode.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import xyz.mynt.myntbarcode.config.IpAddressConfig;

/**
 * Security Filter that will handle unauthorized access by URL 
 * 
 * @author karl.cubilo
 *
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityFilter.class);
	
//	private static final boolean CONDITION = true;
	
	@Autowired
	private IpAddressConfig ipAddressConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("Initiating WebFilter >> ");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if (ipAddressConfig.isActivated()) {
			
			List<String> ipConfigList = ipAddressConfig.getIpAddresses();
			
			String localAddress = request.getLocalAddr();
			
			 boolean match = ipConfigList.stream().anyMatch(string -> localAddress.equals(string));
			 
			 if(match) {
				 
				 chain.doFilter(request, response); 
			 } else {
				 
				 ((HttpServletResponse)response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			 }
			
		} else {
//			((HttpServletResponse) response)
//				.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			chain.doFilter(request, response);
		}
	}
	
	@Override
	public void destroy() {
		logger.debug("Destroying WebFilter >> ");
	}
}	