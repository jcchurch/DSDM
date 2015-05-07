package edu.westga.dsdm.graph;

public class Edge {
	private Vertex a;
	private Vertex b;

	public Edge(Vertex a, Vertex b) {
		if (a == null) {
			throw new IllegalArgumentException("a is null");
		}

		if (b == null) {
			throw new IllegalArgumentException("b is null");
		}
		
		if (a == b) {
			throw new IllegalArgumentException("Vertices cannot be identical.");
		}

		this.a = a;
		this.b = b;
	}

	public boolean isVertexInEdge(Vertex aVertex) {
		return this.a == aVertex || this.b == aVertex;
	}
}
