package com.example.demo.makeVideo;

import org.bytedeco.ffmpeg.global.avcodec;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.Frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;


/**
 * Create 2022/4/18 by Gq
 */
public class SubtitleMix {

    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH🇲🇲ss");
    private static final int VIDEO_WIDTH = 720;
    private static final int VIDEO_HEIGHT = 1280;
    //设置每秒的帧数
    private static final Integer FRAME = 30;
    // 视频帧长度
    private static final int OUT_PUT_LENGTH = FRAME * 40;  // 帧率 * 秒
    // logo位置
    private static final String LOGO_INPUT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/logo.png";
    // 头图路径
    private static final String BANNER_INPUT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/banner.png";
    // 角标路径
    private static final String CORNER_INPUT_PATH ="/Users/gaoqian/Downloads/Movie/test/video/corner.png";
    // 字体路径
    private static final String FONT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/FZYDZHJW.TTF";
    // 文本路径
    private static final String FONT_CONTENT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/content.txt";
    // 输出文件路径
    private static final String OUT_PUT_FILE_PATH = "/Users/gaoqian/Downloads/Movie/test/video/final_out_%s.mp4";
    // 输入文件路径
    private static final String AUDIO_IN_PUT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/sdd-br.mp3";
    // 输入字幕背景文件路径
    private static final String IN_PUT_IMAGE_PATH = "/Users/gaoqian/Downloads/Movie/test/video/bg.png";

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // 1. 先渲染视频
//        String filterContent = "drawtext=fontfile=" + FONT_PATH + ":textfile='" + FONT_CONTENT_PATH + "':y=(0+line_h)-t*20:x=150";
//        String filterContent = "drawtext=fontfile=" + FONT_PATH + ":textfile='" + FONT_CONTENT_PATH + "':line_spacing=20:fontsize=32:x=90:y='if(gte(t,2),h-300-(t-2)*20,h-200)'";
//        String video = createVideo(filterContent);
//        System.out.println(video);
        String video = "/Users/gaoqian/Downloads/Movie/test/video/add_banner_out_1650509878098.mp4";
////        // 2. 再添加音乐
        boolean b = mergeAudioAndVideo(video, "/Users/gaoqian/Downloads/Movie/test/video/music_last_out_" + System.currentTimeMillis() + ".mp4");
//        margeVideo();
//        System.out.println("创建成功： " + b);
//        String video1 = margeMultiVideo("/Users/gaoqian/Downloads/Movie/test/video/music_last_out_1650510121007.mp4", "/Users/gaoqian/Downloads/Movie/test/video/marge_end.mp4");
        System.out.println("共用时： " + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * 合并视频
     */
    private static void margeVideo() throws Exception {
        // 先渲染一个字幕视频
//        String filterContent = "drawtext=fontfile=" + FONT_PATH + ":textfile='" + FONT_CONTENT_PATH + "':fontsize=32:fontcolor=green:y='if(gte(t,2),h-300-(t-2)*30,h-300)':x=100";
//        String video = createVideo(filterContent);
//        System.out.println("创建字幕视频完成：" + video);
        // 获取合并头图后的背景图片
        BufferedImage logo = ImageIO.read(new File(LOGO_INPUT_PATH));
        BufferedImage banner = ImageIO.read(new File(BANNER_INPUT_PATH));
        BufferedImage corner = ImageIO.read(new File(CORNER_INPUT_PATH));
        BufferedImage subtitleImage = createBackgroundImage(logo, banner, corner);
        System.out.println("生成图片完成");
        File outputfile = new File("/Users/gaoqian/Downloads/Movie/test/video/image.jpg");
        boolean jpg = ImageIO.write(subtitleImage, "jpg", outputfile);
        System.out.println("图片保存成功：" + jpg);
        // 合并头图
        String subtitleFile = margeBannerImage(subtitleImage);
        System.out.println(subtitleFile);
//        boolean b = mergeAudioAndVideo(subtitleFile, "/Users/gaoqian/Downloads/Movie/test/video/music-file" + System.currentTimeMillis() + ".mp4");
//        System.out.println(b);
    }

    private static String createVideo(String filterContent) throws IOException {
        String outFileName = String.format(OUT_PUT_FILE_PATH, System.currentTimeMillis());

        FFmpegFrameFilter filter = null;
        FFmpegFrameRecorder recorder = null;
        try {
            // 输入图片流
            BufferedImage read = createSubtitleImage();
            Java2DFrameConverter converter = new Java2DFrameConverter();
            Frame frame = converter.getFrame(read);

            int width = frame.imageWidth;
            int height = frame.imageHeight;

            filter = new FFmpegFrameFilter(filterContent, width, height);
            filter.start();

            // 设置输出路径
            recorder = createOutputFile(outFileName, width, height, 2);
            recorder.start();

            System.out.println("准备开始推流...");
            Frame outFrame;
            for (int j = 0; j < OUT_PUT_LENGTH; j++) {
                filter.push(frame);
                outFrame = filter.pullImage();
                if (outFrame != null) {
                    recorder.record(outFrame);
                }
            }
        } finally {
            // 关闭视频输出流
            if(recorder != null) {
                recorder.stop();
            }
            // 关闭filter
            if(filter != null) {
                filter.stop();
            }
        }
        System.out.println("推流结束...");

        return outFileName;
    }

    /**
     * 合并头图
     */
    private static String margeBannerImage(BufferedImage subtitle) throws IOException {
        String outFileName = "/Users/gaoqian/Downloads/Movie/test/video/add_banner_out_"+ System.currentTimeMillis()+".mp4";
        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameGrabber sourceGrabber = null;
        FFmpegFrameFilter filter = null;
        try {
            // 背景图片的输入流
            BufferedImage read = ImageIO.read(new File("/Users/gaoqian/Downloads/Movie/test/video/image.jpg"));
            Java2DFrameConverter converter = new Java2DFrameConverter();
            Frame bgFrame = converter.getFrame(read);
            // 字幕背景
            BufferedImage subtitleBg = new BufferedImage(720, 900, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = subtitleBg.createGraphics();
            graphics.setBackground(new Color(255, 255, 255));
            graphics.drawImage(subtitleBg, 0, 0, 720, 900, null);
            graphics.fillRect(0, 0, 720, 900);
            graphics.dispose();

            File outputfile = new File("/Users/gaoqian/Downloads/Movie/test/video/subtitleBg.png");
            boolean png = ImageIO.write(subtitleBg, "png", outputfile);

            BufferedImage readPng = ImageIO.read(new File("/Users/gaoqian/Downloads/Movie/test/video/subtitleBg.png"));
            Java2DFrameConverter converter2 = new Java2DFrameConverter();
            Frame subtitleBgFrame = converter2.getFrame(readPng);

            String filterContent="[0:v]scale="+ VIDEO_WIDTH +":"+ VIDEO_HEIGHT +"[bg];[1:v]drawtext=fontfile=" + FONT_PATH + ":fontcolor=black:textfile='" + FONT_CONTENT_PATH + "':fontsize=35:y='if(gte(t,1),300-(t-1)*40,300)':x='(w-text_w)/2',scale=720:900[subtitle];[bg][subtitle]overlay=x=0:y=" + (VIDEO_HEIGHT - 915) + ",format=rgb24[v]";
//            String filterContent = "drawtext=fontfile=" + FONT_PATH + ":fontcolor=black:textfile='" + FONT_CONTENT_PATH + "':fontsize=32:y='if(gte(t,1),300-(t-1)*40,300)':x=0";
//            // 创建输出filter
            filter = new FFmpegFrameFilter(filterContent, VIDEO_WIDTH, VIDEO_HEIGHT);
            filter.setVideoInputs(2);
            filter.start();

            // 创建刻录器
//            recorder = createOutputFile(outFileName, VIDEO_WIDTH, VIDEO_HEIGHT, 2);
            recorder = new FFmpegFrameRecorder(outFileName, VIDEO_WIDTH, VIDEO_HEIGHT, 2);
            recorder.setFormat("mp4");
            recorder.start();

            Frame outFrame;
            for(int i = 0; i < OUT_PUT_LENGTH; i ++) {
                filter.push(0, bgFrame);
                filter.push(1, subtitleBgFrame);
                outFrame = filter.pullImage();
                recorder.record(outFrame);

//                filter.push(bgFrame);
//                outFrame = filter.pullImage();
//                recorder.record(outFrame);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(recorder != null) {
                recorder.stop();
            }
//            if(sourceGrabber != null) {
//                sourceGrabber.stop();
//            }
            if(filter != null) {
                filter.stop();
            }
        }

        return outFileName;
    }

    private static String margeMultiVideo(String file1, String file2) throws FFmpegFrameGrabber.Exception, FFmpegFrameRecorder.Exception {
        String outFileName = "/Users/gaoqian/Downloads/Movie/test/video/final_out_put_" + System.currentTimeMillis() + ".mp4";
        FFmpegFrameRecorder recorder = null;
        FFmpegFrameGrabber file1Grabber = null;
        FFmpegFrameGrabber file2Grabber = null;
        try {
            file1Grabber = new FFmpegFrameGrabber(file1);
            file1Grabber.start();
            file2Grabber = new FFmpegFrameGrabber(file2);
            file2Grabber.start();

            recorder = createOutputFile(outFileName, VIDEO_WIDTH, VIDEO_HEIGHT, file1Grabber.getAudioChannels());
            recorder.start();
            Frame frame1;
            while ((frame1 = file1Grabber.grabFrame()) != null) {
                recorder.record(frame1);
            }
            Frame frame2;
            while ((frame2 = file2Grabber.grabFrame()) != null) {
                recorder.record(frame2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(file1Grabber != null) {
                file1Grabber.stop();
            }
            if(file2Grabber != null) {
                file2Grabber.stop();
            }
            if(recorder != null) {
                recorder.stop();
            }
        }
        return outFileName;
    }

    /**
     * 添加头图角标
     * @param logo
     * @param banner 头图
     * @param corner 角标
     * @return
     */
    private static BufferedImage createBackgroundImage(BufferedImage logo, BufferedImage banner, BufferedImage corner) {
        BufferedImage bufImg = new BufferedImage(VIDEO_WIDTH, VIDEO_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufImg.createGraphics();
        graphics.setPaint(new Color(255, 255, 255));
        graphics.drawImage(bufImg, 0, 0, VIDEO_WIDTH, VIDEO_HEIGHT, null);
        graphics.fillRect(0, 0, VIDEO_WIDTH, VIDEO_HEIGHT);

        // 设置头图
        graphics.drawImage(banner, 0, 0, VIDEO_WIDTH, VIDEO_WIDTH * banner.getHeight() / banner.getWidth(), null);
        // 设置logo背景
        graphics.drawImage(logo, 10, 10, 100, 100, null);
        // 设置角标
        graphics.drawImage(corner, VIDEO_WIDTH - 100, 0, 100, 100, null);

        graphics.dispose();

        return bufImg;
    }

    private static BufferedImage createSubtitleImage() {
        BufferedImage bufImg = new BufferedImage(600, 900, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = bufImg.createGraphics();
        graphics.drawImage(bufImg, 0, 0, 600, 900, null);
        graphics.setPaint(new Color(240, 222, 12, 0));
        graphics.fillRect(0, 0, 600, 900);
        graphics.dispose();

        return bufImg;
    }

    /**
     * 创建录制器
     * @param outFileName
     * @param width
     * @param height
     * @param audioChannel
     * @return
     */
    private static FFmpegFrameRecorder createOutputFile(String outFileName, int width, int height, int audioChannel) {
        // 设置输出路径
        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outFileName, width, height, audioChannel);

        // 视频相关配置，取原视频配置
        recorder.setFrameRate(FRAME);
        //设置视频编码层模式
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
        //设置视频图像数据格式
        recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
        recorder.setVideoBitrate(8000000);
        //视频格式  可以自己选
        recorder.setFormat("mp4");
        return recorder;
    }

    /**
     * 合并音乐
     * @param videoPath
     * @param outPut
     * @return
     * @throws Exception
     */
    private static boolean mergeAudioAndVideo(String videoPath, String outPut) throws Exception {
        boolean isCreated = true;
        File file = new File(videoPath);
        if (!file.exists()) {
            return false;
        }
        FFmpegFrameRecorder recorder = null;
        FFmpegFrameGrabber grabber1 = null;
        FFmpegFrameGrabber grabber2 = null;
        FFmpegFrameFilter filter = null;
        try {
            //抓取视频帧
            grabber1 = new FFmpegFrameGrabber(videoPath);
            //抓取音频帧
            grabber2 = new FFmpegFrameGrabber(SubtitleMix.AUDIO_IN_PUT_PATH);
            grabber1.start();
            grabber2.start();
            //创建录制
            recorder = new FFmpegFrameRecorder(outPut, grabber1.getImageWidth(), grabber1.getImageHeight(),
                    grabber2.getAudioChannels());
            recorder.setFormat("mp4");
            recorder.start();

            long videoLengthTime = grabber1.getLengthInTime();
            filter = new FFmpegFrameFilter("volume='if(lt(t,10),1,max(1-(t-10)/5,0))':eval=frame", grabber2.getAudioChannels());
            filter.start();

            Frame frame1;
            Frame frame2;
            //先录入视频
            while ((frame1 = grabber1.grabFrame()) != null ){
                recorder.record(frame1);
            }
            long audioPlayTime = 0L;
            //然后录入音频
            Frame frame;
            while ((frame2 = grabber2.grabFrame()) != null || audioPlayTime < videoLengthTime) {
                filter.push(frame2);
                frame = filter.pullSamples();
                recorder.setTimestamp(grabber2.getTimestamp());
                recorder.record(frame);
                audioPlayTime = grabber2.getTimestamp();
                if (audioPlayTime >= videoLengthTime) {
                    break;
                }
            }
            grabber1.stop();
            grabber2.stop();
            recorder.stop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (recorder != null) {
                    recorder.release();
                }
                if (grabber1 != null) {
                    grabber1.release();
                }
                if (grabber2 != null) {
                    grabber2.release();
                }
                if(filter != null) {
                    filter.stop();
                }
            } catch (FrameRecorder.Exception e) {
                e.printStackTrace();
            }
        }
        return isCreated;

    }
}
