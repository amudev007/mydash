package mydashboard.gondiacity.in;

/*todo please note important carb is Mood, prot is Fitness, satufat is Concentration, totfat is Love,caloriesfatfood is Depression, category is type of work, calories is Social */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    SharedPreferences app_first_time;
    Boolean check_first;
    FoodDatabase fd;
    String indian,italian,mexican,chinese,american,common;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        fd=new FoodDatabase(this);

        indian="10 Min";
        italian="15 Min";
        mexican="30 Min";
        american="1 Hour";
        chinese="2 Hour";
        common="Whole Day";
        /*todo useer setted timing */

        app_first_time=getSharedPreferences("FitnessnMotion",MODE_WORLD_READABLE);

        check_first=app_first_time.getBoolean("first", true);

        Thread t2=new Thread(){

            public void run()
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(check_first==true)
                {
                    Thread t1=new Thread(){
                        public void run()
                        {
                            InsertIntoDatabase();
                        }
                    };

                    t1.start();
                    Intent toGetDet=new Intent(MainActivity.this,GetDetailsStart.class);
                    startActivity(toGetDet);
                    finish();


                }
                else
                {
                    Intent toFitness=new Intent(MainActivity.this,FitnessnMotionActivity.class);
                    startActivity(toFitness);
                    finish();
                }
            }
        };
        t2.start();
    }

    public void InsertIntoDatabase()
    {
        fd.open();

        fd.clearDatabase();

        fd.Insert("Aloo Chaat", 50, 5, 0.2, 1.3, 13, indian, 231);
        fd.Insert("Aloo Channa Chat", 34, 6, 0, 2, 16.2, indian, 170);
        fd.Insert("Aloo Gobi", 23, 6, 3.1, 14, 126, indian, 239);
        fd.Insert("Aloo Paratha", 47, 18, 4, 11, 99, indian, 360);
        fd.Insert("Aloo Tikki", 28, 3, 2, 8.2, 74, indian, 196);
        fd.Insert("Bhajji", 0, 0, 3, 27, 185, indian, 350);
        fd.Insert("Bhel", 61, 10, 3.4, 15, 135, indian, 415);
        fd.Insert("Buttermilk", 1, 1, 0, 2, 3.6, indian, 19);
        fd.Insert("Curd", 0, 3, 0, 4, 10, indian, 60);
        fd.Insert("Chapathi", 22, 4, 1.6, 4.5, 41, indian, 137);
        fd.Insert("Channa Masala", 0, 0, 0, 0, 91, indian, 158);
        fd.Insert("Chicken Tikka", 2, 27, 0, 16, 144, indian, 260);

   fd.Insert("Aloo Chaat", 50, 5, 0.2, 1.3, 13, italian, 231);
        fd.Insert("Aloo Channa Chat", 34, 6, 0, 2, 16.2, italian, 170);
        fd.Insert("Aloo Gobi", 23, 6, 3.1, 14, 126, italian, 239);
        fd.Insert("Aloo Paratha", 47, 18, 4, 11, 99, italian, 360);
        fd.Insert("Aloo Tikki", 28, 3, 2, 8.2, 74, italian, 196);
        fd.Insert("Bhajji", 0, 0, 3, 27, 185, italian, 350);

        fd.Insert("Bhel", 61, 10, 3.4, 15, 135, mexican, 415);
        fd.Insert("Buttermilk", 1, 1, 0, 2, 3.6, mexican, 19);
        fd.Insert("Curd", 0, 3, 0, 4, 10, mexican, 60);
        fd.Insert("Chapathi", 22, 4, 1.6, 4.5, 41, mexican, 137);
        fd.Insert("Channa Masala", 0, 0, 0, 0, 91, mexican, 158);
        fd.Insert("Chicken Tikka", 2, 27, 0, 16, 144, mexican, 260);

        fd.close();


    }


}
