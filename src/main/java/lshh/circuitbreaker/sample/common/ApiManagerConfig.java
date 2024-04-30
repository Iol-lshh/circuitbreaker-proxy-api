package lshh.circuitbreaker.sample.common;

import lshh.circuitbreaker.core.ApiManager;
import lshh.circuitbreaker.core.ApiManagerImplement;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;
import lshh.circuitbreaker.sample.infrastructure.zipcode.ZipcodeApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiManagerConfig {
    @Bean
    ApiManager<Zipcode> zipcodeApiManager() {
        return new ApiManagerImplement<>(List.of(
                new ZipcodeApi("naver", ""),
                new ZipcodeApi("kakao", "")
        ));
    }
}
