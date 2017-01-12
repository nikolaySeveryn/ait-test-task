package nks.service.graphics.api;

import java.util.List;

import nks.service.graphics.raster.LinerFigureRasterImpl;
import nks.service.graphics.Point;
import nks.service.graphics.raster.LinerFigureRaster;

public class GraphicsServiceImpl implements GraphicsService{
	
	private LinerFigureRaster raster = new LinerFigureRasterImpl();

	public List<Point> getLine(Point a, Point b) {
		return raster.rasterLine(a, b);
	}

	public List<Point> getTriangle(Point a, Point b, Point c) {
		return raster.rasterTriangle(a, b, c);
	} 
}
