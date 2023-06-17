package java_learning.protect;

class sub_class_protect extends Pub
{
    int age;
    public String getName()
    {
        return this.msg;
    }

    public void setName(String name)
    {
        this.msg = name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}

public class test2 {
    public static void main(String []args)
    {
        sub_class_protect test = new sub_class_protect();
        test.setAge(15);
        test.setName("Nguyen");
        System.out.printf("%s + %d", test.getName(), test.getAge());
    }
}
