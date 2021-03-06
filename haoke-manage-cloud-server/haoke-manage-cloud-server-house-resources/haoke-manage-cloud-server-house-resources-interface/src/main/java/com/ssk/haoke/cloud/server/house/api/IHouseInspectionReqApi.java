package com.ssk.haoke.cloud.server.house.api;

import com.ssk.haoke.cloud.server.house.api.dto.request.HouseBookingReqDto;
import com.ssk.haoke.cloud.server.house.api.dto.request.HouseInspectionReqReqDto;
import com.ssk.haoke.cloud.server.house.rest.RestResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
* 看房请求表服务接口
*
* @author 代码生成器
*/
@Api(tags = "好客租房管理平台：房源中心")
@FeignClient(name = "${haoke.manage.center.resources.api.name:haoke-manage-center-resources}",
        path = "/v1/houseinspectionreq",
        url = "${haoke.manage.center.resources.api:}")
public interface IHouseInspectionReqApi {

    /**
     * 新增看房请求表
     *
     * @param addReqDto 看房请求表请求对象
     * @return 处理结果
     */
    @PostMapping("")
    @ApiOperation(value = "新增看房请求表", notes = "新增看房请求表")
    RestResponse<Long> addHouseInspectionReq(@RequestBody HouseInspectionReqReqDto addReqDto);

    /**
     * 修改看房请求表
     *
     * @param modifyReqDto 看房请求表请求对象
     * @return 处理结果
     */
    @PutMapping("")
    @ApiOperation(value = "修改看房请求表", notes = "修改看房请求表")
    RestResponse<Void> modifyHouseInspectionReq(@RequestBody HouseInspectionReqReqDto modifyReqDto);

    /**
     * 删除看房请求表
     *
     * @param ids        看房请求表删除数据ID
     * @return 处理结果
     */
    @DeleteMapping("/{ids}")
    @ApiOperation(value = "删除看房请求表", notes = "删除看房请求表")
    RestResponse<Void> removeHouseInspectionReq(@PathVariable("ids") String ids);

    @PostMapping("/commit")
    @ApiOperation(value = "提交租客提交看房预约",notes = "提交租客提交看房预约")
    RestResponse commitBooking(@RequestBody HouseBookingReqDto houseBookingReqDto);

    @PutMapping("/updateStatus")
    @ApiOperation(value = "提交租客提交看房预约",notes = "提交租客提交看房预约")
    RestResponse updateStatus(@RequestParam("bookingStatus") Integer bookingStatus);
}
