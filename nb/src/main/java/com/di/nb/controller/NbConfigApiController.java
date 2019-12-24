package com.di.nb.controller;

import com.di.nb.domain.*;
import com.di.nb.service.FileStorageService;
import com.di.nb.service.NbConfigService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;


@RestController
@RequestMapping("/rest")
public class NbConfigApiController{
    private static int CODE = 200;
    private static int ERRORCODE = 400;

    //@Autowired
    //private NbConfigDao nbConfigDao;
    @Autowired
    private NbConfigService nbConfigService;

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping(value="/config/uploadFile")
    public ResultJson uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam String device_id,
            @RequestParam String device_name
            ) {
        //System.out.println(device_id + " ----- " + device_name);
        NbConfigBean config = new NbConfigBean();
        config.setDevice_id(device_id);
        config.setDevice_name(device_name);
        String fileName = fileStorageService.storeFile(file);
        int result = nbConfigService.insertConfigService(config);
        ResultJson json = new ResultJson();
        //System.out.println(result);
        if (result == 1) {
            json.setResult(CODE);
            json.setMsg(fileName+ "uploaded success!");
            json.setResult(result);
        }else {
            json.setResult(ERRORCODE);
            json.setMsg("fail！");
            json.setResult(null);
        }
        return json;
    }

    //@PostMapping(value="/config/uploadFile")
    //public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    //    String fileName = fileStorageService.storeFile(file);
    //
    //    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
    //            .path("/downloadFile/")
    //            .path(fileName)
    //            .toUriString();
    //    return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    //}

    @PostMapping(value="/config/get")
    public ResultJson getConfig(@RequestBody RequestParamsData data) {
        ResultJson json = new ResultJson();
        List<NbConfigBean> bean = nbConfigService.getConfigByDeviceId(data);
        if (bean.size() > 0) {
            json.setResult(CODE);
            json.setMsg("success！!!!");
            json.setResult(bean);
        }else {
            json.setResult(ERRORCODE);
            json.setMsg("fail！");
            json.setResult(null);
        }
        return json;
    }

    //@PostMapping(value="/config/new")
    //public ResultJson getConfig(@RequestBody NbConfigBean config) {
    //    ResultJson json = new ResultJson();
    //    int result = nbConfigService.insertConfigService(config);
    //    System.out.println(result);
    //
    //    if (result == 1) {
    //        json.setResult(CODE);
    //        json.setMsg("success！!!!");
    //        json.setResult(result);
    //    }else {
    //        json.setResult(ERRORCODE);
    //        json.setMsg("fail！");
    //        json.setResult(null);
    //    }
    //    return json;
    //}

    @PostMapping(value="/config/update")
    public ResultJson updateConfig(@RequestBody NbConfigBean config) {
        ResultJson json = new ResultJson();
        int result = nbConfigService.updateConfigService(config);
        System.out.println(result);

        if (result == 1) {
            json.setResult(CODE);
            json.setMsg("success！!!!");
            json.setResult(result);
        }else {
            json.setResult(ERRORCODE);
            json.setMsg("fail！");
            json.setResult(null);
        }
        return json;
    }

    @RequestMapping(value="/config/delete",method=RequestMethod.DELETE)
    //@PostMapping(value="/config/delete")
    public ResultJson deleteConfig(@RequestBody RequestParamsData data) {
        ResultJson json = new ResultJson();
        int count = nbConfigService.deleteConfigService(data);
        int code = 200;
        String msg = "";
        code = count >= 0 ? 200 : 400;
        if(count > 0){
            msg = "删除成功！";
        }else{
            msg = "删除失败！";
        }
        json.setStatus(code);
        json.setResult(count);
        json.setMsg(msg);
        return json;
    }



    //@GetMapping(value = "/hello")
    //@ResponseStatus(HttpStatus.OK)
    //public ResultJson text8( ) {
    //    System.out.println("hh");
    //    ResultJson json=new ResultJson();
    //    json.setStatus(CODE);
    //    json.setMsg("请求成功！");
    //    json.setResult(null);
    //    return json;
    //}
}
