package com.test.cib.commons.tests.models;

import com.test.cib.commons.data.ModelInterface;

public class TestModel implements ModelInterface {

	private String testId;

	private String testName;

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
}
