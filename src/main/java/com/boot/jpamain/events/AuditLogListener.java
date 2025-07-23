package com.boot.jpamain.events;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

	@EventListener
	@Order(1)
	public void logRegistration(RegistrationCompleteEvent event) {
		System.out.println("🔍 AUDIT: User registered -> " + event.getStudent().getEmail());
		// Save to audit table (optional)
	}

}
