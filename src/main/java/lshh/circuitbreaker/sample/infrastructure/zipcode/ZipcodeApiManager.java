package lshh.circuitbreaker.sample.infrastructure.zipcode;

import lshh.circuitbreaker.core.ApiManager;
import lshh.circuitbreaker.core.ApiManagerImplement;
import lshh.circuitbreaker.core.exception.ApiConnectException;
import lshh.circuitbreaker.sample.domain.zipcode.Zipcode;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ZipcodeApiManager {
    private final ApiManager<Zipcode> apiManager;

    public ZipcodeApiManager() {
        this.apiManager = new ApiManagerImplement<>(List.of(
                new ZipcodeApi("naver", ""),
                new ZipcodeApi("kakao", "")
        ));
    }

    public ZipcodeApi getApi() {
        return apiManager.findAvailableByOrder()
                .flatMap(api -> Optional.of((ZipcodeApi) api))
                .orElseThrow(ApiConnectException::new);
    }
}
