package sae.raytracing.scene;

import sae.raytracing.elements.IElements;
import sae.raytracing.lights.ILight;
import sae.raytracing.triplet.Color;

public interface IBuilder {
    void setCheckerAll(boolean val, Color c1, Color c2, double size);
    void setDimensions( int width, int height);
    void setCamera(Camera camera);
    void setAmbient(Color color);
    void setShadow(boolean shadow);
    void setMaxDepth(int maxDepth);
    void addLights(ILight lights);
    void addElements(IElements elements);
    Scene scene();
}
