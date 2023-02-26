package com.vigoss.interview;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author Reimu Hakurei
 * @date 2023/1/9 18:53
 */
public class Test2 {

    public final static String CNY = "CNY";
    public final static String HKD = "HKD";
    public final static String JPY = "JPY";
    public final static String EUR = "EUR";
    public final static String GBP = "GBP";

    public final static String FEN = "fen";
    public final static String CENTS = "cents";
    public final static String SEN = "sen";
    public final static String EUROCENTS = "eurocents";
    public final static String PENCE = "pence";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigDecimal result = new BigDecimal(0);
        String x;
        for (int i = 0; i < n; i++) {
            x = sc.next();
            if (x.contains(CNY) || x.contains(FEN)) {
                result = result.add(getFen(x, CNY));
            } else if (x.contains(EUR) || x.contains(EUROCENTS)) {
                result = result.add(getFen(x, EUR));
            } else if (x.contains(HKD) || x.contains(CENTS)) {
                result = result.add(getFen(x, HKD));
            } else if (x.contains(JPY) || x.contains(SEN)) {
                result = result.add(getFen(x, JPY));
            } else if (x.contains(GBP) || x.contains(PENCE)) {
                result = result.add(getFen(x, GBP));
            }
        }
        System.out.println(result.intValueExact());
    }

    private static BigDecimal getFen(String x, String type) {
        BigDecimal res = new BigDecimal(0);
        switch (type) {
            case CNY:
                if (x.contains(CNY)) {
                    String[] s = x.split(CNY);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100));
                    if (s.length > 1) {
                        x = s[1];
                    }
                }
                if (x.contains(FEN)) {
                    String[] s = x.split(FEN);
                    res = res.add(new BigDecimal(s[0]));
                }
                return res;
            case HKD:
                if (x.contains(HKD)) {
                    String[] s = x.split(HKD);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100 * 100).divide(new BigDecimal(123), 2, RoundingMode.HALF_DOWN));
                    if (s.length > 1) {
                        x = s[1];
                    }
                }
                if (x.contains(CENTS)) {
                    String[] s = x.split(CENTS);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100).divide(new BigDecimal(123), RoundingMode.DOWN));
                }
                return res;
            case JPY:
                if (x.contains(JPY)) {
                    String[] s = x.split(JPY);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100 * 100).divide(new BigDecimal(1825), RoundingMode.HALF_DOWN));
                    if (s.length > 1) {
                        x = s[1];
                    }
                }
                if (x.contains(SEN)) {
                    String[] s = x.split(SEN);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100).divide(new BigDecimal(1825), RoundingMode.DOWN));
                }
                return res;
            case EUR:
                if (x.contains(EUR)) {
                    String[] s = x.split(EUR);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100 * 100).divide(new BigDecimal(14), RoundingMode.HALF_DOWN));
                    if (s.length > 1) {
                        x = s[1];
                    }
                }
                if (x.contains(EUROCENTS)) {
                    String[] s = x.split(EUROCENTS);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100).divide(new BigDecimal(14), RoundingMode.DOWN));
                }
                return res;
            case GBP:
                if (x.contains(GBP)) {
                    String[] s = x.split(GBP);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100 * 100).divide(new BigDecimal(12), RoundingMode.HALF_DOWN));
                    if (s.length > 1) {
                        x = s[1];
                    }
                }
                if (x.contains(PENCE)) {
                    String[] s = x.split(PENCE);
                    res = res.add(new BigDecimal(Integer.parseInt(s[0]) * 100).divide(new BigDecimal(12), RoundingMode.DOWN));
                }
                return res;
            default:
                return res;
        }
    }
}
