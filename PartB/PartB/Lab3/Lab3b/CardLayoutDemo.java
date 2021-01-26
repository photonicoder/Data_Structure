import java.awt.*;
import java.awt.event.*;
import java.applet.*;
//<applet code="CardLayoutDemo" width=450 height=500></applet>
public class CardLayoutDemo extends Applet implements ActionListener {
String msg;
Button redButton,greenButton,blueButton;
Panel mypanel;
CardLayout cardl;


Label myLabel;
public void init() {
myLabel=new Label("click the button to change background color");
blueButton=new Button("BLUE");
redButton=new Button("RED");
greenButton=new Button("GREEN");
cardl=new CardLayout();
mypanel=new Panel();
mypanel.setLayout(cardl);
Panel mypanel1=new Panel();
mypanel1.add(myLabel);
mypanel1.add(redButton);
mypanel1.add(blueButton);
mypanel1.add(greenButton);
mypanel.add(mypanel1,"Panel");
add(mypanel);
redButton.addActionListener(this);
blueButton.addActionListener(this);
greenButton.addActionListener(this);
}
public void actionPerformed(ActionEvent ae) {
String str=ae.getActionCommand();
if(str.equals("RED")) {
showStatus("you pressed red. The background color changes to red");
setBackground(Color.red);
}
if(str.equals("BLUE")) {
showStatus("you pressed blue. The background color changes to blue");
setBackground(Color.blue);
}
if(str.equals("GREEN")) {
showStatus("you pressed green. The background color changes to green");
setBackground(Color.green);
}
}
}
