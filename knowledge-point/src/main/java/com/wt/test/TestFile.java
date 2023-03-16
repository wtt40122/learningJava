package com.wt.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/4/28 16:59
 */
public class TestFile {

//    public static String GetMd5HashFromFile(String fileName)
//    {
//        FileStream file = new FileStream(fileName, FileMode.Open);
//        MD5 md5 = new MD5CryptoServiceProvider();
//        byte[] retVal = md5.ComputeHash(file);
//        file.Close();
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < retVal.Length; i++)
//        {
//            sb.Append(retVal[i].ToString("x2"));
//        }
//        return "";
//    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestFile.class);
        logger.info("test");
    }
}
