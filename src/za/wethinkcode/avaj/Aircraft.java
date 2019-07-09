package src.za.wethinkcode.avaj;

public class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private	static long	idCounter = 0L;
	private long nextid() { return (++idCounter); }
	public	Coordinates getCoordinates() { return this.coordinates; }
	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = this.idCounter;
		this.idCounter = nextid();
	}
}
