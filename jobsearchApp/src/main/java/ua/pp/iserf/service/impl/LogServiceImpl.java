package ua.pp.iserf.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Service;
import ua.pp.iserf.service.LogService;
import ua.pp.iserf.util.FileSizeUtil;

@Service
public class LogServiceImpl implements LogService {

    private final float FILE_SIZE_LIMIT = 3;

    @Override
    public String getContent() {

        String content = "";
        float logFileSize = FileSizeUtil.getFileSizeInMB(getLoggerFileName());
        if (logFileSize > FILE_SIZE_LIMIT) {
            return "File size is over then " + FILE_SIZE_LIMIT
                    + " size is:" + logFileSize
                    + " you can't use the browser";
        }

        try {
            content = readFile(getLoggerFileName(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            content = "Log file not found!";
        }

        return content;
    }

    private String getLoggerFileName() {
        return System.getProperty("catalina.base") + File.separator +"logs" + File.separator + "jobsearch.log";
    }

    private String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
