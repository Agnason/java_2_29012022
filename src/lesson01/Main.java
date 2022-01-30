package lesson01;

public class Main {
    public static <bolean> void main(String[] args) {
    /*Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).*/
//  I- способ
        Cat cat = new Cat("Барсик");
        Robot robot = new Robot("Железяка");
        Man man = new Man("Вася");
        cat.jump();
        cat.run();
        robot.jump();
        robot.run();
        man.jump();
        man.run();
//  II-способ
        RunAndJump[] runAndJump = new RunAndJump[]{
                new Cat("Тосик"),
                new Robot("ЭВМ"),
                new Man("Игорь")};
        for (int i = 0; i < runAndJump.length; i++) {
            runAndJump[i].jump();
            runAndJump[i].run();
        }
/*2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль
(успешно пробежал, не смог пробежать и т.д.).*/
        Wall wall = new Wall();
        RunTrack runTrack = new RunTrack();
        RunAndJump[] runAndJump2 = new RunAndJump[]{
                new Cat("Кеша", 3000, 4),
                new Robot("123", 15, 1),
                new Man("Василий", 1000, 3)
        };
        for (RunAndJump sportsmen : runAndJump2) {
            sportsmen.doJumpThroughWall(wall);
            sportsmen.doRunOnRunTrack(runTrack);
        }

        /*3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.*/

        RunAndJump[] sportsmen = new RunAndJump[]{
                new Cat("Роджер", 10, 10),
                new Robot("One", 5, 5),
                new Man("Сергей", 100, 2),
        };
        TestToJumpAndRun[] barriers = new TestToJumpAndRun[]{
                new Wall(),
                new RunTrack()
        };
        for (int i = 0; i < sportsmen.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                barriers[j].tryToJump(sportsmen[i]);
                barriers[j].tryToRun(sportsmen[i]);
            }
        }
   /*4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
        Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.*/

        RunAndJump[] sportsmen2 = new RunAndJump[]{
                new Cat("Василий", 1000, 10),
                new Robot("Два", 5, 5),
                new Man("Гриша", 100, 2),
        };
        TestToJumpAndRun[] barriers2 = new TestToJumpAndRun[]{
                new Wall(),
                new RunTrack()
        };
        System.out.println("начало 4 задания");
        for (int i = 0; i < sportsmen.length; i++) {
            for (int j = 0; j < barriers.length; j++) {
                if (barriers2[j].isCan(sportsmen2[i])) {
                    barriers2[j].tryToJump(sportsmen2[i]);
                    barriers2[j].tryToRun(sportsmen2[i]);
                } else {
                    System.out.println(sportsmen2[i] + " не сможет преодолеть " + barriers2[j]);
                    break;
                }
            }
        }
    }
}
