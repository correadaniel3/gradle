package co.ceiba.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.ceiba.domain.Person;
import co.ceiba.testdatabuilder.PersonTestDataBuilder;

public class NotifyPersonServiceTest {
	private NotifyPersonService notifyPersonService;
	private EmailService emailService;

	@Before
	public void setup() {
		emailService = new EmailService();
		
		//OR
		//emailService = Mockito.mock(EmailService.class);
		//Mockito.when(emailService.sendMail(Mockito.anyString())).thenReturn("Hola mundo");

		notifyPersonService = new NotifyPersonService(emailService);
	}
	
	@Test
	public void notifyTest() {
		Person person = new PersonTestDataBuilder().build();
		String message = notifyPersonService.notify(person);
		Assert.assertNotNull(message);
	}

}
