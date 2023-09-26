package com.gc.system.dvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public
class UserVO {
    private String username;

    private String password;

    private String confirmPassword;
}