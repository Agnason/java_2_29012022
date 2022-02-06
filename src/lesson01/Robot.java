package lesson01;

public class Robot implements RunAndJump {
    private String name;
    private int maxDistance;
    private int maxHeight;

    public Robot(String name) {
        this.name = name;
    }

    public Robot(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }
@Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public void run() {
        System.out.println("Робот " + name + " побежал");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + name + " прыгает");
    }

    @Override
    public void doJumpThroughWall(Wall wall) {
        if (wall.height <= maxHeight) {
            System.out.println("Робот " + name + " успешно перепрыгнул стену");
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену");
        }
    }

    @Override
    public void doRunOnRunTrack(RunTrack runTrack) {
        if (runTrack.distance <= maxDistance) {
            System.out.println("Робот " + name + " удалось пробежать всю дорогу");
        } else {
            System.out.println("Робот " + name + " не смог пробежать дорогу");
        }
    }
    @Override
    public String toString() {
        return "Робот: " + name;
    }
}
