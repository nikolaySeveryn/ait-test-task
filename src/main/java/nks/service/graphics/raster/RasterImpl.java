package nks.service.graphics.raster;

import java.util.List;

/**
 * algorithm:  https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm
 * 
 * @author nks
 */
public class RasterImpl implements Raster {
	
	public List<Point> rasterLine(Point a, Point b) {
		BreserhamLoop loop = BreserhamLoop.buildBreserhamLoop(a, b);
		loop.doLoop();
		return loop.getPixels();
	}
	
	/*
	 List<Point> rasterCircle(Point a, Integer radius){
	 etc etc
	 */
	
}
