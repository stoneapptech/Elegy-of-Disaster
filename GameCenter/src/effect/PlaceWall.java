package effect;

import pipe.Pipe;
import propperty.Wall;

public class PlaceWall extends Effect {

    private Pipe wallOwner;
    public PlaceWall(Pipe wallOwner) {
        this.wallOwner = wallOwner;
    }

    @Override
    public boolean invoke() {
        wallOwner.placeProperty(new Wall());
        return true;
    }
}
