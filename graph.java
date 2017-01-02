public class graph {
	
	private Room A = new Room("A");
	private Room B = new Room("B");
	private Room C = new Room("C");
	private Room D = new Room("D");
	private Room E = new Room("E");
	private Room F = new Room("F");
	private Room G = new Room("G");
	private Room H = new Room("H");
	private Room I = new Room("I");
	private Room J = new Room("J");
	private Room K = new Room("K");
	private Room L = new Room("L");
	public Room now = A;

	public graph(){
		A.setAll(null,B,null,E, new Slime("SS",1));
		B.setAll(null,null,A,F);
		C.setAll(null,D,null,G);
		D.setAll(null,null,C,null);
		E.setAll(A,null,null,I);
		F.setAll(B, G, null, null);
		G.setAll(C, H, F, K);
		H.setAll(null, null, G, L);
		I.setAll(E, J, null, null);
		J.setWest(I);
		K.setNorth(G);
		L.setNorth(H);
	}
}
