package com.ssk.haoke.cloud.server.house.api.dto.response;

import com.ssk.haoke.cloud.server.pojo.BasePojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 房源表
 * </p>
 *
 * @author ssk
 * @since 2019-08-01
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "HouseResourcesRespDto", description = "房源请求响应dto对象")
public class  HouseResourcesRespDto extends BasePojo {


    private static final long serialVersionUID = 8129783375107293156L;
    @ApiModelProperty(name = "id" , value = "主键")
    private Long id;
    /**
     * 房源标题
     */
    @ApiModelProperty(name = "title" , value = "标题")
    private String title;

    /**
     * 楼盘id
     */
    @ApiModelProperty(name = "estateId" , value = "楼盘id")
    private Long estateId;

    /**
     * 楼号（栋）
     */
    @ApiModelProperty(name = "buildingNum" , value = "楼号（栋）")
    private String buildingNum;

    /**
     * 单元号
     */
    @ApiModelProperty(name = "buildingNum" , value = "楼号（栋）")
    private String buildingUnit;

    /**
     * 门牌号
     */
    @ApiModelProperty(name = "buildingFloorNum" , value = "门牌号")
    private String buildingFloorNum;

    /**
     * 租金
     */
    @ApiModelProperty(name = "rent" , value = "租金")
    private Integer rent;

    /**
     * 租赁方式，1-整租，2-合租
     */
    @ApiModelProperty(name = "rentMethod" , value = "租赁方式")
    private Integer rentMethod;

    /**
     * 支付方式，1-付一押一，2-付三押一，3-
付六押一，4-年付押一，5-其它
     */
    @ApiModelProperty(name = "paymentMethod" , value = "支付方式")
    private Integer paymentMethod;

    /**
     * 户型，如：2室1厅1卫
     */
    @ApiModelProperty(name = "houseType" , value = "户型")
    private String houseType;

    /**
     * 建筑面积
     */
    @ApiModelProperty(name = "coveredArea" , value = "建筑面积")
    private Integer coveredArea;

    /**
     * 使用面积
     */
    @ApiModelProperty(name = "useArea" , value = "使用面积")
    private String useArea;

    /**
     * 楼层，如：8/26
     */
    @ApiModelProperty(name = "floor" , value = "楼层")
    private String floor;

    /**
     * 朝向：东、南、西、北
     */
    @ApiModelProperty(name = "orientation" , value = "朝向")
    private String orientation;

    /**
     * 装修，1-精装，2-简装，3-毛坯
     */
    @ApiModelProperty(name = "decoration" , value = "装修 1-精装，2-简装，3-毛坯")
    private Integer decoration;

    /**
     * 配套设施， 如：1洗衣机,2冰箱,3空调,4阳台,5卫生间,6电视,7热水器,8宽带,9沙发,10,衣柜
     */
    @ApiModelProperty(name = "facilities" , value = "配套设施如：1洗衣机,2冰箱,3空调,4阳台,5卫生间,6电视,7热水器,8宽带,9沙发,10,衣柜")
    private Map<Long, String> facilities;

    /**
     * 图片，最多5张
     */
    @ApiModelProperty(name = "pic" , value = "图片")
    private String pic;

    @ApiModelProperty(name = "picList" , value = "图片集合")
    private List picList;
    /**
     * 描述
     */
    @ApiModelProperty(name = "houseDesc" , value = "描述")
    private String houseDesc;

    /**
     * 联系人
     */
    @ApiModelProperty(name = "contact" , value = "联系人")
    private String contact;
    /**
     * 联系人
     */
    @ApiModelProperty(name = "contactId" , value = "联系人")
    private Long contactId;
    /**
     * 手机号
     */
    @ApiModelProperty(name = "mobile" , value = "手机号")
    private String mobile;

    /**
     * 看房时间，1-上午，2-中午，3-下午，4-晚上，5-全
天
     */
    @ApiModelProperty(name = "time" , value = "看房时间")
    private String time;

    /**
     * 物业费
     */
    @ApiModelProperty(name = "propertyCost" , value = "物业费")
    private String propertyCost;
    /**
     * 地址
     */
    @ApiModelProperty(name = "address" , value = "地址")
    private String address;

}
