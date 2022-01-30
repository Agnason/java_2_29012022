package lesson01;

public class Wall implements TestToJumpAndRun {
    final int height = 3;

    @Override
    public void tryToJump(RunAndJump j) {
        if (height <= j.getMaxHeight()) {
            System.out.println(j + " перепрыгнул");
        } else {
            System.out.println(j + " не удалось");
        }
    }
    @Override
    public void tryToRun(RunAndJump j) {
    }

    @Override
    public boolean isCan(RunAndJump j) {
        return height<=j.getMaxHeight();
    }
    @Override
    public String toString() {
        return "Препятствие: Стена " + height + "м" + " высоты" ;
    }
}
