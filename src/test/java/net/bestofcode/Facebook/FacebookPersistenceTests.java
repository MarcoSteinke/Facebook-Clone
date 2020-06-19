package net.bestofcode.Facebook;

import net.bestofcode.Facebook.model.User;
import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.model.profile.Password;
import net.bestofcode.Facebook.model.profile.Username;
import net.bestofcode.Facebook.persistence.FormData;
import net.bestofcode.Facebook.service.DatabaseService;
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

	@Test
	void contextLoads() {
	}

	@Test
	void loadOneUserFromDB() {
		User user = User.create("Marco", "foobar", "marco@gmail.com");
		this.databaseService.insertIntoDB(user);

		User loadedUser = this.databaseService.getFromDB(new Username("Marco"));

		assertEquals("", user.getUsername().getValue(), loadedUser.getUsername().getValue());

	}

	@Test
	void passwordIsAlwaysHashedTheSameWay() {
		String initialPassword = "foobar";
		User user = User.create("Marco", initialPassword, "marco@gmail.com");
		UUID salt = user.getPassword().getSalt();

		Password password = new Password(initialPassword, salt);

		assertEquals("", user.getPassword().getEncryptedPassword(), password.getEncryptedPassword());
	}

	@Test
	void passwordIsPersistedAsEncryptedSaltedHash() {
		String initialPassword = "foobar";
		String initialName = "Marco";
		User user = User.create(initialName, initialPassword, "marco@gmail.com");
		UUID salt = user.getPassword().getSalt();
		this.databaseService.insertIntoDB(user);

		User receivedUser = this.databaseService.getFromDB(new Username(initialName));

		assertEquals("", receivedUser.getPassword().getEncryptedPassword(), new Password(initialPassword, salt).getEncryptedPassword());
	}

	@Test
	void invalidFormDataIsInvalid() {
		FormData formData = new FormData(null, null, null);

		assertEquals("", formData.isValid(), false);
	}

	@Test
	void validFormDataIsValid() {
		FormData formData = new FormData(new Username("Marco"), new Email("q@gmail.com"), new Password("password"));

		assertEquals("", formData.isValid(), true);
	}



}
