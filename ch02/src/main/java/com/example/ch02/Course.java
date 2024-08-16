package com.example.ch02;

import jakarta.validation.constraints.*;


public class Course {

  private long id;
  @NotEmpty
  private String name;
  @NotBlank(message = "카테고리를 정해주세요~!")
  private String category;

//  @Min(value = 1, message = "최소 1이상 이어야 합니다!")
//  @Max(value = 5, message = "최대 5이하 이어야 합니다!")
  @Size(min = 1, max = 5, message = "0과 6 사이의수를 입력~!")
  private String[] rating;

  public void setRating(String[] rating) {
    this.rating = rating;
  }

  private String description;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
