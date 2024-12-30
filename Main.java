//correct one

public class Main {
    private static int[] state;
    private static int moves = 0;

    public static void main(String[] args) {
        int n = 5;
        // Set the initial state with all rings on the skewer
        state = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            state[i] = 1;
        }

        flip(n);

        System.out.println("# of moves: " + moves);
    }

    private static void flip(int n){
        if(n == 1){
            move(1);
        }else if(n==2){
            move(1);
            move(2);
        }else{
            flip(n-2);
            move(n);
            flip(n-2);
            flip(n-1);
        }
    }

    private static void move(int i) {
        // looks at the index of the list
        // sets that index to
        state[i] = 1 - state[i];
        moves++;
        System.out.println("--" + i + "-> " + getStateString());
    }


    private static void printState() {
        System.out.println(getStateString());
    }


    private static String getStateString() {
        // the state as a string
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < state.length; i++) {
            sb.append(state[i]);
        }
        return sb.toString();
    }
}
