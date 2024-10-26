import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LitePegButton extends JButton {
    private final Color[] COLOR = {Color.black, Color.RED, Color.BLUE, Color.GREEN};
    private int colorIndex;

    public LitePegButton(){
        colorIndex=0;
        this.setBackground(COLOR[colorIndex]);
        this.addActionListener(new LightPegListener());

    }
    

    public void reset(){
        colorIndex= 0;
        this.setBackground(COLOR[colorIndex]);
    }

    private class LightPegListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           colorIndex++;
           JButton theButton = (JButton) e.getSource();
           colorIndex = colorIndex%COLOR.length;
        //    if(colorIndex==COLOR.length){
        //     colorIndex=0;
        //    }
           theButton.setBackground(COLOR[colorIndex]);
        }

    }


}
