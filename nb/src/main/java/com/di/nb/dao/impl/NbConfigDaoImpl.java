package com.di.nb.dao.impl;

import com.di.nb.dao.NbConfigDao;
import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.RequestParamsData;
import com.di.nb.mapper.NbConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@SuppressWarnings("all")


@Repository
public class NbConfigDaoImpl implements NbConfigDao {
    @Autowired
    private NbConfigMapper nbConfigMapper;

    @Override
    public List<NbConfigBean> getAllConfig() {
        return nbConfigMapper.getAllConfigMapper();
    }

    @Override
    public NbConfigBean getConfigByDeviceId(String data) {
        //System.out.println(data);
        return nbConfigMapper.getConfigByIdMapper(data);
    }

    @Override
    public int insertConfig(NbConfigBean bean){
        return nbConfigMapper.insertConfigMapper(bean);
    }

    // @Override
    // public int updateConfig(NbConfigBean bean){
    //     return nbConfigMapper.updateConfigMapper(bean);
    // }

    @Override
    public int deleteConfig(String data){
        return nbConfigMapper.deleteConfigMapper(data);
    }



}
