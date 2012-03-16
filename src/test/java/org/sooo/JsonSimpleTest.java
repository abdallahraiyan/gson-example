package org.sooo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;

import com.google.common.collect.Maps;

public class JsonSimpleTest {

	@Test
	public void map2Json() {
		// given
		Map<String, Object> map = Maps.newLinkedHashMap();
		map.put("name", "Soo Philip Kim");
		map.put("emailAddress", "philipjkim@gmail.com");
		map.put("department", "DEVELOPMENT");
		map.put("yearJoined", 2012);

		// when
		String jsonString = JSONValue.toJSONString(map);

		// then
		assertThat(
				jsonString,
				is("{\"name\":\"Soo Philip Kim\",\"emailAddress\":\"philipjkim@gmail.com\",\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}"));
	}

	@Test
	public void json2Object() {
		// given
		String jsonString = "{\"name\":\"Soo Philip Kim\",\"emailAddress\":\"philipjkim@gmail.com\",\"department\":\"DEVELOPMENT\",\"yearJoined\":2012}";

		// when
		JSONObject object = (JSONObject) JSONValue.parse(jsonString);

		// then
		@SuppressWarnings("unchecked")
		Set<String> keySet = object.keySet();
		for (String key : keySet) {
			Object value = object.get(key);
			System.out.printf("%s=%s (%s)\n", key, value, value.getClass()
					.getSimpleName());
		}

		assertThat(object.get("name").toString(), is("Soo Philip Kim"));
		assertThat(object.get("emailAddress").toString(),
				is("philipjkim@gmail.com"));
		assertThat(object.get("department").toString(), is("DEVELOPMENT"));
		assertThat(object.get("yearJoined").toString(), is("2012"));
	}
}
