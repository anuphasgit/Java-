
public class QuickDraw {
    public static void main(String[] args){
        // Checking methods
    //     DeckOfCards myDeck= new DeckOfCards();
    // System.out.println("New Deck:");
    // System.out.println(myDeck.toString());

    // myDeck.shuffle();
    // System.out.println("Shuffled deck:");;
    // System.out.println(myDeck.toString());

    // System.out.println("Num cards Dealt "+myDeck.numCardsDealt());
    // System.out.println("Num Cards Remaining"+myDeck.numCardsRemaining());

    // while(myDeck.numCardsRemaining()>0){
    //     Card nextCard = myDeck.draw();
    //     System.out.println(nextCard.toString());
    //     System.out.println("Num cards dealt "+myDeck.numCardsDealt());
    //     System.out.println("Num cards remaining"+ myDeck.numCardsRemaining());

    // }
    // if (myDeck.draw()==null){
    //     System.out.println("Sucessfully recognized end of deck");
    // }
    // else{
    //     System.out.println("Failed");
    // }
    if(args.length != 2){//@ command line argument
    System.out.println("Usage : java QuickDraw player1Name player2Name");
    return ;
    }

    //Validating argument
    String player1 = args[0];
    String player2 = args[1];

    DeckOfCards myDeck = new DeckOfCards();
    myDeck.shuffle();
     
    Card p1Card= myDeck.draw();
    Card p2Card = myDeck.draw();
    System.out.println(player1+"'s card: "+p1Card.toString());
    System.out.println(player2+"'s card: "+ p2Card.toString());

    if (p1Card.compareTo(p2Card) < 0){
        System.out.println(player1+" is the winner.");
    }
    else if(p1Card.compareTo(p2Card)> 0){
        System.out.println(player2+" is the winner.");
    }
    else{
        System.out.println("It's a tie.");
    }

    }
}
