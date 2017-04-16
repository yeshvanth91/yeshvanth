package List;
class Parent{
    int x=10;
    void show(){
        System.out.println("parent-show");
    }
    
    void OnlyParentShow(){
        System.out.println("OnlyParentShow");
    }
}
 
class Child extends Parent{
    int x=20;
    void show(){
        System.out.println("child-show");
    }
    void OnlyChildShow(){
        System.out.println("OnlyChildShow");
    }
}
 
public class DownCast {
 
    public static void main(String[] args) {
        Parent p = new Child();
        p.show();
        p.OnlyParentShow();
        System.out.println(p.x);
        Parent p1 = new Child();
        Child c=(Child)p1;
        c.show();
        c.OnlyChildShow();
        System.out.println(c.x);
    }
}