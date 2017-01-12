package nks.service.graphics.raster;

import java.util.List;

import nks.service.graphics.Point;

/*
 * near could be CircleFigureRaster SpiralFigureRaster etc.
 */
public interface LinerFigureRaster {
	
	List<Point> rasterLine(Point a, Point b);
	List<Point>rasterTriangle(Point a, Point b, Point c);
	
	/*
	 List<Point> rasterSquare(Point a, Point b, Point c, Point d)
	 List<Point> rasterPentagon(Point a, Point b, Point c, Point d, Point e)
	 etc etc
	 */
}
