package com.vigoss.readCsvFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Reimu Hakurei
 * @date 2023/1/8 20:04
 */
public class CsvFileDao {

    public CsvFileDao() {
    }

    public List<Event> readAll() throws Exception {
        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
        File file = new File(csvFileName);
        List<Event> events = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            // first line is title
            reader.readLine();
            while (reader.readLine() != null) {
                Event event = CsvFileUtils.eventFromCsvLine(reader.readLine());
                events.add(event);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return events;
    }

    public void write(Event event) throws Exception {
        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
        String csvLine = CsvFileUtils.csvLineFromEvent(event) + "\n";
        File file = new File(csvFileName);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.append(csvLine);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Event read(Long eventId) throws Exception {
        List<Event> events = readAll();
        if (eventId == null) {
            return null;
        }
        for (Event event : events) {
            if (eventId.equals(event.getId())) {
                return event;
            }
        }
        return null;
    }
}
