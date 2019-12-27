package com.di.nb.service;

import com.di.nb.domain.NbConfigBean;
import com.di.nb.domain.RequestParamsData;

import java.util.List;

public interface NbConfigService {
     NbConfigBean getConfigByDeviceId(String data);
     String deleteFile(String fileName);
     List<NbConfigBean> getAllConfig();
     int insertConfigService(NbConfigBean bean);
     // int updateConfigService(NbConfigBean bean);
     int deleteConfigService(String data);

}
