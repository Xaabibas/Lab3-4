package point;

import java.util.Random;

public enum Weather {
    SUNNY{
        public void describe() {
            System.out.print("На улице ярко светило солнце.");
        }
    },
    CLOUDY{
        public void describe() {
            System.out.print("Небо было заслонено облаками, не дававшими солнечным лучам добраться до земли.");
        }
    },
    SNOWY{
        public void describe() {
            System.out.print("На землю мягко падал белый снег, покрывая собой дорогу.");
        }
    },
    RAINY{
        public void describe() {
            System.out.print("Свинцовые тучи закрыли небосвод, полило как из ведра.");
        }
    };

    public void describe() {

    }

    public static Weather getRandomWeather(){
        return Weather.values()[new Random().nextInt(Weather.values().length)];
    }
}
