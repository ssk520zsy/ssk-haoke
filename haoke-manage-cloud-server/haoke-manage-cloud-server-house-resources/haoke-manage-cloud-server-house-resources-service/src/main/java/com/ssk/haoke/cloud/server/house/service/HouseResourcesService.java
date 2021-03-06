package com.ssk.haoke.cloud.server.house.service;

import com.ssk.haoke.cloud.server.house.api.dto.request.HouseResourcesReqDto;
import com.ssk.haoke.cloud.server.house.api.dto.response.DropDownRespDto;
import com.ssk.haoke.cloud.server.house.api.dto.response.HouseResourcesListRespDto;
import com.ssk.haoke.cloud.server.house.api.dto.response.HouseResourcesRespDto;
import com.ssk.haoke.cloud.server.house.eo.PageInfo;

import java.util.List;


public interface HouseResourcesService {
    /**
     *
     * @param id
     * @return
     */
    public boolean deleteHouseResources(Long id);
    /**
     * @param houseResourcesReqDto
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    Long saveHouseResources(HouseResourcesReqDto houseResourcesReqDto);

    /**
     * 查询房源列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<HouseResourcesListRespDto> queryHouseResourcesList(String filter, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询房源
     * @param id
     * @return
     */
    HouseResourcesRespDto queryHouseResourcesById(Long id);

    /*
    更新房源
     */
    boolean updateHouseResources(HouseResourcesReqDto houseResourcesReqDto);

    PageInfo<HouseResourcesRespDto> getPageByCity(String cityName,Integer pageNum,Integer pageSize);

    List<DropDownRespDto> getAllCity();

    public void synsHouseData(List<Long> ids);
}