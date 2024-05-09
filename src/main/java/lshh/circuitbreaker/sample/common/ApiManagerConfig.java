package lshh.circuitbreaker.sample.common;

import lshh.circuitbreaker.api.ApiManager;
import lshh.circuitbreaker.api.SimpleApiManager;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;
import lshh.circuitbreaker.sample.infrastructure.zipcode.ZipcodeApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ApiManagerConfig {
    @Bean
    ApiManager<Zipcode> zipcodeApiManager() {
        return new SimpleApiManager<>(List.of(
                new ZipcodeApiClient("naver", ""),
                new ZipcodeApiClient("kakao", "")
        ));
    }
}
