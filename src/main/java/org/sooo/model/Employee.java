package org.sooo.model;

import com.google.common.base.Objects;

public class Employee {

	private String name;
	private String emailAddress;
	private Department department;
	private Integer yearJoined;

	public Employee(String name, String emailAddress, Department department,
			Integer yearJoined) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.department = department;
		this.yearJoined = yearJoined;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Department getDepartment() {
		return department;
	}

	public Integer getYearJoined() {
		return yearJoined;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this.getClass()).add("name", name)
				.add("emailAddress", emailAddress)
				.add("department", department).add("yearJoined", yearJoined)
				.toString();
	}
}
