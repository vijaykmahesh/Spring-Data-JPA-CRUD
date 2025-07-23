package com.boot.jpamain.events;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.boot.jpamain.entity.Student;
import com.boot.jpamain.service.EmailService;

@Component
public class RegistrationListener {

	private final EmailService emailService;

	public RegistrationListener(EmailService emailService) {
		this.emailService = emailService;
	}

	// Receives the event object.
	// Calls the EmailService to send mail.
	@EventListener
	@Order(2)
	public void handleRegistrationComplete(RegistrationCompleteEvent event) {
		Student student = event.getStudent();

		String subject = "🎉 Welcome to Our Platform!";
		String htmlContent = """
				<html>
				<body>
				    <h2 style='color: #2e6c80;'>Welcome, %s!</h2>
				    <p>Thank you for registering. We’re happy to have you with us.</p>
				    <p>Click below to login and get started:</p>
				    <a href="https://yourapp.com/login"
				       style="padding: 10px 15px; background-color: #007bff; color: white; text-decoration: none;">
				       Login
				    </a>
				    <br><br>
				    <p style='font-size: 12px; color: gray;'>If you didn’t sign up, you can ignore this email.</p>
				</body>
				</html>
				""".formatted(student.getEmail());

		emailService.sendHtmlEmail(student.getEmail(), subject, htmlContent);
	}

}
