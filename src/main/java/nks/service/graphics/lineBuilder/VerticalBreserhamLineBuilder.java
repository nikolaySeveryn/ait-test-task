package nks.service.graphics.lineBuilder;

import java.util.ArrayList;
import java.util.List;

import nks.service.graphics.Point;

class VerticalBreserhamLineBuilder extends BreserhamLineBuilder {

	public VerticalBreserhamLineBuilder(Point start, Point end) {
		super(start, end);
	}

	@Override
	public DependentCoordinate createDependentCoordinate() {
		Integer coordinate = getStart().getX();
		Integer errorStep = getHorizontalProjection();
		Integer extremalError = getVerticalProjection();
		DependentCoordinate dependentCoordinateCalculator = new DependentCoordinate(coordinate, errorStep, extremalError);
		dependentCoordinateCalculator.findDirection(getStart().getX(), getEnd().getX());
		return dependentCoordinateCalculator;
	}

	@Override
	public void setDependentCoordinate(Point point, Integer coordinate) {
		point.setX(coordinate);
	}

	@Override
	public List<Point> generateInitialPoints() {
		List<Point>pixels = new ArrayList<Point>();
		for(int i = 0; i <= getVerticalProjection(); ++i) {
			int y = getStart().getY() + i;
			pixels.add(Point.create(null, y));
		}
		return pixels;
	}

	@Override
	public Boolean isPointOrderCorrect() {
		if(getStart().getY() <= getEnd().getY()){
			return true;
		}
		return false;
	}

}
