/*
 * Copyright 2020 by Sriram . All rights reserved.
 * All information contained herein is proprietary and confidential to Sriram .
 *  Any use, reproduction, or disclosure without the written permission of Sriram . is prohibited.
 */
package com.test.cib.commons.validators;

import com.test.cib.commons.data.ModelInterface;
import org.springframework.validation.Errors;


public interface ValidatorInterface {

	boolean validate(ModelInterface model, Errors errors) ;
}
