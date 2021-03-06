package com.ssk.haoke.cloud.server.house.api.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
* 看房请求表Eo对象
*
* @author 代码生成器
*/
@Data
@ApiModel(value = "HouseInspectionReqReqDto", description = "看房请求表dto对象")
public class HouseInspectionReqReqDto{

    /**
    *  主键
    */
    @ApiModelProperty(name = "id", value = "主键")
    private Long id;

    /**
    *  用户id（tb_user）
    */
    @ApiModelProperty(name = "userId", value = "用户id（tb_user）")
    private Long userId;

    /**
    *  房源id（tb_house_resources）
    */
    @ApiModelProperty(name = "houseResoucesId", value = "房源id（tb_house_resources）")
    private Long houseResoucesId;

    /**
    *  看房时间
    */
    @ApiModelProperty(name = "inspectionTime", value = "看房时间")
    private Date inspectionTime;

    /**
    *  请求时间
    */
    @ApiModelProperty(name = "reqTime", value = "请求时间")
    private Date reqTime;

    /**
    *  请求状态（0、待确认 1、待看房 2、已确认 3、已取消）
    */
    @ApiModelProperty(name = "reqStatus", value = "请求状态（0、待确认 1、待看房 2、已确认 3、已取消）")
    private Integer reqStatus;
    @ApiModelProperty(name = "reqStatus", value = "请求状态（0、待确认 1、待看房 2、已确认 3、已取消）")
    private String reqMsg;

    /**
    *  
    */
    @ApiModelProperty(name = "created", value = "")
    private Date created;

    /**
    *  
    */
    @ApiModelProperty(name = "updated", value = "")
    private Date updated;

}