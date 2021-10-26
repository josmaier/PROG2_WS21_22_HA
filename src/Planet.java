public enum Planet {
    Merkur, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptun, Pluto;

    private final static double Circumfrence [] =
            {2440000, 6051000, 6378000, 1738000, 3397000, 71492000, 60268000, 25559000, 24764000, 1160000};

    private final static double Mass [] =
            {3.30E23, 4.87E24, 5.97E24, 7.35E22, 6.42E23, 1.90E27, 5.69E26, 8.66E25, 1.03E26, 1.31E22};

    public double getMass(){
        return Mass[ordinal()];
    }

    public double getCircumfrence(){
        return  Circumfrence[ordinal()];
    }

    public boolean largerThan(Planet p2){
        return (this.getCircumfrence() > p2.getCircumfrence());
    }

    public boolean heavierThan(Planet p2){
        return (this.getMass() > p2.getMass());
    }

    public boolean closerToSun(Planet p2){
        return (this.ordinal() < p2.ordinal());
    }

    public String nextPlanet(){
        Planet p[] = Planet.values();
        if(this.ordinal() == 9){
            return null;
        } else {
            return p[this.ordinal() + 1].toString();
        }
    }
}
