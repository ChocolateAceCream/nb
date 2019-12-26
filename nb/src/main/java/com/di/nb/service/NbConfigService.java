package com.di.nb.service;

import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.RequestParamsData;

import java.util.List;

public interface NbConfigService {
     List<NbConfigBean> getConfigByDeviceId(RequestParamsData data);
     int insertConfigService(NbConfigBean bean);
     // int updateConfigService(NbConfigBean bean);
     int deleteConfigService(RequestParamsData data);

}
