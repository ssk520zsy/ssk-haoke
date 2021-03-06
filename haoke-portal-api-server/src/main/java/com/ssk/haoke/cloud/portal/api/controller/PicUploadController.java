package com.ssk.haoke.cloud.portal.api.controller;

import com.ssk.haoke.cloud.portal.api.service.impl.PicUploadFileSystemService;
import com.ssk.haoke.cloud.portal.api.vo.PicUploadResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("api/pic/upload")
@Controller
@Api("图片上传")
public class PicUploadController {
    //本地文件存储
    @Autowired
    private PicUploadFileSystemService picUploadService;
    /**
     *
     * @param uploadFile
     * @return
     * @throws Exception
     */
    @PostMapping
    @ResponseBody
    @ApiOperation(value = "图片上传")
    public PicUploadResult upload(@RequestParam("file") MultipartFile uploadFile) throws Exception {
        return this.picUploadService.upload(uploadFile);
    }
}