package corto4;

import vista.consulta;

public class Corto4 {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new consulta().setVisible(true);
            }
        });
    }
    
}
