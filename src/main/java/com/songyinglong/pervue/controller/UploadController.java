package com.songyinglong.pervue.controller;

import com.songyinglong.pervue.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        //文件上传
        if(file!=null && !file.isEmpty()){
            //获取文件的原始名称
            String fileOriginalFilename = file.getOriginalFilename();
            //拼接一个新名称
            String fileName = UUID.randomUUID()+"_"+fileOriginalFilename;

            String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
            fileName = date + "/" + fileName;
            //保存的文件地址
            File destFile = new File("D:\\pic",fileName);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            try {
                //执行保存
                file.transferTo(destFile);
                //头像保存的地址
                return Result.ok(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Result.error(10002,"上传失败");
    }
}
