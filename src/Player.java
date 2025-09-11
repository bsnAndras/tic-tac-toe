public enum Player {
    X, O, EMPTY;

    public String toString(){
        if(this.equals(Player.EMPTY)){
            return " ";
        } else {
            return this.name();
        }
    }
}
