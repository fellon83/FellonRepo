package esami.Lab20140220;

public class Process {
	
	private int id;
	private String path;

	public Process(String path) {
		this.path=path;
		this.id=this.hashCode();
		
	}
	public int getID() {
		return id;
	}
	
	public String getPath() {
		return path;
	}
	public String toString() {
		String pathID = "Path: " + path + " " + "ID: " + String.valueOf(id);
		return pathID;
	}
}
