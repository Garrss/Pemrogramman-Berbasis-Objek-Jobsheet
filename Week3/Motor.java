package Week3;

public class Motor {
    // instansi atribut
    private int speed = 0;
    private boolean motorOn = false;
    private int maxSpeed = 100;

    public void startEngine() {
        motorOn = true;
    }

    public void turnOffEngine() {
        motorOn = false;
        speed = 0;
    }

    public void increaseEngine() {
        if (motorOn == true) {
            if (speed + 5 <= maxSpeed) {
                speed += 5;
            } else {
                speed = maxSpeed;
                System.out.println("Speed is at maximum limit: " + maxSpeed);
            }
        }
    }

    public void reduceEngine() {
        if (motorOn == true) {
            speed -= 5;
        } else {
            System.out.println("Motor cycle off");
        }
    }

    public void statusPrint() {
        if (motorOn == true) {
            System.out.println("Motor cycle On");
        } else {
            System.out.println("Motor cycle Off");
        }
        System.out.println("Speed: " + speed + "\n");
    }
}
