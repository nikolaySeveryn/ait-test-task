package nks.service.graphics.raster;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nks.service.graphics.Point;
import nks.service.graphics.lineBuilder.BreserhamLineBuilder;
import nks.service.graphics.lineBuilder.LineBuilder;

/**
 * near could be CircleFigureRaster SpiralFigureRaster etc.
 * 
 * @author nks
 */
public class LinerFigureRasterImpl implements LinerFigureRaster {
	
	public List<Point> rasterLine(Point a, Point b) {
		LineBuilder lineBuilder = BreserhamLineBuilder.createLineBuilder(a, b);
		return lineBuilder.findLinePixels();
	}

	public List<Point> rasterTriangle(Point a, Point b, Point c) {
		Set<Point> trianglePixels = new HashSet<Point>();
		trianglePixels.addAll(rasterLine(a, b));
		trianglePixels.addAll(rasterLine(b, c));
		trianglePixels.addAll(rasterLine(c, a));
		return new ArrayList<Point>(trianglePixels);
	}
	
	/*
	 List<Point> rasterSquare(Point a, Point b, Point c, Point d)
	 List<Point> rasterPentagon(Point a, Point b, Point c, Point d, Point e)
	 etc etc
	 */
	
}
