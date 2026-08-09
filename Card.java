import java.util.Arrays;

public class Card {
    public static final String[] SUITS = {"Club", "Diamond", "Heart", "Spade"};
    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "Jack", "Queen", "King"};

    private final int rank;
    private final int suite;

    public int getRank() {
        return this.rank;
    }

    public int getSuite() {
        return this.suite;
    }

    public Card(int rank, int suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public static void printDeck(Card[] deck) {
        for (Card card : deck) {
            System.out.println(card);
        }
    }

    public static int search(Card[] cards, Card target) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static int biSearch(Card[] cards, Card target) {
        int low = 0;
        int high = cards.length - 1;
        while (low <= high) {
            System.out.println(low+", "+high);
            int mid = (low + high) / 2;
            int comp = cards[mid].compareTo(target);
            if (comp == 0) return mid;
            if (comp == -1) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suite];
    }

    public boolean equals(Card card) {
        return this.rank == card.rank && this.suite == card.suite;
    }

    public int compareTo(Card card) {
        if (this.suite < card.suite) return -1;
        if (this.suite > card.suite) return 1;
        if (this.rank < card.rank) return -1;
        if (this.rank > card.rank) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Card[] cards = new Card[52];
        //if (cards[0] == null) System.out.println("No cards yet !!");
        int ind = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 1; j <= 13; j++) {
                cards[ind++] = new Card(j, i);
            }
        }
        System.out.println(Arrays.toString(cards));       // Prints the Deck Created in Array format
        int val = search(cards, new Card(10, 2));// Sequenial search
        if (val != -1) {
            System.out.println(cards[val].toString());
        } else {
            System.out.println("This card does not exist");
        }

        int bival = biSearch(cards, new Card(1, 1)); // Binary Search
        if (bival != -1) {
            System.out.println(cards[bival].toString());
        } else {
            System.out.println("This card does not exist");
        }
    }
}

