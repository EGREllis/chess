package net.ellise.backend.model.factory;

import lombok.extern.slf4j.Slf4j;
import net.ellise.backend.model.Vector;

import java.util.Set;

@Slf4j
public class BishopValidatorPointFactory extends VectorValidatorPointFactory implements PointFactory {

    @Override
    protected Set<Vector> getDirections() {
        return Vector.DIAGONALS;
    }

    @Override
    protected int maxDistance() {
        return 8;
    }
}
