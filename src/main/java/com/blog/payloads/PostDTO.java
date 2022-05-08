package com.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {


    @NotEmpty
    private String postTitle;

    @NotEmpty
    private String content;

    private String imageName;

    private Date date;

    private CategoryDTO category;

    private UserDTO user;





}
