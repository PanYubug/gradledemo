package com.panyu.mytest;

/*
 单分派、多分派演示
 */
public class Dispatch {

    static class QQ {
    }

    static class _360 {
    }

    public static class Father {
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}

// father choose 360
// son choose qq
// 这个编译器的选择过程，也就是静态分派的过程。
// 这时选择目标方法的依据有两点：一是静态类型是Father还是Son，二是方法参数是QQ还是360.
// 这次选择结果的最终产物是产生了两条invokevirtual指令，两条指令的 参数分别为常量池中指向Father.hardChoice(360)
// 及Father.hardChoice(QQ)方法的符号引用。
// 因为是根据两个宗量进行选择，所以Java语言的静态分派属于多分派类型。
// 运行阶段虚拟机的选择。也就是动态分派的过程。
// 唯一可以影响虚拟机选择的因素只有此方法的接受者的实际类型是Father还是Son。因为只有一个宗量作为选择依据，所以Java
// 语言的动态分派属于单分派类型。
