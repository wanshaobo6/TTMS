package com.ttms.Controller.SystemManage;

import com.ttms.Entity.SysDepartment;
import com.ttms.Entity.SysMenus;
import com.ttms.Entity.SysRoles;
import com.ttms.Entity.SysUser;
import com.ttms.Vo.PageResult;
import com.ttms.service.SystemManage.SysMenusService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//系统管理->用户权限模块->权限管理
@RestController
@RequestMapping("/sysmanage/userauth/rolemanage")    //类中所有方法访问都需要加上共享
public class RoleManageController {

    @Autowired
    private SysMenusService sysMenusService;


    /**
     * @Description:    分页查询所有角色
     * @param
     * @Author:         吴彬
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<SysRoles>> getRolesByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                               @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                                                               @RequestParam(value = "name", required = false) String name){
        PageResult<SysRoles> list = this.sysMenusService.getRolesByPage(page, rows, name);
        return ResponseEntity.ok(list);

    }

    /**
     * 功能描述: 添加角色为角色分配权限
     * 〈〉
     * @Param: [name, note, menuIds]
     * @Return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: 吴彬
     * @Date: 16:48 16:48
     */
    @PostMapping
    public ResponseEntity<Void> AddRole(@RequestParam("name") String name , @RequestParam(required = false,name = "note") String note ,
                                        @RequestParam(name = "menuIds") List<Integer> menuIds, HttpSession session,@RequestParam("departmentId") Integer departmentId ){
        session.getAttribute("user");
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        this.sysMenusService.AddRole(name,note,menuIds,user.getId(),departmentId);
        return ResponseEntity.ok().body(null);
    }

    /**
     * 功能描述: <br>
     * 〈〉查询并返回所有的菜单树
     * @Param: []
     * @Return: org.springframework.http.ResponseEntity<java.util.List<com.ttms.Entity.SysMenus>>
     * @Author: 万少波
     * @Date: 2019/5/27 15:03
     */
    @GetMapping("/tree")
    public ResponseEntity<List<SysMenus>> getMenusTree(){
        return ResponseEntity.ok(sysMenusService.getSysMenusTree());
    }

//    @GetMapping("getDepartmentBypid")
////    public

    /**
    * 功能描述: <br>
    * 〈〉查询所有的父部门
    * @Param: []
    * @Return: org.springframework.http.ResponseEntity<java.util.List<com.ttms.Entity.SysDepartment>>
    * @Author: 吴彬
    * @Date: 15:46 15:46
     */
    @GetMapping("/allDepartment")
    public ResponseEntity<List<SysDepartment>> queryAllDepartment(){
        return ResponseEntity.ok(this.sysMenusService.queryAllDepartment());
    }



}
