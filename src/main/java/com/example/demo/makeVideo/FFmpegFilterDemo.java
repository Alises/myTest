//package com.example.demo.makeVideo;
//
//import org.bytedeco.javacv.CanvasFrame;
//import org.bytedeco.javacv.FFmpegFrameFilter;
//import org.bytedeco.javacv.FFmpegFrameGrabber;
//import org.bytedeco.javacv.Frame;
//
//import javax.swing.*;
//
///**
// * Create 2022/4/19 by Gq
// */
//public class FFmpegFilterDemo {
//    /**
//     * 使用字库支持简体中文字符水印
//     * @author eguid
//     * @param filterContent
//     */
//    public static void overlayChar(String filterContent) throws Exception, org.bytedeco.javacv.FrameFilter.Exception {
//
//        FFmpegFrameGrabber cameraGrabber = new FFmpegFrameGrabber("video=HD Camera");
//        cameraGrabber.setFormat("dshow");// 基于dshow的方式的摄像头采集
//        cameraGrabber.start();
//
//        int width=cameraGrabber.getImageWidth(),height=cameraGrabber.getImageHeight();
//
//        //设置过滤器内容，具体参考http://ffmpeg.org/ffmpeg-filters.html
//        FFmpegFrameFilter filter =new FFmpegFrameFilter(filterContent,width,height);
//        filter.start();
//
//        //FFmpegFrameFilter流程是初始化设置好过滤器后start()-->push(frame)-->Frame pull()--> stop()
//        //使用push()把音视频帧推送到过滤器，然后通过pull()取出视频帧
//        //一般的使用流程是grabber.grab得到的数据push进过滤器中，然后通过pull取出过滤器处理过的视频帧即可。
//
//        CanvasFrame canvas = new CanvasFrame("画面预览");// 新建一个预览窗口
//        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        canvas.setAlwaysOnTop(true);
//        Frame screenFrame = null,cameraFrame;
//
//        // 抓取屏幕画面
//        for (; canvas.isShowing()&&(cameraFrame=cameraGrabber.grab())!=null; ) {
//            //把抓取到的摄像头画面塞进过滤器
//            filter.push(cameraFrame);
//
//            //取出过滤器合并后的图像
//            Frame filterFrame=filter.pullImage();
//
//            // 显示过滤器处理后的画面
//            canvas.showImage(filterFrame);
//        }
//        cameraGrabber.close();
//        filter.close();
//        canvas.dispose();
//    }
//
//    public static void main(String[] args) throws Exception {
//        //静态中文字符叠加
//        String fontPath = "/Users/gaoqian/Downloads/Movie/test/video/maobi.TTF";//中文字体文件路径
//        //从右到左
//        String moveRCharFilterContent = "drawtext=fontfile=" + fontPath + ":text='this is a \"eguid\" string,this is a 中文 string':y=h-line_h-50:x=w-(t-4.5)*w/5.5";
//        overlayChar(moveRCharFilterContent);
//        //从左往右
//        String moveLCharFilterContent = "drawtext=fontfile=" + fontPath + ":text='this is a \"eguid\" string,this is a 中文 string':y=h-line_h-50:x=t*50";
//        overlayChar(moveLCharFilterContent);
//        //字符跑马灯，利用余运算实现循环跑马灯
//        String moveCharFilterContent = "drawtext=fontfile=" + fontPath + ":text='this is a \"eguid\" string,this is a 中文 string':y=h-line_h-50:x=mod(t*50\\,w)";
//        overlayChar(moveCharFilterContent);
//    }
//}
