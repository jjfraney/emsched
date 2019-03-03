package org.jjfflyboy.ministers.model;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class MinisterConstraintTest {

	private static Validator validator;

	@BeforeClass
	static public void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void validatorWorks() {
		Minister minister = Minister.builder().with(m -> {
			m.firstName = null;
			m.lastName = "Flake";
		}).build();
		
		Assert.assertEquals("Got unexpected error", 1, validator.validate(minister).size());
	}

}
