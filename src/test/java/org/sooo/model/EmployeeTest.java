package org.sooo.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void testToString() {
		// given
		Employee e = new Employee("John Doe", "john.doe@email.com",
				Department.ACCOUNTING, 2009);

		// when
		String result = e.toString();

		// then
		assertThat(
				result,
				is("Employee{name=John Doe, emailAddress=john.doe@email.com, department=ACCOUNTING, yearJoined=2009}"));
	}
}
