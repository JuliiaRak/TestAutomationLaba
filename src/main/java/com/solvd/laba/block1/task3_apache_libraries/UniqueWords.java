package com.solvd.laba.block1.task3_apache_libraries;

import com.solvd.laba.block1.task2_oop.DeliveryService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueWords {

    private static final Logger LOGGER = LogManager.getLogger(DeliveryService.class);

    public static void main(String[] args) {
        try {
            String wordsFromFileInString = FileUtils.readFileToString(new File("java.txt"), StandardCharsets.UTF_8);
            String[] wordsFromFile = StringUtils.split(wordsFromFileInString);
            Set<String> uniqueWordsFromFile = new HashSet<>(Arrays.asList(wordsFromFile));
            int uniqueWordCount = uniqueWordsFromFile.size();
            FileUtils.writeStringToFile(new File("uniqueWords.txt"), String.valueOf(uniqueWordCount), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Error in UniqueWords class " + e.getMessage());
        }
    }
}
