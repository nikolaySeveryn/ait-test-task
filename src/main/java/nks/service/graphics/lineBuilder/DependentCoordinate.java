package nks.service.graphics.lineBuilder;

/**
 * This class responds for incrementing dependent coordinate when error reach extremal value.
 * Also it manages error value.
 * 
 * @author nks
 *
 */
class DependentCoordinate {
	
	public enum Direction{
		INCREASING,
		DECREASING
	}
	
	private Integer coordinateValue;
	private Integer error;
	private Integer errorStep;
	private Integer extremalError;
	private Direction updatingDirection;
	
	public DependentCoordinate(Integer coordinateValue, Integer errorStep, Integer extremalError) {
		super();
		this.coordinateValue = coordinateValue;
		this.errorStep = errorStep;
		this.extremalError = extremalError;
		
		this.error = 0;
	}
	
	public void findDirection(Integer start, Integer end){
		//right order start and end coordinate was checked before
		if(start <= end){
			updatingDirection = Direction.INCREASING;
		}
		else{
			updatingDirection = Direction.DECREASING;
		}
	}
	
	
	public void nextIteration() {
		error += errorStep;
		if(2*error >= extremalError){
			updateValue();
			error -= extremalError;
		}
	}
	
	private void updateValue(){
		if(Direction.INCREASING.equals(updatingDirection)) {
			++coordinateValue;
		}
		else if(Direction.DECREASING.equals(updatingDirection)) {
			--coordinateValue;
		}
		else {
			throw new IllegalStateException("Undefined updating direction");
		}
	}
	
	
	public Integer getCoordinateValue(){
		return coordinateValue;
	}
}
