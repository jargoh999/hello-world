public class AirConditioner {
    private boolean isOn ;
    private int temperature = 16;

    public  void powerOn(){
        isOn = true;
    }

    public  void powerOff(){
        isOn = false;
    }


    public void increaseTemperature(){
        if (!(temperature >= 30) )
            temperature++;
    }


    public  void decreaseTemperature(){
        if (!(temperature <= 16) )
            temperature--;
    }


    public int getTemperature(){
        return  temperature;

    }


    public void toggleSwitch(){
     isOn = !isOn;
    }


    public boolean isOn() {
        return isOn;
    }
}
