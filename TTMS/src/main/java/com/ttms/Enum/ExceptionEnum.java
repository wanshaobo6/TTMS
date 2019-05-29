package com.ttms.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {
    USER_UNLOGIN(403,"您没有登陆"),
    NOT_AUTHORITY(403,"您没有权限访问"),
    SYSTEM_ERROR(555,"系统错误，请正确访问"),
    USERNAME_OR_PASSWORD_ERROR(500,"用户名密码错误"),
    USER_NOT_FOUND(404,"查询用户不存在"),
    USER_DELETE_FAIL(500,"查询用户失败"),
    NOT_FOUND_ROLERS(500,"查询角色失败"),
    INSERT_ROLERS_FAIL(500,"新增角色失败"),
    USER_ADD_FAILURE(500,"添加失败"),
    USER_UPDATE_FAILURE(500,"更新失败"),
    USER_NOT_EXIST(404,"用户不存在"),
    USER_VALID_MODIFY_ERROR(500,"用户启动状态更新失败"),
    USER_ACCOUNT_LOCK(500,"账户已被锁定"),
    DEPARTMENT_ADD_FAILURE(500,"部门添加失败"),
    DEPARTMENT_NOT_FOUND(404,"部门不存在"),
    GROUP_UPDATE_FAILURE(500,"团信息修改失败"),
    GROUP_NOT_FOUND(404,"团不存在"),
    PROJECT_NOT_EXIST(404,"项目不存在"),
    USER_NOT_BELONG_PRODUCT_DEP(403,"用户不属于产品部"),
    GROUP_VALID_MODIFY_ERROR(500,"团启动状态更新失败"),
    ;
    private int status;
    private String message;
}
