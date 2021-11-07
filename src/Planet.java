public enum Planet {
    /**
     *  Setting elements of enum
     */
    Merkur, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptun, Pluto;

    /**
     *  Setting circumference and Mass arrays with values in order
     */
    private final static double Circumference [] =
            {2440000, 6051000, 6378000, 1738000, 3397000, 71492000, 60268000, 25559000, 24764000, 1160000};

    private final static double Mass [] =
            {3.30E23, 4.87E24, 5.97E24, 7.35E22, 6.42E23, 1.90E27, 5.69E26, 8.66E25, 1.03E26, 1.31E22};

    /**
     * Getter for the mass of a planet
     * @return double
     */
    public double getMass(){
        return Mass[ordinal()];
    }

    /**
     * Getter for the circumference of a object
     * @return double
     */
    public double getCircumference(){
        return  Circumference[ordinal()];
    }

    /**
     * Checks which object has the larger circumference using the getters
     * @param p2    Second planet to compare to
     * @return      boolean
     */
    public boolean largerThan(Planet p2){
        return (this.getCircumference() > p2.getCircumference());
    }

    /**
     * Compares the masses of both objects
     * @param p2    Second planet to compare to
     * @return      boolean
     */
    public boolean heavierThan(Planet p2){
        return (this.getMass() > p2.getMass());
    }

    /**
     * Compares the distance to the sun
     * @param p2    Second planet to compare to
     * @return      boolean
     */
    public boolean closerToSun(Planet p2){
        return (this.ordinal() < p2.ordinal());
    }

    /**
     * Outputs the next Planet in the order of their distance to the sun
     * @return  String
     */
    public String nextPlanet(){
        Planet p[] = Planet.values();
        if(this.ordinal() == 9){
            return null;
        } else {
            return p[this.ordinal() + 1].toString();
        }
    }
}
