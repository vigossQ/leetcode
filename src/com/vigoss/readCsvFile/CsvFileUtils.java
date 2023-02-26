package com.vigoss.readCsvFile;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Reimu Hakurei
 * @date 2023/1/8 20:04
 */
public class CsvFileUtils {

    private static final String CSV_SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public static String csvLineFromEvent(Event event) {
        if (Objects.isNull(event)) {
            return null;
        }
        return event.getId() + CSV_SEPARATOR +
                event.getName() + CSV_SEPARATOR +
                event.getDescription() + CSV_SEPARATOR +
                event.getStart() + CSV_SEPARATOR +
                event.getEnd() + CSV_SEPARATOR;
    }

    public static Event eventFromCsvLine(String csvLine) {
        if (csvLine == null || "".equals(csvLine)) {
            return null;
        }
        try {
            Event event = new Event();
            String[] csvItem = csvLine.split(CSV_SEPARATOR);
            event.setId(Long.valueOf(csvItem[0]));
            event.setName(csvItem[1]);
            event.setDescription(csvItem[2]);
            event.setStart(LocalDateTime.parse(csvItem[3]));
            event.setEnd(LocalDateTime.parse(csvItem[4]));
            return event;
        } catch (Exception e) {
            System.out.println("throws exception, info: \n");
            e.printStackTrace();
            return null;
        }
    }
}
