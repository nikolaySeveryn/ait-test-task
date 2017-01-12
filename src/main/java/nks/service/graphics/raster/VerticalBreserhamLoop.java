package nks.service.graphics.raster;

class VerticalBreserhamLoop extends BreserhamLoop {

	public VerticalBreserhamLoop(Point start, Point end) {
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
	public void generateInitialPoints() {
		for(int i = 0; i <= getVerticalProjection(); ++i) {
			int y = getStart().getY() + i;
			getPixels().add(new Point(null, y));
		}
	}

	@Override
	public Boolean isPointOrderCorrect() {
		if(getStart().getY() <= getEnd().getY()){
			return true;
		}
		return false;
	}

}
