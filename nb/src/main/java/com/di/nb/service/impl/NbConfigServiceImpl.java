package com.di.nb.service.impl;

import com.di.nb.dao.NbConfigDao;
import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.RequestParamsData;
import com.di.nb.service.NbConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class NbConfigServiceImpl implements NbConfigService {

    @Autowired
    private NbConfigDao nbConfigDao;

    @Override
    public List<NbConfigBean> getConfigByDeviceId(RequestParamsData data){
        return nbConfigDao.getConfigByDeviceId(data);
    }

    @Override
    public int insertConfigService(NbConfigBean bean){
        return nbConfigDao.insertConfig(bean);
    }

    // @Override
    // public int updateConfigService(NbConfigBean bean){
    //     return nbConfigDao.updateConfig(bean);
    // }

    @Override
    public int deleteConfigService(RequestParamsData data){
        return nbConfigDao.deleteConfig(data);
    }

}
