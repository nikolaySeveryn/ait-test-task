package nks.service.graphics.lineBuilder;

import java.util.ArrayList;
import java.util.List;

import nks.service.graphics.Point;

class HorizontalBreserhamLineBuilder extends BreserhamLineBuilder {

	public HorizontalBreserhamLineBuilder(Point start, Point end) {
		super(start, end);
	}


	@Override
	public List<Point> generateInitialPoints() {
		List<Point>pixels = new ArrayList<Point>();
		for(int i = 0; i <= getHorizontalProjection(); ++i) {
			int x = getStart().getX() + i;
			pixels.add(Point.create(x, null));
		}
		return pixels;
	}


	@Override
	public DependentCoordinate createDependentCoordinate() {
		Integer coordinate = getStart().getY();
		Integer errorStep = getVerticalProjection();
		Integer extremalError = getHorizontalProjection();
		DependentCoordinate dependentCoordinateCalculator = new DependentCoordinate(coordinate, errorStep, extremalError);
		dependentCoordinateCalculator.findDirection(getStart().getY(), getEnd().getY());
		return dependentCoordinateCalculator;
	}


	@Override
	public void setDependentCoordinate(Point point, Integer coordinate) {
		point.setY(coordinate);
	}


	@Override
	public Boolean isPointOrderCorrect() {
		if(getStart().getX() <= getEnd().getX()){
			return true;
		}
		return false;
	}


}
