package com.example.prati.mp4;

import android.graphics.Bitmap;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Handlers for the worker threads
    private Handler t1Handler;
    private Handler t2Handler;
    private static boolean ifsomebodyhaswon=false;

    //To count the number of turns over so that the game can be stopped once the turns reach 9
    private static int turnscovered=0;


    //The UI handler responsible for updating the UI and send and receive messages from worker threads
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            int player_playing = msg.arg1;
            if (turnscovered <=10) {
                switch (player_playing) {
                    case 1:
                        int selectedbutton1 = msg.arg2;
                        Log.i("Arg val is", String.valueOf(+selectedbutton1));
                        try { Thread.sleep(1000); }
                       catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                        //Set the Text of the corresponding button number to X
                        BArray[selectedbutton1].setText("X");
                        turnscovered++;

                        player1choices.add(selectedbutton1);

                        //  Check if Player 1 won has already won by using all 8 conditions(3 rows ,3 columns and 2 diagonals)
                        // If yes show toast and break
                        if(player1choices.size()>=3)
                        {
                           if (player1choices.containsAll(Row1)) {
                               try { Thread.sleep(300); }
                               catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                               ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                           }
                            if (player1choices.containsAll(Row2)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }
                            if (player1choices.containsAll(Row3)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }
                            if (player1choices.containsAll(Col1)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;

                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }
                            if (player1choices.containsAll(Col2)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }

                            if (player1choices.containsAll(Col3)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }
                            if (player1choices.containsAll(Diag1)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }
                            if (player1choices.containsAll(Diag2)) {
                                try { Thread.sleep(300); }
                                catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                ifsomebodyhaswon=true;
                                Toast.makeText(MainActivity.this, "Player 1 has won!", Toast.LENGTH_SHORT).show();
                                break;

                            }




                        }
                        //Its a tie if no one has won , but number of turns has reached 9, show toast and break
                        if(turnscovered>=9) {
                            try { Thread.sleep(300); }
                            catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                            Toast.makeText(MainActivity.this, "It's a tie! Game ended", Toast.LENGTH_SHORT).show();
                            break;
                        }

                        try { Thread.sleep(1000); }
                        catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;

                        //Informing thread 2 (player 2 ) that thread 1(player 1) has finished its turn and it has to make a move now
                        //Obtain a message and send it to the Handler of thread2
                        Message callthread2=  Message.obtain();
                        t2Handler.sendMessage(callthread2);
                        break;

                    case 2:
                        int selectedbutton2 = msg.arg2;
                        Log.i("Arg val is", String.valueOf(+selectedbutton2));
                        try { Thread.sleep(1000); }
                        catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                        //Set the Text of the corresponding button number to O
                        BArray[selectedbutton2].setText("O");
                        turnscovered++;
                        player2choices.add(selectedbutton2);

                        //  Check if Player 2 won has already won by using all 8 conditions(3 rows ,3 columns and 2 diagonals)
                        // If yes show toast and break
                         if(player2choices.size()>=3)
                         {
                             if (player2choices.containsAll(Row1)) {
                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }
                             if (player2choices.containsAll(Row2)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }
                             if (player2choices.containsAll(Row3)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }
                             if (player2choices.containsAll(Col1)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }
                             if (player2choices.containsAll(Col2)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }

                             if (player2choices.containsAll(Col3)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }
                             if (player2choices.containsAll(Diag1)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }
                             if (player2choices.containsAll(Diag2)) {

                                 try { Thread.sleep(300); }
                                 catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                                 ifsomebodyhaswon=true;
                                 Toast.makeText(MainActivity.this, "Player 2 has won!", Toast.LENGTH_SHORT).show();
                                 break;

                             }

                         }
                        //Its a tie if no one has won , but number of turns has reached 9, show toast and break
                          if(turnscovered>=9) {
                              try { Thread.sleep(300); }
                              catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;
                              Toast.makeText(MainActivity.this, "It's a tie! Game ended", Toast.LENGTH_SHORT).show();
                              break;
                          }


                        try { Thread.sleep(1000); }
                        catch (InterruptedException e) { System.out.println("Thread interrupted!") ; } ;

                        //Informing thread 1 (player 1 ) that thread 2(player 2) has finished its turn and it has to make a move now
                        //Obtain a message and send it to the Handler of thread1

                        Message callthread1=  Message.obtain();
                        t1Handler.sendMessage(callthread1);
                        break;
                }

            }
        }
    };
    Button A1, A2, A3, B1, B2, B3, C1, C2, C3;
    Button start;
    public static int RAND_VAL = 0;
    public static final int PLAYER1_PLAYING = 1;
    public static final int PLAYER2_PLAYING = 2;
    Random r = new Random();
    int min = 0;
    int max = 9;
    Button[] BArray = new Button[9];
    Thread t1 = new Thread(new ReadPageRunnable1());
    Thread t2 = new Thread(new ReadPageRunnable2());

    //Arraylists which holds the winning conditions
    static ArrayList<Integer> player1choices = new ArrayList<Integer>(3);
    static ArrayList<Integer> player2choices = new ArrayList<Integer>(3);
    static ArrayList<Integer> UsedVals = new ArrayList<Integer>(9);
    static ArrayList<Integer> Row1 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Row2 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Row3 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Col1 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Col2 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Col3 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Diag1 = new ArrayList<Integer>(3);
    static ArrayList<Integer> Diag2 = new ArrayList<Integer>(3);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create Button objects
        BArray[0] = (Button) findViewById(R.id.A1);
        BArray[1] = (Button) findViewById(R.id.A2);
        BArray[2] = (Button) findViewById(R.id.A3);
        BArray[3] = (Button) findViewById(R.id.B1);
        BArray[4] = (Button) findViewById(R.id.B2);
        BArray[5] = (Button) findViewById(R.id.B3);
        BArray[6] = (Button) findViewById(R.id.C1);
        BArray[7] = (Button) findViewById(R.id.C2);
        BArray[8] = (Button) findViewById(R.id.C3);

        Row1.add(0);
        Row1.add(1);
        Row1.add(2);
        Row2.add(3);
        Row2.add(4);
        Row2.add(5);
        Row3.add(6);
        Row3.add(7);
        Row3.add(8);
        Col1.add(0);
        Col1.add(3);
        Col1.add(6);
        Col2.add(1);
        Col2.add(4);
        Col2.add(7);
        Col3.add(2);
        Col3.add(5);
        Col3.add(8);
        Diag1.add(0);
        Diag1.add(4);
        Diag1.add(8);
        Diag2.add(2);
        Diag2.add(4);
        Diag2.add(6);

        // BArray = {A1, A2, A3, B1, B2, B3, C1, C2, C3};
        start = (Button) findViewById(R.id.start);


        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

               // Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
                //Check if Thread t1 and t2 are already started
                //This loop is executed when the game has ended either in a tie or a player has already won and
                // The user will click on Start game then
                // Re initialize all the global variables as if its a fresh start and send message to t1Handler to start game
              if((t1.isAlive())&&(t2.isAlive())&& (((turnscovered)>=9)||(ifsomebodyhaswon==true)))

                {
                    //mHandler.removeMessages(PLAYER1_PLAYING);
                    //mHandler.removeMessages(PLAYER2_PLAYING);

                    turnscovered=0;
                    player1choices.clear();
                    player2choices.clear();
                    UsedVals.clear();
                    ifsomebodyhaswon=false;
                    RAND_VAL=0;
                    BArray[0].setText("");
                    BArray[1].setText("");
                    BArray[2].setText("");
                    BArray[3].setText("");
                    BArray[4].setText("");
                    BArray[5].setText("");
                    BArray[6].setText("");
                    BArray[7].setText("");
                    BArray[8].setText("");

                    Message callhandler=Message.obtain();
                    t1Handler.sendMessage(callhandler);

                }

              //Check if Thread t1 and t2 are already started
              //This loop is executed when the game has not ended and
              // The user will click on Start game in between
              // Re initialize all the global variables as if its a fresh start and threads will continue playing
              else  if((t1.isAlive())&&(t2.isAlive())&&(turnscovered<9)){




                 // mHandler.removeMessages(PLAYER1_PLAYING);
                  //mHandler.removeMessages(PLAYER2_PLAYING);
                  UsedVals.clear();
                  turnscovered=0;
                  player1choices.clear();
                  player2choices.clear();
                  ifsomebodyhaswon=false;
                  RAND_VAL=0;
                  BArray[0].setText("");
                  BArray[1].setText("");
                  BArray[2].setText("");
                  BArray[3].setText("");
                  BArray[4].setText("");
                  BArray[5].setText("");
                  BArray[6].setText("");
                  BArray[7].setText("");
                  BArray[8].setText("");




              }
              // This loop is executed the first time on launch of the application and
              //The two players t1 and t2 threads are created
                else {


                  t1.start();
                  t2.start();
              }

            }
        });


    }

    class ReadPageRunnable1 implements Runnable {
        @Override
        public void run() {
            //Initialize the current thread as a looper.
            Looper.prepare();

            //Generate unique random number for the button to be filled for the first time
            //Thread 1 is set as the default player who starts the game initially
            RAND_VAL = r.nextInt(max - min) + min;
            UsedVals.add(RAND_VAL);
            Message msgfirst = Message.obtain();
            msgfirst.arg1 = PLAYER1_PLAYING;
            msgfirst.arg2 = RAND_VAL;
            Log.i("Player1 init value is ", String.valueOf(+RAND_VAL));

            //Send message to UI handler to update UI based on the data sent by message
            mHandler.sendMessage(msgfirst);
            Toast.makeText(getApplicationContext(), "Player 1 chose : "+(RAND_VAL+1), Toast.LENGTH_SHORT).show();

            //Generate unique random number for the button to be filled
            //This is executed when it receives message from case 2 in mHandler
            t1Handler = new Handler() {

                public void handleMessage(Message msg) {





                            do {

                                RAND_VAL = r.nextInt(max - min) + min;


                            } while ((UsedVals.contains(RAND_VAL)));
                            UsedVals.add(RAND_VAL);
                            Message msgsecond = mHandler.obtainMessage();
                            msgsecond.arg1 = PLAYER1_PLAYING;
                            msgsecond.arg2 = RAND_VAL;
                            Log.i("Player1 later value is ", String.valueOf(+RAND_VAL));
                            mHandler.sendMessage(msgsecond);
                            Toast.makeText(getApplicationContext(), "Player 1 chose : " + (RAND_VAL + 1), Toast.LENGTH_SHORT).show();

                    }


            };
           // Run the message queue in this thread.
            Looper.loop();
        }
    }


        class ReadPageRunnable2 implements Runnable {
            @Override
            public void run() {
                //Initialize the current thread as a looper.
                Looper.prepare();

                //Generate unique random number for the button to be filled
                //This is executed when it receives message from case 1 in mHandler
                  t2Handler = new Handler() {

                      public void handleMessage(Message msg) {




                                  do {

                                      RAND_VAL = r.nextInt(max - min) + min;
                                      //Log.i("Val by p2", String.valueOf(+RAND_VAL)) ;


                                  } while ((UsedVals.contains(RAND_VAL)));

                                  UsedVals.add(RAND_VAL);
                                  Message msgfrpmp2 = mHandler.obtainMessage();
                                  msgfrpmp2.arg1 = PLAYER2_PLAYING;
                                  msgfrpmp2.arg2 = RAND_VAL;
                                  Log.i("Player2 later value is ", String.valueOf(+RAND_VAL));
                                  mHandler.sendMessage(msgfrpmp2);
                                  Toast.makeText(getApplicationContext(), "Player 2 chose : " + (RAND_VAL + 1), Toast.LENGTH_SHORT).show();

                          }



                  };
                // Run the message queue in this thread.
                  Looper.loop();

            }
        }


    }
