package com.example.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.validation.Flag;

public class UserDTO {

  @NotNull(message = "姓名不能为空")
  private String name;

  @NotNull(message = "年龄不能为空")
  @Max(value = 120, message = "最大值不能大于120")
  @Min(value = 18, message = "最小值不能低于18")
  private Integer age;
  
  @NotNull(message = "标识位不能为空")
  @Flag(value = {"0", "2", "3"})
  private Integer flag;
  
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
