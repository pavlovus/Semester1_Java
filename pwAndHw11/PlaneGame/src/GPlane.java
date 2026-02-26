import acm.graphics.GCompound;
import acm.graphics.GPolygon;


public class GPlane extends GCompound{
	public GPlane(double width, double height){
		body = new GPolygon();
		body.addVertex(0, height/5);
		body.addVertex(width/7.5, height*3/5);
		body.addVertex(width*2/5, height*3/5);
		body.addVertex(width/3, height);
		body.addVertex(width*7/15, height);
		body.addVertex(width*3/5, height*3/5);
		body.addVertex(width*13/15,height*3/5);
		body.addVertex(width, height/2);
		body.addVertex(width*13/15, height*2/5);
		body.addVertex(width*3/5, height*2/5);
		body.addVertex(width*2/5, height*2/5);
		body.addVertex(width*3/5, height*2/5);
		body.addVertex(width*7/15, 0);
		body.addVertex(width/3, 0);
		body.addVertex(width*2/5, height*2/5);
		body.addVertex(width/7.5,height*2/5);
		body.addVertex(width/15, height/5);
		body.addVertex(0, height/5);
		body.addEdge(width/7.5, height*2/5);
		body.addEdge(width*4/15, 0);
		body.addEdge(-width/15,  height*2/5);
		body.addEdge(width/7.5, 0);
		body.addEdge( width/7.5, -height*2/5);
		body.addEdge(width*4/15, 0);
		body.addEdge(width/7.5, -height/10);
		body.addEdge(-width/7.5, -height/10);
		body.addEdge(-width*4/15, 0);
		body.addEdge(-width/7.5, -height*2/5);
		body.addEdge(-width/7.5, 0);
		body.addEdge(width/15,  height*2/5);
		body.addEdge(-width*4/15, 0);
		body.addEdge(-width/15, height/5);
		body.addEdge(-width/15, 0);
		add(body);
	}
	private GPolygon body;
}
