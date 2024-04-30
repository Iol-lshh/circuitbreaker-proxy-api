package lshh.circuitbreaker.sample.domain.zipcode;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZipcodeService {
    private final ZipcodeApiProxy api;

    public Zipcode findZipcodeByAddress(String address) {
        return api.findZipcodeByAddress(address);
    }
}
