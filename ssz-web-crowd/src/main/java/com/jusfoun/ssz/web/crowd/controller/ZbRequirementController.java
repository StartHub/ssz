package com.jusfoun.ssz.web.crowd.controller;

import com.jusfoun.ssz.core.utils.ReturnData;
import com.jusfoun.ssz.crowd.api.service.ZbRequirementService;
import com.jusfoun.ssz.crowd.api.vo.ZbRequirementVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author : dengxu
 * @create 2018-07-18 15:28
 **/

@Api(value = "众包需求接口Controller", tags = {"众包需求操作接口"})
@RestController
@RequestMapping("/zbrequire")
public class ZbRequirementController {

    protected Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    ZbRequirementService zbRequirementService;

    @ApiOperation(value = "新增需求", notes = "填写需求必须项[]")
    @PostMapping("/info")
    public ReturnData addZbReq(
//            @ApiParam(name = "title", value = "需求标题", required = true) String title,
//            @ApiParam(name = "contectName", value = "需求联系人", required = true) String contectName,
//            @ApiParam(name = "contectPhone", value = "需求电话", required = true) String contectPhone,
//            @ApiParam(name = "desc", value = "需求描述", required = true) String desc
//            @RequestBody
//            @ApiParam(name = "参数列表", value = "输入JSON格式参数", required = true)
//                    @ModelAttribute(name = "1", value = "2")
            @ApiParam @RequestBody ZbRequirementVo vo
    ) {

        try {
            vo.getZbRequirement().setUserId("1111");
            return zbRequirementService.insertRequirement(vo);
        } catch (Exception e) {
            logger.error("发布需求失败", e);
            return ReturnData.error("发布需求失败");
        }
    }

    /**
     * paramType：参数位置
     * header 对应注解：@RequestHeader
     * query 对应注解：@RequestParam
     * path  对应注解: @PathVariable
     * body 对应注解: @RequestBody
     */
    @ApiOperation(value = "查询需求", notes = "根据ID获取需求信息")
    @ApiImplicitParam(name = "id", value = "需求ID", required = true, paramType = "query", dataType = "Long")
    @GetMapping("/info")
    public ReturnData getZbReq(Long id) {
        try {
            return zbRequirementService.selectById(id);
        } catch (Exception e) {
            logger.error("需求查询失败", e);
            return ReturnData.error("需求查询失败");
        }
    }

    @ApiOperation(value = "更新需求", notes = "填写需求必须项")
    @PutMapping("/info")
    public ReturnData updateZbReq(
            @RequestBody ZbRequirementVo vo
    ) {

        try {
            return zbRequirementService.insertRequirement(vo);
        } catch (Exception e) {
            logger.error("更新需求失败", e);
            return ReturnData.error("更新需求失败");
        }
    }

    @GetMapping("/dev")
    public String testDevtools(){
        return "hao shi ma ni zhi dao ma ?";
    }


}
