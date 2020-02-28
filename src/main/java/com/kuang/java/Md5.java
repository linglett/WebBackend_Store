package com.kuang.java;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5 {
    public static String getMD5String(String str) {
        return DigestUtils.md5Hex(str);
    }

}
