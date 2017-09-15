/**
 * Created by kottejimmy on 9/7/2017.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.EventQueue;
import javax.swing.JFrame;


//the actual stopwatch
public class StopWatch {
    private WatchGUI myGui;
    private int hours;
    private int min;
    private int sec;
    private int dsec; //1/10 second

    public boolean isThreadStarted() {
        return threadStarted;
    }

    private boolean threadStarted;
    public boolean timer;

    public StopWatch(){
        //initiate time
        hours=0;
        min=0;
        sec=0;
        dsec=0;
        threadStarted = true;
        timer = false;

        //createthreadClass

        //create GUI
        myGui = new WatchGUI(this);
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myGui.setVisible(true);
            }
        });
    }

    public void start(){
      Thread a = new Thread(new ThreadClass(this));
      this.threadStarted=true;
      a.start();

    }

    public void stop()  {

        threadStarted=false;

    }

    public void reset(){
        hours=0;
        min=0;
        sec=0;
        dsec=0;
        myGui.writeTime(hours+":"+min+":"+sec+"."+dsec);
    }

    public void tick(){
        dsec++;
        if (dsec==10){
            sec++;
            dsec=0;
        }
        if (sec==60){
            min++;
            sec=0;
        }
        if (min==60){
            hours++;
            min = 0;
        }
        if (hours==24&&min==60&&sec==60&&dsec==10){
            reset();
        }
        myGui.writeTime(hours+":"+min+":"+sec+"."+dsec);

    }
}
