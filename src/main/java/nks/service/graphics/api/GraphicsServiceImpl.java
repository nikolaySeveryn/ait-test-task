package nks.service.graphics.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nks.service.graphics.raster.RasterImpl;
import nks.service.graphics.raster.Point;
import nks.service.graphics.raster.Raster;

public class GraphicsServiceImpl implements GraphicsService{
	
	private Raster raster = new RasterImpl();

	public List<Point> getLine(Point a, Point b) {
		return raster.rasterLine(a, b);
	}

	public List<Point> getTriangle(Point a, Point b, Point c) {
		Set<Point> trianglePixels = new HashSet<Point>();
		trianglePixels.addAll(getLine(a, b));
		trianglePixels.addAll(getLine(b, c));
		trianglePixels.addAll(getLine(c, a));
		return new ArrayList<Point>(trianglePixels);
	} 
	
	public static void main(String[] args) {
		GraphicsService service = new GraphicsServiceImpl();
//		List<Point> res = service.getTriangle(new Point(3, 13), new Point(9,3), new Point(16,10));
		List<Point> res = service.getLine(new Point(3, 13), new Point(9,3));
		for(Point p: res){
			System.out.println(p);
		}
	}
	
}
