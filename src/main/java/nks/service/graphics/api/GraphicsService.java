package nks.service.graphics.api;

import java.util.List;

import nks.service.graphics.raster.Point;

public interface GraphicsService {
	List<Point> getLine(Point a, Point b);
	List<Point> getTriangle(Point a,Point b,Point c);
}
