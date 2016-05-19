import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
//import com.bruceeckel.swing.*;

// Shows progress bar tied to a slider bar.  
// mearly interesting, not much more

public class ProgressSlider extends JFrame {

  JProgressBar pb = new JProgressBar();
  JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);
  
  public ProgressSlider() {
    setLayout(new GridLayout(2,1));
    add(pb);
    sb.setValue(0);
    sb.setPaintTicks(true);
    sb.setMajorTickSpacing(20);
    sb.setMinorTickSpacing(5);
    sb.setBorder(new TitledBorder("Slide Me"));
    pb.setModel(sb.getModel());		 // Share model
    add(sb);
	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 pack();
	 setTitle("Slide me");
	 setLocationRelativeTo(null);
	 setVisible(true);
  }
  public static void main(String[] args) {
    new ProgressSlider();
  }
}