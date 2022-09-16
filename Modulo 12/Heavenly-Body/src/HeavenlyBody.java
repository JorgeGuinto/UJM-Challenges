import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON,
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    //Hacemos que el input sea un objeto en general para hacer un correcto "Override" del método
    //Sí lo dejáramos como un HeavenlyBody en lugar de genérico estaríamos haciendo un overload en lugar de un override
    public final boolean equals (Object body) {
        //Aquí se compara si tienen la misma referencia por lo que sería el mismo objeto
        if (this == body) {
            return true;
        }

        // Aquí se ve si lo que mandamos es "nada" o es una clase diferente por lo que no serían iguales
        /*if (body == null || (body.getClass() != this.getClass())) {
            return false;
        }*/
        // Lo eliminamos en el Challenge para ver otro método de comparación

        if (body instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) body;
            return this.key.equals((theObject).getKey());
        }
        return false;
    }

    @Override
    //No estoy muy seguro de porqué agregar un número pequeño arregla este tema.
    public final int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }
        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())){
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
