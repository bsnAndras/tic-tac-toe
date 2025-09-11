public enum Player {
    X, O, EMPTY;

    public Player switchPlayer(){
        if(this.equals(Player.valueOf("X"))){
            return Player.O;
        }

        if(this.equals(Player.valueOf("O"))){
            return Player.X;
        }

        System.err.println("switchPlayer() method can only be applied to Player.X and Player.O !");
        return this;
    }

    public String toString(){
        if(this.equals(Player.EMPTY)){
            return " ";
        } else {
            return this.name();
        }
    }
}
