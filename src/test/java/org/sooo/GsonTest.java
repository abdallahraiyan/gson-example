package org.sooo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.sooo.model.Department;
import org.sooo.model.Employee;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonTest {

	private Gson gson = new Gson();
	private Gson gsonSerializingNulls = new GsonBuilder().serializeNulls()
			.create();

	@Test
	public void object2Json() {
		// given
		Employee e = new Employee("Soo Philip Kim", "philipjkim@gmail.com",
				Department.DEVELOPMENT, 2012);

		// when
		String jsonString = gson.toJson(e);

		// then
		assertThat(
				jsonString,
				is("{\"name\":\"Soo Philip Kim\",\"emailAddress\":\"philipjkim@gmail.com\",\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}"));
	}

	@Test
	public void object2JsonUsingDefaultGsonWhenNullFieldsExist() {
		// given
		Employee e = new Employee(null, null, Department.DEVELOPMENT, 2012);

		// when
		String jsonString = gson.toJson(e);

		// then
		assertThat(jsonString,
				is("{\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}"));
	}

	@Test
	public void object2JsonUsingNullSerializingGsonWhenNullFieldsExist() {
		// given
		Employee e = new Employee(null, null, Department.DEVELOPMENT, 2012);

		// when
		String jsonString = gsonSerializingNulls.toJson(e);

		// then
		assertThat(
				jsonString,
				is("{\"name\":null,\"emailAddress\":null,\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}"));
	}

	@Test
	public void json2Object() {
		// given
		String jsonString = "{\"name\":\"Soo Philip Kim\",\"emailAddress\":\"philipjkim@gmail.com\",\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}";

		// when
		Employee e = gson.fromJson(jsonString, Employee.class);

		// then
		assertThat(e.getName(), is("Soo Philip Kim"));
		assertThat(e.getEmailAddress(), is("philipjkim@gmail.com"));
		assertThat(e.getDepartment(), is(Department.DEVELOPMENT));
		assertThat(e.getYearJoined(), is(2012));
	}

	@Test
	public void json2ObjectWithNullsUsingDefaultGson() {
		// given
		String jsonString = "{\"name\":null,\"emailAddress\":null,\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}";

		// when
		Employee e = gson.fromJson(jsonString, Employee.class);

		// then
		assertThat(e.getName(), is(nullValue()));
		assertThat(e.getEmailAddress(), is(nullValue()));
		assertThat(e.getDepartment(), is(Department.DEVELOPMENT));
		assertThat(e.getYearJoined(), is(2012));
	}

	@Test
	public void json2ObjectWithNullsUsingNullSerializingGson() {
		// given
		String jsonString = "{\"name\":null,\"emailAddress\":null,\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}";

		// when
		Employee e = gsonSerializingNulls.fromJson(jsonString, Employee.class);

		// then
		assertThat(e.getName(), is(nullValue()));
		assertThat(e.getEmailAddress(), is(nullValue()));
		assertThat(e.getDepartment(), is(Department.DEVELOPMENT));
		assertThat(e.getYearJoined(), is(2012));
	}
}
