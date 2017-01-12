package nks.service.graphics.raster;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Original integer algorithm: 
 * https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%91%D1%80%D0%B5%D0%B7%D0%B5%D0%BD%D1%85%D1%8D%D0%BC%D0%B0
 *  
 * works only if deltax > deltay and y is growing  
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
public abstract class BreserhamLoop {
	
	private List<Point>pixels = new ArrayList<Point>();
	
	private Point start;
	private Point end;
	
	private Integer horizontalProjection;
	private Integer verticalProjection;
    
	public static BreserhamLoop buildBreserhamLoop(Point start, Point end) {
		if(start == null || end == null) {
			throw new NullPointerException();
		}
		if(start.getX()==null || start.getY()==null || end.getX()==null || end.getY()==null){
			throw new IllegalArgumentException();
		}
		
		Integer horizontalProjection = calculateHorizontalProjection(start, end);
		Integer verticalProjection = calculateVericalProjection(start, end);
		if(horizontalProjection >= verticalProjection){
			return new HorizontalBreserhamLoop(start, end);
		}
		else{
			return new VerticalBreserhamLoop(start, end);
		}
	}

	public static Integer calculateHorizontalProjection(Point start, Point end) {
		return Math.abs(end.getX() - start.getX());
	}
	public static Integer calculateVericalProjection(Point start, Point end) {
		return Math.abs(end.getY() - start.getY());
	}
	
	
	public BreserhamLoop(Point start, Point end) {
		if(start==null || end==null) {
			throw new IllegalArgumentException();
		}
		this.start = start;
		this.end = end;
		this.horizontalProjection = calculateHorizontalProjection(start, end);
		this.verticalProjection = calculateVericalProjection(start, end);
	}
	
	public abstract DependentCoordinate createDependentCoordinate();
	public abstract void setDependentCoordinate(Point point, Integer coordinate);
	public abstract void generateInitialPoints();
	public abstract Boolean isPointOrderCorrect();
	
	public void doLoop() {
		if(!isPointOrderCorrect()){
			swapPoints();
		}
		generateInitialPoints();
		DependentCoordinate dependentCoordinate = createDependentCoordinate();
		for(Point currentPixel: getPixels()) {
			setDependentCoordinate(currentPixel, dependentCoordinate.getValue());
			dependentCoordinate.nextIteration();
		}
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
	public List<Point> getPixels() {
		return pixels;
	}
	protected Point getStart() {
		return start;
	}
	protected Point getEnd() {
		return end;
	}
	
	
}
