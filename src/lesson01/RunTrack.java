package lesson01;

public class RunTrack implements TestToJumpAndRun{
    final int distance=200;

    @Override
    public void tryToJump(RunAndJump j) {
    }

    @Override
    public void tryToRun(RunAndJump j) {
        if (distance<= j.getMaxDistance()) {
            System.out.println(j + " пробежал");
        } else {
            System.out.println(j + " не удалось");
        }
    }
    @Override
    public boolean isCan(RunAndJump j) {
        return distance<=j.getMaxDistance();
    }
    @Override
    public String toString() {
        return "Препятствие: Дорожка " + distance + "м" + " длины";
    }
}

