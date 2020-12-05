package br.com.employee.system.api.application.validation;

import br.com.employee.system.api.application.validations.CreateEmployeePojoApplicationValidation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
class createEmployeePojoApplicationValidationTests {

	CreateEmployeePojoApplicationValidation createEmployeePojoApplicationValidation = new CreateEmployeePojoApplicationValidation();

	@Test
	void checkCpfThatDontExistInBlacklist() throws IOException {

		boolean Blacklist = createEmployeePojoApplicationValidation.checkBlackList("99999999999");

		assertEquals(false, Blacklist);
	}

	@Test
	void checkCpfFromBlacklist() throws IOException {
		boolean Blacklist = createEmployeePojoApplicationValidation.checkBlackList("75367551041");
		assertTrue(Blacklist);

	}

	@Test
	void checkInvalidBirthDate() {
		LocalDate currentDate = LocalDate.now();

		boolean checkAge = createEmployeePojoApplicationValidation.checkAge(LocalDate.of(2020, 05,06), currentDate);
		assertTrue(checkAge);
	}

	@Test
	void checkValidBirthDate() {
		LocalDate currentDate = LocalDate.now();

		boolean checkAge = createEmployeePojoApplicationValidation.checkAge(LocalDate.of(1998, 05,06), currentDate);
		assertTrue(checkAge);
	}

}
