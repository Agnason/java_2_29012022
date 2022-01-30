package lesson01;

public class Cat implements RunAndJump{
    private String name;
    private int maxDistance;
    private int maxHeight;


    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int maxDistance, int maxHeight) {
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
        System.out.println("Кот " + name + " побежал");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + name + " прыгает");
    }
    @Override
    public void doJumpThroughWall(Wall wall) {
        if (wall.height <= maxHeight) {
            System.out.println("Кот " + name + " успешно перепрыгнул стену");
        } else {
            System.out.println("Кот " + name + " не смог перепрыгнуть стену");
        }
    }

    @Override
    public void doRunOnRunTrack(RunTrack runTrack) {
        if (runTrack.distance <= maxDistance) {
            System.out.println("Кот " + name + " удалось пробежать всю дорогу");
        } else {
            System.out.println("Кот " + name + " не смог пробежать дорогу");
        }
    }
    @Override
    public String toString() {
        return "Кот: " + name;
    }

}
