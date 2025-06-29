package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/coinList")
    public String coinList(@RequestParam double targetAmt) {

        double inputAmt = targetAmt;

        // Validate targetAmt
        if (targetAmt <= 0 || targetAmt > 10000) {
            return "Invalid amount. Amount must be between 0 and 10000";
        }

        double[] givenCoinList = {0.01, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 50, 100, 1000};

        List<Double> reduceCoinList = new ArrayList<>();
        for (double coin : givenCoinList) {
            if (coin <= targetAmt) {
                reduceCoinList.add(coin);
            }
        }

        // Reverse order from bigger coin denomination first
        reduceCoinList.sort(Collections.reverseOrder());

        List<Double> outputCoinList = new ArrayList<>();
        int i = 0;
        while (targetAmt > 0 && i < reduceCoinList.size()) {
            double coin = reduceCoinList.get(i);
            if (coin <= targetAmt) {
                outputCoinList.add(coin);
                targetAmt -= coin;
                targetAmt = Math.round(targetAmt * 100.0) / 100.0;
            } else {
                i++;
            }
        }

        // Use DecimalFormat to remove .0 for whole numbers
        DecimalFormat df = new DecimalFormat("#.##");

        String formattedInputAmt = df.format(inputAmt);
        String formattedReduceCoinList = formatListWithDecimalFormat(reduceCoinList, df);
        String formattedOutputCoinList = formatListWithDecimalFormat(outputCoinList, df);

        return "Input:\n" +
                "Target amount: " + formattedInputAmt + "\n" +
                "Coin denominator: " + formattedReduceCoinList + "\n" +
                "Output: " + formattedOutputCoinList;
    }

    private String formatListWithDecimalFormat(List<Double> list, DecimalFormat df) {
        List<String> formattedList = new ArrayList<>();
        for (double d : list) {
            formattedList.add(df.format(d));
        }
        return formattedList.toString();
    }
}
