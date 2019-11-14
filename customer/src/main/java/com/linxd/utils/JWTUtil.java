package com.linxd.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author linxd
 * @date 2019/11/13 15:00
 * Description: No Description
 */
public class JWTUtil {
    public static final String SECRET_KEY = "123456"; //秘钥
    public static final long TOKEN_EXPIRE_TIME = 5 * 60 * 1000; //token过期时间
    public static final long REFRESH_TOKEN_EXPIRE_TIME = 10 * 60 * 1000; //refreshToken过期时间
    private static final String ISSUER = "linxd"; //签发人

    /**
     * 生成签名
     * @param accId
     * @return
     */
    public static String generateToken(String accId){
        Date now = new Date();
        //算法
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

        String token = JWT.create()
                .withIssuer(ISSUER) //签发人
                .withIssuedAt(now) //签发时间
                .withExpiresAt(new Date(now.getTime() + TOKEN_EXPIRE_TIME)) //过期时间
                .withClaim("accId", accId) //保存身份标识
                .sign(algorithm);
        return token;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static boolean verify(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY); //算法
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 从token获取account
     */
    public static String getAccount(String token){
        try{
            return JWT.decode(token).getClaim("accId").asString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return "";
    }
}
