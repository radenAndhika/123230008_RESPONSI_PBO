package main;
import View.ParkirView;

public class main {

    public static void main(String[] args) {
    
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new ParkirView().setVisible(true);
            }
        });
    }

}

