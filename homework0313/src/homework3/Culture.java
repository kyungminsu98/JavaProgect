package homework3;

public class Culture {
	 protected String title;
	 protected int directorCount;
	 protected int actorCount;
	 protected int audience;
	 protected int totalScore;
	 
	 public Culture(String title, int directorCount, int actorCount) {
		 this.title = title;
	     this.directorCount = directorCount;
	     this.actorCount = actorCount;
	 }
	 public void setTotalScore(int score) {
	     this.audience++;
	     this.totalScore += score;
	 }
}
