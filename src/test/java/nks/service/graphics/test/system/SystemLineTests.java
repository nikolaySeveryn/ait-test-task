package nks.service.graphics.test.system;


import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

import nks.service.graphics.api.GraphicsService;
import nks.service.graphics.api.GraphicsServiceImpl;
import nks.service.graphics.raster.Point;

public class SystemLineTests {
	
	private GraphicsService service = new GraphicsServiceImpl();
	
	private List<Point> result;

	
	@Test
	public void testHorizontalIncreasing(){
		result = service.getLine(Point.create(2, 2), Point.create(16, 5));
		checkHorizontalIncreasing();
		result = service.getLine(Point.create(16, 5), Point.create(2, 2));
		checkHorizontalIncreasing();
	}
	

	private void checkHorizontalIncreasing() {
		assertThat(result, containsInAnyOrder(
				Point.create(2,2),
				Point.create(3,2),
				Point.create(4,2),
				Point.create(5,3),
				Point.create(6,3),
				Point.create(7,3),
				Point.create(8,3),
				Point.create(9,4),
				Point.create(10,4),
				Point.create(11,4),
				Point.create(12,4),
				Point.create(13,4),
				Point.create(14,5),
				Point.create(15,5),
				Point.create(16,5)
				));
	}
	
	@Test
	public void testHorizontalDecreasing(){
		result = service.getLine(Point.create(2, 6), Point.create(14, 1));
		checkHorizontalDecreasing();
		result = service.getLine(Point.create(14, 1), Point.create(2, 6));
		checkHorizontalDecreasing();
	}
	
	private void checkHorizontalDecreasing(){
		assertThat(result, containsInAnyOrder(
				Point.create(2,6),
				Point.create(3,6),
				Point.create(4,5),
				Point.create(5,5),
				Point.create(6,4),
				Point.create(7,4),
				Point.create(8,3),
				Point.create(9,3),
				Point.create(10,3),
				Point.create(11,2),
				Point.create(12,2),
				Point.create(13,1),
				Point.create(14,1)
				));
	}
	
	@Test
	public void testVerticalIncreasing(){
		result = service.getLine(Point.create(2, 2), Point.create(5, 16));
		checkVerticalIncriasing();
		result = service.getLine(Point.create(5, 16), Point.create(2, 2));
		checkVerticalIncriasing();
	}
	
	private void checkVerticalIncriasing() {
		assertThat(result, containsInAnyOrder(
				Point.create(2, 2),
				Point.create(2, 3),
				Point.create(2, 4),
				Point.create(3, 5),
				Point.create(3, 6),
				Point.create(3, 7),
				Point.create(3, 8),
				Point.create(4, 9),
				Point.create(4, 10),
				Point.create(4, 11),
				Point.create(4, 12),
				Point.create(4, 13),
				Point.create(5, 14),
				Point.create(5, 15),
				Point.create(5, 16)
				));
	}
	
	@Test
	public void testVerticalDecreasing(){
		result = service.getLine(Point.create(6, 2), Point.create(1, 14));
		checkVerticalDecreasing();
		result = service.getLine(Point.create(1, 14), Point.create(6, 2));
		checkVerticalDecreasing();
	}
	
	private void checkVerticalDecreasing(){
		assertThat(result, containsInAnyOrder(
				Point.create(6, 2),
				Point.create(6, 3),
				Point.create(5, 4),
				Point.create(5, 5),
				Point.create(4, 6),
				Point.create(4, 7),
				Point.create(3, 8),
				Point.create(3, 9),
				Point.create(3, 10),
				Point.create(2, 11),
				Point.create(2, 12),
				Point.create(1, 13),
				Point.create(1, 14)
				));
	}
	
	@Test
	public void testAbsolutelyHorizotal(){
		result = service.getLine(Point.create(2, 3), Point.create(16, 3));
		checkAbsolutelyHorizotal();
		result = service.getLine(Point.create(16, 3), Point.create(2, 3));
		checkAbsolutelyHorizotal();
	}
	
	private void checkAbsolutelyHorizotal(){
		assertThat(result, containsInAnyOrder(
				Point.create(2, 3),
				Point.create(3, 3),
				Point.create(4, 3),
				Point.create(5, 3),
				Point.create(6, 3),
				Point.create(7, 3),
				Point.create(8, 3),
				Point.create(9, 3),
				Point.create(10,3),
				Point.create(11,3),
				Point.create(12,3),
				Point.create(13,3),
				Point.create(14,3),
				Point.create(15,3),
				Point.create(16,3)
				));
	}
	
	@Test
	public void testAbsolutelyVertical(){
		result = service.getLine(Point.create(3, 2), Point.create(3, 16));
		checkAbsolutelyVertical();
		result = service.getLine(Point.create(3, 16), Point.create(3, 2));
		checkAbsolutelyVertical();
	}
	
	private void checkAbsolutelyVertical(){
		assertThat(result, containsInAnyOrder(
				Point.create(3, 2),
				Point.create(3, 3),
				Point.create(3, 4),
				Point.create(3, 5),
				Point.create(3, 6),
				Point.create(3, 7),
				Point.create(3, 8),
				Point.create(3, 9),
				Point.create(3, 10),
				Point.create(3, 11),
				Point.create(3, 12),
				Point.create(3, 13),
				Point.create(3, 14),
				Point.create(3, 15),
				Point.create(3, 16)
				));
	}
	
	public void test45Degrees(){
		result = service.getLine(Point.create(0, 2), Point.create(15, 17));
		check45Degrees();
		result = service.getLine(Point.create(15, 17), Point.create(0, 2));
		check45Degrees();
	}
	
	private void check45Degrees(){
		assertThat(result, containsInAnyOrder(
				Point.create(0, 2),
				Point.create(1, 3),
				Point.create(2, 4),
				Point.create(3, 5),
				Point.create(4, 6),
				Point.create(5, 7),
				Point.create(6, 8),
				Point.create(7, 9),
				Point.create(8, 10),
				Point.create(9, 11),
				Point.create(10, 12),
				Point.create(11, 13),
				Point.create(12, 14),
				Point.create(13, 15),
				Point.create(14, 16),
				Point.create(15, 17)
				));
	}
	
	@Test
	public void testXCrossingHorizontal(){
		result = service.getLine(Point.create(0, 2), Point.create(11, -4));
		checkXCrossingHorizontal();
		result = service.getLine(Point.create(11, -4), Point.create(0, 2));
		checkXCrossingHorizontal();
	}
	
	private void checkXCrossingHorizontal(){
		assertThat(result, containsInAnyOrder(
				Point.create(0,2),
				Point.create(1,1),
				Point.create(2,1),
				Point.create(3,0),
				Point.create(4,0),
				Point.create(5,-1),
				Point.create(6,-1),
				Point.create(7,-2),
				Point.create(8,-2),
				Point.create(9,-3),
				Point.create(10,-3),
				Point.create(11,-4)
				));
	}
	
	@Test
	public void testXCrossingVertical(){
		result = service.getLine(Point.create(2, -7), Point.create(6, 9));
		checkXCrossingVertical();
		result = service.getLine(Point.create(6, 9), Point.create(2, -7));
		checkXCrossingVertical();
	}
	
	private void checkXCrossingVertical(){
		assertThat(result, containsInAnyOrder(
				Point.create(2,-7),
				Point.create(2,-6),
				Point.create(3,-5),
				Point.create(3,-4),
				Point.create(3,-3),
				Point.create(3,-2),
				Point.create(4,-1),
				Point.create(4, 0),
				Point.create(4, 1),
				Point.create(4, 2),
				Point.create(5, 3),
				Point.create(5, 4),
				Point.create(5, 5),
				Point.create(5, 6),
				Point.create(6, 7),
				Point.create(6, 8),
				Point.create(6, 9)
				));
	}
	
	
	
	
	
	
	@Test
	public void testYCrossingHorizontal(){
		result = service.getLine(Point.create(2, 0), Point.create(-4, 11));
		checkYCrossingHorizontal();
		result = service.getLine(Point.create(-4, 11), Point.create(2, 0));
		checkYCrossingHorizontal();
	}
	
	private void checkYCrossingHorizontal(){
		assertThat(result, containsInAnyOrder(
				Point.create(2,  0),
				Point.create(1,  1),
				Point.create(1,  2),
				Point.create(0,  3),
				Point.create(0,  4),
				Point.create(-1, 5),
				Point.create(-1, 6),
				Point.create(-2, 7),
				Point.create(-2, 8),
				Point.create(-3, 9),
				Point.create(-3, 10),
				Point.create(-4, 11)
				));
	}
	
	@Test
	public void testYCrossingVertical(){
		result = service.getLine(Point.create(-7, 2), Point.create(9, 6));
		checkYCrossingVertical();
		result = service.getLine(Point.create(9, 6), Point.create(-7, 2));
		checkYCrossingVertical();
	}
	
	private void checkYCrossingVertical(){
		assertThat(result, containsInAnyOrder(
				Point.create(-7, 2),
				Point.create(-6, 2),
				Point.create(-5, 3),
				Point.create(-4, 3),
				Point.create(-3, 3),
				Point.create(-2, 3),
				Point.create(-1, 4),
				Point.create( 0, 4),
				Point.create( 1, 4),
				Point.create( 2, 4),
				Point.create( 3, 5),
				Point.create( 4, 5),
				Point.create( 5, 5),
				Point.create( 6, 5),
				Point.create( 7, 6),
				Point.create( 8, 6),
				Point.create( 9, 6)
				));
	}
	
	private void printResult(){
		for(Point p: result){
			System.out.println(p);
		}
	}
}
