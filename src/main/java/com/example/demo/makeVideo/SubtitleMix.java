//package com.example.demo.makeVideo;
//
//import org.bytedeco.ffmpeg.global.avcodec;
//import org.bytedeco.ffmpeg.global.avutil;
//import org.bytedeco.javacv.*;
//import org.bytedeco.javacv.Frame;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//
//
///**
// * Create 2022/4/18 by Gq
// */
//public class SubtitleMix {
//
//    private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH🇲🇲ss");
//    private static final int VIDEO_WIDTH = 720;
//    private static final int VIDEO_HEIGHT = 1280;
//    //设置每秒的帧数
//    private static final Integer FRAME = 30;
//    // 视频时间长度 秒
//    private static final Integer TIME_LENGTH = 62;
//    // 视频帧长度
//    private static final int OUT_PUT_LENGTH = FRAME * TIME_LENGTH;  // 帧率 * 秒
//
//    private static final int LAST_AUDIO_DOWN = 4;
//    // logo位置
//    private static final String LOGO_INPUT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/logo.png";
//    // 头图路径
//    private static final String BANNER_INPUT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/banner.png";
//    // 角标路径
//    private static final String CORNER_INPUT_PATH ="/Users/gaoqian/Downloads/Movie/test/video/corner.png";
//    // 字体路径
//    private static final String FONT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/FZYDZHJW.TTF";
//    // 文本路径
//    private static final String FONT_CONTENT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/content.txt";
//    // 输出文件路径
//    private static final String OUT_PUT_FILE_PATH = "/Users/gaoqian/Downloads/Movie/test/video/final_out_%s.mp4";
//    // 输入文件路径
////    private static final String AUDIO_IN_PUT_PATH = "/Users/gaoqian/Downloads/Movie/test/video/lrq-cf.mp3";
//    private static final String AUDIO_IN_PUT_PATH = "/Volumes/WorkFiles/test/upload/audio/142bd6b25fff4c5c82c2565847d5acf6.mp3";
//    // 输入字幕背景文件路径
//    private static final String IN_PUT_IMAGE_PATH = "/Users/gaoqian/Downloads/Movie/test/video/bg.png";
//
//    private static final String REMIX_MATE_PATH = "/Volumes/WorkFiles/test/upload/remix/99ff867451f84a51b85c31b069d20bc9.mp4";
//
//    public static void main(String[] args) throws Exception {
//        long start = System.currentTimeMillis();
//        margeVideo();
////        String inFile1 = "/Users/gaoqian/Downloads/Movie/test/video/add_banner_out_1651722165148.mp4";
////        String inFile2 = "/Users/gaoqian/Downloads/Movie/test/video/marge_end.mp4";
////        String inFile2 = "/Users/gaoqian/Downloads/Movie/test/video/fade_out_put_1651722377316.mp4";
////        getVideoFrameRate(inFile1);
////        testFade("/Users/gaoqian/Downloads/Movie/test/video/marge_end.mp4");
////        margeMultiVideo(inFile1, inFile2);
////        concatVideo(inFile1, inFile2, "/Users/gaoqian/Downloads/Movie/test/video/test_concat_video.mp4");
////        testDrawText();
//        System.out.println("共用时： " + (System.currentTimeMillis() - start) + " ms");
//    }
//
//    /**
//     * 合并视频
//     */
//    private static void margeVideo() throws Exception {
//        // 合并背景图片
////        BufferedImage logo = ImageIO.read(new File(LOGO_INPUT_PATH));
////        BufferedImage banner = ImageIO.read(new File(BANNER_INPUT_PATH));
////        BufferedImage corner = ImageIO.read(new File(CORNER_INPUT_PATH));
////        BufferedImage subtitleImage = createBackgroundImage(logo, banner, corner);
////        System.out.println("生成图片完成");
////        // 保存背景图
////        File outputfile = new File("/Users/gaoqian/Downloads/Movie/test/video/image.jpg");
////        boolean jpg = ImageIO.write(subtitleImage, "jpg", outputfile);
////        // 合并头图
////        String subtitleFile = margeBannerImage(subtitleImage);
////        System.out.println(subtitleFile);
//
////        // 合并音乐
//        String musicVideo = mergeAudioAndVideo("/Volumes/WorkFiles/test/create/videos/temp/scroll_9633ab727c7e4e3f9053a5ffc1c5773b.mp4", "/Users/gaoqian/Downloads/Movie/test/video/music-file" + System.currentTimeMillis() + ".mp4");
//        System.out.println(musicVideo);
////        // 合并结尾视频
////        String video1 = margeMultiVideo(musicVideo, "/Users/gaoqian/Downloads/Movie/test/video/marge_end.mp4");
////        System.out.println(video1);
//    }
//
//    /**
//     * 合并头图
//     */
//    private static String margeBannerImage(BufferedImage subtitle) throws IOException {
//        String outFileName = "/Users/gaoqian/Downloads/Movie/test/video/add_banner_out_"+ System.currentTimeMillis()+".mp4";
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameFilter filter = null;
//        try {
//            // 背景图片的输入流
//            BufferedImage read = ImageIO.read(new File("/Users/gaoqian/Downloads/Movie/test/video/image.jpg"));
//            Java2DFrameConverter converter = new Java2DFrameConverter();
//            Frame bgFrame = converter.getFrame(read);
//            // 字幕背景
//            BufferedImage subtitleBg = new BufferedImage(720, 880, BufferedImage.TYPE_INT_RGB);
//            Graphics2D graphics = subtitleBg.createGraphics();
//            graphics.setBackground(new Color(255, 255, 255));
//            graphics.drawImage(subtitleBg, 0, 0, 720, 880, null);
//            graphics.fillRect(0, 0, 720, 880);
//            graphics.dispose();
//
//            File outputfile = new File("/Users/gaoqian/Downloads/Movie/test/video/subtitleBg.png");
//            boolean png = ImageIO.write(subtitleBg, "png", outputfile);
//
//            BufferedImage readPng = ImageIO.read(new File("/Users/gaoqian/Downloads/Movie/test/video/subtitleBg.png"));
//            Java2DFrameConverter converter2 = new Java2DFrameConverter();
//            Frame subtitleBgFrame = converter2.getFrame(readPng);
//
//            String filterContent="[0:v]scale="+ VIDEO_WIDTH +":"+ VIDEO_HEIGHT +"[bg];[1:v]drawtext=fontfile=" + FONT_PATH + ":line_spacing=15:fontsize=36:fontcolor=black:textfile='" + FONT_CONTENT_PATH + "':y='if(gte(t,1),300-(t-1)*60,300)':x='(w-text_w)/2',scale=720:880[subtitle];[bg][subtitle]overlay=x=0:y=" + (VIDEO_HEIGHT - 915) + ",format=rgb24,fade=type=out:st=57:d=5:alpha=1[v]";
////            String filterContent = "drawtext=fontfile=" + FONT_PATH + ":fontcolor=black:textfile='" + FONT_CONTENT_PATH + "':fontsize=32:y='if(gte(t,1),300-(t-1)*40,300)':x=0";
//            // 创建输出filter
//            filter = new FFmpegFrameFilter(filterContent, VIDEO_WIDTH, VIDEO_HEIGHT);
//            filter.setVideoInputs(2);
//            filter.start();
//
//            // 创建刻录器
//            recorder = new FFmpegFrameRecorder(outFileName, VIDEO_WIDTH, VIDEO_HEIGHT, 2);
//            recorder.setVideoQuality(1L);
//            recorder.setFrameRate(FRAME);
//            recorder.setVideoBitrate(8000000);
//            recorder.setFormat("mp4");
//            recorder.start();
//
//            Frame outFrame;
//            for(int i = 0; i < OUT_PUT_LENGTH; i ++) {
//                filter.push(0, bgFrame);
//                filter.push(1, subtitleBgFrame);
//                outFrame = filter.pullImage();
//                recorder.record(outFrame);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(recorder != null) {
//                recorder.stop();
//            }
//            if(filter != null) {
//                filter.stop();
//            }
//        }
//
//        return outFileName;
//    }
//
//    private static void testDrawText() throws Exception {
//        String outFileName = "/Users/gaoqian/Downloads/Movie/test/video/test_remix_out_"+ System.currentTimeMillis()+".mp4";
//        FFmpegFrameGrabber grabber = null;
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameFilter filter = null;
//        try {
//            grabber = new FFmpegFrameGrabber(REMIX_MATE_PATH);
//            grabber.start();
////            String filterContent="[0:v]scale="+ VIDEO_WIDTH +":"+ VIDEO_HEIGHT +"[bg];[1:v]drawtext=fontfile=" + FONT_PATH + ":line_spacing=15:fontsize=36:fontcolor=black:textfile='" + FONT_CONTENT_PATH + "':y='if(gte(t,1),300-(t-1)*60,300)':x='(w-text_w)/2',scale=720:880[subtitle];[bg][subtitle]overlay=x=0:y=" + (VIDEO_HEIGHT - 915) + ",format=rgb24,fade=type=out:st=57:d=5:alpha=1[v]";
////            String filterContent = "drawtext=fontfile=" + FONT_PATH + ":fontcolor=black:textfile='" + FONT_CONTENT_PATH + "':fontsize=32:y='if(gte(t,1),300-(t-1)*40,300)':x=0";
//            String moveLCharFilterContent = "drawtext=fontfile=" + FONT_PATH + ":fontcolor=red:text='我是一条字幕，我是一条字幕我是一条字幕我是一条字幕我是一条字幕':fontsize=32:y=150:x=150";
//            // 创建输出filter
//            filter = new FFmpegFrameFilter(moveLCharFilterContent, VIDEO_WIDTH, VIDEO_HEIGHT);
//            filter.start();
//
//            // 创建刻录器
//            recorder = new FFmpegFrameRecorder(outFileName, VIDEO_WIDTH, VIDEO_HEIGHT, 2);
//            recorder.setVideoQuality(1L);
//            recorder.setFrameRate(FRAME);
//            recorder.setVideoBitrate(8000000);
//            recorder.setFormat("mp4");
//            recorder.start();
//
//            Frame outFrame;
////            for(int i = 0; i < OUT_PUT_LENGTH; i ++) {
////                filter.push(0, bgFrame);
////                filter.push(1, subtitleBgFrame);
////                outFrame = filter.pullImage();
////                recorder.record(outFrame);
////            }
//            while ((outFrame = grabber.grabFrame()) != null) {
//                filter.push(outFrame);
//                Frame frame = filter.pullImage();
//                if(frame != null && frame.image != null) {
//                    recorder.record(frame);
//                }
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(grabber != null) {
//                grabber.stop();
//            }
//            if(recorder != null) {
//                recorder.stop();
//            }
//            if(filter != null) {
//                filter.stop();
//            }
//        }
//    }
//
//
//    private static String margeMultiVideo(String file1, String file2) throws FFmpegFrameGrabber.Exception, FFmpegFrameRecorder.Exception {
//        String outFileName = "/Users/gaoqian/Downloads/Movie/test/video/final_out_put_" + System.currentTimeMillis() + ".mp4";
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameGrabber file1Grabber = null;
//        FFmpegFrameGrabber file2Grabber = null;
//        FFmpegFrameFilter margeFilter = null;
//        try {
//            file1Grabber = new FFmpegFrameGrabber(file1);
//            file1Grabber.start();
//            file2Grabber = new FFmpegFrameGrabber(file2);
//            file2Grabber.start();
//            String filterContent = "[0:v][1:v]xfade=transition=fade:duration=2:offset=2[out]";
//            margeFilter = new FFmpegFrameFilter(filterContent, VIDEO_WIDTH, VIDEO_HEIGHT);
//            margeFilter.start();
//
//            recorder = createOutputFile(outFileName, VIDEO_WIDTH, VIDEO_HEIGHT, file1Grabber.getAudioChannels());
//            recorder.start();
//
//            Frame frame1;
//            Frame frame2;
//            Frame outFrame;
//
//            while ((frame1 = file1Grabber.grabFrame()) != null) {
//                margeFilter.push(0,frame1);
//                frame2 = file2Grabber.grabFrame();
//                margeFilter.push(1,frame2);
//                outFrame = margeFilter.pullImage();
//                recorder.record(outFrame);
//            }
//
////            while ((frame2 = file2Grabber.grabFrame()) != null) {
////                margeFilter.push( frame2);
////                outFrame = margeFilter.pullImage();
////                recorder.record(outFrame);
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if(file1Grabber != null) {
//                file1Grabber.stop();
//            }
//            if(file2Grabber != null) {
//                file2Grabber.stop();
//            }
//            if(recorder != null) {
//                recorder.stop();
//            }
//        }
//        return outFileName;
//    }
//
//    /**
//     * 添加头图角标
//     * @param logo
//     * @param banner 头图
//     * @param corner 角标
//     * @return
//     */
//    private static BufferedImage createBackgroundImage(BufferedImage logo, BufferedImage banner, BufferedImage corner) {
//        int times = 2;
//        BufferedImage bufImg = new BufferedImage(VIDEO_WIDTH * times, VIDEO_HEIGHT * times, BufferedImage.TYPE_INT_RGB);
//        Graphics2D graphics = bufImg.createGraphics();
//        graphics.setPaint(new Color(255, 255, 255));
//        graphics.drawImage(bufImg, 0, 0, VIDEO_WIDTH * times, VIDEO_HEIGHT * times, null);
//        graphics.fillRect(0, 0, VIDEO_WIDTH * times, VIDEO_HEIGHT * times);
//
//        // 设置头图
//        graphics.drawImage(banner, 0, 0, VIDEO_WIDTH * times, VIDEO_WIDTH * times * banner.getHeight() / banner.getWidth(), null);
//        // 设置logo背景
////        graphics.drawImage(logo, 10, 10, 70 * times, 70 * times, null);
//        // 设置角标
//        graphics.drawImage(corner, VIDEO_WIDTH * times - 70 * times, 0, 70 * times, 70 * times, null);
//
//        graphics.dispose();
//
//        return bufImg;
//    }
//
//    /**
//     * 创建录制器
//     * @param outFileName
//     * @param width
//     * @param height
//     * @param audioChannel
//     * @return
//     */
//    private static FFmpegFrameRecorder createOutputFile(String outFileName, int width, int height, int audioChannel) {
//        // 设置输出路径
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outFileName, width, height, 2);
//
//        // 视频相关配置，取原视频配置
//        recorder.setFrameRate(FRAME);
//        //设置视频编码层模式
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//        //设置视频图像数据格式
//        recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//        recorder.setVideoBitrate(80000000);
//        recorder.setVideoQuality(0L);
//        //视频格式  可以自己选
//        recorder.setFormat("mp4");
//        return recorder;
//    }
//
//    /**
//     * 合并音乐
//     * @param videoPath
//     * @param outPut
//     * @return
//     * @throws Exception
//     */
//    private static String mergeAudioAndVideo(String videoPath, String outPut) throws Exception {
//        File file = new File(videoPath);
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameGrabber grabber1 = null;
//        FFmpegFrameGrabber grabber2 = null;
//        FFmpegFrameFilter filter = null;
//        try {
//            //抓取视频帧
//            grabber1 = new FFmpegFrameGrabber(videoPath);
//            //抓取音频帧
//            grabber2 = new FFmpegFrameGrabber(SubtitleMix.AUDIO_IN_PUT_PATH);
//            grabber1.start();
//            grabber2.start();
//            //创建录制
//            recorder = new FFmpegFrameRecorder(outPut, grabber1.getImageWidth(), grabber1.getImageHeight(), 2);
//            //设置视频编码层模式
//            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//            //设置视频图像数据格式
//            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//            recorder.setVideoBitrate(8000000);
//            recorder.setFormat("mp4");
//            recorder.start();
//
//            long videoLengthTime = grabber1.getLengthInTime();
//            filter = new FFmpegFrameFilter("volume='if(lt(t," + (TIME_LENGTH - LAST_AUDIO_DOWN) + "),1,max(1-(t-" + (TIME_LENGTH - LAST_AUDIO_DOWN) +  ")/" + LAST_AUDIO_DOWN + ",0.2))':eval=frame", grabber2.getAudioChannels());
//            filter.start();
//
//            Frame frame1;
//            Frame frame2;
//            //先录入视频
//            while ((frame1 = grabber1.grabFrame()) != null ){
//                recorder.record(frame1);
//            }
//            long audioPlayTime = 0L;
//            //然后录入音频
//            Frame frame;
//            while ((frame2 = grabber2.grabFrame()) != null || audioPlayTime < videoLengthTime) {
//                filter.push(frame2);
//                frame = filter.pullSamples();
//                recorder.setTimestamp(grabber2.getTimestamp());
//                recorder.record(frame);
//                audioPlayTime = grabber2.getTimestamp();
//                if (audioPlayTime >= videoLengthTime) {
//                    break;
//                }
//            }
//            grabber1.stop();
//            grabber2.stop();
//            recorder.stop();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (recorder != null) {
//                    recorder.release();
//                }
//                if (grabber1 != null) {
//                    grabber1.release();
//                }
//                if (grabber2 != null) {
//                    grabber2.release();
//                }
//                if(filter != null) {
//                    filter.stop();
//                }
//            } catch (FrameRecorder.Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return outPut;
//    }
//
//
//    private static void testFade(String inFile) throws IOException {
//        String outFile = "/Users/gaoqian/Downloads/Movie/test/video/fade_out_put_"+ System.currentTimeMillis() + ".mp4";
//        FFmpegFrameGrabber inGrabber = null;
//        FFmpegFrameFilter inFilter = null;
//        FFmpegFrameRecorder outRecorder = null;
//        try {
//            inGrabber = new FFmpegFrameGrabber(inFile);
//            inGrabber.start();
//
//            outRecorder = new FFmpegFrameRecorder(outFile, VIDEO_WIDTH, VIDEO_HEIGHT, 2);
//            outRecorder.setVideoQuality(1L);
//            outRecorder.setFrameRate(FRAME);
//            outRecorder.setVideoBitrate(8000000);
//            outRecorder.setFormat("mp4");
//            outRecorder.start();
//            Frame frame;
//            Frame outFrame;
//            while ((frame = inGrabber.grabFrame())!= null) {
//                outRecorder.record(frame);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(inGrabber != null) {
//                inGrabber.stop();
//            }
//            if(outRecorder != null) {
//                outRecorder.stop();
//            }
//        }
//    }
//
//    private static void getVideoFrameRate(String v) throws FFmpegFrameGrabber.Exception {
//        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(v);
//        grabber.start();
//        System.out.println("frameRate:  " + grabber.getFrameRate());
//        grabber.stop();
//    }
//
//    /**
//     * 测试合并视频
//     * @param v1
//     * @param v2
//     * @param out
//     */
//    private static void concatVideo(String v1, String v2, String out) throws IOException {
//        FFmpegFrameGrabber v1Grabber = null;
//        FFmpegFrameGrabber v2Grabber = null;
//        FFmpegFrameFilter filter = null;
//        FFmpegFrameRecorder recorder = null;
//        try {
//            v1Grabber = new FFmpegFrameGrabber(v1);
//            v1Grabber.start();
//            v2Grabber = new FFmpegFrameGrabber(v2);
//            v2Grabber.start();
//            recorder = new FFmpegFrameRecorder(out, VIDEO_WIDTH, VIDEO_HEIGHT, 2);
//            recorder.setFrameRate(30);
//            //设置视频编码层模式
//            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//            //设置视频图像数据格式
//            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//            recorder.setVideoBitrate(8000000);
//            recorder.setFormat("mp4");
//            recorder.start();//scale=512:288[v1];scale=512:288[v2];[v1][v2]concat[outv];
//            String filterContent = "[0:v]scale="+ VIDEO_WIDTH +":"+ VIDEO_HEIGHT +"[first];[1:v]scale="+ VIDEO_WIDTH +":"+ VIDEO_HEIGHT +"[second];[first][second]xfade=transition=fade:offset=5:duration=2[v]";
//            filter = new FFmpegFrameFilter(filterContent, VIDEO_WIDTH, VIDEO_HEIGHT);
//            filter.setVideoInputs(2);
//            filter.start();
//
//            Frame frame;
//            Frame frame2;
//            Frame outFrame;
//            while ((frame = v1Grabber.grabFrame()) != null) {
//                filter.push(0, frame);
//                frame2 = v2Grabber.grabFrame();
//                filter.push(1, frame2);
//                outFrame = filter.pullImage();
//                recorder.record(outFrame);
//            }
////
////            while ((frame = v2Grabber.grabFrame()) != null) {
////                filter.push(frame);
////                outFrame = filter.pullImage();
////                recorder.record(outFrame);
////            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(v1Grabber != null) {
//                v1Grabber.stop();
//            }
//            if(v2Grabber != null) {
//                v2Grabber.stop();
//            }
//            if(filter != null) {
//                filter.stop();
//            }
//            if(recorder != null) {
//                recorder.stop();
//            }
//        }
//    }
//}
