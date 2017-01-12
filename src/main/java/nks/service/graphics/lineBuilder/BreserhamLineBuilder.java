package nks.service.graphics.lineBuilder;

import java.util.List;

import nks.service.graphics.Point;


/**
 * 
 * Original integer algorithm:
 * https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm 
 * https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%91%D1%80%D0%B5%D0%B7%D0%B5%D0%BD%D1%85%D1%8D%D0%BC%D0%B0
 *  
 * works only if deltax > deltay and y is increasing  
 * 
 *  function line(x0, x1, y0, y1)
 *    int deltax := abs(x1 - x0)
 *    int deltay := abs(y1 - y0)
 *    int error := 0
 *    int deltaerr := deltay
 *    int y := y0
 *    for x from x0 to x1
 *        plot(x,y)
 *        error := error + deltaerr
 *        if 2 * error >= deltax
 *            y := y + 1
 *            error := error - deltax
 * 
 * @author nks
 *
 */
public abstract class BreserhamLineBuilder implements LineBuilder {
	
	private Point start;
	private Point end;
	
	private Integer horizontalProjection;
	private Integer verticalProjection;
    
	public static LineBuilder createLineBuilder(Point start, Point end) {
		if(start == null || end == null) {
			throw new NullPointerException();
		}
		if(start.getX()==null || start.getY()==null || end.getX()==null || end.getY()==null){
			throw new IllegalArgumentException();
		}
		
		Integer horizontalProjection = calculateHorizontalProjection(start, end);
		Integer verticalProjection = calculateVericalProjection(start, end);
		if(horizontalProjection >= verticalProjection){
			return new HorizontalBreserhamLineBuilder(start, end);
		}
		else{
			return new VerticalBreserhamLineBuilder(start, end);
		}
	}

	public static Integer calculateHorizontalProjection(Point start, Point end) {
		return Math.abs(end.getX() - start.getX());
	}
	public static Integer calculateVericalProjection(Point start, Point end) {
		return Math.abs(end.getY() - start.getY());
	}
	
	
	public BreserhamLineBuilder(Point start, Point end) {
		if(start==null || end==null) {
			throw new IllegalArgumentException();
		}
		this.start = start;
		this.end = end;
		this.horizontalProjection = calculateHorizontalProjection(start, end);
		this.verticalProjection = calculateVericalProjection(start, end);
	}
	
	/**
	 * This method create DependedCoordinate class and set necessary parameters  
	 * @return
	 */
	protected abstract DependentCoordinate createDependentCoordinate();
	/**
	 * This method choose which coordinate is dependent and set it in point
	 * 
	 * @param point - point for setting coordinate
	 * @param coordinate - coordinate value
	 */
	protected abstract void setDependentCoordinate(Point point, Integer coordinate);
	/**
	 * This method generate List of Points with independent coordinate but without depended
	 * @return
	 */
	protected abstract List<Point> generateInitialPoints();
	/**
	 * This method checks that independent value of end point is larger than independent value of start point 
	 * @return
	 */
	protected abstract Boolean isPointOrderCorrect();
	
//	@Override
	public List<Point> findLinePixels() {
		if(!isPointOrderCorrect()){
			swapPoints();
		}
		List<Point>pixels = generateInitialPoints();
		DependentCoordinate dependentCoordinate = createDependentCoordinate();
		for(Point currentPixel: pixels) {
			setDependentCoordinate(currentPixel, dependentCoordinate.getCoordinateValue());
			dependentCoordinate.nextIteration();
		}
		return pixels;
	}
	
	private void swapPoints() {
		Point startTmp = new Point(start);
		this.start = new Point(this.end);
		this.end = new Point(startTmp);
	}
	
	
	
	/*
	 *  plain getters and setters
	 */
	protected Integer getHorizontalProjection() {
		return horizontalProjection;
	}
	protected Integer getVerticalProjection() {
		return verticalProjection;
	}
	protected Point getStart() {
		return start;
	}
	protected Point getEnd() {
		return end;
	}
	
	
}
