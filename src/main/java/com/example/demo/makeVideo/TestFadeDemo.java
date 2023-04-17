//package com.example.demo.makeVideo;
//
//import org.bytedeco.ffmpeg.global.avcodec;
//import org.bytedeco.ffmpeg.global.avutil;
//import org.bytedeco.javacpp.Loader;
//import org.bytedeco.javacv.*;
//import org.bytedeco.javacv.Frame;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
//
///**
// * Create 2022/5/5 by Gq
// */
//public class TestFadeDemo {
//    private static final int FRAME_RATE = 30;
//    private static final int time_length = 10;
//    private static final String img1 = "/Users/gaoqian/Downloads/Movie/test/video/DSC_0430.JPG";
//    private static final String img2 = "/Users/gaoqian/Downloads/Movie/test/video/DSC_0421.JPG";
//
//
//    public static void main(String[] args) throws Exception {
////        String out = "/Users/gaoqian/Downloads/Movie/test/video/make_video_%s.mp4";
////        testFadeVideo(String.format(out, 1), String.format(out, 2));
////        testXfadeEffect(String.format(out, 1), String.format(out, 2));
////        testParams(String.format(out, 1), String.format(out, 2), "fade");
////        String deLogoUrl = "/Users/gaoqian/Downloads/Movie/test/video/v0200fg10000c9ntmc3c77ubg4h1e4rg.MP4";
//        String inFile = "/Users/gaoqian/Downloads/Movie/test/video/make_video_1.mp4";
//        String outFile = "/Users/gaoqian/Downloads/Movie/test/video/make_video_2.mp4";
////        makeNewVideo(inFile, outFile);
//        testCommadLine(inFile, outFile);
//    }
//
//
//    private static void makeNewVideo(String in, String out) throws IOException {
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameGrabber grabber = null;
//        try {
////            BufferedImage readimg = ImageIO.read(new File(in));
////            Java2DFrameConverter converter2 = new Java2DFrameConverter();
////            Frame imgFrame = converter2.getFrame(readimg);
//            grabber = new FFmpegFrameGrabber(in);
//            grabber.start();
//
//            recorder = new FFmpegFrameRecorder(out, grabber.getImageWidth(), grabber.getImageHeight(), grabber.getAudioChannels());
//            recorder.setVideoBitrate(256 * 1024 * 1024);
//            recorder.setVideoQuality(1.0);
//            recorder.setFrameRate(FRAME_RATE);
//            //设置视频编码层模式
//            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//            //设置视频图像数据格式
//            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//            recorder.setFormat("mp4");
//            recorder.start();
//            Frame frame;
//            while ((frame = grabber.grabFrame()) != null) {
//                recorder.record(frame);
//            }
//        } finally {
//            if(recorder != null) {
//                recorder.close();
//            }
//            if(grabber != null) {
//                grabber.close();
//            }
//        }
//    }
//
//    private static void testXfadeEffect(String in, String in2) throws IOException {
//        String out = "/Users/gaoqian/Downloads/Movie/test/video/test_xfade_video.mp4";
//        FFmpegFrameGrabber source1 = null;
//        FFmpegFrameGrabber source2 = null;
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameFilter filter = null;
//        FFmpegFrameFilter filter2 = null;
//
//        try {
//            source1 = new FFmpegFrameGrabber(in);
//            source1.start();
//            source2 = new FFmpegFrameGrabber(in2);
//            source2.start();
//
////            String filterContent = "[0][in]xfade=transition=fade:duration=1:offset=4.5,format=yuv420p[out]";
////            String filterContent = "xfade=transition=fade:duration=2:offset=5";
//            String filterContent = "fade=t=out:st=9.5:d=0.5:color=white";
////            String filterContent = "[0:v]fade=t=out:st=10:d=2[v0];[1:v]fade=t=in:st=0:d=2[tmp];[tmp]fade=t=out:st=10:d=2[v1];[v0][v1]concat=n=2:v=1:a=0[vo];[0:a][1:a]concat=n=2:v=0:a=1[ao]";
//            filter = new FFmpegFrameFilter(filterContent, 1500, 1000);
//            filter.start();
//
//            recorder = new FFmpegFrameRecorder(out, 1500, 1000, 2);
//            recorder.setVideoBitrate(256 * 1024 * 1024);
//            recorder.setVideoQuality(1.0);
//            recorder.setFrameRate(30);
//            //设置视频编码层模式
//            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//            //设置视频图像数据格式
//            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//            recorder.setFormat("mp4");
//            recorder.start();
//
//            Frame frame1, outFrame;
//            while ((frame1 = source1.grabFrame()) != null) {
//                filter.push(frame1);
//                outFrame = filter.pullImage();
//                recorder.record(outFrame);
//            }
//            System.out.println("第一部分写入完毕");
//
//            String filterContent2 = "fade=t=in:st=0:d=0.5:color=white";
//            filter2 = new FFmpegFrameFilter(filterContent2, 1500, 1000);
//            filter2.start();
//            Frame frame2, outFrame2;
//            while ((frame2 = source2.grabFrame()) != null) {
//                filter2.push(frame2);
//                outFrame2 = filter2.pullImage();
//                recorder.record(outFrame2);
//            }
//
//            System.out.println("第2部分写入完毕");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(source1 != null) {
//                source1.stop();
//            }
//            if(source2 != null) {
//                source2.stop();
//            }
//            if(filter != null) {
//                filter.stop();
//            }
//            if(recorder != null) {
//                recorder.stop();
//            }
//        }
//    }
//
//    private static void testFadeEffect(String in) throws IOException {
//        String out = "/Users/gaoqian/Downloads/Movie/test/video/test_fade_video.mp4";
//        FFmpegFrameGrabber source1 = null;
//        FFmpegFrameRecorder recorder = null;
//        FFmpegFrameFilter filter = null;
//
//        try {
//            source1 = new FFmpegFrameGrabber(in);
//            source1.start();
//            recorder = new FFmpegFrameRecorder(out, source1.getImageWidth(), source1.getImageHeight(), 2);
//            recorder.setVideoBitrate(120 * 1024);
//            recorder.setVideoQuality(1.0);
//            recorder.setFrameRate(30);
//            //设置视频编码层模式
//            recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//            //设置视频图像数据格式
//            recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
//            recorder.setFormat("mp4");
//            recorder.start();
//
//            String filterContent = "fade=t=in:st=0:d=2:alpha=0";
//            filter = new FFmpegFrameFilter(filterContent, source1.getImageWidth(), source1.getImageHeight());
//            filter.start();
//
//            Frame frame1, outFrame;
//            while ((frame1 = source1.grabFrame()) != null) {
//                filter.push(frame1);
//                outFrame = filter.pullImage();
//                recorder.record(outFrame);
//            }
//
//            System.out.println("第一部分写入完毕");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(source1 != null) {
//                source1.stop();
//            }
//            if(filter != null) {
//                filter.stop();
//            }
//            if(recorder != null) {
//                recorder.stop();
//            }
//        }
//    }
//
//    private static void testParams(String a, String b, String effect) throws IOException, InterruptedException {
//
//        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
//        List<String> params = new ArrayList<>();
//        params.add(ffmpeg);
//        params.add("-i");
//        params.add(a);   // 第一个视频的输入
//        params.add("-i");
//        params.add(b);    // 第二个视频的输入
//        params.add("-filter_complex");
//        params.add("xfade=transition=" + effect + ":offset=9:duration=1");    // 效果
//        params.add("-y");
//        params.add("/Users/gaoqian/Downloads/Movie/test/video/test_grabber_params" + System.currentTimeMillis() + ".mp4");    // 输出目录
//        ProcessBuilder pb = new ProcessBuilder(params);
//        pb.inheritIO().start().waitFor();
//    }
//
//    private static void testDelogo(String a) throws IOException, InterruptedException {
//        FFmpegFrameRecorder.tryLoad();
//        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
//        List<String> params = new ArrayList<>();
//        params.add(ffmpeg);
//        params.add("-i");
//        params.add(a);   // 第一个视频的输入
//        params.add("-b:v");
//        params.add("548k");
//        params.add("-vf");
//        params.add("delogo=x=0:y=0:w=1280:h=720:show=0");    // 去水印参数
//        params.add("/Users/gaoqian/Downloads/Movie/test/video/test_delogo_" + System.currentTimeMillis() + ".mp4");    // 输出目录
//        ProcessBuilder pb = new ProcessBuilder(params);
//        pb.inheritIO().start().waitFor();
//    }
//
//    private static void testCommadLine(String a, String b) throws IOException, InterruptedException {
//        FFmpegFrameRecorder.tryLoad();
//        String ffmpeg = Loader.load(org.bytedeco.ffmpeg.ffmpeg.class);
//        List<String> params = new ArrayList<>();
//        params.add(ffmpeg);
//        params.add("-i");
//        params.add(a);   // 第一个视频的输入
//        params.add("-i");
//        params.add(b);    // 第二个视频的输入
//        params.add("-vcodec");
//        params.add("h264");
//        params.add("-pix_fmt");
//        params.add("yuv420p");
//        params.add("-b");
//        params.add("50000k");
////        params.add("-maxrate");
////        params.add("1000k");
////        params.add("-minrate");
////        params.add("1000k");
////        params.add("-bufsize");
////        params.add("50k");
//        // /Volumes/WorkFiles/test/create/videos/temp/content_file_6972f8912cdf487e9b9c1b4ec0253c00.txt
//        // /Volumes/WorkFiles/test/font/FZYDZHJW.TTF
//        params.add("-framerate");
//        params.add("25/1");
//        params.add("-filter_complex");
////        params.add("xfade=transition=fadewhite:offset=9:duration=1");    // 效果
//        params.add("drawtext=fontfile=/Volumes/WorkFiles/test/font/FZYDZHJW.TTF:line_spacing=16:fontsize=36:fontcolor=black:textfile='/Volumes/WorkFiles/test/create/videos/temp/content_file_6972f8912cdf487e9b9c1b4ec0253c00.txt':y='if(gte(t,1),h/2-(t-1)*80,h/2)':x='(w-text_w)/2'");
//        params.add("-y");
//        params.add("/Users/gaoqian/Downloads/Movie/test/video/test_delogo_" + System.currentTimeMillis() + ".mp4");    // 输出目录
//        ProcessBuilder pb = new ProcessBuilder(params);
//        pb.inheritIO().start().waitFor();
//    }
//
//
//    /**
//     *  //创建processBuilder对象
//     *         ProcessBuilder processBuilder = new ProcessBuilder();
//     *
//     *         //设置第三方应用命令
//     *         List<String> list = new ArrayList<>();
//     *         list.add("ffmpeg");
//     *         list.add("-i");
//     *         list.add("/root/1.mp4");
//     *         list.add("-hls_time");
//     *         list.add("10");
//     *         list.add("-hls_list_size");
//     *         list.add("0");
//     *         list.add("-hls_segment_filename");
//     *         list.add("/root/test/m3u8_%05d.ts");
//     *         list.add("/root/test/1.m3u8");
//     *         processBuilder.command(list);
//     *
//     *         //将标准输入流和错误流合并
//     *         processBuilder.redirectErrorStream(true);
//     *
//     *         //启动一个进程
//     *         Process process = processBuilder.start();
//     *
//     *         //通过标准输入流拿到正常错误的信息
//     *         InputStream inputStream = process.getInputStream();
//     *
//     *         //转成字符流输出
//     *         InputStreamReader reader = new InputStreamReader(inputStream, "GBK");
//     *         //缓冲
//     *         char[] chars = new char[1024];
//     *         int len = -1;
//     *         while ((len = reader.read(chars)) != -1) {
//     *             String string = new String(chars, 0, len);
//     *             System.out.println(string);
//     *         }
//     *
//     *         //关流
//     *         reader.close();
//     *         inputStream.close();
//     */
//}
