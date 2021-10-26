public class PlanetTest {

    public static void main(String[] args){
        Planet P = Planet.Pluto;

        P = Planet.Earth;

        System.out.println(P.nextPlanet());

        System.out.println("Is the earth bigger than jupiter? " + P.largerThan(Planet.Jupiter));
        System.out.println("Is the earth heavier than venus? " + P.heavierThan(Planet.Venus));
        System.out.println("What planet comes after the earth? " + P.nextPlanet());
        System.out.println("Is the earth or neptune closer to the sun? " + P.closerToSun(Planet.Neptun));

    }
}
