package burtgel;

import java.awt.Dimension;
import java.awt.Toolkit;

public interface BurtgelInterface {
    
    Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
    final int screen_width = (int)resolution.getWidth();
    final int screen_height = (int)resolution.getHeight();
}
