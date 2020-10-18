class Time{
    int hour;
    int min;
    int sec;
    int hour1;
    int min1;
    int sec1;
    Time(int hour,int min,int sec,int hour1,int min1,int sec1){
        this.hour=hour;
        this.min=min;
        this.sec=sec;
        this.hour1=hour1;
        this.min1=min1;
        this.sec1=sec1;
    }
    void add(){
        int totalHours = hour1 + hour;
        int totalMinutes = min1 + min;
        int totalSeconds = sec1 + sec;
        if (totalSeconds >= 60) {
        totalMinutes ++;
        totalSeconds = totalSeconds % 60;
        }
        if (totalMinutes >= 60) {
        totalHours ++;
        totalMinutes = totalMinutes % 60;
    }
    System.out.println("hour"+totalHours);
    System.out.println("min"+totalMinutes);
    System.out.println("sec"+totalSeconds);
        
    }
}
class Time_operation{
    public static void main(String args[]) {
        Time t = new Time(1,40,30,3,30,10);
        t.add();
       
        
    }
}
