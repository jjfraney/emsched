package org.jjfflyboy.ministers.model;

import java.util.function.Consumer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class Minister {
	private String firstName;
	private String lastName;
	
	public Minister() {}
	public Minister(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
	}
	
	@NotBlank
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@NotBlank
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	public static class Builder {
		public String firstName;
		public String lastName;
		public Builder with(Consumer<Builder> function) {
			function.accept(this);
			return this;
		}
		public Minister build() {
			return new Minister(this);
		}
	}

}
