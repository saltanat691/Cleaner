package com.spo.service;

import com.spo.model.CleanerRequest;
import com.spo.model.CleanerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CleanerService {

    public List<CleanerResponse> calculate(CleanerRequest input) {

        return input.getRooms().stream()
                .map(room -> this.calculate(room, input.getSenior(), input.getJunior()))
                .collect(Collectors.toList());
    }

    private CleanerResponse calculate(Integer room, Integer senior, Integer junior) {
        return calcMaxAmountSenior(room, senior, junior);
    }

    private CleanerResponse calcMaxAmountSenior (Integer room, Integer senior, Integer junior) {
        CleanerResponse result = new CleanerResponse();
        int amountSenior = room/senior;

        if (amountSenior <=1) {
            result.addSenior(1);
            room -=senior;
        } else {
            result.addSenior(amountSenior-1);
            room -=senior*(amountSenior-1);
        }

        return calcLeftCapacity(room, senior, junior, result);
    }

    private CleanerResponse calcLeftCapacity (Integer room, Integer senior, Integer junior, CleanerResponse result) {
        if (room <= senior) {
            if (room <= junior) result.addJunior(1);
            else result.addSenior(1);
        } else {
            if (room - 2*junior <= 0) {
                result.addJunior(2);
            } else {
                if (room - senior -junior <= 0) {
                    result.addSenior(1); result.addJunior(1);
                } else result.addSenior(2);
            }
        }
        return result;
    }
}
