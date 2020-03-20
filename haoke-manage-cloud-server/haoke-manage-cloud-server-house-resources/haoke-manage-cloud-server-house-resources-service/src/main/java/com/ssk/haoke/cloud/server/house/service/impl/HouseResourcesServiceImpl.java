package com.ssk.haoke.cloud.server.house.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.ssk.haoke.cloud.server.house.api.dto.request.HouseResourcesReqDto;
import com.ssk.haoke.cloud.server.house.api.dto.response.HouseResourcesRespDto;
import com.ssk.haoke.cloud.server.house.eo.EstateEo;
import com.ssk.haoke.cloud.server.house.eo.HouseResourcesEo;
import com.ssk.haoke.cloud.server.house.eo.PageInfo;
import com.ssk.haoke.cloud.server.house.mapper.HouseEstateMapper;
import com.ssk.haoke.cloud.server.house.service.BaseServiceImpl;
import com.ssk.haoke.cloud.server.house.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResourcesEo> implements HouseResourcesService {

    public static final Logger logger = LoggerFactory.getLogger(HouseResourcesServiceImpl.class);
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Resource
    private HouseEstateMapper houseEstateMapper;
    /**
     * @param id
     * @return
     */
    public boolean deleteHouseResources(Long id) {
        return super.deleteById(id) > 0 ? true : false;
    }


    /**
     * @param houseResourcesReqDto
     * @return -1:输入的参数不符合要求，0：数据插入数据库失败，1：成功
     */
    public int saveHouseResources(HouseResourcesReqDto houseResourcesReqDto) {
        // 编写校验逻辑，如果教研不通过，返回-1
        if (StringUtils.isBlank(houseResourcesReqDto.getTitle())) {
            return -1;
        }
        // 其他校验以及逻辑省略 ……
        HouseResourcesEo houseResourcesEo = new HouseResourcesEo();
        BeanUtils.copyProperties(houseResourcesReqDto, houseResourcesEo, HouseResourcesEo.class);
        return super.save(houseResourcesEo);
    }

    /**
     * 查询房源列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<HouseResourcesRespDto> queryHouseResourcesList(String filter, Integer pageNum, Integer pageSize) {
        HouseResourcesEo houseResourcesEo = new HouseResourcesEo();
        try {
            houseResourcesEo = OBJECT_MAPPER.readValue(filter, HouseResourcesEo.class);
        } catch (IOException e) {
            logger.error("string转对象异常：{}",e);
        }

        IPage<HouseResourcesEo> eoIPage = queryPageListByWhere(houseResourcesEo, pageNum, pageSize);
        PageInfo pageInfo = IPage2PageInfo(eoIPage);
        return pageInfo;
    }

    /**
     * 根据id查询房源
     *
     * @param id
     * @return
     */
    public HouseResourcesRespDto queryHouseResourcesById(Long id) {
        HouseResourcesEo houseResourcesEo = super.queryById(id);
        if (null == houseResourcesEo) {
            return null;
        } else {
            HouseResourcesRespDto houseResourcesRespDto = new HouseResourcesRespDto();
            BeanUtils.copyProperties(houseResourcesEo, houseResourcesRespDto,"facilities");
            String facilities = houseResourcesEo.getFacilities();
            if (StringUtils.isNotEmpty(facilities)){
                String[] split = facilities.split(",");
                houseResourcesRespDto.setFacilities(split);
            }
            EstateEo estateEo = houseEstateMapper.selectById(houseResourcesEo.getEstateId());
            houseResourcesRespDto.setAddress(estateEo.getAddress());
            return houseResourcesRespDto;
        }
    }

    @Override
    public PageInfo<HouseResourcesRespDto> getPageByCity(String cityName,Integer pageNum,Integer pageSize) {
        EstateEo estateEo = new EstateEo();
        estateEo.setCity(cityName);
        //查出所有该城市的楼盘
        List<EstateEo> estateEos = houseEstateMapper.selectList(new QueryWrapper<>(estateEo));
        //筛选所有楼盘id
        List<Long> estateIds = estateEos.stream().map(e -> e.getId()).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(estateEos)){
            HouseResourcesEo houseResourcesEo = new HouseResourcesEo();
            QueryWrapper<HouseResourcesEo> queryWrapper = new QueryWrapper<>(houseResourcesEo);
            queryWrapper.in("estate_id",estateIds);
            IPage<HouseResourcesEo> houseResourcesEoIPage = this.queryPageList(queryWrapper, pageNum, pageSize);
            PageInfo<HouseResourcesRespDto> dtoPageInfo = IPage2PageInfo(houseResourcesEoIPage);
            return dtoPageInfo;
        }else {
            return null;
        }
    }

    /**
     * 更新房源
     *
     * @param houseResourcesReqDto
     * @return
     */
    public boolean updateHouseResources(HouseResourcesReqDto houseResourcesReqDto) {
        if (null == houseResourcesReqDto) {
            return false;
        }
        HouseResourcesEo houseResourcesEo = new HouseResourcesEo();
        BeanUtils.copyProperties(houseResourcesReqDto, houseResourcesEo, HouseResourcesEo.class);
        Integer update = super.update(houseResourcesEo);
        return update == 1;
    }

    private PageInfo<HouseResourcesRespDto> IPage2PageInfo(IPage eoIPage) {
        List<HouseResourcesEo> eos = eoIPage.getRecords();
        if (CollectionUtils.isEmpty(eos)){
            return null;
        }
        List<HouseResourcesRespDto> respDtos = Lists.newArrayList();
        for (HouseResourcesEo eo : eos) {
            HouseResourcesRespDto respDto = new HouseResourcesRespDto();
            BeanUtils.copyProperties(eo, respDto);
            String facilities = eo.getFacilities();
            if (StringUtils.isNotEmpty(facilities)){
                String[] split = facilities.split(",");
                respDto.setFacilities(split);
            }
            EstateEo estateEo = houseEstateMapper.selectById(eo.getEstateId());
            respDto.setAddress(estateEo.getAddress());
            respDtos.add(respDto);
        }
        PageInfo<HouseResourcesRespDto> respDtoPage = new PageInfo<>();
        respDtoPage.setRecords(respDtos);
        respDtoPage.setPageNum(Integer.parseInt(String.valueOf(eoIPage.getCurrent())));
        respDtoPage.setPageSize(Integer.parseInt(String.valueOf(eoIPage.getSize())));
        Long total = eoIPage.getTotal();
        respDtoPage.setTotal(total.intValue());
        return respDtoPage;
    }

}