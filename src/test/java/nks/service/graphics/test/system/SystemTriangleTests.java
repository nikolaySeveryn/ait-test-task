package nks.service.graphics.test.system;

import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.Test;

import nks.service.graphics.api.GraphicsService;
import nks.service.graphics.api.GraphicsServiceImpl;
import nks.service.graphics.raster.Point;

public class SystemTriangleTests {

	private GraphicsService service = new GraphicsServiceImpl();
	private List<Point> result;
	
	@Test
	public void testSimpleTriangle() {
		result = service.getTriangle(Point.create(3, 13), Point.create(9, 3), Point.create(16, 10));
		checkSimpleTriangle();
		result = service.getTriangle(Point.create(9, 3),Point.create(3, 13), Point.create(16, 10));
		checkSimpleTriangle();
		result = service.getTriangle(Point.create(9, 3), Point.create(16, 10), Point.create(3, 13));
		checkSimpleTriangle();
		result = service.getTriangle(Point.create(3, 13), Point.create(16, 10), Point.create(9, 3));
		checkSimpleTriangle();		
	}
	
	private void checkSimpleTriangle() {
		assertThat(result, containsInAnyOrder(
				Point.create(12,11),
				Point.create(10,11),
				Point.create(6,8),
				Point.create(8,12),
				Point.create(6,12),
				Point.create(4,11),
				Point.create(4,12),
				Point.create(4,13),
				Point.create(9,3),
				Point.create(11,5),
				Point.create(13,7),
				Point.create(15,9),
				Point.create(15,10),
				Point.create(13,11),
				Point.create(7,6),
				Point.create(7,7),
				Point.create(11,11),
				Point.create(9,12),
				Point.create(5,9),
				Point.create(5,10),
				Point.create(7,12),
				Point.create(5,13),
				Point.create(3,13),
				Point.create(10,4),
				Point.create(12,6),
				Point.create(14,8),
				Point.create(16,10),
				Point.create(8,4),
				Point.create(14,10),
				Point.create(8,5)
				));
	}
	
	@Test
	public void testRightTriangleWithAxisCrosses() {
		result = service.getTriangle(Point.create(-4, 5), Point.create(-4, -6), Point.create(3, 5));
		checkRightTriangleWithAxisCrosses();
	}
	
	private void checkRightTriangleWithAxisCrosses() {
		assertThat(result, containsInAnyOrder(
				Point.create(-4,-5),
				Point.create(-2,-3),
				Point.create(-4,-4),
				Point.create(0,0),
				Point.create(-4,-3),
				Point.create(0,1),
				Point.create(2,3),
				Point.create(-4,-2),
				Point.create(2,4),
				Point.create(-4,-1),
				Point.create(2,5),
				Point.create(-4,0),
				Point.create(-4,1),
				Point.create(0,5),
				Point.create(-4,2),
				Point.create(-4,3),
				Point.create(-2,5),
				Point.create(-4,4),
				Point.create(-4,5),
				Point.create(-3,-5),
				Point.create(-3,-4),
				Point.create(-1,-2),
				Point.create(-1,-1),
				Point.create(1,2),
				Point.create(3,5),
				Point.create(1,5),
				Point.create(-1,5),
				Point.create(-3,5),
				Point.create(-4,-6)
				));
	}
	
	
	
	private void printResult() {
		for(Point p: result) {
			System.out.println(p);
		}
	}
}
