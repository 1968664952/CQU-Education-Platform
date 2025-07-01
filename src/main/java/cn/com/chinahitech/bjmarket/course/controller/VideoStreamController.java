package cn.com.chinahitech.bjmarket.course.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Map;

@RestController
@RequestMapping("/video")
public class VideoStreamController {

    private static final String VIDEO_DIR = "src/main/resources/static/video/";

    @PostMapping("/play")
    public void streamVideo(@RequestBody Map<String, String> requestMap,
                            HttpServletRequest request,
                            HttpServletResponse response) throws IOException {

        String fileName = requestMap.get("fileName");
        if (fileName == null || fileName.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        File videoFile = new File(VIDEO_DIR + fileName);
        if (!videoFile.exists()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String range = request.getHeader("Range");
        long start = 0;
        long end = videoFile.length() - 1;

        if (range != null && range.startsWith("bytes=")) {
            String[] parts = range.substring(6).split("-");
            try {
                start = Long.parseLong(parts[0]);
                if (parts.length > 1) {
                    end = Long.parseLong(parts[1]);
                }
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
        }

        long contentLength = end - start + 1;

        response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
        response.setContentType("video/mp4");
        response.setHeader("Accept-Ranges", "bytes");
        response.setHeader("Content-Range", String.format("bytes %d-%d/%d", start, end, videoFile.length()));
        response.setHeader("Content-Length", String.valueOf(contentLength));

        try (RandomAccessFile raf = new RandomAccessFile(videoFile, "r");
             OutputStream os = response.getOutputStream()) {

            raf.seek(start);
            byte[] buffer = new byte[8192];
            long remaining = contentLength;
            int len;
            while ((len = raf.read(buffer)) != -1 && remaining > 0) {
                if (remaining < len) {
                    len = (int) remaining;
                }
                os.write(buffer, 0, len);
                remaining -= len;
            }
        }
    }
}
