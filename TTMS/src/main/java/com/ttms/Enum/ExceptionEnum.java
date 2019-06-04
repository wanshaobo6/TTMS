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
    WRONG_OPERATION(444,"请正确操作"),
    FILE_UPLOAD_FAIL(500,"文件上传失败"),
    FILE_SIZE_TOO_LARGE(500,"文件过大"),
    TIME_CONVERTER_ERROR(404,"时间转换错误"),
    NOT_OPERATION_AUTHORITY(403,"您无权创建项目"),
    USER_HAVE_BEEN_LIMIT(403,"您已被禁用"),
    MENUS_ALLOW_ACCESS_IS_NULL(404,"没有可以访问的菜单"),
    SYSTEM_ERROR(555,"系统错误，请正确访问"),
    USERNAME_OR_PASSWORD_ERROR(403,"用户名密码错误"),
    USER_NOT_FOUND(404,"查询用户不存在"),
    USER_NAME_DUPLICATED(501,"用户名重复"),
    USER_DELETE_FAIL(500,"查询用户失败"),
    ROLERS_NOT_FOUND(404,"角色没有找到"),
    INSERT_ROLERS_FAIL(500,"新增角色失败"),
    USER_ADD_FAILURE(500,"添加失败"),
    USER_UPDATE_FAILURE(500,"更新失败"),
    USER_NOT_EXIST(404,"用户不存在"),
    USERNAEME_NOT_EMPTY(500,"负责人不能为空"),
    USER_VALID_MODIFY_ERROR(500,"用户启动状态更新失败"),
    USER_ACCOUNT_LOCK(500,"账户已被锁定"),
    DEPARTMENT_ADD_FAILURE(500,"部门添加失败"),
    DEPARTMENT_NOT_FOUND(404,"部门不存在"),
    GROUP_UPDATE_FAILURE(500,"团信息修改失败"),
    GROUP_NOT_FOUND(404,"团不存在"),
    GROUP_ADD_FAILURE(500,"创建团失败"),
    GROUP_NAME_NULL(500,"团名不能为空"),
    PROJECT_NOT_EXIST(404,"项目不存在"),
    PROJECT_ID_NULL(500,"项目id不能为空"),
    USER_NOT_BELONG_PRODUCT_DEP(403,"用户不属于产品部"),
    DEPARTMENT_NOT_USER(404,"该部门下没有人"),
    USER_NOT_NULL(404,"用户不能为空"),
    GROUP_VALID_MODIFY_ERROR(500,"团启动状态更新失败"),
    PROJECTNAME_NOT_EMPTY(500,"团启动状态更新失败"),
    GROUPNAME_NOT_EMPTY(500,"团名不能为空"),
    USER_NOT_GROUPCHARGEUSER(500,"你不是团的负责人"),
    PROJECTID_NOT_FOUND(500,"ID不存在"),
    PROJECT_UPDATE_FAIL(500,"项目更新失败"),
    PROJECT_INSERT_FAIL(500,"项目新增失败"),
    PROJECT_CODE_NULL(500,"项目编号不能为空"),
    PROJECT_NAME_NULL(500,"项目名称不能为空"),
    DEPATMENT_ID_NULL(500,"部门id不能为空"),
    PROJECT_PROHIBIT_OR_ENABLE_FAIL(500,"更新状态失败"),
    DEPARTMENT_VALID_MODIFY_ERROR(500,"部门启动状态更新失败"),
    NOT_FOUND_ROLERS(404,"没有找到角色"),
    PRODUCTCATID_NOT_FOUND(404,"没有找到该分类"),
    NOT_FOUND_PARENTID(404,"没有找到该分类的父id"),
    PRODUCT_ADD_FAIL(500,"产品添加失败"),
    USER_NOT_GRUOPCHARGEUSER(500,"当前用户不是团的负责人"),
    PRODUCT_ADD_FAILURE(500,"创建产品失败"),
    PRODUCT_EDIT_FAIL(500,"修改产品失败"),
    YOU_CREATE_PRODUCT(500,"你已经创过产品了"),
    PRODUCT_CAT_NOT_FOUNDF(500,"产品分类没有"),
    PRODUCT_CAT_ADD_FAIL(500,"产品分类添加失败"),
    PRODUCT_CAT_EXISTENCE_PRODUCE(500,"该分类下已经存在商品不能删除"),
    PRODUCT_CAT_UPDATE_FAIL(500,"产品分类修改失败"),
    PRODUCT_UPDATE_FAIL(500,"操作失败"),
    PWERMISSION_OPTERATION(500,"你没有权限操作"),
    PRODUCT_NOT_FOUND(404,"产品不存在"),
    NUMBER_NOT_ENOUGH(500,"产品剩余数量不足分销"),
    PRODUCT_UPDATE_NUM_FAIL(404,"产品更新数量失败"),
    INSERT_DISTRIBUTOR_FAIL(404,"新增分销商失败"),
    PRODUCT_ATTACHMENT_NOT_FOUND(404,"产品下不存在附件"),
    PRODUCT_DISTRIBUTOR_NOT_FOUND(404,"没有为该产品分销的分销商"),
    PRODUCTDISTRIBUTOR_NOT_MATCH(401,"产品没有被该分销商分销"),
    SUPDISTRIBUTOR_NOT_FOUND(404,"产品分销商没有找到"),
    ATTACHMENT_INSERT_FAIL(500,"新增附件失败"),
    RESGUIDE_NOT_FOUND(404,"导游不存在"),
    MSG_UPDATE_FALI(404,"消息更新失败"),
    MSG_RELEASE_FALI(404,"消息发布失败"),
    PRODUCT_GUIDE_DELETE_FAIL(500,"产品下的导游删除失败"),
    PRODUCT_GUIDE_ALREADY_EXIST(501,"产品下的导游不能重复增加"),
    PRODUCT_GUIDE_INSERT_FAIL(501,"为产品增加导游失败"),
    PRODUCT_PRICE_POLICY_NOT_FOUND(404,"该产品下没有价格优惠政策"),
    PRODUCT_PRICE_POLICY_DELETE_FAIL(500,"产品下的价格优惠政策删除失败"),
    PRODUCT_PRICE_POLICY_ALREADY_EXIST(501,"产品下的优惠信息不能重复增加"),
    PRODUCT_PRICE_POLICY_INSERT_FAIL(501,"为产品增加优惠政策失败"),
    PRICE_POLICY_NOT_FOUND(404,"价格政策不存在"),
    PRODUCT_ROUTE_SET_FAIL(404,"行程设置失败"),
    PRODUCT_ROUTE_UPDATE_FAIL(404,"行程更新失败")
    ;
    private int status;
    private String message;
}
