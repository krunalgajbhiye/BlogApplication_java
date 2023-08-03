package com.blog.main.blogApp.RequestResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthRequest {

    private String userName;
    private String password;

}
