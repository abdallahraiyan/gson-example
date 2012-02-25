package org.sooo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sooo.model.Department;
import org.sooo.model.Employee;

import com.google.gson.Gson;

public class GsonTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Gson gson = new Gson();

	@Test
	public void object2Json() {
		// given
		Employee e = new Employee("Soo Philip Kim", "philipjkim@gmail.com",
				Department.DEVELOPMENT, 2012);

		// when
		String jsonString = gson.toJson(e);

		// then
		logger.info(jsonString);
	}

	@Test
	public void json2Object() {
		// given
		String jsonString = "{\"name\":\"Soo Philip Kim\",\"emailAddress\":\"philipjkim@gmail.com\",\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}";

		// when
		Employee e = gson.fromJson(jsonString, Employee.class);

		// then
		logger.info(e.toString());
		assertThat(e.getName(), is("Soo Philip Kim"));
		assertThat(e.getEmailAddress(), is("philipjkim@gmail.com"));
		assertThat(e.getDepartment(), is(Department.DEVELOPMENT));
		assertThat(e.getYearJoined(), is(2012));
	}
}
