package net.ellise.backend.model.factory;

import lombok.extern.slf4j.Slf4j;
import net.ellise.backend.model.Vector;

import java.util.Set;

@Slf4j
public class QueenValidatorPointFactory extends VectorValidatorPointFactory implements PointFactory {

    @Override
    protected Set<Vector> getDirections() {
        return Vector.ALL_NON_ZERO;
    }

    @Override
    protected int maxDistance() {
        return 8;
    }
}
