package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDTO {

    @NotEmpty
    private Integer categoryId;

    @NotEmpty
    private String categoryTitle;

    @NotEmpty
    private String categoryDescription;
}
