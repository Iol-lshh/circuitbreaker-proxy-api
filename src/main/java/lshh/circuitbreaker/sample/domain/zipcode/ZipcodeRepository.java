package lshh.circuitbreaker.sample.domain.zipcode;

import lshh.circuitbreaker.api.exception.ApiConnectException;

import java.util.Optional;

public interface ZipcodeRepository {

    Optional<Zipcode> findZipcodeByAddress(String address);

    void fallback(String address, ApiConnectException exception);
}
