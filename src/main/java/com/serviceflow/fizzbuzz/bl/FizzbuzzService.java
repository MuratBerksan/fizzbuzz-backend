package com.serviceflow.fizzbuzz.bl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.serviceflow.fizzbuzz.model.FizzbuzzModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FizzbuzzService {

    public FizzbuzzModel convertToFizzbuzz(List<Integer> inputSequence) throws JsonProcessingException {

        StringBuilder stringBuilder = new StringBuilder();

        for (Integer item : inputSequence) {

            if (item % 3 == 0 && item % 5 == 0) {
                stringBuilder.append("Fizz Buzz");
            } else if (item % 3 == 0) {
                stringBuilder.append("Fizz");
            } else if (item % 5 == 0) {
                stringBuilder.append("Buzz");
            } else {
                stringBuilder.append(item);
            }

            stringBuilder.append(",");
        }

        FizzbuzzModel convertedFizzbuzz = new FizzbuzzModel();
        convertedFizzbuzz.setFizzBuzz(stringBuilder.toString().replaceAll(",$", ""));

        return convertedFizzbuzz;
    }
}
