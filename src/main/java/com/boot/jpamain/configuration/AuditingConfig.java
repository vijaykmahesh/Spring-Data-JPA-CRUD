package com.boot.jpamain.configuration;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfig {

	@Bean
	public AuditorAware<String> auditorProvider() {
		return () -> Optional.of("admin"); // Replace for real use
	}

}
