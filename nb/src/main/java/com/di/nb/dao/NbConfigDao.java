package com.di.nb.dao;

import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.RequestParamsData;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NbConfigDao {
    List<NbConfigBean> getConfigByDeviceId(RequestParamsData data);
    int insertConfig(NbConfigBean bean);
    int updateConfig(NbConfigBean bean);
    int deleteConfig(RequestParamsData data);
}

