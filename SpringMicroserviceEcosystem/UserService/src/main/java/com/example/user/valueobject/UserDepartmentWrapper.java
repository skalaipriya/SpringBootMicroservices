package com.example.user.valueobject;

import com.example.user.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDepartmentWrapper {

    private UserInfo userInfo;
    private Department department;
}
