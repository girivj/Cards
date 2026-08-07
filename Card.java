public class Card {
  private int rank;
  private int suite;
  
  private String suits[] = {"Club","Diamond","Heart","Spade"};
  
  public Card(int rank, int suite){
    this.rank = rank;
    this.suite = suite;
  }

  public toString(){
    return String.format("%s of %d",this.suits[suite]);
  }
}
