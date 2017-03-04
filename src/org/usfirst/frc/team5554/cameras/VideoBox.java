package org.usfirst.frc.team5554.cameras;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSource;
import edu.wpi.first.wpilibj.CameraServer;

public class VideoBox
{
	private CvSource outputStream;
	
	public VideoBox(int width, int height, String name)
	{
		outputStream = CameraServer.getInstance().putVideo(name, width, height);
	}
	
	public void stream(Mat feed)
	{
		outputStream.putFrame(feed);
	}
	
	public Mat DrawGuideLines(Mat mat , GuideLines gl)
	{
		Imgproc.line(mat, new Point(gl.GetLeftX(),gl.GetUpY()) , new Point(gl.GetLeftX(),gl.GetDownY()),gl.GetColor(),gl.GetThickness());
		Imgproc.line(mat, new Point(gl.GetRightX(),gl.GetUpY()) , new Point(gl.GetRightX(),gl.GetDownY()),gl.GetColor(),gl.GetThickness());
		return mat;
	}
	
	public Mat DrawLine(Mat mat , Point upperPoint , Point lowerPoint , Scalar color, int thickness)
	{
		Imgproc.line(mat , upperPoint , lowerPoint , color, thickness);
		return mat;
	}
	
	public Mat DrawCircle(Mat mat , Point center , int radius , Scalar color , int thickness)
	{
		Imgproc.circle(mat, center, radius, color , thickness);
		return mat;
	}
	
	public Mat RotateFrame(Mat src , double angle)
	{
		Point pt = new Point(src.cols()/2 , src.rows()/2);
		Mat r = Imgproc.getRotationMatrix2D(pt, angle, 1.0);
		Imgproc.warpAffine(src, src, r, new Size(src.cols(),src.rows()));
		return src;
	}

}
