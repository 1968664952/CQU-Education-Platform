package cn.com.chinahitech.bjmarket.utils;


import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;

public class VideoMetadataUtil {

    /**
     * 获取视频时长（秒）
     * @param filePath 视频文件本地路径（如：D:/project/static/video/2025/07/03/1.9.mp4）
     * @return 时长（秒），失败返回 0.0
     */
    public static double getDuration(String filePath) {
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(filePath)) {
            grabber.start();
            long durationInMicroseconds = grabber.getLengthInTime(); // 微秒
            grabber.stop();
            return durationInMicroseconds / 1_000_000.0; // 转换为秒
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
            return 0.0; // 失败时返回默认值
        }
    }

    /**
     * 获取视频分辨率（宽x高）
     * @param filePath 视频文件本地路径
     * @return 分辨率字符串（如 "1920x1080"），失败返回 "Unknown"
     */
    public static String getResolution(String filePath) {
        try (FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(filePath)) {
            grabber.start();
            int width = grabber.getImageWidth();
            int height = grabber.getImageHeight();
            grabber.stop();
            return width + "x" + height;
        } catch (FrameGrabber.Exception e) {
            e.printStackTrace();
            return "Unknown";
        }
    }
}