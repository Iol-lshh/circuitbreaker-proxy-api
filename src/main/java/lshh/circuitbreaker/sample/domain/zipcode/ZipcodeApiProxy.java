package lshh.circuitbreaker.sample.domain.zipcode;

import lshh.circuitbreaker.core.exception.ApiConnectException;

public interface ZipcodeApiProxy {

    Zipcode findZipcodeByAddress(String address);

    void fallback(String address, ApiConnectException exception);
}
