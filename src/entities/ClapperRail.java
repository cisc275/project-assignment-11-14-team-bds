package entities;
public class ClapperRail extends Bird{
	private int branches;
	private boolean invisible;
	
	public int getNumBranches() {
		return this.branches;
	}
	
	public void incBranches() {
		branches = branches + 1;
	}
	
	
}

