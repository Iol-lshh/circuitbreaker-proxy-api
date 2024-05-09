package lshh.circuitbreaker.sample.domain.zipcode;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZipcodeService {
    private final ZipcodeRepository api;

    public Optional<Zipcode> findZipcodeByAddress(String address) {
        return api.findZipcodeByAddress(address);
    }
}
