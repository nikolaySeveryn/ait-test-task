package nks.service.graphics.raster;

import java.util.List;

public interface Raster {
	List<Point> rasterLine(Point a, Point b);
	/*
	List<Point> rasterCircle(Point a, Integer radius);
	etc etc
	 */
}
