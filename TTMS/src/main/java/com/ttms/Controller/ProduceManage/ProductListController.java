package com.ttms.Controller.ProduceManage;

import com.ttms.Entity.*;
import com.ttms.Vo.PageResult;
import com.ttms.Vo.ProductVo;
import com.ttms.service.ProductManage.IProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//----------产品管理->产品->产品列表------------
@RestController
@RequestMapping("/producemanage/product/productlist")
public class ProductListController {
    @Autowired
    private IProductListService productListService;

    /**
     * 功能描述: <br>
     * 〈〉更新产品的状态【上架，下架，代售】
     * @Param: [productId, pstatus]
     * @Return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: 吴彬
     * @Date: 17:18 17:18
     */
    @PutMapping("/privilege/updateproductStatus")
    public ResponseEntity<Void> updateproductStatus(@RequestParam int productId ,@RequestParam Integer pstatus){
        productListService.updateproductStatus(productId,pstatus);
        return  ResponseEntity.ok().build();
    }

    /**
     * 功能描述: <br>
     * 〈〉查询该产品所有的分销商
     * @Param: [pid]
     * @Return: org.springframework.http.ResponseEntity<java.util.List<com.ttms.Vo.ProductVo>>
     * @Author: 吴彬
     * @Date: 17:17 17:17
     */
    @GetMapping("/distributor/{pid}")
    public ResponseEntity<List<ProductVo>> getDistributorsByPid(@PathVariable("pid") Integer pid){
        return ResponseEntity.ok(this.productListService.getDistributorsByPid(pid));
    }

    /**
     * 功能描述: <br>
     * 〈〉为产品添加分销商
     * @Param: [pid, distributorId, distributorNumber, startTime, endTime]
     * @Return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: 吴彬
     * @Date: 17:29 17:29
     */
    @PostMapping("/privilege/distributor")
    public ResponseEntity<Void> addProductDistribute(Integer productId ,Integer distributorId ,
                                                     Integer distributorNumber, Date startTime, Date endTime){

        //TODO 没有完成需要查询产品的数量是否够分销  需要加一次判断
        this.productListService.addProductDistribute(productId,distributorId,distributorNumber,startTime,endTime);

        return   ResponseEntity.ok().build();
    }

    /**
     * 功能描述: <br>
     * 〈〉分页查询项目
     * @Param: [status, productCatId1, productCatId2, productCatId3, projectName, productNumber, productName, serverStartTime, serverEndTime, page, size]
     * @Return: org.springframework.http.ResponseEntity<com.ttms.Vo.PageResult>
     * @Author: 万少波
     * @Date: 2019/5/31 14:15
     */
    @GetMapping("/page")
    public ResponseEntity<PageResult<ProProduct>>  queryProjectByPage(
            @RequestParam(required = false,defaultValue = "-1") int status,
            @RequestParam(required = false,defaultValue = "-1") int productCatId1,
            @RequestParam(required = false,defaultValue = "-1") int productCatId2,
            @RequestParam(required = false,defaultValue = "-1") int productCatId3,
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) String productNumber,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Date serverStartTime,
            @RequestParam(required = false) Date serverEndTime ,
            @RequestParam(required = false ,defaultValue = "1") int page ,
            @RequestParam(required = false , defaultValue = "5") int size
    ){

        return ResponseEntity.ok(productListService.queryProjectByPage(status,productCatId1,
                productCatId2,productCatId3,projectName,productNumber,productName,serverStartTime,
                serverEndTime,page,size));
    }

    /**
     * 功能描述: <br>
     * 〈〉删除为产品分销的分销商
     * @Param: []
     * @Return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: 万少波
     * @Date: 2019/6/1 13:55
     */
    @DeleteMapping("/privilege/distributor")
    public ResponseEntity<Void> deleteProductDistribute(@RequestParam int productId ,@RequestParam int productDistributorId){
        return ResponseEntity.ok(productListService.deleteProductDistribute(productId,productDistributorId));
    }

    /**
     * 功能描述: <br>
     * 〈〉获取所有的分销商
     * @Param: []
     * @Return: org.springframework.http.ResponseEntity<java.util.List<com.ttms.Entity.SupDistributor>>
     * @Author: 万少波
     * @Date: 2019/6/1 14:39
     */
    @GetMapping("/distributors")
    public ResponseEntity<List<SupDistributor>> getAllDistributorInfo(){
        return ResponseEntity.ok(productListService.getAllDistributorInfo());
    }

    /**
     * 功能描述: <br>
     * 〈〉查询当前产品下所有附件
     * @Param: [pid]
     * @Return: org.springframework.http.ResponseEntity<java.util.List<com.ttms.Entity.ResoAttachment>>
     * @Author: 万少波
     * @Date: 2019/6/1 14:49
     */
    @GetMapping("/allAttachment/{pid}")
    public ResponseEntity<List<ResoAttachment>> getAttachmentsByPid(@PathVariable int pid){
        return ResponseEntity.ok(productListService.getAttachmentsByPid(pid));
    }

    /**
     * 功能描述: <br>
     * 〈〉新增附件
     * @Param: [pid, fileName, attachmentname, attachmentUrl]
     * @Return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: 万少波
     * @Date: 2019/6/1 14:58
     */
    @PostMapping("/privilege/attachment")
    public ResponseEntity<Void> addAttachement(@RequestParam int productId  ,
                                               @RequestParam String fileName ,
                                               @RequestParam String fileUrl,
                                               @RequestParam String attachmentname){
        return ResponseEntity.ok(productListService.addAttachement(productId ,fileName ,fileUrl ,attachmentname));
    }

    /**
     * 功能描述: <br>
     * 〈〉获取和产品关联的所有导游
     * @Param: [pid]
     * @Return: org.springframework.http.ResponseEntity<java.util.List<com.ttms.Entity.ResGuide>>
     * @Author: 万少波
     * @Date: 2019/6/1 20:29
     */
    @GetMapping("/guide/{pid}")
    public ResponseEntity<List<ResGuide>> getGuidesByProductId(@PathVariable Integer pid){
        return ResponseEntity.ok(productListService.getGuidesByProductId(pid));
    }

    /**
     * 功能描述: <br>
     * 〈〉删除产品下面的导游
     * @Param: [productId, guideId]
     * @Return: org.springframework.http.ResponseEntity<java.lang.Void>
     * @Author: 万少波
     * @Date: 2019/6/1 20:35
     */
    @DeleteMapping("/privilege/guide")
    public ResponseEntity<Void> deleteProductGuide(@RequestParam Integer productId  , @RequestParam Integer guideId){
        return ResponseEntity.ok(productListService.deleteProductGuide(productId , guideId));
    }
    
    /**
     * 功能描述: <br>
     * 〈〉分页查询所有我的项目中未添加的导游
     * @Param: [guideName, mobile, language, nationality, page, rows]
     * @Return: org.springframework.http.ResponseEntity<com.ttms.Vo.PageResult<com.ttms.Entity.ProProductGuide>>
     * @Author: 万少波
     * @Date: 2019/6/1 21:19
     */
    @RequestMapping("/guide/page")
    public ResponseEntity<PageResult<ResGuide>>
    queryGuidesNotInProduct(
                           @RequestParam  Integer productId,
                           @RequestParam(required = false)  String guideName ,
                           @RequestParam(required = false) String mobile,
                           @RequestParam(required = false) String language ,
                           @RequestParam(required = false) String nationality,
                           @RequestParam(required = false,defaultValue = "1") int page ,
                           @RequestParam(required = false,defaultValue = "5") int rows){
        return ResponseEntity.ok(productListService.queryGuidesNotInProduct(productId,guideName,mobile,language,nationality,page,rows));
    }
 }
