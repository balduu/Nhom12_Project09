package Project_GK_Index;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private final int WIDTH = 500;
    private final int HEIGHT = 400;
    private final int DOT_SIZE = 5;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 60;
    private int DELAY = 70;

    private int x[] = new int[ALL_DOTS];
    private int y[] = new int[ALL_DOTS];
    
    private int dots;
    private int apple_x;
    private int apple_y;
    private int asgard_x;
    private int asgard_y;
    private int thor_x;
    private int thor_y;
    private int kratos_x;
    private int kratos_y;
    
    private int kill;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    private Image asgard;
    private Image thor;
    private Image kratos;
    
    private Image ending;


    public Board() {
        addKeyListener(new TAdapter());
        //setBackground(Color.blue);

        ImageIcon iid = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\dotr.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\apple.png");
        apple = iia.getImage();
        
        ImageIcon iias = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\asgard.png");
        asgard = iias.getImage();

        ImageIcon iih = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\headr.png");
        head = iih.getImage();
        
        ImageIcon iit = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\thor.png");
        thor = iit.getImage();
        
        ImageIcon iik = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\kratos.png");
        kratos = iik.getImage();

        setFocusable(true);
        initGame();
    }


    public void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z*10;
            y[z] = 50;
        }

        locateApple();
        locateAsgard();

        timer = new Timer(DELAY, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);
        Image img;
        img = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\midgard.png").getImage();
        Thor();
        Kratos();
    	g.drawImage(img, 0, 0, null);
        if (inGame) {
        	
            g.drawImage(apple, apple_x, apple_y, this);
            g.drawImage(asgard, asgard_x, asgard_y, this);
            
            if (kill >= 5)	
            	g.drawImage(thor, thor_x, thor_y, this);
            
            if (dots >= 10)
            	g.drawImage(kratos, kratos_x, kratos_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0)
                    g.drawImage(head, x[z], y[z], this);
                else g.drawImage(ball, x[z], y[z], this);
            }

            Toolkit.getDefaultToolkit().sync();
            g.dispose();

        } else {
        	
            gameOver(g);
        }
    }

        
    public void gameOver(Graphics g) {    	
    	
    	g.drawImage(ending, 0, 0, null);
    	
    	
    }


    public void checkApple() {

        if ((x[0] > apple_x - 10) && (y[0] > apple_y - 10) && (x[0] < apple_x+10) && (y[0] < apple_y + 10)) {
            dots++;
            kill++;
            locateApple();
        }
    }
    
    public void checkAsgard() {

        if ((x[0] > asgard_x - 10) && (y[0] > asgard_y - 10) && (x[0] < asgard_x+10) && (y[0] < asgard_y + 10)) {
            dots--;
            kill++;
            locateAsgard();
        }
    }
    
    public void checkThor() {

        if ((x[0] > thor_x -20 ) && (y[0] > thor_y - 20 ) && (x[0] < thor_x+30) && (y[0] < thor_y + 30)) {
        	ending = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\endingThor2.png").getImage();
        	if((dots != 15) && (dots != 25) && (dots != 35) && (dots != 45) && (dots != 55)) 
        		ending = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\endingThor1.png").getImage();
        	if(kill >= 5)
        		inGame = false;
        }
        if (dots >= 30)
        	ending = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\endingThor1.png").getImage();
    }
    
    public void checkKratos() {

        if ((x[0] > kratos_x -20 ) && (y[0] > kratos_y - 20 ) && (x[0] < kratos_x+30) && (y[0] < kratos_y + 30)) {
        	ending = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\endingGOW.png").getImage();
     	if((dots >= 15) || (kill >= 20))
        		inGame = false;
        }
    }


    public void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
            
        }

        if (left) {
            x[0] -= DOT_SIZE;
            ImageIcon iih = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\headl.png");
            head = iih.getImage();
            ImageIcon iid = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\dotl.png");
            ball = iid.getImage();
        }

        if (right) {
            x[0] += DOT_SIZE;
            ImageIcon iih = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\headr.png");
            head = iih.getImage();
            ImageIcon iid = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\dotr.png");
            ball = iid.getImage();
        }

        if (up) {
            y[0] -= DOT_SIZE;
            ImageIcon iih = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\headu.png");
            head = iih.getImage();
            ImageIcon iid = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\dotu.png");
            ball = iid.getImage();
        }

        if (down) {
            y[0] += DOT_SIZE;
            ImageIcon iih = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\headd.png");
            head = iih.getImage();
            ImageIcon iid = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\dotd.png");
            ball = iid.getImage();
        }
    }


    public void checkCollision() {

    	for (int z = dots; z > 0; z--) {
    		if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
    			ending = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\endingDeath.png").getImage();
    			inGame = false;
    		}
    	}
    	
    	if(dots == 0) {
    		ending = new ImageIcon("F:\\ZJava\\workspace\\T_virus\\Image\\Snake\\endingDeath.png").getImage();
    		inGame = false;
    	}
    		
        if (y[0] > HEIGHT) {
            //inGame = false;
        	y[0] = 0;
        }

        if (y[0] < 0) {
            //inGame = false;
        	y[0] = HEIGHT;
        }

        if (x[0] > WIDTH) {
            //inGame = false;
        	x[0] = 0;
        }

        if (x[0] < 0) {
            //inGame = false;
        	x[0] = WIDTH;
        }
    }

    public void locateApple() {
        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }
    
    public void locateAsgard() {
        int r = (int) (Math.random() * RAND_POS);
        asgard_x = ((r * DOT_SIZE));
        r = (int) (Math.random() * RAND_POS);
        asgard_y = ((r * DOT_SIZE));
    }
    
    public void Kratos() {
    	kratos_x = 400;
    	kratos_y = 50;
    }
    
    public void Thor() {
    	thor_x = 400;
    	thor_y = 250;
    }

    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            checkApple();
            checkAsgard();
            checkThor();
            checkKratos();
            checkCollision();
            move();
        }

        repaint();
    }


    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up)) {
                down = true;
                right = false;
                left = false;
            }
        }
    }
}