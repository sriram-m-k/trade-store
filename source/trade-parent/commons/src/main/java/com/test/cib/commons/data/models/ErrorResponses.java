/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.commons.data.models;

import org.apache.logging.log4j.core.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponses {

	private List<ErrorResponse> errorResponses;

	public List<ErrorResponse> getErrorResponses() {
		return errorResponses;
	}

	public void setErrorResponses(List<ErrorResponse> errorResponses) {
		this.errorResponses = errorResponses;
	}

	public void addErrorRespone(ErrorResponse error)	{
		if(error== null)	{
			return;
		}
		if(Assert.isEmpty(getErrorResponses()))	{
			errorResponses = new ArrayList<ErrorResponse>();
		}
		errorResponses.add(error);
	}
}
