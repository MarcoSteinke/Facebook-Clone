package net.bestofcode.Facebook;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.model.profile.Username;
import net.bestofcode.Facebook.persistence.forms.LoginFormData;
import net.bestofcode.Facebook.persistence.forms.RegistrationFormData;
import net.bestofcode.Facebook.service.DatabaseService;
import net.bestofcode.Facebook.service.LoginService;
import net.bestofcode.Facebook.service.RegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class FacebookPersistenceTests {

	@Autowired
	DatabaseService databaseService;
	@Autowired
	RegistrationService registrationService;
	@Autowired
	LoginService loginService;

	@Test
	void contextLoads() {
	}

	@Test
	void loadOneUserFromDB() {
		User user = User.create("Marco", "foobar", UUID.randomUUID(), "marco@gmail.com");
		this.databaseService.insertIntoDB(user);

		User loadedUser = this.databaseService.getUserByUsername(new Username("Marco"));

		assertEquals("", user.getUsername().getValue(), loadedUser.getUsername().getValue());

	}

	@Test
	void passwordIsAlwaysHashedTheSameWay() {
		String initialPassword = "foobar";
		Password password = new Password(initialPassword);
		User user = User.create("Marco", initialPassword, password.getSalt(), "marco@gmail.com");
		UUID salt = user.getPassword().getSalt();

		Password comparePassword = new Password(initialPassword, salt);

		assertEquals("", user.getPassword().getEncryptedPassword(), comparePassword.getEncryptedPassword());
	}

	@Test
	void passwordIsPersistedAsEncryptedSaltedHash() {
		String initialPassword = "foobar";
		String initialName = "Marco";
		Password password = new Password(initialPassword);
		User user = User.create(initialName, initialPassword, password.getSalt(), "marco@gmail.com");
		UUID salt = user.getPassword().getSalt();
		this.databaseService.insertIntoDB(user);

		User receivedUser = this.databaseService.getUserByUsername(new Username(initialName));

		assertEquals("", receivedUser.getPassword().getEncryptedPassword(), new Password(initialPassword, salt).getEncryptedPassword());
	}

	@Test
	void invalidFormDataIsInvalid() {
		RegistrationFormData registrationFormData = new RegistrationFormData(null, null, null);

		assertEquals("", registrationFormData.isValid(), false);
	}

	@Test
	void validFormDataIsValid() {
		RegistrationFormData registrationFormData = new RegistrationFormData(new Username("Marco"), new Email("q@gmail.com"), new Password("password"));

		assertEquals("", registrationFormData.isValid(), true);
	}

	@Test
	void invalidLoginFormDataIsInvalid() {
		UUID uuid = UUID.randomUUID();
		LoginFormData loginFormData = new LoginFormData(null, new Password("password", uuid));

		assertEquals("", loginFormData.isValid(), false);
	}

	@Test
	void validLoginFormDataIsValid() {
		UUID uuid = UUID.randomUUID();
		LoginFormData loginFormData = new LoginFormData(new Email("test@gmail.com"), new Password("password", uuid));

		assertEquals("", loginFormData.isValid(), true);
	}

	@Test
	void passwordVerificationIsValid() {
		UUID salt = UUID.randomUUID();
		String dummyPassword = "foobar";
		Password password= new Password(dummyPassword, salt);
		Email email = new Email("peter@gmail.com");
		RegistrationFormData registrationFormData = new RegistrationFormData(new Username("Peter"), email, password);
		registrationService.registerUser(registrationFormData);
		LoginFormData loginFormData = new LoginFormData(email, password);

		User registeredUser = this.loginService.loginUser(loginFormData);

		System.out.println(registeredUser.getPassword() + ", " + password.getEncryptedPassword());

		assertEquals("", registeredUser.getPassword().getEncryptedPassword(), password.getEncryptedPassword());

	}



}
