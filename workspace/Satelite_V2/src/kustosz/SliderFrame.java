package kustosz;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class SliderFrame extends JFrame {

	private static JSlider slider;
	private static int maxRange = 300;
	

	public SliderFrame() {


		slider = new JSlider(JSlider.HORIZONTAL, 0, maxRange,300);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		this.add(slider);
	}

//===========================================================================	
	public int getSliderValue() {

		//int result = slider.getMinorTickSpacing();
		return slider.getValue();
	}
}