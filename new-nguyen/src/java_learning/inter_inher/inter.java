package java_learning.inter_inher;

interface interfa
{
    String name = "Bob";
    public void check();
}

class inhe
{
    String name;
}

class inter_test implements interfa
{
    @Override
    public void check()
    {
        System.out.println(inter_test.name + " is here");
    }
}

class inher_test extends inhe
{
    int age;
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }
}

public class inter {
    public static void main(String []args)
    {
        //interface
        inter_test f1 = new inter_test();
        f1.check();
        inher_test f2 = new inher_test();
        f2.setName("Phong");
        f2.setAge(18);
        System.out.printf("%s + %d", f2.getName(), f2.getAge());
    }
}
