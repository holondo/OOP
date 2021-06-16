public class Card
{
        private int value;
        private char suit;
        

        public Card(int value, char suit)
        throws java.lang.IllegalArgumentException
        {
            suit = Character.toLowerCase(suit);
            if(value < 2 || value > 14) throw new IllegalArgumentException("Value must be between 2 and 15.");
            if(suit != 'd' && suit != 'c' && suit != 'h' && suit != 's') throw new IllegalArgumentException("Value must d(diamonds), c(clubs), h(hearts) or s(spades).");
            this.value = value;
            this.suit = suit;
        }

        public Card(String description)
        throws java.lang.IllegalArgumentException
        {
            String[] aux = description.split(" ");
            
            if(aux[1].toLowerCase().contains("queen") || aux[1].toLowerCase().contentEquals("q")) value = 11;
            if(aux[1].toLowerCase().contains("joker") || aux[1].toLowerCase().contentEquals("j")) value = 12;
            if(aux[1].toLowerCase().contains("king") || aux[1].toLowerCase().contentEquals("k")) value = 13;
            if(aux[1].toLowerCase().contains("ace") || aux[1].toLowerCase().contentEquals("A")) value = 14;

            

        }


        public static void main(String[] args) {
            
            try {
                Card a = new Card(2, 'c');
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
}