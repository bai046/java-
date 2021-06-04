package com.example.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagValidator implements ConstraintValidator<Flag, Integer> {
  private String[] values;
  
  @Override
  public void initialize(Flag flag) {
      this.values = flag.value();
  }

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
		boolean isValid = false;
		if (value == null) {
			return false;
		}
		// 遍历校验
		for (int i = 0; i < values.length; i++) {
			if (values[i].equals(String.valueOf(value))) {
				isValid = true;
				break;
			}
		}
		return isValid;
	}

}
