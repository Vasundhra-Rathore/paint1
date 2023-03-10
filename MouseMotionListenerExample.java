import java.awt.*;
import java.applet.*;
/*
 <APPLET CODE="Flyingkite.JAVA" WIDTH=500 HEIGHT=500>
 </APPLET>
*/
//The basic applet class.The applet shows kite flying
public class Flyingkite extends Applet implements Runnable
{
    Thread t;
    //4 variables used to vary the kite positions.
    int x1=10,y1=1,tx=10,ty=10;
    public void start()
    {
        if(t==null)
        {
            t=new Thread(this,"New Thread");//New side Thread created on start of applet.
            t.start();
        }
    }
    public void stop()
    {
        if(t!=null)
        {
            t=null;//On stop of applet the created thread is destroyed.
        }
    }
    //Implementation of method run() of Runnable interface.
    public void run()
    {
        Thread t1=Thread.currentThread();
        while(t==t1)
        {
            repaint();
            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {

            }
        }
    }
    public void paint(Graphics g)
    {
        x1 += tx;
        if(x1 > 500)
            tx = -5;
        if(x1 < 0 )
            tx = 10;
        y1 += ty;
        if(y1 > 100)
            ty = -10;
        if(y1 < 0 )
            ty = 10;
        g.setColor(Color.BLACK);
        int x[]={200+x1,250+x1,200+x1,150+x1,200+x1};
        int y[]={200+y1,270+y1,350+y1,270+y1,200+y1};
        g.fillPolygon(x,y,5);
        g.setColor(Color.RED);
        //for wings of kite
        g.drawLine(200+x1,348+y1,210+x1,380+y1);
        g.drawLine(200+x1,348+y1,200+x1,380+y1);
        g.drawLine(200+x1,348+y1,190+x1,380+y1);
        g.drawLine(200+x1,348+y1,180+x1,380+y1);
        g.drawLine(200+x1,348+y1,170+x1,380+y1);
        g.drawLine(200+x1,348+y1,220+x1,380+y1);
        g.drawLine(200+x1,348+y1,230+x1,380+y1);
        g.drawLine(170+x1,380+y1,230+x1,380+y1);
        //for inside structure of kite
        g.setColor(Color.RED);
        g.drawLine(200+x1,230+y1,200+x1,320+y1);
        g.drawLine(160+x1,270+y1,240+x1,270+y1);
        g.drawLine(200+x1,230+y1,160+x1,270+y1);
        g.drawLine(200+x1,230+y1,240+x1,270+y1);
        g.drawLine(240+x1,270+y1,200+x1,320+y1);
        g.drawLine(200+x1,320+y1,160+x1,270+y1);
        //for kite string
        g.setColor(Color.RED);
        g.drawLine(700,700,200+x1,350+y1);
    }
}