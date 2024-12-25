import exceptions.NegTime;

public class JourneyTime {
    private int nonStopTime;
    private int currentTime;
    private int hours;
    private int minutes;

    public JourneyTime(int hours, int minutes) {
        try {
            if (hours < 0 | minutes < 0) {
                throw new NegTime();
            }
            this.hours = hours + minutes / 60;
            this.minutes = minutes % 60;
            this.nonStopTime = 0;
            this.currentTime = 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public String passedTime() {
        return "Через " + (nonStopTime / 60 > 0 ? nonStopTime / 60 + " часа " : "") +
                (nonStopTime % 60 > 0 ? nonStopTime % 60 + " минут" : "");
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void addCurrentTime(int time){
        try {
            if (time < 0) {
                throw new NegTime();
            }
            this.currentTime += time;
        } catch (NegTime e) {
            System.out.println(e.getMessage());
        }

    }

    public int getAllTime(){
        return this.hours * 60 + this.minutes;
    }

    public void pass(int time){
        try {
            if (time < 0) {
                throw new NegTime();
            }
            this.nonStopTime += time;
        } catch (NegTime e) {
            System.out.println(e.getMessage());
        }
    }
}
