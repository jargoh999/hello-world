public class Bike {

    private boolean isOn;
    private  int speed ;




    public boolean isOn() {
        return isOn;
    }

    public void powerOn() {
        isOn = true;
    }

    public void powerOff() {
        isOn = false;
    }


    public void accelerate() {

        if (isOn) {
            if (!(speed < 0 || speed > 20)) {
                speed++;

            } else if (speed > 20 || speed <= 30) {
                speed += 2;

            } else if (speed > 30 || speed <= 40) {
                speed += 3;

            } else if (speed > 40) {
                speed += 4;

            }
        }

    }

    public void decelerate() {

        if (isOn) {
            if (!(speed < 0 || speed > 20)) {
                speed--;

            } else if (speed > 20 || speed <= 30) {
                speed -= 2;

            } else if (speed > 30 || speed <= 40) {
                speed -= 3;

            } else if (speed > 40) {
                speed -= 4;

            }


        }


    }


    public int getBikeSpeed(){
        return speed;
    }














    public int switchGear() {
        int gear = 0;
    switch (speed/10){

        case 1:
            gear = 1;
            break;
        case  2:
            gear = 1;
            break;

        case 3:
          gear = 2;
          break;

        case 4 :
            gear = 3;
             break;


        default:
            gear = 4;
    }
     return gear;

    }



}










