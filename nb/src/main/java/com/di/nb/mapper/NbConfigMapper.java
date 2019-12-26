package com.di.nb.mapper;

import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.RequestParamsData;
//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
public interface NbConfigMapper {
    //@Select("SELECT * FROM nb_config WHERE deviceId = ${deviceId}")
    List<NbConfigBean> getConfigMapper(RequestParamsData data);

    int insertConfigMapper(NbConfigBean bean);
    // int updateConfigMapper(NbConfigBean bean);
    int deleteConfigMapper(RequestParamsData data);

    //@Insert("insert into nb_config(gatewayId) values(#{gatewayId}")
    //int insert(@Param("gatewayId") String gatewayId);
}

