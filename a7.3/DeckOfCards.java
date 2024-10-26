import java.util.Random;

public class DeckOfCards implements DeckOfCardsInterface{

    private int DECK_SIZE= 52;

    private Card[] deck;
    private int nextCardIndex;
    

    public DeckOfCards(){
        deck = new Card[DECK_SIZE];
        nextCardIndex = 0;
        

        int i= 0 ;
        for (Suit suit : Suit.values()){
            for (Rank rank: Rank.values()){
                deck[i]= new Card(suit,rank);
                i++;
            }
        }
    }

    public void shuffle(){
        Random random= new Random();
        for (int i=0; i < deck.length;i++){
            int j = random.nextInt(deck.length);
            Card temp = deck[i];
            deck[i]=deck[j];
            deck[j]= temp;
        }
        nextCardIndex=0;
    }

    public Card draw() {
        if(numCardsRemaining()>0){
            nextCardIndex++;
       return deck[nextCardIndex-1];
        }
        else {
            return null;
        }
    }

    public int numCardsRemaining(){
        return DECK_SIZE - nextCardIndex;
    }

    public int numCardsDealt(){
        
        return nextCardIndex;
    }

    public Card[] dealtCards(){
        return null;
    }

    public Card[] remainingCards(){
        return null;
    }
    public String toString(){
        String str= "";
        for(Card card: deck){
            str+= card.toString()+"\n";
        }
        return str;
    }
}