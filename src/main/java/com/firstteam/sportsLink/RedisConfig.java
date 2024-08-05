// //package com.firstteam.sportsLink;
// //
// //import org.springframework.context.annotation.Bean;
// //import org.springframework.context.annotation.Configuration;
// //import org.springframework.data.redis.connection.RedisConnectionFactory;
// //import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
// //import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
// //
// //@Configuration
// //@EnableRedisHttpSession
// //public class RedisConfig {
// //
// //    @Bean
// //    public RedisConnectionFactory redisConnectionFactory() {
// //        return new LettuceConnectionFactory("redis.lrmhop.ng.0001.apn2.cache.amazonaws.com", 6379);
// //        //return new LettuceConnectionFactory("redis1.tfcivz.ng.0001.apn2.cache.amazonaws.com", 6379);
// //    }
// //}
//         package com.firstteam.sportsLink;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.data.redis.connection.RedisConnectionFactory;
// import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
// import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
// import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// @Configuration
// @EnableRedisHttpSession
// public class RedisConfig {

//     @Value("${REDIS_HOST}")
//     private String redisHost;
//     private int port = 6379;

//     @Bean
//     public RedisConnectionFactory redisConnectionFactory() {
//         RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
//         redisConfiguration.setHostName(redisHost);
//         redisConfiguration.setPort(port);
//         return new LettuceConnectionFactory(redisConfiguration);
//     }
// }