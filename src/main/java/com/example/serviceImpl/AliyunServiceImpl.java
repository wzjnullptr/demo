package com.example.serviceImpl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import com.example.service.AliyunService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * oss文件上传实现类
 */
@Service
public class AliyunServiceImpl implements AliyunService {

    @Value("${aliyun.dir.prefix}")
    private String ALIYUN_DIR_PREFIX;
    @Value("${aliyun.oss.bucketName}")
    private String ALIYUN_OSS_BUCKETNAME;
    //设置最多查看五个文件
    private final int MAX_NUM = 5;
    @Autowired
    private OSSClient ossClient;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String uploadFile(MultipartFile file, String storagePath) {
        String fileName = StringUtils.EMPTY;
        String fileUrl = StringUtils.EMPTY;
        try {
            InputStream ins = file.getInputStream();
            //生成唯一的序列id 用于标识文件
            fileName = UUID.randomUUID().toString();
            //创建文件路径
            fileUrl = ALIYUN_DIR_PREFIX + "/" + fileName.replace("-", "") + "-" + storagePath;
            //文件上传
            PutObjectResult result = ossClient.putObject(ALIYUN_OSS_BUCKETNAME, fileUrl, ins);
            if (null != result) {
                return fileUrl;
            }
            //设置公共读
            ossClient.setBucketAcl(ALIYUN_OSS_BUCKETNAME, CannedAccessControlList.PublicRead);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileUrl;
    }

    @Override
    public String deleteFile(String path) {
        try {
            ossClient.deleteObject(ALIYUN_OSS_BUCKETNAME, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    @Override
    public List<OSSObjectSummary> list() {
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(ALIYUN_OSS_BUCKETNAME).withMaxKeys(MAX_NUM));
        List<OSSObjectSummary> ossList = objectListing.getObjectSummaries();
        return ossList;
    }
}
