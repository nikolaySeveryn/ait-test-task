package nks.service.graphics.raster;

class HorizontalBreserhamLoop extends BreserhamLoop {

	public HorizontalBreserhamLoop(Point start, Point end) {
		super(start, end);
	}


	@Override
	public void generateInitialPoints() {
		for(int i = 0; i <= getHorizontalProjection(); ++i) {
			int x = getStart().getX() + i;
			getPixels().add(new Point(x, null));
		}
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
