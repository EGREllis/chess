package net.ellise.backend.model.factory;

import net.ellise.backend.model.Vector;

import java.util.Set;

public class KnightValidatorPointFactory extends VectorValidatorPointFactory {
    @Override
    protected Set<Vector> getDirections() {
        return Vector.KNIGHTS;
    }

    @Override
    protected int maxDistance() {
        return 1;
    }
}
