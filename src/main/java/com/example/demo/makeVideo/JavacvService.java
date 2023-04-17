//package com.example.demo.makeVideo;
//
//import com.example.demo.makeVideo.bean.ImageAddTextOrLogoBean;
//import com.example.demo.makeVideo.bean.Position_X;
//import com.example.demo.makeVideo.bean.Position_Y;
//import com.sun.prism.j2d.J2DPrismGraphics;
//import org.bytedeco.ffmpeg.global.avcodec;
//import org.bytedeco.javacv.*;
//import org.bytedeco.javacv.Frame;
//import org.bytedeco.opencv.opencv_core.IplImage;
//import sun.print.ProxyGraphics2D;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.Random;
///**
// * Create 2022/4/19 by Gq
// */
//public class JavacvService {
//
//    private static final String outPutFile = "/Users/gaoqian/Downloads/Movie/test/video/gd_outtest.mp4";
//    private static final String inPutFile = "/Volumes/WorkFiles/test/upload/remix/99ff867451f84a51b85c31b069d20bc9.mp4";
//
//    private static String[] texts = {"世上无难事", "只怕有心人", "只要思想不滑坡", "办法总比困难多", "长江后浪推前浪", "前浪死在沙滩上"};
//
//    private Java2DFrameConverter converter = new Java2DFrameConverter();
//    private String imgSuffix = "jpg";
//
//    static {
//        try {
//            FFmpegFrameGrabber.tryLoad();
//            FFmpegFrameRecorder.tryLoad();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
////        scaleVideo();
////        fillVideo();
////        addLogo();
//        scrollingSubtitles();
////        addFrame();
//    }
//
//    /**
//     * 添加滚动字幕
//     * @throws IOException
//     */
//    public static void scrollingSubtitles() throws IOException {
////        String filterStr = "movie='logo.9947f96f.png'[logo];[in]drawtext=text='我是滚动字幕–HiIT青年':fontfile=simhei.ttf:y=h-line_h-10:x=w-(t-4.5)*w/5.5:fontcolor=white:fontsize=40:shadowx=2:shadowy=2[text];[text][logo]overlay=15:15[out]";
////        String filterStr = "movie='/Users/gaoqian/Downloads/Movie/test/video/logo.jpeg'[logo];[in]drawtext=text='我是滚动字幕--HiIT青年':fontfile=FreeSerif.ttf:y=h-line_h-10:x=w-(t-4.5)*w/5.5:fontcolor=white:fontsize=40:shadowx=2:shadowy=2[text];[text][logo]overlay=15:15[out]";
//        String fontPath = "/Users/gaoqian/Downloads/Movie/test/video/maobi.TTF";//中文字体文件路径
////        String moveCharFilterContent = "drawtext=fontfile=" + fontPath + ":text='this is a \"eguid\" string,this is a 中文 string':y=h-line_h-50:x=mod(t*50\\,w)";
////        String moveLCharFilterContent = "drawtext=fontfile=" + fontPath + ":text='this is a \"eguid\" string,this is a 中文 string':y=h-line_h-50:x=t*50";
//        String moveLCharFilterContent = "drawtext=fontfile=" + fontPath + ":textfile='/Users/gaoqian/Downloads/Movie/test/video/content.txt':y=(0-line_h)-t*20:x=150";
//        // 输入视频
//        FFmpegFrameGrabber stream0 = new FFmpegFrameGrabber(new File(inPutFile));
//        stream0.start();
//
//        FFmpegFrameFilter filter = new FFmpegFrameFilter(moveLCharFilterContent, stream0.getImageWidth(), stream0.getImageHeight());
//        filter.start();
//        // 输出视频
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(new File(outPutFile), stream0.getImageWidth(), stream0.getImageHeight());
//        recorder.setFormat("mp4");
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//        recorder.start();
//
//        int idx = 0;
//        Frame frame0, frame;
//        while ((frame0 = stream0.grabImage()) != null) {
//            filter.push(frame0);
//            frame = filter.pullImage();
//            if (frame != null && frame.image != null) {
//                recorder.record(frame);
//            }
//            if (idx++ > 100) {
//                break;
//            }
//        }
//        recorder.close();
//        filter.close();
//        stream0.close();
//    }
//
//    /**
//     * 缩放视频
//     * @throws IOException
//     */
//    public static void scaleVideo() throws IOException {
//        String filterStr = "scale=320:240[out]";
//        FFmpegFrameGrabber stream0 = new FFmpegFrameGrabber(new File("YYT.mp4"));
//        stream0.start();
//        System.out.println("width=" + stream0.getImageWidth() + ", height=" + stream0.getImageHeight());
//
//        FFmpegFrameFilter filter = new FFmpegFrameFilter(filterStr, stream0.getImageWidth(), stream0.getImageHeight());
//        filter.start();
//
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(new File("scale.YYT.mp4"), 320, 240);
//        recorder.setFormat("mp4");
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//        recorder.start();
//
//        int idx = 0;
//        Frame frame0, frame;
//        while ((frame0 = stream0.grabImage()) != null) {
//            filter.push(frame0);
//            frame = filter.pullImage();
//            if (frame != null && frame.image != null) {
//                recorder.record(frame);
//            }
//            if (idx++ > 100) {
//                break;
//            }
//        }
//        recorder.close();
//        filter.close();
//        stream0.close();
//    }
//
//    /**
//     * 填充视频
//     * @throws IOException
//     */
//    public static void fillVideo() throws IOException {
//        String filterStr = "pad=700:412:30:30:pink[out]";
//        FFmpegFrameGrabber stream0 = new FFmpegFrameGrabber(new File("scale.YYT.mp4"));
//        stream0.start();
//        System.out.println("width=" + stream0.getImageWidth() + ", height=" + stream0.getImageHeight());
//
//        FFmpegFrameFilter filter = new FFmpegFrameFilter(filterStr, stream0.getImageWidth(), stream0.getImageHeight());
//        filter.start();
//
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(new File("fill.scale.YYT.mp4"), stream0.getImageWidth(), stream0.getImageHeight());
//        recorder.setFormat("mp4");
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//        recorder.start();
//
//        int idx = 0;
//        Frame frame0, frame;
//        while ((frame0 = stream0.grabImage()) != null) {
//            filter.push(frame0);
//            frame = filter.pullImage();
//            if (frame != null && frame.image != null) {
//                recorder.record(frame);
//            }
//            if (idx++ > 100) {
//                break;
//            }
//        }
//        recorder.close();
//        filter.close();
//        stream0.close();
//    }
//
//    /**
//     * 添加视频Logo
//     * @throws IOException
//     */
//    public static void addLogo() throws Exception {
//        // 原视频
//        FFmpegFrameGrabber stream0 = new FFmpegFrameGrabber("YYT.mp4");
//        stream0.start();
//
//        final int imageWidth = stream0.getImageWidth();
//        final int imageHeight = stream0.getImageHeight();
//        final int audioChannels = stream0.getAudioChannels();
//        String outputFileName = "logo.YYT.mp4";
//
//        FFmpegFrameRecorder recorder = new FFmpegFrameRecorder(outputFileName, imageWidth, imageHeight, audioChannels);
//        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264);
//        recorder.start();
//
//        Frame frame0, frame;
//
//        ImageAddTextOrLogoBean logoBean = new ImageAddTextOrLogoBean();
//        logoBean.setImageUrl("logo.9947f96f.png");
//        logoBean.setPositon_X(Position_X.LEFT);
//        logoBean.setPositon_Y(Position_Y.TOP);
//        logoBean.setState(0);
//
//        Font font = new Font("Mononspace", Font.BOLD, 30);
//
//        ImageAddTextOrLogoBean textBean = new ImageAddTextOrLogoBean();
//        textBean.setFont(font);
//        textBean.setPositon_X(Position_X.CONTER);
//        textBean.setPositon_Y(Position_Y.BOTTOM);
//        textBean.setState(1);
//
//        int i = 0;int j = 0;
//        Java2DFrameConverter converter = new Java2DFrameConverter();
//        while ((frame0 = stream0.grabFrame()) != null) {
//            if (frame0.image == null){
//                recorder.record(frame0);
//                continue;
//            }
//            BufferedImage bufferedImage = converter.convert(frame0);
//
//            if (i % 30 == 0 && j < texts.length){
//                j++;
//            }
//            i++;
//            textBean.setWatermark(texts[j]);
//            imageAddImage(logoBean,bufferedImage);
//            imageAddText(textBean,bufferedImage);
//            bufferedImage.flush();
//
//            frame = converter.convert(bufferedImage);
//            recorder.record(frame);
//        }
//
//        recorder.close();
//        stream0.close();
//    }
//
//    /**
//     *
//     * @param beans
//     * @param bufferedImage
//     * @return 0 完成 1图片不存在 2异常错误
//     */
//    public static int ImageAddTextOrImage(java.util.List<ImageAddTextOrLogoBean> beans, BufferedImage bufferedImage) {
////        try {
////            File sourceFile = new File(source);
////            if (!sourceFile.exists()) {
////                return 1;
////            }
////            for (int i = 0; i < beans.size(); i++) {
////                if (i == 0) {
////                    if (beans.get(i).getState() == 0) {//添加图片
////                        imageAddImage(beans.get(i), source, output);
////                    } else if (beans.get(i).getState() == 1) {//添加文字
////                        imageAddText(beans.get(i), source, output);
////                    }
////                } else {
////                    if (beans.get(i).getState() == 0) {//添加图片
////                        imageAddImage(beans.get(i), bufferedImage);
////                    } else if (beans.get(i).getState() == 1) {//添加文字
////                        imageAddText(beans.get(i), output, output);
////                    }
////                }
////
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            return 2;
////        }
//        return 0;
//    }
//
//    /**
//     * 添加图片
//     *
//     * @param logoBean  logo
//     * @param bufferedImage  原始图片
//     * @throws Exception
//     */
//    private static void imageAddImage(ImageAddTextOrLogoBean logoBean, BufferedImage bufferedImage) throws Exception {
//        final int width = bufferedImage.getWidth();
//        final int height = bufferedImage.getHeight();
//        Graphics2D pen = bufferedImage.createGraphics();
//        pen.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//
//        ImageIcon imgIcon = new ImageIcon(logoBean.getImageUrl());
//        Image con = imgIcon.getImage();
//
//        if (logoBean.getToMinSize() != 1) {
//            BufferedImage bufImg = ImageIO.read(new File(logoBean.getImageUrl())); //读取图片
//            con = bufImg.getScaledInstance((int) (con.getWidth(null) * logoBean.getToMinSize()),
//                    (int) (con.getHeight(null) * logoBean.getToMinSize()), bufImg.SCALE_SMOOTH);//设置缩放目标图片模板
//
//        }
//        int x = setPoitionX(logoBean, width, pen, con);
//        int y = setPoitionY(logoBean, height, pen, con);
//
//        pen.drawImage(con, x, y, null);//水印的位置
//        pen.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
//        pen.dispose();
//    }
//
//    /**
//     * 添加文字
//     *
//     * @param textBean  文字信息
//     * @param bufferedImage 图片
//     * @throws Exception
//     */
//    private static void imageAddText(ImageAddTextOrLogoBean textBean, BufferedImage bufferedImage) throws Exception {
//        int srcImgWidth = bufferedImage.getWidth();
//        int srcImgHeight = bufferedImage.getHeight();
//        Graphics2D pen = bufferedImage.createGraphics();
//        if (textBean.getColor() != null) {
//            pen.setColor(textBean.getColor());
//        }
//        if (textBean.getFont() != null) {
//            pen.setFont(textBean.getFont());
//        }
//        //设置水印的坐标
//        int x = setPoitionX(textBean, srcImgWidth, pen, null);
//        int y = setPoitionY(textBean, srcImgHeight, pen, null);
//
//        pen.drawString(textBean.getWatermark(), x, y); //加水印
//        pen.dispose();
//    }
//
//    /**
//     * 计算x位置
//     *
//     * @param iBean       要添加的内容的信息
//     * @param srcImgWidth 背景图片宽度
//     * @param g
//     * @param image
//     * @return
//     * @throws Exception
//     */
//    private static int setPoitionX(ImageAddTextOrLogoBean iBean, int srcImgWidth, Graphics2D g, Image image)
//            throws Exception {
//        int x = 0;
//        if (iBean.getPositon_X() == Position_X.LEFT) {
//            if (iBean.getX() < 0) {
//                x = 0;
//            } else {
//
//            }
//            if (iBean.getX() > 100) {
//                x = srcImgWidth;
//            } else {
//                x = (int) Math.round(srcImgWidth / 100.0 * iBean.getX());
//            }
//
//        } else if (iBean.getPositon_X() == Position_X.CONTER) {
//            if (iBean.getState() == 0) {
//                x = srcImgWidth / 2 - image.getWidth(null) / 2;
//            } else if (iBean.getState() == 1) {
//                x = srcImgWidth / 2 - (g.getFontMetrics(g.getFont()).charsWidth(iBean.getWatermark().toCharArray(), 0,
//                        iBean.getWatermark().length()) / 2);
//            }
//
//        } else if (iBean.getPositon_X() == Position_X.RIGHT) {
//            if (iBean.getState() == 0) {
//                x = (int) (srcImgWidth - image.getWidth(null) - Math.round(srcImgWidth / 100.0 * iBean.getX()));
//            } else if (iBean.getState() == 1) {
//                x = (int) (srcImgWidth - (g.getFontMetrics(g.getFont()).charsWidth(iBean.getWatermark().toCharArray(),
//                        0, iBean.getWatermark().length())) - Math.round(srcImgWidth / 100.0 * iBean.getX()));
//            }
//        }
//        return x;
//    }
//
//    /**
//     * 计算y位置
//     *
//     * @param iBean
//     * @param srcImgHeight //原图片高度
//     * @param g
//     * @param image
//     * @return
//     * @throws Exception
//     */
//    private static int setPoitionY(ImageAddTextOrLogoBean iBean, int srcImgHeight, Graphics2D g, Image image)
//            throws Exception {
//        int y = 0;
//        if (iBean.getPositon_Y() == Position_Y.TOP) {
//            if (iBean.getY() < 0) {
//                y = 0;
//            } else if (iBean.getY() > 100) {
//                y = srcImgHeight;
//            } else {
//                y = (int) Math.round(srcImgHeight / 100.0 * iBean.getY());
//            }
//        } else if (iBean.getPositon_Y() == Position_Y.CONTER) {
//
//            if (iBean.getState() == 0) {
//                y = srcImgHeight / 2 - image.getHeight(null) / 2;
//            } else if (iBean.getState() == 1) {
//                y = srcImgHeight / 2 - (g.getFontMetrics(g.getFont()).getHeight()) / 2;
//            }
//
//        } else if (iBean.getPositon_Y() == Position_Y.BOTTOM) {
//            if (iBean.getState() == 0) {
//                y = (int) (srcImgHeight - image.getHeight(null) - Math.round(srcImgHeight / 100.0 * iBean.getY()));
//            } else if (iBean.getState() == 1) {
//                y = (int) (srcImgHeight - (g.getFontMetrics(g.getFont()).getHeight())
//                        - Math.round(srcImgHeight / 100.0 * iBean.getY()));
//            }
//
//        }
//        return y;
//    }
//
//    /**
//     * 添加画面
//     */
//    public static void addFrame(){
//        String sourceFilePath="YYT.mp4";
//        String mergeFielPath="scale.YYT.mp4";
//
//        File file = new File(sourceFilePath);
//        //抓取资源
//        FFmpegFrameGrabber frameGrabber1 = new FFmpegFrameGrabber(sourceFilePath);
//        //待处理的视频文件
//        FFmpegFrameGrabber frameGrabber2 = new FFmpegFrameGrabber(mergeFielPath);
//        //
//        Frame frame = null;
//        Frame mergeFrame = null;
//        FFmpegFrameRecorder recorder = null;
//        String fileName = null;
//        try{
//            //开始抓取
//            frameGrabber1.start();
//            frameGrabber2.start();
//            //随机数
//            Random random = new Random();
//            fileName = file.getAbsolutePath() + random.nextInt(100)+".mp4";
//            System.out.println("--文件名-->>"+fileName);
//            recorder = new FFmpegFrameRecorder(fileName, frameGrabber1.getImageWidth(), frameGrabber1.getImageHeight(), frameGrabber1.getAudioChannels());
//
//            recorder.setSampleRate(frameGrabber1.getSampleRate());
//            recorder.setFrameRate(frameGrabber1.getFrameRate());
//            recorder.setTimestamp(frameGrabber1.getTimestamp());
//            recorder.setVideoBitrate(frameGrabber1.getVideoBitrate());
//            recorder.setVideoCodec(frameGrabber1.getVideoCodec());
//
//            recorder.start();
//            int index=0;
//            while (true){
//                frame=frameGrabber1.grabFrame();
//                if(frame ==null){
//                    break;
//                }
//                //帧图片
//                if(frame.image !=null){
//                    IplImage iplImage = Java2DFrameUtils.toIplImage(frame);
//                    BufferedImage buffImg=Java2DFrameUtils.toBufferedImage(iplImage);
//                    //图片绘制
//                    mergeFrame=frameGrabber2.grabFrame();
//                    if(mergeFrame !=null){
//                        System.out.println("--合并视频--"+(mergeFrame.image == null));
//                        //判断获取图片帧是否为空，如果为空就在获取一帧，循环判断
//                        while (mergeFrame.image ==null){
//                            mergeFrame=frameGrabber2.grabFrame();
//                        }
//                        Graphics2D graphics = buffImg.createGraphics();
//                        Image mergeBuffer = Java2DFrameUtils.toBufferedImage(mergeFrame);
//                        graphics.drawImage(mergeBuffer,0,100,200,150,null);
//                        graphics.dispose();
//                    }
//                    //新的一帧
//                    Frame newFrame = Java2DFrameUtils.toFrame(buffImg);
//                    recorder.record(newFrame);
//                }
//                //设置音频
//                if(frame.samples !=null){
//                    recorder.recordSamples(frame.sampleRate,frame.audioChannels,frame.samples);
//                }
//                System.out.println("帧值="+index);
//                index ++;
//            }
//            recorder.stop();
//            recorder.release();
//            frameGrabber2.stop();
//            frameGrabber1.stop();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//
//    private void test() {
//        BufferedImage image = new BufferedImage(0,0,0);
//        Graphics2D pen  = image.createGraphics();
//        pen.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        pen.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        pen.setStroke(new BasicStroke(2f));
//        Rectangle rectangle = new Rectangle();
//    }
//}
