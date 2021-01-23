package com.wt.tmall.thirdparty;

import com.aliyun.oss.OSS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TmallThirdPartyApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private OSS ossClient;

	@Test
	public void uploadImage() throws IOException {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
//		String endpoint = "oss-cn-beijing.aliyuncs.com";
//		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
//		String accessKeyId = "LTAI4G2FLaijpsLoJ8JyGAcy";
//		String accessKeySecret = "nx8rnaFpOprp56BrMxn4xyZO4GyLwq";
		String bucketName = "wttoss";
		String fileUrl = "C:\\Users\\wangtao\\Desktop\\图片\\美女\\10.jpg";
		String objectName = "10.jpg";
		// 创建OSSClient实例。
//		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		// 上传文件流。
		InputStream inputStream = new FileInputStream(fileUrl);
		ossClient.putObject(bucketName, objectName, inputStream);
		// 关闭OSSClient。
		ossClient.shutdown();

		System.out.println("上传完成...");
	}

}
