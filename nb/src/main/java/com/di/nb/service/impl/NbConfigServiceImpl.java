package com.di.nb.service.impl;

import com.di.nb.dao.NbConfigDao;
import com.di.nb.domain.NbConfigBean;
import com.di.nb.service.NbConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class NbConfigServiceImpl implements NbConfigService {

    @Autowired
    private NbConfigDao nbConfigDao;

    @Value("${file.upload-dir}")
    private String path;

    @Override
    public NbConfigBean getConfigByDeviceId(String data){
        return nbConfigDao.getConfigByDeviceId(data);
    }

    @Override
    public String deleteFile(String fileName){
        System.out.println("-------------Deleting single file--------------");

        Path filePath = Paths.get(path+"/"+fileName).toAbsolutePath().normalize();
        System.out.println(filePath);
        File file=new File(filePath.toString());

        if(file.exists()){
            if(file.delete()){
                return "解析包文件删除成功";
            }else{
                return "解析包文件删除失败";
            }
        }
        return "文件不存在";
    }


    @Override
    public List<NbConfigBean> getAllConfig(){
        return nbConfigDao.getAllConfig();
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
    public int deleteConfigService(String data){
        return nbConfigDao.deleteConfig(data);
    }

}
