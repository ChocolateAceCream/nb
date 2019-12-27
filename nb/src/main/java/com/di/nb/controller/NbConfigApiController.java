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

    /**since there is a file in uploading http request, the request body has to be of type
     * form-data, so @RequestBody annotation cannot be applied here. in order to encapsulate request params,
     * only way is to customize your own annotation, such as @FormData, which should be done later
     *
     * 因为上传的http请求包含文件，所以请求的body必须是 form-data， 所以@RequestBody不可用。封装这种请求的唯一方法
     * 是定制自己的标注，比如@FormData
     * */
    @PostMapping(value="/config/uploadFile")
    public ResultJson uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam String deviceId,
            @RequestParam String gatewayId,
            @RequestParam String serviceType,
            @RequestParam String serviceId,
            @RequestParam String isParsing,
            @RequestParam String parseField,
            @RequestParam String parseJarClass,
            @RequestParam String parseJarMethod,
            @RequestParam String isBaseDecode,
            @RequestParam String storageFields,
            @RequestParam String isCallback,
            @RequestParam String appId,
            @RequestParam String method,
            @RequestParam String callbackUrl,
            @RequestParam String maxRetransmit,
            @RequestParam String expireTime,
            @RequestParam String callbackFieldsKey,
            @RequestParam String callbackFieldsValues
            ) {
        //System.out.println(deviceId + " ----- " + gatewayId);
        NbConfigBean config = new NbConfigBean();
        config.setDeviceId(deviceId);
        config.setGatewayId(gatewayId);
        config.setServiceType(serviceType);
        config.setServiceId(serviceId);
        config.setIsParsing(isParsing);
        config.setParseField(parseField);
        config.setParseJarClass(parseJarClass);
        config.setParseJarMethod(parseJarMethod);
        config.setIsBaseDecode(isBaseDecode);
        config.setStorageFields(storageFields);
        config.setIsCallback(isCallback);
        config.setAppId(appId);
        config.setMethod(method);
        config.setCallbackUrl(callbackUrl);
        config.setMaxRetransmit(maxRetransmit);
        config.setExpireTime(expireTime);
        config.setCallbackFieldsKey(callbackFieldsKey);
        config.setCallbackFieldsValues(callbackFieldsValues);

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

    @RequestMapping(value="/config/get",method=RequestMethod.GET)
    public ResultJson getConfig() {
        ResultJson json = new ResultJson();
        List<NbConfigBean> bean = nbConfigService.getAllConfig();
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

    // @PostMapping(value="/config/update")
    // public ResultJson updateConfig(@RequestBody NbConfigBean config) {
    //     ResultJson json = new ResultJson();
    //     int result = nbConfigService.updateConfigService(config);
    //     System.out.println(result);

    //     if (result == 1) {
    //         json.setResult(CODE);
    //         json.setMsg("success！!!!");
    //         json.setResult(result);
    //     }else {
    //         json.setResult(ERRORCODE);
    //         json.setMsg("fail！");
    //         json.setResult(null);
    //     }
    //     return json;
    // }

    @RequestMapping(value="/config/delete",method=RequestMethod.DELETE)
    //@PostMapping(value="/config/delete")
    //public ResultJson deleteConfig(@RequestBody RequestParamsData data) {
    public ResultJson deleteConfig(@RequestParam String deviceId) {
        ResultJson json = new ResultJson();
        NbConfigBean bean = nbConfigService.getConfigByDeviceId(deviceId);
        if(bean==null){
            json.setStatus(400);
            json.setResult("error");
            json.setMsg("deviceId错误，数据没找到");
        } else {
            String msg = nbConfigService.deleteFile(bean.getParseJarClass());
            int count = nbConfigService.deleteConfigService(deviceId);
            int code = 200;
            code = count >= 0 ? 200 : 400;
            if(count > 0){
                msg += ",sql删除成功！";
            }else{
                msg += ",sql删除失败！";
            }
            json.setStatus(code);
            json.setResult(count);
            json.setMsg(msg);
        }
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
