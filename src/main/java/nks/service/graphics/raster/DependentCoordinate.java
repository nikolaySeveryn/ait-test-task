package nks.service.graphics.raster;

public class DependentCoordinate {
	
	public enum Direction{
		INCREASING,
		DECREASING
	}
	
	private Integer value;
	private Integer error;
	private Integer errorStep;
	private Integer extremalError;
	private Direction updatingDirection;
	
	public DependentCoordinate(Integer coordinate, Integer errorStep, Integer extremalError) {
		super();
		this.value = coordinate;
		this.errorStep = errorStep;
		this.extremalError = extremalError;
		
		this.error = 0;
	}
	
	public void findDirection(Integer start, Integer end){
		if(start <= end){
			updatingDirection = Direction.INCREASING;
		}
		else{
			updatingDirection = Direction.DECREASING;
		}
	}
	
	public void increateError() {
		error += errorStep;
	}
	
	public void nextIteration() {
		increateError();
		if(2*error >= extremalError){
			updateValue();
			error -= extremalError;
		}
	}
	
	
	public void updateValue(){
		if(Direction.INCREASING.equals(updatingDirection)) {
			++value;
		}
		else if(Direction.DECREASING.equals(updatingDirection)) {
			--value;
		}
		else {
			throw new IllegalStateException("Undefined updating direction");
		}
	}
	
	
	public Integer getValue(){
		return value;
	}
}
